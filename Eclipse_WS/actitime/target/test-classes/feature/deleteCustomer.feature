@development
Feature: Customer Deletion

  Background: 
    Given user is logged in to the application

  Scenario: Delete customer
    When user click on tasks and verify the task page
    Then user search for a customer Customer-TestngDec-2020-3 and click on settings button
    And click on Actions and delete button
    Then user will confirm by clicking on delete button
    And user validate the success message
    And logout of the application
