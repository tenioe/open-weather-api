
<h1 align="center">OpenWeather API Project</h1>
<img alt="Project Sparta Badge" src="https://img.shields.io/badge/project-sparta-%23e43560?label=project&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAABZVBMVEVAIFHkNWBBH1FDHlHiNmBBH1LON2DlNWBcHVH+/v////3FNmFAHlRAG08/H1A+IFFhIU5BHlL9/fxBH05EHVL///xAHlH9//3//v3Y0dnjNl9LLFhCHVRDG08+IU79//v7//vMwtD4+Pi8scF6ZITjNmLfOF5BI1JDHU/28/ZuV3pGKFZEI1FnH08/HU339veDbI7kNV7iN11NHlE/HEv//////P/7/PrVOGPdN2JiIVE8IVFAHU8/H05UHk1AGU1HHUxNHEy8scCklamjk6iCa4p3YYDRNmbKNmLHNmHBNWHnNGCvMGBTH1NAHFHy7PLt6e/Vy9iwpLWwpLSoma6jkKaXf5t6ZoFvVnpgRG1hS2lYPWW1M11NMFqMLViLJ1iVLFd2KVd7JVR2IFOHKFJeIVFaH009GUjg2ePDuMfAucKzqLqxpbiQeZeMe5HaOGTQN2CqNGCmLF+dLFuEKllJJ1lGKFVpXQQhAAACNUlEQVR42qXQhXajWACAYZyQwmVxSrwtbNzdU7fU3X3c5fmHCHMgDcfmj4ePa9A4XBQ50GBxZzQqAMgW28BpWkYccVwwaDdCMNAreP5zVk+l+rg1CBREAu3HH1cbxKvuWQuJXPdhu2pgGAaT9raw2r1sTdUo3H3F8vkBckRqa3VujJDuXS2XN4xXKKdt9v0jIqI/q8NRdFjXHEjb2i4MEYLLL5ukhuVIUqutrc842rgRhmeA0umn2haskXr16inlcdYu0NCgKN3b1nUsp63dtqMcJ3P0IM7vH3ywAB+OJID2DGZmfO+x/mbw/1HJZBKxH7X8vG4avfoIgLD6YX7Y4uL8SsuOkDqBma0/s+nzt4p3FFVaTkO2xBSBGXltwyMzCxmFokIURalh5diO2EaKMIwcOeMBzMKceZ2vVCp8hT8u2geS6wQJY/oIlVV+cSU76BzYR/L3b75tEl/GKMSfvOl00szODm5HEN7tvaQebgt/UbFYZBgOmghncdBtQaPpIstLS0vLK78mFEv7ab/IscOFU6okSd5S7FNrAiFRVAAox6xmeIoKK4qi8uF3SWhq4HJWMg+yVPKGKG8kMd1ArfjRweHB4ftM2BUFg/5mOtpsFi/2XBBiJiAM0wkEOu4IRdHodXzQ2edddyQyq7uxQRmeHyB5OjrNhFRVCYVUhQ9HfkMuaC4kDfMq/JHggs72Z8ftf7wE0xcuJH1W18kdfPoRQLIcDZhFAyjOOc3kgIMQd/Fv6A8ksVwk6PNPnQAAAABJRU5ErkJggg=="/>
A project to build a testing framework for an api.

## Table Of Contents

### About
A group project focused on developing testing frameworks for open-source APIs within an agile enviroment.  
- **The API we will be using: https://openweathermap.org/current**
- **The framework will be made using JUnit and Jackson.**
- **Agile Framework: Scrum**

### Our Team
Every member is a developer and a tester.

- **Teniola Etti** - SCRUM Master
- **Alex Sikorski** - Development
- **Jakub Matyjewicz** - Development
- **Golam Choudhury** - Development
- **Jack Ingham** - Development
- **Kurtis Hanson** - Development
- **Dominic Cogan-Tucker** - Development

### Tools

- JDK 11
- Maven
- Hamcrest
- IntelliJ
- JUnit 5
- Jackson
- Git

### Project Architecture
- The program will use **Service Object Model** to represent the various API requests.
   - DTO: Classes that represent the different requests.
   - ConnectionManager: A class which handles the connection to the live system and collects the response. 
   - Injector: A class responsible for injecting the payload into weather DTOs


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

