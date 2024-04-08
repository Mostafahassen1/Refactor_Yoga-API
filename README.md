# Refactor_Yoga-API

To set up the Yoga API, follow these steps:

## 1. Set up PostgreSQL Database

First, create a Docker container for the PostgreSQL database:

```bash
docker run -p 5432:5432 --name Yoga-postgres -e POSTGRES_USER=yoga -e POSTGRES_PASSWORD=root -e POSTGRES_DB=yoga -d postgres
```


## 2. Connect Database with Spring

Connect the Yoga API with the PostgreSQL database by configuring the `application.properties` file with the following properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yoga
spring.datasource.username=yoga
spring.datasource.password=root
```
