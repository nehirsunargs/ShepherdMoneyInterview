# Shepherd Money Interview Project

This project is a Java-based application developed as part of an interview project. It is designed to manage credit cards, users, and their balance histories.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The project consists of a backend server built using Java and Spring Boot. It provides RESTful APIs for managing users, credit cards, and their balance histories. The application uses Spring Data JPA for data persistence and follows the MVC (Model-View-Controller) architecture pattern.

## Features

- Create, read, update, and delete users
- Add credit cards to users
- Retrieve all credit cards associated with a user
- Find the user associated with a credit card
- Update credit card balance history with transactions

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) 8 or later
- Apache Maven
- MySQL or another compatible database server

## Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/interview-project.git
   ```

2. Navigate to the project directory:

   ```bash
   cd interview-project
   ```

3. Build the project using Maven:

   ```bash
   mvn clean package
   ```

4. Run the application:

   ```bash
   java -jar target/interview-project.jar
   ```

## Usage

Once the application is running, you can interact with it using any HTTP client, such as Postman. The application exposes RESTful endpoints for managing users and credit cards. See the [Endpoints](#endpoints) section for details on available endpoints and their usage.

## Endpoints

- **POST /user**: Create a new user.
- **DELETE /user**: Delete a user by ID.
- **POST /credit-card**: Add a credit card to a user.
- **GET /credit-card:all**: Retrieve all credit cards associated with a user.
- **GET /credit-card:user-id**: Find the user associated with a credit card by card number.
- **POST /credit-card:update-balance**: Update credit card balance history with transactions.

## License

This project is licensed under the [MIT License](LICENSE).
