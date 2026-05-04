# Restaurant API

Spring Boot **layered architecture** example (mirroring a `UserCtrl` / `UserService` / `UserRepository` style layout):

| Layer | Class | Responsibility |
|--------|--------|----------------|
| Presentation | `OrderController` | HTTP: `ResponseEntity` for all responses |
| Business | `OrderService` | Rules, transactions on write paths |
| Data access | `OrderRepository` | JPA persistence |
| Domain / persistence model | `RestaurantOrder` | `@Entity` mapped to the database |

Also includes a small static UI under `src/main/resources/static/`.

## Prerequisites

- Java 17
- Maven 3.8+ (or use your IDE’s Maven integration)
- PostgreSQL running locally

## Database setup

The application expects PostgreSQL with:

| Setting   | Value            |
|----------|------------------|
| Host     | `localhost`      |
| Port     | `5432`           |
| Database | `restaurantdb`   |
| User     | `softdev`        |
| Password | `Restaurant2026` |

Create the database and role (adjust if your PostgreSQL install uses a different superuser):

```sql
CREATE USER softdev WITH PASSWORD 'Restaurant2026';
CREATE DATABASE restaurantdb OWNER softdev;
```

If the database already exists under another owner, grant access:

```sql
GRANT ALL PRIVILEGES ON DATABASE restaurantdb TO softdev;
```

After connecting to `restaurantdb`, ensure the user can use the schema (for Hibernate `ddl-auto=update`):

```sql
\c restaurantdb
GRANT ALL ON SCHEMA public TO softdev;
```

## Configuration

Connection settings live in `src/main/resources/application.properties`:

- `spring.datasource.url=jdbc:postgresql://localhost:5432/restaurantdb`
- `spring.datasource.username=softdev`
- `spring.datasource.password=Restaurant2026`
- `spring.jpa.hibernate.ddl-auto=update`

Change only if your local PostgreSQL uses different host, port, database name `restaurantdb`, or user `softdev`.

## Run

From the project root (where `pom.xml` is):

```bash
mvn spring-boot:run
```

Then open:

- Static UI: [http://localhost:8080/](http://localhost:8080/)
- Orders API: [http://localhost:8080/api/orders](http://localhost:8080/api/orders)

## API overview

Implemented in `OrderController` (`/api/orders`):

- `GET /api/orders` — list all orders (`ResponseEntity.ok(...)`)
- `POST /api/orders` — create an order (JSON body with `mealName`; status is set in `OrderService`; response `201` with body)
