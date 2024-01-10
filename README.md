# **Book Application**

## This is example application to learn how Docker can be used to wrap 3 microservices i.e, Spring Application, MySQL and Prometheus 

## Currenty in development
1. Adding data to the API (probably will fetch from other API for books but will add Users via API)
2. Usage of mockito framework
3. Refactor of security code 
4. Usage of Bcrypt password encoder or will Use JWT in future

## Checklist:
[X] Spring REST Methods.  
[X] Spring Actuator.  
[X] Spring JPA.  
[X] Spring Security.  
[X] Prometheus. 
[X] Swagger

This application is still in development. 
### Proposed final date : 10-Mar-2024

# prerequisite:
- JDK 18
- Gradle
- MySQL 
or 
- Docker

## How to install application without __Docker__ ?
- check if your MySQL is running
- check __spring.datasource.url__ and give the correct credentials in application.properties file. For Eg :
	- spring.datasource.url=jdbc:mysql://db:3306/book_application
	- spring.datasource.hikari.connectionTimeout=30000
	- spring.datasource.username=application_user
	- spring.datasource.password=application123!
- Run Gradle Build which will produce Executable Jar file in ./build/libs
- Go to Command Prompt and run " java -jar <jar file name> ". 

* Note : Prometheus is used here as Docker image. So You can pull using docker command **"docker pull prom/prometheus:latest"** and replace file **/src/resources/prometheus.yml** file in **/etc/Prometheus/Prometheus.yml** *

## How to install application with ** Docker **?
- Check docker compose YML file for exposed port
- Run "docker compose up -d"
- run the URL __"http://localhost:9090/status for application status"__

__Note: Sometimes Application will be stopped due to late initialization of MySQL DB. You can run command ** docker-compose run web -d__