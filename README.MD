# Proyecto de Gestión de Turismo

## Descripción Técnica del Proyecto

Este proyecto es una aplicación de consola para la gestión de un sistema de turismo. Permite realizar operaciones CRUD sobre clientes, paquetes turísticos y reservas, además de consultas específicas. A continuación, se detallan los aspectos técnicos:

### Base de Datos
- **Tipo de Base de Datos**: MySQL
- **Estructura**:
    - **Tabla `cliente`**: Almacena información de los clientes (nombre, email, teléfono).
    - **Tabla `paquete_turistico`**: Contiene los paquetes turísticos (nombre, destino, precio, duración).
    - **Tabla `reserva`**: Registra las reservas realizadas por los clientes para los paquetes turísticos.
    - **Tabla `actividad`**: Detalla actividades adicionales asociadas a los paquetes turísticos.

### Conector Usado
- **Conector JDBC**: Se utiliza el driver `mysql-connector-java` para la conexión con la base de datos.

### Estructura del Proyecto
- **Modelo (`model`)**: Clases que representan las entidades (`Cliente`, `PaqueteTuristico`, `Reserva`, etc.).
- **DAO (`dao` y `daoImpl`)**: Interfaces y clases de implementación para las operaciones de acceso a datos.
- **Aplicación (`app`)**: Contiene la clase principal `App.java` con el menú interactivo.
- **SQL (`turismo.sql`)**: Script para la creación de la base de datos y sus tablas.

---

## Cómo Ejecutar el Proyecto

1. **Requisitos Previos**:
    - Tener instalado MySQL y configurado un usuario con permisos.
    - Tener configurado Java 8 o superior.
    - Tener Maven instalado para la gestión de dependencias.

2. **Configuración de la Base de Datos**:
    - Ejecutar el script `turismo.sql` en MySQL para crear la base de datos y las tablas necesarias.

3. **Configuración del Proyecto**:
    - Clonar el repositorio del proyecto.
    - Configurar el archivo `src/main/resources/db.properties` con los datos de conexión a la base de datos:
      ```properties
      db.url=jdbc:mysql://localhost:3306/turismo
      db.user=tu_usuario
      db.password=tu_contraseña
      ```

4. **Compilación y Ejecución**:
    - Desde la raíz del proyecto, ejecutar:
      ```bash
      mvn clean install
      java -cp target/tu-proyecto.jar org.example.app.App
      ```

---



## Autor
- **Nombre**: [Gonzalo Rodriguez de dios Cabrera] 
