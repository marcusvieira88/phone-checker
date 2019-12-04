# Phone Checker

It is a single page application in Java that shows a customers list categorized by country and phone state (valid or not valid).

## Run 
```
mvn spring-boot:run
```
The home page can be access in http://localhost:8080.

## Docker Image 

Create project jar:
```
mvn package
```

Build Docker image:
```
docker build -t <docker-hub-account>/phone_checker_v1.0 .
```

Run Docker image:
```
docker run -p 8080:8080 -it <docker-hub-account>/phone_checker_v1.0
```

## Technologies
Below the technologies used in this project:

* Java 11 - programming language (current long-term support release version).
* Thymeleaf - Used for create home page template.
* Bootstrap 4 - Used for page CSS. 
* Spring Boot Data JPA - Used to access SQlite data.
* SQlite - Customers database.
* MockMVC - Template tests.
* JUnit5 - Unit tests.
* Lombok - Avoid boilerplate java code.
* MapStruct - Avoid boilerplate copy values code.
* Docker - Create a file for build a project image.
