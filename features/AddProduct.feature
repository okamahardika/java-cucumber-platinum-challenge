@addedProduct
Feature: Added Product

  @addedProduct @positive
  Scenario: As a user should be able to added new product
    Given navigate to url
    * login as "valid_credential"
    * click button jual
    When input valid data for product
    Then current url should be "https://secondhand-store.herokuapp.com/"
