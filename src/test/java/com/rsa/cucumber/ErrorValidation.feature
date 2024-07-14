
@tag
Feature: Error Validation
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce page
    

  @ErrorValidation
  Scenario Outline: Positive Test of Submitting the order
  	Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." messege is displayed
    
    Examples: 
      | name                  | password  |
      | rshulshetty@gmail.com | Iamking@00 | 
