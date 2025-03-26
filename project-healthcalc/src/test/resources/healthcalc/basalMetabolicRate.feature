@Basal-Metabolic-Rate
Feature: Compute Basal Metabolic Rate
  As a person I want to know the basal metabolic rate
  given physical characteristics
  so that I can improve my lifestyle

  @women @compute
  Scenario: Computing the correct value for basal metabolic rate for women
  Given a health calculator
  And weight is 64
  And height is 164
  And age is 21
  And gender is w
  When I compute the basal metabolic rate function
  Then the system returns a value between 1456.4 and 1456.6.

  @men @compute
    Scenario: Computing the correct value for basal metabolic rate for men
    Given a health calculator
    And weight is 80
    And height is 184
    And age is 25
    And gender is m
    When I compute the basal metabolic rate function
    Then the system returns a value between 1901.1 and 1901.3.

  @invalid-input @weight
  Scenario: Invalid weight input. Upper limit exceeded
  Given a health calculator
  And weight is 450
  And height is 184
  And age is 25
  And gender is m
  When I compute the basal metabolic rate function
  Then the system throws an exception with the message "Weight out of range (1-400 kg)".

  @invalid-input @weight
  Scenario: Invalid weight input. Lower limit exceeded
  Given a health calculator
  And weight is -89
  And height is 184
  And age is 25
  And gender is m
  When I compute the basal metabolic rate function
  Then the system throws an exception with the message "Weight out of range (1-400 kg)".

  @invalid-input @height
  Scenario Outline: Invalid height inputs
    Given a health calculator
    And weight is 65
    And height is <h>
    And age is 23
    And gender is w
    When I compute the basal metabolic rate function
    Then the system throws an exception with the message "Height out of range (1-250 cm)".

    Examples:
    |  h  |
    | -10 |
    |  0  |
    | 260 |

  @invalid-input @age
  Scenario: Invalid age input. Upper limit exceeded
  Given a health calculator
  And weight is 54
  And height is 156
  And age is 120
  And gender is w
  When I compute the basal metabolic rate function
  Then the system throws an exception with the message "Age out of range (1-110 years)".
  
  @invalid-input @age
  Scenario: Invalid age input. Lower limit exceeded
  Given a health calculator
  And weight is 54
  And height is 156
  And age is 0
  And gender is w
  When I compute the basal metabolic rate function
  Then the system throws an exception with the message "Age out of range (1-110 years)".

  @invalid-input @gender
  Scenario: Invalid gender input
  Given a health calculator
  And weight is 54
  And height is 156
  And age is 12
  And gender is x
  When I compute the basal metabolic rate function
  Then the system throws an exception with the message "Invalid gender. Do use 'w' or 'm'".