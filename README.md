# Movie Database API

## Description

The Movie Database API is a simple RESTful API built with Spring Boot that allows users to manage and query movies, actors, and directors. The system supports operations such as viewing a list of movies, adding new movies, updating existing movies, and searching for movies by title or release date. The data is persisted in a MongoDB database using Spring Data MongoDB.

## Features

- View a list of all available movies.
- Add new movies to the database.
- Update existing movie details.
- Search for movies by title or release date.
- Manage actors and directors associated with movies.

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data MongoDB
- MongoDB
- Maven
- JUnit 5
- Mockito (for unit testing)

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.x](https://maven.apache.org/download.cgi)
- [MongoDB](https://www.mongodb.com/try/download/community)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/bshevyrov/epam-mid-task3.git
cd epam-mid-task3 
```
### 2. Configure Environment Variables
```bash
MONGO_DB_URI=db_uri
MONGO_DB_USERNAME=db_username
MONGO_DB_PASSWORD=db_password
MONGO_DB_DATABASE=db_name
```
### 3. Build the Application
```bash
mvn clean install
```
### 4. Run the Application
```bash
mvn spring-boot:run
```


## Chat GPT log


[chat.html](chat.html)