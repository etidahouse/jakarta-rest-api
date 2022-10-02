# jakarta-rest-api

## Requirements
[Docker](https://www.docker.com/)

## Technologies 
[Java 11 (openjdk)](https://openjdk.org/projects/jdk/11/), [Maven](https://maven.apache.org/), [Payara Community Server](https://www.payara.fish/downloads/payara-platform-community-edition/)

[Jakarta EE](https://jakarta.ee/)

## Build project
```bash
sh build
```

## Run project
```bash
sh deploy
```

The service is deployed at http://localhost:8085/api-rest/

## Query

Get all personnes : 
```bash
curl --location --request GET 'http://localhost:8085/api-rest/api/personnes/'
```

Create personne :
```bash
curl --location --request POST 'http://localhost:8085/api-rest/api/personnes/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 2,
    "age": 42,
    "name": "rodriguez"
}'
```

Get a personne :
```bash
curl --location --request GET 'http://localhost:8085/api-rest/api/personnes/0'
```