Feature: This feature will test/verify basic functionalities of REST API [GET, POST, PUT & DELETE] using RESTAssured library.
  Sample REST API is created & hosted locally [localhost:3000]

  Background: 
    Given API server is up & running on "http://localhost:3000"

  @api-test1 @get-method
  Scenario Outline: GET Method Test - verify active users & stocks data using GET method
    When user access the endpoint "<end_point1>"
    Then user should get status as "<status_code>"
    And user should receive data with header content-type as "<content_type>"
    And user should get active user "<user>"
    When user access the endpoint "<end_point2>"
    Then user should get status as "<status_code>"
    And user should receive data with header content-type as "<content_type>"
    Then user should get stock as "<stock>"

    Examples: 
      | end_point1 | end_point2 | status_code | content_type     | user        | stock |
      | /users     | /stocks    |         200 | application/json | Oneil Pinto | TCS   |
      | /users     | /stocks    |         200 | application/json | Amol Jadhav | HDFC  |

  @api-test2 @post-method
  Scenario Outline: POST Method Test - create new user using POST method
    When user access the endpoint "<end_point1>"
    Then user should get status as "<status_code1>"
    And user should receive data with header content-type as "<content_type>"
    When user create and reads the payload "<payload>"
    And attach it to the request body and post
    Then user should get status as "<status_code2>"

    Examples: 
      | end_point1 | status_code1 | content_type     | payload              | status_code2 |
      | /users     |          200 | application/json | payload_new_user.txt |          201 |

  @api-test2.1 @post-method
  Scenario Outline: POST Method Test - create new stock using POST method
    When user access the endpoint "<end_point1>"
    Then user should get status as "<status_code1>"
    And user should receive data with header content-type as "<content_type>"
    When user create and reads the payload "<payload>"
    And attach it to the request body and post
    Then user should get status as "<status_code2>"

    Examples: 
      | end_point1 | status_code1 | content_type     | payload               | status_code2 |
      | /stocks    |          200 | application/json | payload_new_stock.txt |          201 |
