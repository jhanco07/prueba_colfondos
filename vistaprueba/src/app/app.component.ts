import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Cliente } from './models/cliente';
import { TiposDocumentos } from './models/tipos_documentos';
import { TipoDocumento } from './models/tipo_documeto';
import { BusinessService } from './services/business.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'vistaprueba';

  tiposDocumentos: TipoDocumento[] = [];

  resp!: TiposDocumentos;

  checkoutForm = this.formBuilder.group({
    cedula: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
    tipoDocumento: ['', Validators.required],
    correo: ['', [Validators.email, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
    celular: ['', [Validators.required, Validators.min(3000000000),
      Validators.max(3999999999)
      ,Validators.pattern("^((\d{3}\)|0)?[0-9]{10}$")]],
  });




  constructor(private businessService:BusinessService,  private formBuilder: FormBuilder){}
  ngOnInit(): void {
    this.getAllTiposDocumento();
  }
  getAllTiposDocumento() {
    this.businessService.getTiposDOcumento()
      .subscribe(
        (response: any) => {                           //next() callback
          console.log('response received: '+response);
          this.tiposDocumentos = response.tiposDocumento;
        },
        (error: any) => {                              //error() callback
          console.error('Request failed with error');
        },
        () => {                                   //complete() callback
          console.error('Request completed'); 
        })
    

  }

  guardar(){

    console.log("idTipoDocumento:"+ this.checkoutForm?.get('tipoDocumento')?.value);
    let cliente: Cliente = {
      cedula: this.checkoutForm?.get('cedula')?.value,
      idTipoDocumento: this.checkoutForm?.get('tipoDocumento')?.value,
      celular: this.checkoutForm?.get('celular')?.value,
      correo: this.checkoutForm?.get('correo')?.value
    }

    this.businessService.guardarCliente(cliente).subscribe(
      (response) => {
        console.log(response.tipoRespuesta);
        if(response.tipoRespuesta=="OK"){
            alert("Cliente guardado con exito");
        }else{
          alert(response.tipoRespuesta+":"+response.descError);
        }       
      },
      (error) => console.log(error)
    );
  }

}
