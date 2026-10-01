Feature: Login functionality

  Background:
    Given I am on the login page

  @smoke
  Scenario Outline: Login validation using multiple credentials

    When I enter valid username "<username>" and password "<password>"
    And I click on login button
    Then I should be logged in successfully with "<message>"

    Examples:
      | username  | password              | message                        |
      | tomsmith  | SuperSecretPassword!  | You logged into a secure area! |
      | wronguser | SuperSecretPassword!  | Your username is invalid!      |
      | tomsmith  | wrongpassword         | Your password is invalid!      |
