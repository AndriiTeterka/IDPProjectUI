# Personal IDP Plan: Java automation framework for web application
This project is a personal IDP (Individual Development Plan) initiative focused on creating an
automated testing framework for web application. The framework aims to improve test coverage,
efficiency and skills in test automation.

# Features
- **Browser Automation with Selenide:** Selenide simplifies browser automation tasks by
providing a user-friendly API and enhancing test stability.
- **Modular Design with Page Object Pattern:** The framework follows a modular
design approach, implementing the Page Object pattern. This promotes code reusability,
maintainability, and readability.
- **Support for Different Testing Levels:** The framework supports unit testing, integration
testing, and end-to-end testing, ensuring comprehensive test coverage.
- **Test Data Management with Typesafe Config:** Efficient management of test data using
Typesafe Config allows for flexible and structured handling of test data.
- **Logging and Reporting with LogBack and Allure Reports:** Detailed logging with LogBack
and comprehensive reporting with Allure Reports aid in troubleshooting and analysis
of test results.
- **Test Execution and Assertions with TestNG:** TestNG facilitates the execution of test
cases, supporting parallel execution, data-driven testing, and various types of assertions.
- **Integration with Build Systems:** The framework seamlessly integrates with Maven for
easy incorporation into development and CI pipelines.
- **Continuous Integration with GitHub Actions:** The project includes continuous
integration (CI) using GitHub Actions, enabling automatic build, test and reporting processes
triggered by code changes in *master* branch.

## Installation and configuration
1. Clone the repository to your local machine or download the project as a ZIP file.
2. Open the pom.xml file in the project root directory. Update the project dependencies 
and plugins as per your requirements. (Optional)
3. Open the testng.xml file in the project root directory.Customize the <test> and <classes>
sections to include or exclude specific test classes or packages. (Optional)
## Building the Project
To build the project and download the necessary dependencies, run the following command:
```
mvn clean install
```

To execute the test suite defined in the testng.xml file, use the following command:
```
mvn test
```
