# prueba_colfondos

La logica de negocio se encuentra en el proyecto TestColfondos, ejecutar primero este: mvn-spring-boot:run puerto 8080

El proyecto grafico esta en vistaprueba ejecutar ng serve puerto 4200

la base datos esta embebida en el proyecto como especifica la prueba con H2:

url del administrador de bd: http://localhost:8080/h2-console/

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=start123

El log transaccional se encuentra en la tabla LOG de la base de datos, con tipo respuesta OK o ER





