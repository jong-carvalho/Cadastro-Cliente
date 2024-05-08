## Project  - Simple Customer Registration 

This project was built to be a customer registration. 
In order to be a simple base software for testing technologies such as:
> Kafka, Rabbit MQ, Flyway, Liquibase, Prometheus, Grafana, Jenkins and etc.

The project containing five endpoints: 
- **GET**: Get all the customers
  - ` curl --location 'localhost:8080/clients' `
- **GET**:Get customer by id 
  - ` curl --location 'localhost:8080/clients/CLI_3AB68719-C610-46A9-85AC-8D1D6F5EFF9B' \
    --data '' `
- **POST**: Create a new customer
  - ` curl --location 'localhost:8080/clients' \
    --header 'Content-Type: application/json' \
    --data '{
    "client_name": "Joao",
    "client_phone": "(11)123456789",
    "client_cpf": "123.456.789-05"
    }' `
- **PUT**: Change a customer
  - ` curl --location --request PUT 'localhost:8080/clients/CLI_3AB68719-C610-46A9-85AC-8D1D6F5EFF9B' \
    --header 'Content-Type: application/json' \
    --data '{
    "client_name": "Joao",
    "client_phone": "(11)123456789",
    "client_cpf": "99999999999"
    }' `
- **DELETE**: Delete a client by id
  - ` curl --location --request DELETE 'localhost:8080/clients/CLI_D772BAC1-0F49-4421-8F67-D9E85707F8ED' `


___

Teste
