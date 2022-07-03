Feature: Search

  Background: Open Media Releases
    Given I open "https://www.nsw.gov.au/media-releases"

  Scenario Outline: Search for Media Releases for any given Minister
    Given I want to search for Media Releases for "<Minister>"
    And I expand the accordion for "Filter by Minister"
    And I select the checkbox for the given minister
    When I run the search
    Then Verify that the results on all pages only contain media releases for the given minister
    #And Verify that there are a maximum of 12 results per page

    Examples:
      | Minister          |
      | The Premier       |
     # | Minister for Infrastructure, Cities, Active Transport       |