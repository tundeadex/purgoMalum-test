Feature: PurgoMalum Profanity API Test.


Scenario: ReturnFalseIfTextDoesNotContainsProfanity
    Given a call is made to profanity service with text "this is some test without profanity"
    Then response code is "200"
    And the response body is "false"



  Scenario: ReturnTrueIfTextContainsProfanity
    Given a call is made to profanity service with text "this is shit"
    Then response code is "200"
    And the response body is "true"



  Scenario: ReturnTrueForNewlyAddedProfanityWord
    Given a call is made to profanity service with text "this is a mercedes benz" and a new profanity word "mercedes"
    Then response code is "200"
    And the response body is "true"