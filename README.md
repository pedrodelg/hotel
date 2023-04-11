# 🏨 REST API Hotel

REST API where customer can check room availability, place a reservation, cancel it or modify it.


## 🚀 Getting started
1. This application is connected to a MySQL Data base so we need to create following schema and table
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

```bash
Post /api/book-room
```
* Description: Use to book the room if it's available. 

```bash
Delete /api/cancel-reservation/{id}
```
* Description: Use to cancel the reservation

```bash
Get /api/find-reservation/{id}
```
* Description: Use to check the reservation

```bash
Put /api/update-reservation
```
* Description: Use to update the reservation


## 💻 Technologies:
* Java 17
* Spring Boot 3
* Hibernate
* Gradle
* Lombok
* MySQL

