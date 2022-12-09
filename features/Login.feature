@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given open browser "chrome" and go to url "https://www.saucedemo.com/"
    When login as "standard_user"
    Then current url should be "https://www.saucedemo.com/inventory.html"
    And close browser

  @login @positive
  Scenario: As a user i should be able to login and logout
      Given open browser "chrome" and go to url "https://www.saucedemo.com/"
      When login as "standard_user"
      Then current url should be "https://www.saucedemo.com/inventory.html"
      * user logout
      * close browser

  @login @negative
    Scenario Outline: As a user i should not be able to login because credential is not valid
      Given open browser "chrome" and go to url "https://www.saucedemo.com/"
      When login as "invalid_user"
      Then user verify error message with value "<errorMessage>"
      And close browser
      Examples:
        | errorMessage                                                              |
        | Epic sadface: Username and password do not match any user in this service |

  @About @positive
  Scenario: As a user i should be able to direct to about page
    Given open browser "headless chrome" and go to url "https://www.saucedemo.com/"
    And login as "standard_user"
    And current url should be "https://www.saucedemo.com/inventory.html"
    When user click about sidebar
    Then current url should be "https://saucelabs.com/"