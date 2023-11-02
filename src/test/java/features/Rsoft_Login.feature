Feature: L_01 - Login into Rsoft
    
    # Login page_Feature_Scenario
    
Scenario: L_01_05 Login Into Rsoft
Given Launch the Rsoft URL
When Enter Valid Company Name
And Enter Valid User Name
And Enter Valid password
And click on login button
And All Element Verification in the Login Page


Scenario: L_01_06  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Invalid Company Name
And Enter Invalid User Name
And Enter Invalid Password
Then click on login button

Scenario: L_01_07  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Invalid Company Name
And Enter Valid User Name
And Enter Invalid Password
Then click on login button

Scenario: L_01_08  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Invalid Company Name
And Enter Invalid User Name
And Enter Valid Password
Then click on login button

Scenario: L_01_09  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Invalid Company Name
And Enter Valid User Name
And Enter Valid Password
Then click on login button

Scenario: L_01_10  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Valid Company Name
And Enter Invalid User Name
And Enter Valid Password
Then click on login button

Scenario: L_01_11  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Valid Company Name
And Enter Invalid User Name
And Enter Invalid Password
Then click on login button

Scenario: L_01_12  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Valid Company Name
And Enter Valid User Name
And Enter Invalid Password
Then click on login button

Scenario: L_01_13  Login Into Rsoft
Given Launch the Rsoft URL
When Do not enter any data in Company name
And Do not enter any data in User Name
And Do not enter any data in Password
Then click on login button

Scenario: L_01_14  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Valid Company Name
And Do not enter any data in User Name
And Enter Valid Password
Then click on login button

Scenario: L_01_15  Login Into Rsoft
Given Launch the Rsoft URL
When Enter Valid Company Name
And Enter Valid User Name
And Do not enter any data in Password
Then click on login button

Scenario: L_01_16  Login Into Rsoft
Given Launch the Rsoft URL
When Do not enter any data in Company name
And Enter Valid User Name
And Enter Valid Password
Then click on login button