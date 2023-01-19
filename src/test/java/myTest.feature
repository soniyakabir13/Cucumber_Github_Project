Feature: As a user of google
  I would like to search for any keyword I wish
  in order to make most out of any google experience

  Scenario: verify user can search a keyword and see result

    Given I am on the google home page
    When I enter "Macbook pro" keywords
    When I should see a result


  Scenario: verify if user search a keyword that is not in the index it should not display any results
    Given I am on the google home page
    When I enter "xdfgjjuytreagyhjmllikj@#$jhkoouyt" keywords
    Then I should not see a result


  Scenario Outline: verify if user can search for 1000/ multiple keywords keywords and gets results
    Given I am on the google home page
    When I enter "<keywords>" keywords
    Then I should see a result
    Examples:
      | keywords |
      | apple    |
      | orange   |
      | cars     |


  Scenario Outline: verify if user can search for 1000 keywords and do not gets results
    Given I am on the google home page
    When I enter "<keywords>" keywords
    Then I should not see a result
    Examples:
      | keywords               |
      | &%$AXDFHJJM            |
      | @#$astykmnbv           |
      | @#$AZXCVBGFFHGHJRTTYUI |







