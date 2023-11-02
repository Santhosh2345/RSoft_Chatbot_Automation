#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
#Feature: Title of your feature
  #I want to use this template for my feature file
#
  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail  
      
Feature: F_02 Forgot password functions in Rsoft


Scenario: F_02_17 Forgot Paassword
Given Launch rsoft url
When Enter valid Company name           
When Enter valid User name            
And Enter valid Email address      
Then Click Submit button



Scenario: F_02_10 Forgot Password
Given Launch rsoft url
When Enter the invalid Company Name
When Enter the invalid User Name
And Enter the invalid Email address
Then Click Submit button
      


Scenario: F_02_11 Forgot Password
Given Launch rsoft url
When Enter the invalid Company name
And Enter the valid User name
And Enter the invalid Email address  
Then Click the Submit button


Scenario: F_02_12 Forgot Password
Given Launch rsoft url
When Enter the invalid Company name
And Enter the invalid User name
And Enter the valid Email address  
Then Click the Submit button


Scenario: F_02_13 Forgot Password
Given Launch rsoft url
When Enter the invalid Company name
And Enter the valid User name
And Enter the valid Email address  
Then Click the Submit button


Scenario: F_02_14 Forgot Password
Given Launch rsoft url
When Enter the valid Company name
And Enter the invalid User name
And Enter the valid Email address  
Then Click the Submit button


Scenario: F_02_15 Forgot Password
Given Launch rsoft url
When Enter the valid Company name
And Enter the invalid User name
And Enter the invalid Email address  
Then Click the Submit button


Scenario: F_02_16 Forgot Password
Given Launch rsoft url
When Enter the valid Company name
And Enter the valid User name
And Enter the invalid Email address  
Then Click the Submit button


Scenario: F_02_06 Forgot Password
Given Launch rsoft url
When Enter the valid Company name
And Do not enter any data in User name
And Enter the valid Email address  
Then Click the Submit button


Scenario: F_02_07 Forgot Password
Given Launch rsoft url
When Enter the valid Company name
And Enter the valid User name
And Do not enter any data in Email address  
Then Click the Submit button


Scenario: F_02_08 Forgot Password
Given Launch rsoft url
#When Do not enter any data in Company name
When Enter the valid User name
And Enter the invalid Email address  
Then Click the Submit button


Scenario: F_02_23 Forgot Password
Given Launch rsoft url
When Do not enter any data in Company name
And Do not enter any data in User name
And Do not enter any data in Email address  
Then Click the Submit button