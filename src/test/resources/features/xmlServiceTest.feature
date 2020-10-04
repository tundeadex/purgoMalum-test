Feature: PurgoMalum Profanity XML API Test.


  Scenario: ResponseShouldReturnTextAsResultInXm
    Given a call is made to profanity XML service with text "this is some xml test input"
    Then response code is "200"
    And the response body xml "result" equal "this is some xml test input"


  Scenario: AddWordToProfanityListAndReplaceWordWithFillChar
    Given a call is made to profanity XML service with text "this is a test task", add "this" and fillChar"*"
    Then response code is "200"
    And the response body xml "result" equal "**** is a test task"


  Scenario: ReturnCharacterLimitError
    Given a call is made to profanity XML service with text "this is a test task" and fillText "this is curiously long replacement text"
    Then response code is "200"
    And the response body xml "error" equal "User Replacement Text Exceeds Limit of 20 Characters."