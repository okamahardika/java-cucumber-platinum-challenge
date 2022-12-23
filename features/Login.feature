@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given navigate to url
    When login as "valid_credential"
    Then current url should be "https://secondhand-store.herokuapp.com/"
