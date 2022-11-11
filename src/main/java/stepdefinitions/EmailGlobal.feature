Feature: Email Template Feature

Scenario Outline: As a Gym Owner I will be able to create & edit Email templates so that I can reuse the message content while sending any Email

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed
Then Click on the setup menu which is in the top right side
Then Click on Email Templates
Then Email Template page should be displayed
Then Click on Create an Email Template button
Then Enter Title <title>
Then Enter Subject <subject>
Then Enter Message <message>
Then Click on Save

Examples:
|username|password|title|subject|message|
|'test-gymtime@tier5.in'|'123456'|'Test Title'|'Test Subject'|'Test Message'|