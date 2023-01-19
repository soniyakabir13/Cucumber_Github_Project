Feature: As a user of google
  I would like to search for any keyword I wish
  in order to make most out of any google experience

  Scenario: verify user can search a keyword and see result

    Given I am on the google home page
    When I enter "Macbook pro" keywords
    When I should see a result
