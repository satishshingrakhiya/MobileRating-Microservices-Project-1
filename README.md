# MobileRating-Microservices-Project-1
This is bare minimum Microservices project, which represents how microservices communicate.

## Prerequisite
1. Java 11

## How to install and run project
1. Clone the repository
2. Open Project in IntelliJ (or Your Favourite IDE)
3. Start each microserivice one by one
4. Go to http://localhost:8081/catalog/name to see output of mobile-catalog-service which is consumer of mobile-info-service and rating-info-service
5. Go to http://localhost:8761/ to see all the microservices which are registered with eureka server
6. Go to mobile-catalog-service inside controller package to see use of Rest Template and Discovery Server to make calls to other microservices
7. Use Postman tool to check all the apis in each microserive
