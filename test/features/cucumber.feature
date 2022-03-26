# Bijesh Bajracharya

Feature: Bowling Game
  Description of feature

#  @Bowling@Bowling
#  Scenario: Add a Roll
#    Given Create new Bowling Game
#    When Add a roll
#    Then Roll added

  @Bowling
  Scenario: All Strikes
    Given Create a new Bowling Game
    When All Strikes
    Then Maximum Score is 300


  @Bowling
  Scenario: Set Bowl
    Given Create a new Bowling Game
    When Set Bowl
    Then Maximum Score is 16

  @Bowling
  Scenario: Add a bowl
    Given Create a new Bowling Game
    When Add a bowl
    Then Roll added

  @Bowling
  Scenario: Is Spare
    Given Create a new Bowling Game
    When First and Second bowl are 5
    Then The Game is Spare


  @Bowling
  Scenario: All Spares
    When All bowl are Spare
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
      | 5 |
    Then Total score is 150

  @Bowling
  Scenario: Testing valid inputs
    When Invalid data entered
    Then throw error

  @Bowling
  Scenario: All Spare
    Given Create a new Bowling Game
    When All Spare
    Then Maximum Score is 150

  @Bowling
  Scenario: verify scratch Score for all frames with few Strikes
    Given Create a new Bowling Game
    When player makes pin for all 10 frames
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
      | 5 |
      | 4 |
    Then verify scratch score of the game 90
    And verify final score with handicap of 20
      | 110 |

  @Bowling
  Scenario: All bowl are Strike
    Given Create a new Bowling Game
    When All bowl are Strike
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
      | 10 |
    Then Total score Strike is 300