# 🏨 REST API Hotel

REST API for a Hotel where customer can check room availability, place a reservation, cancel it or modify it.


## 🚀 Getting started
1. This application is connected to a MySQL DB, so we need to create the following schema and table running below script:
```sql
CREATE SCHEMA `hotel` ;

CREATE TABLE hotel.HotelBooking (
	ID int NOT NULL,
    Name varchar(20),
    ArrivalDate date,
    DepartureDate date,
    PRIMARY KEY (ID)
);

```
2. Clon the project.
3. Inside the project look for "application.yaml" file and set your **DB credentials**
```yaml
    username: 
    password: 
```
4. Open the project on IntelliJ or eclipse and run the main class HotelApplication.java for running the project

## 🛠 Rest API methods

```text
POST /api/book-room
```
* Description: Used to book the room if it's available. 

```text
DELETE /api/cancel-reservation/{id}
```
* Description: Used to cancel the reservation

```text
GET /api/find-reservation/{id}
```
* Description: Used to see reservation information

```text
PUT /api/update-reservation
```
* Description: Used to update the reservation

```text
GET /api/checkRoomAvailability
```
* Description: Used to check available dates for reservation

#### For more information you can check the swagger documentation in following link:

```text
http://localhost:8080/swagger-ui/index.html
```

#### You can find the postman collection inside the project in the following path: 

```text
/hotel/src/main/resources/Hotel.postman_collection.json
```

## 💻 Technologies:
* Java 17
* Spring Boot 3
* Hibernate
* Gradle
* Lombok
* MySQL

Developed by [Pedro Delgadillo](https://github.com/pedrodelg)💻
