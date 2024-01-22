# Proyecto de Administración de Proyectos con Tablero Kanban (Backend)

## Descripción del Proyecto

Este proyecto tiene como objetivo facilitar la gestión y seguimiento de proyectos mediante un sistema de administración con un tablero Kanban. Permite la creación, asignación y seguimiento de tareas asociadas a cada proyecto, proporcionando una visión clara del progreso y las actividades pendientes.

## Tecnologías Utilizadas

- **Spring Boot**: Framework de desarrollo que simplifica la creación de aplicaciones Java.
- **MongoDB**: Base de datos NoSQL utilizada para almacenar de manera flexible la información de proyectos, tareas y usuarios.
- **Spring Data MongoDB**: Facilita la integración de MongoDB con aplicaciones Spring.
- **Java**: Lenguaje de programación principal.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

## Estructura del Proyecto

La estructura del proyecto sigue las convenciones de Spring Boot y se organiza en paquetes que reflejan la arquitectura MVC (Modelo-Vista-Controlador). A continuación, se proporciona una descripción general de los principales componentes:

- **Controladores (`controller`)**: Gestión de solicitudes HTTP y respuestas relacionadas con proyectos y tareas.
- **Modelos (`model`)**: Definición de las entidades principales, como `Project`, `Task` y `User`.
- **Repositorios (`repository`)**: Interfaz para operaciones de acceso a base de datos relacionadas con proyectos, tareas y usuarios.
- **Servicios (`service`)**: Lógica de negocios y manipulación de datos para proyectos, tareas y usuarios.

## Configuración y Uso

1. **Configuración de la Base de Datos MongoDB**:
   - Asegúrate de tener una instancia de MongoDB ejecutándose localmente o configura la conexión en `application.properties`.
  
2. **Ejecución del Proyecto**:
   - Ejecuta la clase principal `AdminApplication.java` para iniciar la aplicación Spring Boot.

3. **Acceso a la API**:
   - La API estará disponible en `http://localhost:8080/`.
   - Utiliza herramientas como Postman o CURL para interactuar con la API.

4. **Documentación API**:
   - La documentación de la API generada automáticamente estará disponible en `http://localhost:8080/swagger-ui.html`.

## Contribuciones

Siéntete libre de contribuir al proyecto abriendo problemas (issues) o enviando solicitudes de extracción (pull requests). Se aprecia cualquier tipo de aporte que mejore la funcionalidad, la eficiencia o la usabilidad del proyecto.

## Licencia

Este proyecto se distribuye bajo la licencia [MIT](LICENSE), lo que significa que puedes utilizar, modificar y distribuir el código de esta aplicación de forma gratuita, siempre y cuando incluyas el aviso de copyright y la licencia MIT en cualquier copia o porción sustancial del software.
