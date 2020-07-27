DROP DATABASE IF EXISTS restaurantBookings;

CREATE DATABASE restaurantBookings;

USE restaurantBookings;

CREATE TABLE Bookings
(
BookingID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
FirstName varchar(30) NOT NULL,
LastName varchar(30) NOT NULL,
Mobile varchar(15) NOT NULL,
Email varchar(30) NOT NULL,
DateBooking date
);


INSERT INTO Bookings (FirstName,LastName,Mobile,Email,DateBooking) VALUES ('Peter','Pan','123','peter@pan.com','2017-01-01');
INSERT INTO Bookings (FirstName,LastName,Mobile,Email,DateBooking) VALUES ('Lara','Rios','456','email@email.com','2018-02-03');


