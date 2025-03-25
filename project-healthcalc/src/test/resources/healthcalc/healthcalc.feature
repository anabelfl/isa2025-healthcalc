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
Feature: Calculate Ideal weight
  As a person I want to know the ideal weight
  given physical characteristics
  so that I can determine the target weight for a healthy lifestyle

  @tag1
  Scenario: Computing the correct value for ideal weight for women
    Given a health calculator
    And height is 164
    And gender is female
    When I compute the ideal weight function
    Then the system returns a value between 58.3 and 58.5 kg. 

  @tag2
  Scenario: Computing the correct value for ideal weight for men
    Given a health calculator
    And height is 180
    And gender is male
    When I compute the ideal weight function
    Then the system returns a value between 72.4 and 72.6 kg.

  @tag3
  Scenario Outline: Invalid height inputs
    Given a health calculator
    And height is <h>
    And gender is female
    When I compute the ideal weight function
    Then the system throws an exception with the message "Height out of range (1-250)".

    Examples:
    | h   |
    | -10 |
    | 0   |

  @tag4
  Scenario Outline: Invalid gender inputs
    Given a health calculator
    And height is 170
    And gender is <g>
    When I compute the ideal weight function
    Then the system throws an exception with the message "Invalid gender. Do use 'w' or 'm'".
  
    Examples:
    | g        |
    | f   |
    | m     |
    | x        |
    | mals     |
    | femalf   |

@tag5
Feature: Calculate Basal Metabolic Rate
  As a person I want to know the basal metabolic rate
  given physical characteristics
  so that I can improve my lifestyle

  @tag6
  Scenario: Computing the correct value for basal metabolic rate for women
  Given a health calculator
  And height is 164
  And gender is female
  When I compute the basal metabolic rate function
  Then the system returns a value between 1456.4 and 1456.6.
