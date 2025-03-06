Feature: This feature will test/verify the home page of National Australia Bank

  @test1 @sanity @SODcheck @SIT
  Scenario: verify header links presence on home page
    Given user opens nab website "https://www.nab.com.au/"
    Then nab website should load successfuly
    And "Personal" link should present on home page
    And "Business" link should present on home page
    And "Corporate" link should present on home page
    And "About us" link should present on home page
    And "Help" link should present on home page

  @test2 @SODcheck @SIT
  Scenario Outline: verify search functionality on home page
    Given user opens nab website "https://www.nab.com.au/"
    Then nab website should load successfuly
    When user clicks on search button
    And user enters "<SearchText>" in searchbox
    And user hits "Enter" key
    Then "<SearchText>" link should display in search results

    Examples: 
      | SearchText              |
      | Find a home loan expert |
      | Investing in property   |
