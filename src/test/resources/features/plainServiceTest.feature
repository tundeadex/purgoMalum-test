Feature: PurgoMalum Profanity PlainText API Test.


  Scenario: ResponseShouldReturnTextAsPlain
    Given a call is made to profanity PlainText service with text "this is some plain test input"
    Then response code is "200"
    And the response body equals "this is some plain test input"



  Scenario: AddWordToProfanityListAndReplaceWordWithFillChar
    Given a call is made to profanity service with text "this is a test task", add "task" and fillChar"_"
    Then response code is "200"
    And the response body equals "this is a test ____"


  Scenario: ReturnCharacterLimitError
    Given a call is made to profanity service with text "this is a test task" and fillText "this is curiously long replacement text"
    Then response code is "200"
    And the response body equals "User Replacement Text Exceeds Limit of 20 Characters."