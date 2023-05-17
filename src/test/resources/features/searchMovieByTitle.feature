Feature: Search movie by title

  Scenario Outline: Search Movie by Title "Back to the Future"

    Given User opens Home page
    And  User verifies page is opened
    When User searches the movie by title "<title>"
    When User clicks on the movie which is released in year "<year>"
    Then User verifies that the movie description matches the following "<description>"

    Examples:
      | title              | year | description                                                                                                                                                                                  |
      | Back to the future | 1985 | Marty McFly, a 17-year-old high school student, is accidentally sent thirty years into the past in a time-traveling DeLorean invented by his close friend,the eccentric scientist Doc Brown. |
