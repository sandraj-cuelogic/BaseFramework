Feature: Create a session, save all the session values and keep updating them

Scenario Outline: Verify if for a campaign session can be created and created sessions can be continuously updated 
Given Creating <counts> session for the Campaign <campaignID>
When the session id is retrieved and saved in an array

Examples:
| counts | | campaignID|
| 10 | | 55272 |