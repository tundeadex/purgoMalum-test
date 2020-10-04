Feature: PurgoMalum Profanity Json API Test.


  Scenario: ResponseShouldReturnTextAsResultInJson
    Given a call is made to profanity json service with text "this is some test input"
    Then response code is "200"
    And the response body json "result" equals "this is some test input"


  Scenario: AddWordToProfanityListAndReplaceWordWithFillChar
    Given a call is made to profanity json service with text "this is a test task", add "test" and fillChar"*"
    Then response code is "200"
    And the response body json "result" equals "this is a **** task"


  Scenario: ReturnCharacterLimitError
    Given a call is made to profanity json service with text "this is a test task" and fillText "this is curiously long replacement text"
    Then response code is "200"
    And the response body json "error" equals "User Replacement Text Exceeds Limit of 20 Characters."