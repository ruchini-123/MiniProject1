
# Student Database Management System

A console-based Java application using JDBC to manage student information in a MySQL database.

## Features
- Add new students
- View all students
- Update student information
- Delete students

## Setup Instructions

### Prerequisites
- Java 8 or later
- MySQL Server
- MySQL Connector/J (JDBC driver)

### Database Setup
1. Create the database:
   ```sql
   CREATE DATABASE studentdb;
   USE studentdb;
   
   CREATE TABLE students (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100),
       age INT,
       grade VARCHAR(10)
   );
