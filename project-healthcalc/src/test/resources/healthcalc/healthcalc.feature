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
@tag
Feature: Ideal weight
  As a persona I want to know the ideal weight
  given physical characteristics
  so that I can improve my lifestyle

  @tag1
  Scenario: Computing the correct value for ideal weight for women
    Given a health calculator
    And height is 164 cm
    And gender is female
    When I compute the ideal weight function
    Then the system returns 58.4

