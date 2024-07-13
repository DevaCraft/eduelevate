# Employee Management System

## Introduction
This project is a simple Employee Management System developed using Spring Boot. It allows for managing employee records including adding, updating, retrieving, and deleting employee details.

## Technologies Used
- Java
- Spring Boot
- Maven

## Features
- Add new employee records
- Retrieve employee details by ID
- Update existing employee records
- Delete employee records

## Getting Started
To run this project locally:
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.

## API Endpoints

### Add Employee
- **POST** `/api/employees`
- Adds a new employee to the system.

### Get Employee by ID
- **GET** `/api/employees/{id}`
- Retrieves details of an employee by ID.

### Update Employee
- **PUT** `/api/employees/{id}`
- Updates the details of an existing employee.

### Delete Employee
- **DELETE** `/api/employees/{id}`
- Deletes an employee from the system.

## Examples

### Add Employee
Request:
```json
POST /api/employees
{
  "name": "John Doe",
  "department": "Engineering",
  "salary": 100000.00
}# eduelevate
Explore and Run
