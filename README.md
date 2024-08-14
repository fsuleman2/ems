# [EMS](https://github.com/fsuleman2/ems)

**Employee Management System** is a Spring Booot Application designed for use within an Employee Management System (EMS-REST). This service handles various RESTful operations related to employee management, such as creating, reading, updating, and deleting employee records.

## Features

- **RESTful API**: Provides endpoints for managing employee data.
- **Microservice Architecture**: Designed to be part of a larger EMS, allowing for modular and scalable development.
- **CRUD Operations**: Supports Create, Read, Update, and Delete operations for employee records.
- **Integration Ready**: Easily integrates with other services within the EMS ecosystem.

## Getting Started

### Prerequisites

- **Java 17 or higher**
- **Spring Boot**
- **Spring DATA JPA**
- **Maven**
- **Database (e.g. PostgreSQL)**

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/fsuleman2/ems.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd ems
    ```

3. **Build the project:**

    Using Maven:
    ```bash
    mvn clean install
    ```

    Or using Gradle:
    ```bash
    ./gradlew build
    ```

4. **Run the application:**

    ```bash
    java -jar target/ems-0.0.1-SNAPSHOT.jar
    ```
5.  **Clone the Microservice**
     ```bash
    git clone https://github.com/fsuleman2/ems-rest.git
    ```
### Usage

After starting the application, the REST API will be available. You can interact with it using tools like `curl`, Postman, or any HTTP client.

For example, to get a list of all employees:

```bash
GET http://localhost:9090/employees
