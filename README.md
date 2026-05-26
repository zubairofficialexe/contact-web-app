# Contact Web App

A stylish Spring Boot contact form with MySQL persistence and an admin page to view submissions.

## Run with Docker Compose

```bash
docker compose up --build
```

Open:
- Contact form: http://localhost:8080/
- Admin page: http://localhost:8080/admin

## Tech Stack
- Spring Boot 3
- Thymeleaf
- Spring Data JPA
- Validation
- MySQL 8
- Docker Compose

## Notes
- The app uses `spring.jpa.hibernate.ddl-auto=update`, so the table is created automatically.
- For production, add authentication for the `/admin` page.
