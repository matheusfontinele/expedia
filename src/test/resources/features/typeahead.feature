Feature: Typeahead
  
  Scenario: Search a valid stay
  Given a search for "Walt Disney World"
  When request typeahead endpoint
  Then status code is 200
    And result search should be not empty

  Scenario: Search nonexistent stay
    Given a search for "shouldreturnothing"
    When request typeahead endpoint
    Then status code is 200
    And result search should be empty

  Scenario: Empty search
    Given a search for ""
    When request typeahead endpoint
    Then status code is 200
    And result search should be empty
    
   Scenario: Search a valid stay
  	Given a search for "Walt Disney World"
  	When request typeahead endpoint
  	Then status code is 200
    And schema should be correct