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
|'test-gymown1@tier5.in'|'123456'|'Personal Details'|'Gym own'|'test-gymown1@tier5.in'|'Gym own edited'|
|'test-own1@tier5.in'|'123456'|'Personal Details'|'Owner Gym'|'test-own1@tier5.in'|'Owner Gym edited'|
|'test-staff1@tier5.in'|'123456'|'Personal Details'|'Staff One'|'test-staff1@tier5.in'|'Staff One edited'|
|'test-staff2@tier5.in'|'123456'|'Personal Details'|'Staff Two'|'test-staff2@tier5.in'|'Staff Two edited'|

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
|'test-staff1@tier5.in'|'123456'|'Personal Details'|'India'|
|'test-staff2@tier5.in'|'123456'|'Personal Details'|'India'|

Scenario Outline: As a gym owner I will be able to change password so that I can recreate a new password after validating the current password

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed
Then Click on the setup menu which is in the top right side
Then There will be one option named <option>, need to click on that
Then The Personal Details dashboard will open
Then In the right side there will be a section called Change Password
Then There will be Three text box by which we can change the password, which are Current Password, New Password, Confirm New Password
Then Need to fill up the field accordingly as Current Password <current password>, New Password <new password>, Confirm New Password <confirm new password>
Then Click on save in the bottom

Examples:
|username|password|option|current password|new password|confirm new password|
|'test-gymown1@tier5.in'|'123456'|'Personal Details'|'Tier5@'|'Tier5#5'|'Tier5#5'|
|'test-own1@tier5.in'|'123456'|'Personal Details'|'Tier5@'|'Tier5#5'|'Tier5#5'|
|'test-staff1@tier5.in'|'123456'|'Personal Details'|'Tier5@'|'Tier5#5'|'Tier5#5'|
|'test-staff2@tier5.in'|'123456'|'Personal Details'|'Tier5@'|'Tier5#5'|'Tier5#5'|

Scenario Outline: As a gym owner/gym staff I will be able to edit the account details so that I can change the Username & display picture whenever required

Given Enter username as <username>
And Enter Password as <password>
When Click on Login
Then Dashboard should be displayed
Then Click on the setup menu which is in the top right side
Then There will be one option named <option>, need to click on that
Then The Personal Details dashboard will open
Then I want to edit the personal details, edit display picture <image path>

Examples:
|username|password|option|image path|
|'test-gymown1@tier5.in'|'123456'|'Personal Details'|'/home/tier5/Pictures/1661514171866.jpg'|
|'test-own1@tier5.in'|'123456'|'Personal Details'|'/home/tier5/Pictures/1661514171866.jpg'|
|'test-staff1@tier5.in'|'123456'|'Personal Details'|'/home/tier5/Pictures/1661514171866.jpg'|
|'test-staff2@tier5.in'|'123456'|'Personal Details'|'/home/tier5/Pictures/1661514171866.jpg'|