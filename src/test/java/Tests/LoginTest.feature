Feature: As a user I would like to be able to
  login to flight reservation application

 Scenario: verify login using a valid user name and valid password
 Given Iam on the home page
 When I enter valid username and password
 Then I should logged in



   Scenario Outline: verify login using a valid user name and valid password
     Given Iam on the home page
     When I enter "<username>" username and "<password>" password
     Then I should logged in

    Examples:
   |username     |password   |
  |abc@gmail.com| 1234      |
   |abc@gmail.com|invalid1234|
  |abc@gmail.com|invalid2345|




  Scenario: verify invalid user name does not login a user
   Given Iam on the home page
    When I enter "wronguser@gmail.com" username and "wrongpwd" password
   Then I should not be logged in

