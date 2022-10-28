Feature: Login Feature

Scenario Outline: As a Gym Owner/ Gym Staff I want to login to portal with valid credential

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed

Examples:
|username|password|
|'test-gymown1@tier5.in'|'123456'|
|'test-own1@tier5.in'|'123456'|

Scenario Outline: As a Gym Owner/ Gym Staff I want to login to portal with Invalid credential

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then This will be in Login page only

Examples:
|username|password|
|'test-gymown1@tier5.in'|'12345'|
|'test-own1@tier5.in'|'12345'|