# Proyecto Gestión Fútbol - CRUD JSP + JDBC

## Requisitos
- Java JDK 8 o superior
- Apache Tomcat 9+
- MySQL Server 8+
- Maven (Opcional, pero recomendado si se añaden dependencias)

## Base de datos
1. Abrir MySQL y ejecutar el script ubicado en `database/script.sql`.
2. La base de datos `gestion_futbol` será creada junto con las tablas `usuario` y `equipo_futbol`.

## Ejecución
1. Configurar el proyecto en el IDE (Eclipse, IntelliJ IDEA, etc.) como un proyecto Web dinámico o Maven.
2. Asegurar que el driver JDBC de MySQL está en el classpath (ej. en `WEB-INF/lib` o vía Maven `pom.xml`).
3. Desplegar la aplicación en Apache Tomcat.
4. Acceder a la URL base (ej: `http://localhost:8080/gestion_futbol/login.jsp`).

## Variables necesarias
- **Credenciales BD**: En la clase `ConexionBD.java`, configurar URL, USER (`root`) y PASSWORD.
- **Usuario administrador**: El script de BD incluye por defecto usuario `admin`, clave `admin123`.
