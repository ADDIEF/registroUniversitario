# 🎓 Sistema de Registro Universitario

Proyecto de backend desarrollado en Spring Boot que permite gestionar estudiantes, materias, inscripciones, docentes y evaluaciones, con seguridad basada en JWT, documentación Swagger y persistencia en PostgreSQL. También incluye caché con Redis para optimización de rendimiento.

---

## 🚀 Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Security + JWT**
- **PostgreSQL**
- **Redis** (opcional, para caching)
- **Swagger UI / OpenAPI**
- **Lombok**
- **Maven**

---

## 📁 Estructura del Proyecto

📦registroUniversitario
┣ 📂src/main/java/com/universidad
┃ ┣ 📂controller
┃ ┣ 📂service
┃ ┣ 📂model
┃ ┣ 📂repository
┃ ┣ 📂dto
┃ ┗ 📂config
┣ 📂resources
┃ ┗ application.properties
┣ 📂db
┃ ┗ universidad_datos.sql
┗ README.md


---

## 🔐 Roles y Seguridad

El sistema utiliza **JWT (Json Web Token)** para autenticación segura. Se definen los siguientes roles:

| Rol        | Funcionalidad principal                              |
|------------|------------------------------------------------------|
| `ADMIN`    | Crear usuarios, materias, estudiantes, docentes.     |
| `DOCENTE`  | Consultar evaluaciones propias.                      |
| `ESTUDIANTE` | Ver inscripciones y materias asignadas.          |

---

## 📦 Endpoints Principales

### 📘 Materias
| Método | Endpoint               | Descripción                           |
|--------|------------------------|----------------------------------------|
| GET    | `/api/materias`        | Listar todas las materias              |
| GET    | `/api/materias/{id}`   | Obtener materia por ID                 |
| GET    | `/api/materias/codigo/{codigoUnico}` | Buscar por código único  |
| POST   | `/api/materias`        | Registrar nueva materia                |
| PUT    | `/api/materias/{id}`   | Actualizar materia                     |
| DELETE | `/api/materias/{id}`   | Eliminar materia                       |

### 🧑‍🎓 Estudiantes
| Método | Endpoint                                     | Descripción                                  |
|--------|----------------------------------------------|----------------------------------------------|
| GET    | `/api/estudiantes`                          | Listar estudiantes                           |
| GET    | `/api/estudiantes/{id}`                     | Obtener estudiante por ID                    |
| GET    | `/api/estudiantes/{id}/materias`            | Materias inscritas del estudiante            |
| GET    | `/api/estudiantes/inscripcion/{numero}`     | Buscar estudiante por número de inscripción  |
| GET    | `/api/estudiantes/activos`                  | Listar estudiantes activos                   |
| PUT    | `/api/estudiantes/{id}`                     | Actualizar datos del estudiante              |
| PUT    | `/api/estudiantes/{id}/baja`                | Dar de baja un estudiante                    |
| POST   | `/api/estudiantes`                          | Registrar estudiante                         |

### 📝 Inscripciones
| Método | Endpoint                   | Descripción                         |
|--------|----------------------------|--------------------------------------|
| GET    | `/api/inscripciones`      | Listar inscripciones                |
| GET    | `/api/inscripciones/{id}` | Obtener inscripción por ID          |
| POST   | `/api/inscripciones`      | Inscribir estudiante a materia      |
| DELETE | `/api/inscripciones/{id}` | Eliminar inscripción                |

### 👨‍🏫 Evaluaciones Docente
| Método | Endpoint                                              | Descripción                         |
|--------|-------------------------------------------------------|--------------------------------------|
| GET    | `/api/evaluaciones-docente/{id}`                     | Obtener evaluación por ID           |
| GET    | `/api/evaluaciones-docente/docente/{docenteId}`     | Ver todas las evaluaciones de un docente |
| POST   | `/api/evaluaciones-docente`                         | Crear evaluación                    |
| DELETE | `/api/evaluaciones-docente/{id}`                    | Eliminar evaluación                 |

### 🔐 Autenticación
| Método | Endpoint                      | Descripción                        |
|--------|-------------------------------|-------------------------------------|
| POST   | `/api/auth/login`            | Login y generación de token JWT    |
| POST   | `/api/auth/logout`           | Cierre de sesión (opcional)        |
| POST   | `/api/auth/signup`           | Registro de nuevo usuario          |
| GET    | `/api/auth/session-info`     | Obtener información de la sesión   |

---

## 📂 Base de Datos

- Nombre: `universidad`
- Motor: **PostgreSQL**
- Archivo de ejemplo: `db/universidad_datos.sql`

Puedes restaurarlo en pgAdmin con la opción de **Restore** o ejecutando el script manualmente desde la consola:

```bash
psql -U postgres -d universidad -f db/universidad_datos.sql


Swagger
Puedes acceder a la documentación interactiva de la API en:

🔗 http://localhost:8085/swagger-ui/index.html

Cómo ejecutar
1. Clona el proyecto: git clone https://github.com/ADDIEF/registroUniversitario.git

2. Cambia a la rama de la práctica:
git checkout docs/PRACTICA2

Asegúrate de configurar tu base de datos en src/main/resources application.properties.

Ejecuta el proyecto: ./mvnw spring-boot:run

(Opcional) Verifica que Redis esté activo en el puerto 6379 si deseas usar caching.

🔗 Repositorio
🔗 https://github.com/ADDIEF/registroUniversitario/tree/docs/PRACTICA2

👨‍💻 Autor
Adriana Valeria Fernández Flores Universidad Mayor de San Andrés – TAW 251
2025

