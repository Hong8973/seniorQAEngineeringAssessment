# QA Assessment

A sample UI project using Selenium, Java, Maven and Cucumber.

The test loads the website, opens the accordion for Filter by Minister, selects the minister, runs the search and verifies that all the results on all result-pages contain that minister in the tags.

Structure:
- The Use Case (Scenario) is documented in: src/test/resources/pages/search.feature
- Each line in the Scenario is linked to code in a Step Definition class: src/test/java/stepdefinitions/SearchStepDefinitions 
- The Step Definitions are then linked to code in classes generally organised by web page, with another class for common reusable methods located in: src/main/java/pages 
- The page objects are kept with the relevant class relating to the web page

# Issues
Unfortunately I was not able to complete the challenge successfully, due to issues with chrome version 103.

The following error kept occurring: "org.openqa.selenium.WebDriverException: unknown error: unexpected command response"

I attempted to fix the issue by googling the error message and trying various suggestions.
I also tried to change to the firefox browser, but I ran out of time.

I would have liked to have added more assertions, however the chrome issue took up most of my time.


# Instructions on how to run

## Prerequisites to run

This requires the following:
* Java JDK
* Maven
* Cucumber plugin
* Chrome browser

## Use Maven to run

Open a command window, navigate to the folder where the project files are located and run:

    mvn test

This runs the Search feature using Cucumber's JUnit runner.
