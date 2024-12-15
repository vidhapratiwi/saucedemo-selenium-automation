Feature: saucedemo login
  @Login
  Scenario Outline: user login with valid credentials
    Given user already on login page
    When user input <username> as username
    And user input <password> as password
    And user click login button
    Then user verify <status> login result

    #yang success masih belum bisa selesai sampai close tab
    Examples:
      | username            | password      | status
#      | standard_user       | secret_sauce  | success
      | locked_out_user     | secret_sauce  | failed
#      | problem_user        | secret_sauce  | success
#      | performance_glitch  | secret_sauce  | success
#      | error_user          | secret_sauce  | success
#      | visual_user         | secret_sauce  | success
      | coba_user           | coba_password | failed
      |                     | secret_sauce  | failed
      | standard_user       |               | failed
      |                     |               | failed