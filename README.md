# red-hospitalaria
### Developed by: 

Jazmín Villagra

### Dependencias

* Java 8
* Postgres 9+

### Run Proyect

1- Crear la BD **red-hospitalaria**. Se puede ejecutar el script **create_database.sql** y se creará la bd.

2- Ejecutar el script **create_tables.sql** en la BD

3- Instalar todas las dependencias:

    $ mvn clean install -DskipTests
    
4- Crear el jar

    $ mvn clean install -DskipTests
    

5- Se puede acceder a traves de http://192.168.0.18:8080/api/    
