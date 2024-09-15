# Spring-Boot REST API

### Clean Architecture - DDD

### Documentation

#### http status codes for REST API - Success Responses

```text
- CREATE - 201  CREATED
- READ -   200  OK
- UPDATE - 200  OK
- DELETE - 204  NO_CONTENT
```

View dependencies and configuration in the `build.gradle` file.

- Lombok
- H2 Database
- JpaRepository
- Hibernate

Environment variables are set in `applicaion.properties` file. H2, In-Memory Database is also configured by default.

### Running Application and Database

```bash
/gradlew build
```

```bash
/gradlew bootRun
```

Default API URL

```text
http://localhost:8080/api/v1/categories
```

Default H2 Database console

```text
http://localhost:8080/api/v1/h2
```

Default database credentials

- JDBC URL - jdbc:h2:mem:devdb
- username - root
- password -

### Roadmaps

- Exception Handling with specific error codes
- Data Validation
- Mutable and Immutable Models
- Mutable and Immutable Services
- Relationships
- Swagger Documentation
- Environment Variables
- Security
- Docker
- Unit Testing
- Integration Testing
