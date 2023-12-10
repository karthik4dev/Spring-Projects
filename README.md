# **Book Application**

## This is example application to learn how Docker can be used to wrap 3 microservices i.e, Spring Application, MySQL and Prometheus 

## Checklist:
[X] Spring REST Methods.  
[X] Spring Actuator.  
[X] Spring JPA.  
[] Spring Security.  
[X] Prometheus.  

This application is still in development. 
###P roposed final date : 10-Jan-2023

# prerequisite:
- JDK 18
- Gradle
- MySQL 
or 
- Docker

## How to install application without **Docker**?
- check if your MySQL is running
- check ** spring.datasource.url ** and give the correct credentials in application.properties file. For Eg :
	- spring.datasource.url=jdbc:mysql://db:3306/book_application
	- spring.datasource.hikari.connectionTimeout=30000
	- spring.datasource.username=application_user
	- spring.datasource.password=application123!
- Run Gradle Build which will produce Executable Jar file in ./build/libs
- Go to Command Prompt and run "java -jar <jar file name>". 

* Note : Prometheus is used here as Docker image. So You can pull using docker command **"docker pull prom/prometheus:latest"** and replace file **/src/resources/prometheus.yml** file in **/etc/Prometheus/Prometheus.yml** *

## How to install application with ** Docker **?
- Check docker compose YML file for exposed port
- Run "docker compose up -d"
- run the URL ** "http://localhost:9090/status for application status" **

* Note: Sometimes Application will be stopped due to late initialization of MySQL DB. You can run command ** docker-compose run web -d **

