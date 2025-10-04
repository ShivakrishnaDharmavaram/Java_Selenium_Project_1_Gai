# Automated Login Form Testing Using Selenium

## Project Overview
This project automates the testing of a login form on the demo website:  
https://the-internet.herokuapp.com/login

It covers multiple login scenarios including valid login, invalid login, and empty input fields using Selenium WebDriver in Java with TestNG framework.

---

## Features
- Valid login test using correct username and password.
- Invalid login test with wrong credentials.
- Empty field validation with appropriate error messages.
- Page Object Model (POM) design pattern implementation.
- Use of explicit waits for element synchronization.
- Test assertions to verify expected behaviors.

---

## Technologies Used
- Java 17
- Selenium WebDriver
- TestNG testing framework
- ChromeDriver (can be replaced with other browser drivers)
- Maven for build and dependency management

---
## Setup Instructions

- Create a maven project in intellij and add mentioned and required dependencies.
- Implement LoginTest code to automate the process.
- Download or clone the project and run tests directly from IDE, right-click on `LoginTests.java` and choose Run.

## Code Highlights

- Project follows **Page Object Model (POM)** for separation of page and test logic.
- Explicit wait usage for synchronization.
- Assertions validate success/error messages on login.
- Tests organized using TestNG annotations.


# How to run this project

- Download and unzip the project.
- Import it in Intellij
- Update the project correctly
- Run the LoginTest file to execute the code.

