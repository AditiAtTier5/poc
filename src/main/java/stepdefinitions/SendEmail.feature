Feature: Send Email Feature

Scenario Outline: As a Gym Owner or Gym staff I will be able to Send and Email

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed
Then Click on the setup menu which is in the top right side
Then Click on Email Templates
Then Email Template page should be displayed
Then Click on Option dropdown select Email
Then Enter Email ID <email ID> to send an Email
Then Select from template
Then Click on Send Email

Examples:
|username|password|email ID|
|'test-own1@tier5.in'|'123456'|'aditi.ghosh@tier5.in'|