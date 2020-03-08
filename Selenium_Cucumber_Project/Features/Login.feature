Feature: Open Vodafone Homepage
	As an unprivileged user
	Open the home page and login with invalid credentials

Scenario: Go to Vodafone website
Given the user opens a browser and go to "http://www.vodafone.co.nz"
When user clicks on My Vodafone tab 
	And user clicks on Login button
	And user enters invalid username "medelvecina"
	And user enters invalid password "password"
	And user clicks Sign in button
Then user should NOT be able to login successfully