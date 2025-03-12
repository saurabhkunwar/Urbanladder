Feature: User Registration and Login
  As a user
  I want to register, log in, and update my account settings
  So that I can securely access and manage my account

  Background:
    Given the user is on the home page
#@signup
  #Scenario Outline: User SignUp
    #When the user navigates to the registration page
    #And enters "<email>" and "<password>"
    #And submits the registration form
    #Then the account should be created successfully
#
  #Examples:
    #| email                 | password    |
    #| kunwar@gmail.com  | password@1234  |
   #
@login
  Scenario Outline: User Login
    When the user navigates to the login page
    And enters "<email>" and "<password>"
    And clicks the login button
    Then the user should be logged in successfully

  Examples:
    | email                | password   |
    |  johndo@gmail.com    | Pass@12345  |
  
  
  
  @updateAccount
  Scenario Outline: Update Account Settings - Change Password
    Given the user is logged in
    When the user navigates to the account settings page
    And updates the password from "<old_password>" to "<new_password>"
    And saves the changes
    Then the password should be updated successfully

  Examples:
    | old_password | new_password  |
    | johndo@gmail.com    |  Pass@12345   |
  
