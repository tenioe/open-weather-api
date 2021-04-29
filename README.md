
# 
<h1 align="center">OpenWeather API Project</h1>
A project to build a testing framework for an api.

## Table Of Contents

### About
A group project focused on developing testing frameworks for open-source APIs within an agile enviroment.  
- **The API we will be using: https://openweathermap.org/current**
- **The framework will be made using JUnit and Jackson.**
- **Scrum agile enviroment**

### Our Team
Every member is a developer and a tester.

- **Teniola Etti** - SCRUM Master
- **Alex Sikorski** - Development
- **Jakub Matyjewicz** - Development
- **Golam Choudhury** - Development
- *Jack Ingham* - Development
- **Kurtis Hanson** - Development
- **Dominic Cogan-Tucker** - Development

### Tools

- JDK 11
- Maven
- Hamercrest
- IntelliJ
- JUnit 5
- Git
- Github

### Rules :

* Do not touch the master branch.
* Branches : 
    *  The dev branch acted as our final increment stage version of the product.
    *  Feature branches were features worked on whcih were to be merged into the dev branch.
        * Naming convention: ticket#/module-worked-on
          * t10/weatherdto
          * t10/weatherdto-impl
          * bugfix/connection-manager-and-injector
* Follow SOLID principles.
* Strictly adhere to OOP for scalability, maintainability, testability, and general robustness.
* Document the project throughout form the start to ensure integrity.
* Program individually and review git pull requests by one other member.

### Our Definition of Done :heavy_check_mark:

1. Sprints are documented.
2. Each feature has a test case. 
3. Framework has been reviewed by stakeholders.
4. Kanban accurately represnets our project state.
5. Test cases exit for each feature.

### Project Architecture
- **The program will use Service Object Model to represent the various API requests.**
1. DTO: Classes whcih represent the various requests to be made.
2. ConnectionManager: A class which handles the connection to the live system and collecting the response. 
3. Injector: A class responsible for injecting the payload into weather DTOs

### Sprint 0 
#### The Product Backlog
As a team, we had inspected the Open Weather Map API and assessed what possible things a tester would want to test.

Building on this, User Epics were constructed which were then broken down further into user stories to populate the product backlog. 

Each User Story had its own user acceptance criteria and list of developer requirements to ensure that a certain standard is met 
before each story is considered a closed issue. 

### Building the Project - First Stages
- Created an Interface for each section of the API response (e.g., 'weather', 'wind', 'cloud')
- Created Interfaces for the two distinctly different response cases (single city, list of multiple cities)
- Created an interface for default methods which are common across all DTOs.


## Documentation

### Dependancies