### Sprint 0 
#### The Product Backlog
As a team, we had inspected the Open Weather Map API and assessed what possible things a tester would want to test.

Building on this, User Epics were constructed which were then broken down further into user stories to populate the product backlog.

Each User Story had its own user acceptance criteria and list of developer requirements to ensure that a certain standard is met
before each story is considered a closed issue.

The progress and structure of the project will be continuously updated throughout the Sprint.

#### Building the Project - First Stages
- Created an Interface for each section of the API response (e.g., 'weather', 'wind', 'cloud')
- Created Interfaces for the two distinctly different response cases (single city, list of multiple cities)
- Created an interface for default methods which are common across all DTOs.

### Sprint 1
#### Requirements
A tester will be able to easily choose which distinct endpoint to use for openweathermap api.

The framework has the option of two DTOs, single city and multiple city. depending on which endpoint they decide to use. 

A tester will not have to worry about the internal differences between the single and multiple city responses, such as 
differences in the naming of keys. 

### Epics
#### Epic 1 - *As a product owner, I want to see some documentation of Sprints, so that I can see what work is done and how*
#### Epic 2 - *As a tester, I want to see documentation of the framework, so that I can understand how to use it*
#### Epic 3 - *As a tester, I want to use a framework to aid me with specific test cases*
#### Epic 4 - *As a tester, I want to see DTOs for all types of API calls I can make so that I can view and test the data*


## Documentation
### Different Types of Responses
The Open Weather Map API has two distinct cases for responses to API calls:
- Single City Response
- Multiple City Response
### Initiating the Connection
- The ConnectionManager's **getConnection()** method provides the end-point, allowing the user to add
  parameters based on what exactly needs to be tested.
- The end-points and the corresponding parameters which can be passed into getConnection() are:
    - **BY_CITY_NAME**, (city_name, state_code, country_code)
        - *Requires a minimum of city_name, state_code and country_code are optional*
    - **BY_CITY_ID**, (city_id)
    - **BY_COORDS**, (longitude, latitude)
    - **BY_ZIP**, (zip_code, country_code)
    - **BY_BBOX**, (bounded_box)
    - **BY_CIRCLE**, (longitute, latitude, cnt)

| **API Endpoint** | **Type of Response** |         
|--------------|----------------------|
| BY_CITY_NAME | Single City          |
| BY_CITY_ID   | Single City          |
| BY_COORDS    | Single City          |
| BY_ZIP       | Single City          |
| BY_BBOX      | Multiple City        |
| BY_CIRCLE    | Multiple City        |


| **Type of Response** | **DTO to Use**         |
|----------------------|------------------------|
| Single City          | *CityDTO.java*         |
| Multiple City        | *MultipleCityDTO.java* |

- **InjectDTO()** takes a fully constructed URL and uses ObjectMapper() of the Jackson library to read JSON as POJOs
  and "inject" them into the DTOs.

### Example Set-Up & Test
```java
static CityDTO cityDTO;

@BeforeEach
void setUp() {
    cityDTO = Injector.injectDTO(ConnectionManager.getConnection(EndPoint.BY_CITY_NAME, "Memphis"));
}

@Test
@DisplayName("Check the cloud coverage is between 0 and 100")
void checkTheCloudCoverageIsBetween0And100() {
    Assertions.assertTrue(cityDTO.getCloudDTO().isBetween0and100());
    System.out.println(cityDTO.getCloudDTO().getCloudCoverage());
}
```

***IMPORTANT*** - You will require an API key from [Open Weather Map](openweathermap.org/api) in order to make API calls. place this key in a file named 
'application.properties' in the resources directory.

Example of api-key in **application.properties**:
*api.key = xxxxxxxxxxxxxxxxxxxx...*


### Dependencies

```
<dependencies>
   <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.7.1</version>
      <scope>test</scope>
   </dependency>
   <dependency>
     <groupId>org.hamcrest</groupId>
     <artifactId>hamcrest-all</artifactId>
     <version>1.3</version>
     <scope>test</scope>
   </dependency>
   <dependency>
     <groupId>com.fasterxml.jackson.core</groupId>
     <artifactId>jackson-databind</artifactId>
     <version>2.12.3</version>
   </dependency>
</dependencies>
```
