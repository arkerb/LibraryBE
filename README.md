# LibraryBE

### Simple Library REST API

## Setup

Requires Java 11 to run

Make sure to run build.gradle. Once built run LibraryApplication to start the server

Default port is 8080

## How to use

The application uses an in-memory database H2 for a quick and easy setup. No docker is required. The database will hold
data until the server has been stopped. On server start it uses Class config files to create test data.

To access to database use go to
`http://localhost:8080/h2-console`
Login data has already been provided.

Use postman to make simple request

Example request

`http://localhost:8080/api/user/1`

## Comments

Application is not 100% ready. There are features that haven't yet been implemented.

Repository doesn't see @Lombok Setter, Getter and Constructors, so they had to be manually added.

### TODO

- Create authorization once Front-End application has been created
- Create tests
- Encrypt passwords when saving to database


