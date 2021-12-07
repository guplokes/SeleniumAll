 Feature: Login into Application 2
 
 Scenario Outline: Positive test validting login(with parameterizing multiple times)
 Given Inialize the chrome browser
 And Navigate to "http://qaclickacademy.com" website
 And Click on login page link to land on Login Page
 When User enters <username> and <password> and click on login button
 Then Verify user is sucessfully logged in
 And close the browser
 
 Examples:
 |username										|password	|
 |lokeshvarshney786@gmail.com	|lu41234	|
 |radhakuma23@gmail.com				|jhxuihu1 |