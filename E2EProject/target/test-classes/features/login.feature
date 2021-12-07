#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
      
 Feature: Login into Application
 
 Scenario: Positive test validting login
 Given Inialize the chrome browser
 And Navigate to "http://qaclickacademy.com" website
 And Click on login page link to land on Login Page
 When User enters "lokeshvarshney786@gmail.com" and "lokesh123" and click on login button
 Then Verify user is sucessfully logged in