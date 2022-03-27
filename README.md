# Rest API

## Usage on Windows

### Run the application on Windows

``````
.\mvnw.cmd clean spring-boot:run
``````

### Example of usage on Windows

``````
curl -i -X POST http://localhost:8080/api/createUser -H 'Content-Type:application/json' -d '{\"name\":\"Guy\"}'
``````
``````
curl -i -X POST http://localhost:8080/api/createAccountForUser/1
``````
``````
curl -i -X POST http://localhost:8080/api/depositForAccount/1?amount=10000
``````
``````
curl -i -X POST http://localhost:8080/api/withdrawalForAccount/1?amount=3000
``````
``````
curl -i http://localhost:8080/api/historyForAccount/1
``````
``````
curl -i -X POST http://localhost:8080/api/createAccountForUser/1
``````
``````
curl -i -X POST http://localhost:8080/api/depositForAccount/2?amount=20000
``````
``````
curl -i http://localhost:8080/api/getUser/1
``````

## Usage on Linux

### Run the application on Linux

``````
.\mvn clean spring-boot:run
``````

### Example of usage on Linux

``````
curl -i -X POST http://localhost:8080/api/createUser -H 'Content-Type:application/json' -d '{"name":"Guy"}'
curl -i -X POST http://localhost:8080/api/createAccountForUser/1
curl -i -X POST http://localhost:8080/api/depositForAccount/1?amount=10000
curl -i -X POST http://localhost:8080/api/withdrawalForAccount/1?amount=3000
curl -i http://localhost:8080/api/historyForAccount/1
curl -i -X POST http://localhost:8080/api/createAccountForUser/1
curl -i -X POST http://localhost:8080/api/depositForAccount/2?amount=20000
curl -i http://localhost:8080/api/getUser/1
``````
