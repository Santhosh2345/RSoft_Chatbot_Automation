Feature: F_06 CRM Setting User and Access Contorl

Scenario: F_06_01 Test the Functions of User Module
Given Launch the rsoft url
When Login and redirect to the user module
And Verify the Elements Present 
And Check the all functions of User Module
Then finish the test


Scenario: F_06_02 Verify the Presence and Enabiblity of all elemeents in the User Setting
Given Launch the rsoft url
When Login and redirect to the User Setting
And Element Verification in Active user
And Element Verification in InActive user
Then Test Finish


Scenario: F_06_03 Element and Functional Verification in Creating User
Given Launch the rsoft url
When Login and redirect to the Creating User Page
And Element and Functional Verification in Creating User Page
And Created User Data Verification
And Login Checking for Created User
And Created User Filter and Edit_Detail Element Verification
And User Filter Delete Cancelation Process
And User Delete and Restore Function
And Delete The User Permanently
And Permanent User Delete Process From InActive user
Then Test Finish


Scenario: F_06_04 Verify the Presence and Enabiblity of all elemeents in the Profile Setting
Given Launch the rsoft url
When Login and redirect to the Profile Setting
And Element Verification in Profiles Page
And Element Verification in Craeting Profile Page
Then Test Finish


Scenario: F_06_05 Verify the Presence and Enabiblity of all elemeents in the Sharing Rules Setting
Given Launch the rsoft url
When Login and redirect to the Sharing Rules Setting
And Element Verification in Sharing Rules Page
Then Test Finish