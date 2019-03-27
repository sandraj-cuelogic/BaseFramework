Feature: As a valid request that is sent, the response code that should be received is 200

Scenario: Verify if the response code received when a valid request is sent is 200
Given when the GET request is passed
Then the response should contain 200 in its response code
