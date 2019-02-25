@ie_EDFHomePageNew
Feature: EDF Search Results
  I want to verify that when I navigate to the edfstage url, I land on its home page

  Scenario Outline: Navigate to the edfstage url and confirm that you have reached its landing page
    Given I navigate to the edfstage url in "<browserName>"
    When the page has the title as "Enterprise Delivery Framework"
    Then confirm that user has reached EDF's landing page

    Examples: 
      | browserName |
| ie |
