# SpringBoot API Starter

***
## Setup Database

#### Start The docker-compose File
*RUN*: `docker-compose up -d`

#### Exec The Postgre Container
*RUN*: `docker exec -it springboot-api-postgres-c psql -U admin`

List All Databases
*RUN*: `\list`

CREATE ecommerce DATABASE
*RUN*: `CREATE DATABASE starter;`

List All Databases
*RUN*: `\list`

_THIS SHOULD NOW INCLUDE A NEW DATABASE_ `starter`
***
### NOW RUN THE PROJECT - `MAIN.java`

##### In IntelliJ IDEA - navigate to MAIN.java File Under - `src > main > java > com.ecommerce`
#### In The Top Bar Select `main` and then click on `Play Icon` To Start The Project.


***

## SWAGGER DOCS

#### In Your Browser Open: `http://localhost:8080/swagger-ui/index.html`

Most of the APIs are protected so user needs to be authenticated to use those. Create a new user `/api/v1/auth/register`, copy the token from response, click on `authorize` button in `top-right` corner and paste the token in `value field`, and click on `authorize`.

##### Now protected routes can be used.