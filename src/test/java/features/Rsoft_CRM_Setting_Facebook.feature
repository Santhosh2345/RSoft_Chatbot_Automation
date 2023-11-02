Feature: F_12 Facebook setting in CRM settnig

Scenario: F_12_01 Check the Leads properly import from Facebook webapplication
Given Launch the Facebook webapplication and Login
When Go to the Leads pushing page by using development URL and Push the leads from Facebook
And Login in to the Salezcrm webapplication and redirect to the Facebook Module and Verify the leads in module
Then Finish the Scenario