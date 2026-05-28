Feature: New User comes to application and starts using it
Scenario: Registered user comes to application, login & logout  

Given User is on Login Page  
When User enters username  
And User enters password  
And User clicks on Login Button  
Then User should be logged in successfully  
When User clicks on logout button  
Then User should be logged out
