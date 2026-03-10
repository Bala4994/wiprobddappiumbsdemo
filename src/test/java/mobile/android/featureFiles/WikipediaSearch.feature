Feature: Wikipedia Mobile Application

  Scenario: Search article and navigate to dashboard

    Given user launches Wikipedia application
    And user taps on Search Wikipedia
    When user enters search keyword "BrowserStack"
    Then search results should appear
    When user selects first search result
    Then error page should open
    When user navigates back
    Then Home page should be displayed

Scenario: Settings screen validation
    When user selects more options
    Then settings button should be displayed
    When User clicks on settings button
    Then General settings screen should be visible

Scenario: Login screen validation
    When user clicks on more options
    Then Login to wikipedia should be displayed
    When user clicks on Login to wikipedia
    Then Sign up button should be displayed