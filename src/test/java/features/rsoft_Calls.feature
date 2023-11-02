Feature: F_10 Calls Module

Scenario: F_10_01 Verify the calls module
Given Launch the rsoft url
When Login and redirect to the Calls module
And Create the Calls Record with Random Value 
And Verify the Convert Status
And Convert that record to Lead