Feature: Login Functionality

	@actitime
  Scenario Outline: Successful Login
    Given user is on login page
    When user enter valid <username> and <password>
    And click on login Button
    Then user will be landed in dashboard page
    And close the browser

    Examples: 
      | username | password |
      | admin    | manager  |
      | admin    | manager  |
