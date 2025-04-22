
# 📚 Registro Universitario – API REST con Spring Boot

Este proyecto es una API RESTful desarrollada con **Spring Boot**, como parte de una práctica académica de backend.  
Su objetivo es gestionar un registro de estudiantes utilizando operaciones CRUD básicas en memoria (sin base de datos).

---

## ✅ Funcionalidades

La API permite:

- 📋 **Listar todos los estudiantes** – `GET /api/estudiantes`
- 🔍 **Buscar estudiante por ID** – `GET /api/estudiantes/{id}`
- ➕ **Crear nuevo estudiante** – `POST /api/estudiantes`
- ✏️ **Actualizar estudiante existente** – `PUT /api/estudiantes/{id}`
- 🗑️ **Eliminar estudiante por ID** – `DELETE /api/estudiantes/{id}`

---

## 🛠️ Tecnologías utilizadas

- Java 17  
- Spring Boot  
- Maven  
- Lombok  
- Postman (para pruebas)  

---

## ▶️ Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/ADDIEF/RegistroUniversitario.git
   ```

2. Entra al proyecto:
   ```bash
   cd RegistroUniversitario
   ```

3. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

4. Accede a los endpoints desde:
   ```
   http://localhost:8082/api/estudiantes
   ```

---

## Pruebas con Postman

Las pruebas fueron realizadas con la herramienta Postman para verificar:

- ✔️ Creación (`POST`)
- ✔️ Consulta (`GET`)
- ✔️ Actualización (`PUT`)
- ✔️ Eliminación (`DELETE`)

---

## 📌 Autor

Este proyecto fue realizado por **ADRIANA VALERIA FERNANDEZ FLORES** como la parte 3 de la práctica 1.  
Gracias por revisar el código. ✨

