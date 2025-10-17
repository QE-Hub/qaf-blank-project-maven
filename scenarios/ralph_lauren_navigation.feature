Feature: Ralph Lauren Website Navigation

  @Smoke @RalphLauren
  Scenario: Open Ralph Lauren homepage and navigate to PDP
    Given I open the Ralph Lauren website
    Then I should see the Ralph Lauren homepage
    When I click on the first product
    Then I should see the Product Detail Page
    And I should see the product price
    And I should see add to cart button is enabled

  @Smoke @RalphLauren
  Scenario: Search for product and navigate to PDP
    Given I open the Ralph Lauren website
    When I search for "polo shirt"
    And I click on the first product
    Then I should see the Product Detail Page
    And I should see product title containing "polo"

  @RalphLauren
  Scenario: Navigate to Men's section and select product
    Given I open the Ralph Lauren website
    When I navigate to Men's section
    And I click on the first product
    Then I should see the Product Detail Page
    And I should see size selector is available
    And I should see color selector is available

  @RalphLauren
  Scenario: Navigate to Women's section and select product
    Given I open the Ralph Lauren website
    When I navigate to Women's section
    And I click on the first product
    Then I should see the Product Detail Page
    And I should see the product price

  @RalphLauren
  Scenario: Navigate to Kids' section and select product
    Given I open the Ralph Lauren website
    When I navigate to Kids' section
    And I click on the first product
    Then I should see the Product Detail Page
    And I should see add to cart button is enabled

  @RalphLauren
  Scenario: Complete product selection flow
    Given I open the Ralph Lauren website
    When I click on the first product
    Then I should see the Product Detail Page
    When I select size "M"
    And I select color "Blue"
    And I set quantity to 2
    Then I should see add to cart button is enabled
    When I add the product to cart
    Then I should see the Product Detail Page