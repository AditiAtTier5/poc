Feature: Personal details

Scenario Outline: As a Gym Owner/ Gym Staff I will be able to read my auto populated personal details under general settings so that I can update it as per my requirement

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed
Then Click on the setup menu which is in the top right side
Then There will be one option named <option>, need to click on that
Then The Personal Details dashboard will open
Then There at the left side auto populated personal details will be there
Then There will be name <name> & email <email> about user
Then I want to edit the personal details, edit name <edited name>

Examples:
|username|password|option|name|email|edited name|
|'test-gymown1@tier5.in'|'123456'|'Personal Details'|'Gym own edited'|'test-gymown1@tier5.in'|'Gym own edited'|
|'test-own1@tier5.in'|'123456'|'Personal Details'|'Owner Gym edited'|'test-own1@tier5.in'|'Owner Gym edited'|

Scenario Outline: As a Gym Owner I will be able to view & update the Basic settings so that I can save the new data

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed
Then Click on the setup menu which is in the top right side
Then There will be one option named <option>, need to click on that
Then The Personal Details dashboard will open
Then In the right side there will be a section called Basic Settings
Then I can view and edit country name as <country to select> information
Then Click on save in the bottom

Examples:
|username|password|option|country to select|
|'test-gymown1@tier5.in'|'123456'|'Personal Details'|'India'|
|'test-own1@tier5.in'|'123456'|'Personal Details'|'India'|
