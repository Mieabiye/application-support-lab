Application Support Lab

Overview

Application Support Lab is a backend application developed to demonstrate practical application support and incident management skills.

The project simulates a basic IT support incident management system where support personnel can retrieve, create, update, and delete incidents reported by users.

It is built with Kotlin and Spring Boot, using an H2 database for data persistence.

Objectives

- Demonstrate REST API development.
- Practise incident management operations.
- Work with relational database persistence.
- Understand application troubleshooting and backend development.
- Build practical skills relevant to IT and Application Support roles.

Technologies Used

- Language: Kotlin
- Framework: Spring Boot
- Build Tool: Gradle
- Database: H2 Database
- Persistence: Spring Data JPA / Hibernate
- JDK: Java 17
- Development Environment: IntelliJ IDEA

Features

- Retrieve all recorded incidents.
- Retrieve an individual incident using its ID.
- Create new incidents.
- Update the status of existing incidents.
- Delete incidents.
- Automatically load sample incidents when the database is empty.
- Persist incident records using an H2 file-based database.

Incident Information

Each incident contains:

Field| Description
ID| Unique incident identifier
Title| Short description of the issue
Description| Details of the reported problem
Priority| HIGH, MEDIUM, or LOW
Status| OPEN, IN_PROGRESS, or RESOLVED

API Endpoints

Base URL: "http://localhost:8081"

Method| Endpoint| Purpose
GET| "/api/incidents"| Retrieve all incidents
GET| "/api/incidents/{id}"| Retrieve an incident by ID
POST| "/api/incidents"| Create a new incident
PUT| "/api/incidents/{id}/status?status=RESOLVED"| Update incident status
DELETE| "/api/incidents/{id}"| Delete an incident

Running the Application

Prerequisites

- JDK 17 or later
- IntelliJ IDEA or another Kotlin-compatible IDE
- Git

Steps

1. Clone the repository:
   
   git clone https://github.com/Mieabiye/application-support-lab.git

2. Open the project in IntelliJ IDEA.

3. Allow Gradle to complete project synchronisation.

4. Run the Spring Boot application.

5. Open the API in your browser:
   
   "http://localhost:8081/api/incidents"

Database Configuration

The application uses an H2 file-based database.

Database URL:

"jdbc:h2:file:./data/incidentdb"

The H2 console is available at:

"http://localhost:8081/h2-console"

Login details:

- JDBC URL: "jdbc:h2:file:./data/incidentdb"
- Username: "sa"
- Password: Leave blank

Project Status

The core incident management API has been implemented. GET operations have been tested successfully. POST, PUT, and DELETE endpoint testing is still in progress.

Learning Outcomes

Through this project, I am developing practical experience in:

- RESTful API development.
- Backend application support.
- Database integration and persistence.
- Incident lifecycle management.
- Application configuration and troubleshooting.
- Version control using Git and GitHub.

Author

George Mieabiye David

GitHub: "Mieabiye" (https://github.com/Mieabiye)