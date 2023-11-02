      
Feature: F_04 My Profile Element Functionalities

Scenario: F_04_01 All Element Present or Not in My Profile Page

Given Launch the rsoft URL
When Login to the application
And Check the User Management block element
And Check the User Login & Role block eLement
And Check the Currency and Number Field Configuration block element
And Check the More Information block element
Then Check the User Address block element


Scenario: F_04_02 All Element Present or Not in My Profile Edit Page

Given Launch the rsoft URL
When Login to the application
And Check the User Login & Role block eLement
And Check the Currency and Number Field Configuration block element
And Check the More Information block element
Then Check the User Address block element


Scenario: F_04_03 My Profile Edit Page fields Functionalities

Given Launch the rsoft URL
When Login to the application
And Check the User Login & Role block fields functionalities
And Check the Currency and Number Field Configuration block fields functionalities
And Check the More Information block fields functionalities
Then Check the User Address block fields functionalities      


Scenario: F_04_04 My Profile Fields Functionalities

Given Launch the rsoft URL
When Login to the application
And Check all fields in My Profile Page 


Scenario: F_04_05 Password Changing Element Functionalities

Given Launch the rsoft URL
When Login to the application
And Check the Password Changing Element Functionalities Save
And Check the Password Changing Element Functionalities Cancel