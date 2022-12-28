@addOfferItem
Feature: Added Product

  @addOfferItem @positive
  Scenario: As a user should be able to added new product
    Given navigate to url
    * login as "valid_credential"
    * click card item
    * click offer and put price offer
    When click button send
    Then Alert success will shown
