Feature: F_09 Workflow Trigger Checking For Mail

Scenario: F_09_01 Verify Only On The First Time Save For Email
Given Launch the rsoft url
When Login and redirect to the Workflow Setting
And Verify the Module Name, Workflow Execution Condition and Action Type in 3rd Step
And Create a record in that Module and Verify the Email Trigger


Scenario: F_09_02 Verify Only On The First Time Save For Notification
Given Launch the rsoft url
When Login and redirect to the Workflow Setting
And Verify the Module Name, Workflow Execution Condition and Action Type in 3rd Step
And Create a record in that Module and Verify the Notification Trigger


Scenario: F_09_03 Verify Only On The First Time Save For SMS Notification
Given Launch the rsoft url
When Login and redirect to the Workflow Setting
And Verify the Module Name, Workflow Execution Condition and Action Type in 3rd Step
And Create a record in that Module and Verify the SMS Notification Trigger