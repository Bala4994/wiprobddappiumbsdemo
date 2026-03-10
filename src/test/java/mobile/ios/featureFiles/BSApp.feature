Feature: Verify BrowserStack Sample App functionality

Scenario: Verify BrowserStack Text Input
	Given User try to find Text Button in Sample App
	When User type in "hello@browserstack.com" in the Text Input field
	Then User should get the entered text in the Text Output field

Scenario: Verify BrowserStack WebView Flow
	When User click Web View tab
	Then BrowserStack landing page should appear

	When User click Web Testing tab
	Then Live and Automate options should be visible

Scenario: Verify BrowserStack SignIn page
	When User click Web View tab
	Then BrowserStack landing page should appear
	And Search menu and more options buttons should be visible
	When User click Sign in from more options
	Then Google sign in and Sign up options should appear