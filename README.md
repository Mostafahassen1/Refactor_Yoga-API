# Refactor_Yoga-API

------------------------------------------------------------------------------------------------------
                 ## Technologies and Frameworks Used

### Programming Language
- **Java 17**: 

### Build Tool
- **Maven**: Dependency management and build automation.
 

### Spring Boot
- **Actuator**: Monitoring and management.
- **Data JPA**: Database access and ORM with Hibernate.
- **Web**: Building web applications and RESTful services.
- **DevTools**: Enhanced development experience.
- **Security**: Adding security features to the application.
- **Data Redis Reactive**: Integration with Redis for reactive data access( used in gateway ).

### Spring Cloud
- **Spring Cloud Gateway MVC**:

### Database
- **PostgreSQL**: Database management system.

### Authentication
- **JSON Web Tokens (JWT)**:
  - **jjwt-api**
  - **jjwt-impl**
  - **jjwt-jackson**

### Testing
- **Spring Boot Starter Test**: Testing utilities (JUnit, Hamcrest, Mockito).

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Configuration
- This project uses a **application.yml** file for configuration instead of the traditional **application.properties** file. 


## To set up the Yoga API, follow these steps:

### 1. Set up PostgreSQL Database

First, create a Docker container for the PostgreSQL database:

```bash
docker run -p 5432:5432 --name Yoga-postgres -e POSTGRES_USER=yoga -e POSTGRES_PASSWORD=root -e POSTGRES_DB=yoga -d postgres
```


### 2. Connect Database with Spring

Connect the Yoga API with the PostgreSQL database by configuring the `application.properties` file with the following properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yoga
spring.datasource.username=yoga
spring.datasource.password=root
```
