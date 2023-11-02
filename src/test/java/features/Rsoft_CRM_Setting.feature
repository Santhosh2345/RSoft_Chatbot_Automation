Feature: F_05 CRM Setting Login History

Scenario: F_05_01 Check the Elements visibility and Functionalities for Login History

Given Launch the rsoft URL
When Login and redirect to the Login History Setting
And Check the visiblity and functionalities of the  Elements
Then Check the visiblity and functionalities of the Page Naviation Elements


Scenario: F_05_02 Check the Elements visibility and Functionalities for CRM Setting

Given Launch the rsoft URL
When Login and redirect to the CRM Setting initial Page
And Check all the Elements are Present or Not.
Then Finish the Test


Scenario: F_05_03 Check the Elements visibility and Functionalities for CRM Sub-Settings

Given Launch the rsoft URL
When Login and redirect to the CRM Setting initial Page
And Check all the Sub-Settings Element functionality for User & Access Control
And Check all the Sub-Settings Element functionality for Studio
And Check all the Sub-Settings Element functionality for Templates
And Check all the Sub-Settings Element functionality for Other Settings
Then Check all the Sub-Settings Element functionality for Integration


Scenario: F_05_04 Check the Elements visibility and Functionalities for Edit Field Setting

Given Launch the rsoft URL
When Login and redirect to the Edit Field Setting Page
And Check all the Elements are Present or Not and Functionalities
And Check the Add Module funtions
Then Finish the Test


Scenario: F_05_05 Check the Elements visibility and Functionalities for Module Manager Setting
Given Launch the rsoft URL
When Login and redirect to the Module Manager Setting Page
And Check all the Elements are Present or Not and Functionalities
And Check the Add Module funtions
And Verify the created module
Then Finish the Test


Scenario: F_05_05 Check the Elements visibility and Functionalities for Menu Editor Setting
Given Launch the rsoft URL
When Login and redirect to the Menu Editor Setting Page
And Check all the Elements are Present or Not and Functionalities
And Check the Add Menu Groups
And Verify the created module Functions
Then Finish the Test