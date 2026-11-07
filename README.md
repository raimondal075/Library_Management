# Folio — Library Management System

Folio is a student-first library project with a responsive web preview, Java REST API backed by H2, and Kotlin Android companion.

## Technology roles
- **HTML** structures the web interface.
- **CSS** provides responsive styling, book cards and visual interactions.
- **JavaScript** powers catalogue search, filters, demo borrowing/returns, reading history and requests.
- **Java / Spring Boot** provides REST endpoints and database-backed catalogue and loan operations.
- **Kotlin / Android** provides a native companion client for the Java API.

## Structure
- `index.html`, `assets/`: GitHub Pages-ready web app.
- `backend-java/`: Spring Boot API and H2 database.
- `android-kotlin/`: Android Studio Kotlin client.

## Web preview
Open `index.html` or publish the repository root with GitHub Pages. The preview uses localStorage and sample student data. It is a front-end demonstration and does not authenticate users or call the Java API.

## Java API
Requires JDK 17+ and Maven:
```bash
cd backend-java
mvn spring-boot:run
```
API base: `http://localhost:8080/api`
- `GET /books?q=clean` — search catalogue.
- `GET /loans/{studentId}` — active loans and returned history.
- `POST /loans` — borrow: `{"bookId":1,"studentId":"student-001"}`.
- `POST /loans/{loanId}/return` — return: `{"studentId":"student-001"}`.
- `POST /requests` — validate and acknowledge a book request.

H2 persists catalogue and loans under `backend-java/data/`. Requests are currently acknowledged but not saved for librarian review. Authentication, role-based permissions, fines, audit logging and production hardening are not implemented. CORS is permissive for local learning and must be restricted before production.

## Android companion
Open `android-kotlin` in Android Studio and run on an emulator. Emulator host address is `10.0.2.2`. For a physical phone, change the base URL in `MainActivity.kt` to your computer's LAN IP.

## Demo limitations
Browser loans are local to that browser and do not synchronize with the Java database. The API accepts a supplied student ID and does not verify identity or roles. This is an educational prototype, not a production library service.
