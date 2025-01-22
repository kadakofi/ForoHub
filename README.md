📚 ForoHub - Plataforma de Gestión de Foros
ForoHub es una aplicación desarrollada en Spring Boot que permite gestionar foros de discusión donde los usuarios pueden publicar temas, responder a otros, y participar en comunidades virtuales de manera eficiente. Esta aplicación proporciona una interfaz intuitiva y funcionalidades robustas para administrar usuarios, temas y comentarios.

🌟 Características principales
Gestión de Usuarios: Registro, autenticación y permisos de usuarios.
Administración de Foros: Creación, edición y eliminación de foros temáticos.
Interacción en los Temas: Publicación de mensajes, respuestas y gestión de conversaciones.
Persistencia de Datos: Utiliza PostgreSQL como base de datos relacional.
Seguridad: Manejo seguro de contraseñas e inicios de sesión mediante Spring Security.
API RESTful: Interfaz de programación basada en REST para integraciones.

🔗 Endpoints de la API
Método	Endpoint	Descripción
GET	/api/foros	Listar todos los foros
POST	/api/foros	Crear un nuevo foro
GET	/api/usuarios	Listar usuarios registrados
POST	/api/usuarios	Registrar un nuevo usuario
GET	/api/mensajes	Obtener mensajes de un foro
POST	/api/mensajes	Agregar un nuevo mensaje

🛠️ Tecnologías Utilizadas
Java 17 – Lenguaje de programación.
Spring Boot – Framework para el desarrollo de la aplicación.
Spring Security – Para la autenticación y autorización de usuarios.
MySQL – Base de datos para el almacenamiento de información.
Maven – Gestión de dependencias y compilación.
