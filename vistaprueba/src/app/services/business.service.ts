import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import {  TiposDocumentos } from '../models/tipos_documentos';
import { Cliente } from '../models/cliente';
import { Cabecera } from '../models/cabecera';

@Injectable({
  providedIn: 'root'
})
export class BusinessService {

   endpoint:string='http://localhost:8080/'; 

   

  constructor(private http: HttpClient) { } 

  getTiposDOcumento():any{
    return this.http.get<TiposDocumentos>(this.endpoint+'getAllTipoDocumento');        
   
  }

guardarCliente(cliente:Cliente){
  return this.http.post<Cabecera>(this.endpoint+'saveCliente', cliente);  
}

}
