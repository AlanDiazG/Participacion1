# Autores

### Alan Mauricio Diaz Guerrero

### Matias Alejandro Suarez Zuñiga

### Pedro Alonso Gutierrez Agramon

## Participacion 1 API REST de Agencia de Autos


Este proyecto es una API RESTful sencilla construida con el Spring Framework que simula una agencia de autos. Permite la gestión de una colección de autos mediante operaciones CRUD básicas. El proyecto está configurado como una clase controladora que maneja solicitudes HTTP.

Estructura del Proyecto
Controlador: AutoRestController maneja las solicitudes HTTP entrantes.
Modelo: Auto representa la entidad del automóvil.
Endpoints de la API


#### Endpoints Generales

GET /api/agencia/saludar

>Devuelve un mensaje de saludo a los estudiantes listados en el código.

GET /api/agencia/alumnos

>Devuelve una lista de los estudiantes en formato HTML.


#### Endpoints de Gestión de Autos

GET /api/agencia/

> Recupera todos los autos en la agencia.

GET /api/agencia/{id}
>  Recupera el auto con el id especificado.

POST /api/agencia/
>  Agrega un nuevo auto a la agencia. Los datos del auto deben enviarse en el cuerpo de la solicitud.

PUT /api/agencia/{id}
>  Reemplaza el auto con el id especificado por uno nuevo. Si el auto no existe, crea uno nuevo.

PUT /api/agencia/
>  Devuelve un mensaje de error indicando que no se admiten reemplazos completos de recursos en este endpoint.

PATCH /api/agencia/{id}
>  Actualiza campos específicos del auto con el id especificado según el cuerpo de la solicitud.

DELETE /api/agencia/{id}
>  Elimina el auto con el id especificado de la agencia.

#### Formatos de Respuesta

  Se utiliza el formato JSON para las respuestas de la API.
  Se utiliza HTML para la lista de estudiantes.

#### Manejo de Errores

Devuelve 404 Not Found si no se encuentra el auto solicitado.
Devuelve 204 No Content si los datos proporcionados para la actualización están incompletos.
Devuelve códigos de estado apropiados para cada operación (e.g., 201 Created, 200 OK).

#### Requisitos Previos

Java 8 o superior

Dependencias de Spring Boot incluidas en el proyecto

Una herramienta de construcción como Maven o Gradle
