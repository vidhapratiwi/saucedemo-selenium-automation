Feature: footer links
  @FooterLinks

  Scenario Outline:
    Given user in homepage
    When user click <linkName> link in the footer
    Then user is redirected to the correct <expectedURL>

    Examples:
    | linkName  | expectedURL
    | twitter   | https://x.com/saucelabs
    | facebook  | https://www.facebook.com/saucelabs
    | linkedin  | https://www.linkedin.com/company/sauce-labs/