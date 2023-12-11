Feature: Application Login


Scenario: Home page deault login
Given User is Netbanking landing page
When User login into applicaton with "jin" and password "1234"
Then Home page is populated
And Cards displayed is "true"

Scenario: Home page deault login
Given User is Netbanking landing page
When User login into applicaton with "john" and password "4321"
Then Home page is populated
And Cards displayed is "false"