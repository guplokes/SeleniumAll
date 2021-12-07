Feature: Application login

Scenario: Home page default login

Given User is on landing page
When User login into application with username "john" and password "luc12334"
Then Home page is populated
And cards displayed are "true"

Scenario: Home page default login

Given User is on landing page
When User login into application with username "lucy" and password "1225614"
Then Home page is populated
And cards displayed are "false"