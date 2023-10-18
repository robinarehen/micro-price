# micro-price
Este proyecto da solución a la prueba planteada en el README [TESTJAVA-2020](documentacion/TestJava2020.md).

Se agrega una bateria de pruebas de **POSTMAN**, se puede descargar el archivo aquí [test-collection](documentacion/Test-Java-2020.postman_collection.json)

# Descripción
El proyecto fue creado mediante la metodología `Api First` por tal motivo cuenta con dos módulos de Maven, donde el módulo [service-api](micro-price-service-api/) se cuenta con la configuración para mediante un archivo `SWAGGER` se generan los modelos y las interfaces con la configuración de los endpoints.

En el módulo [service-rest](micro-price-service-rest/) se cuenta con toda la logica de negocio, conexión a la base de datos y la bateria de test unitarios.


