# Ralph Lauren Website Testing Framework

This document describes the implementation of step definitions and page object model for testing Ralph Lauren website navigation, specifically for opening the homepage and navigating to Product Detail Pages (PDP).

## Project Structure

```
src/test/java/com/qmetry/qaf/example/
├── pages/
│   ├── BasePage.java                 # Base page object with common functionality
│   ├── RalphLaurenHomePage.java     # Homepage page object model
│   └── RalphLaurenPDPPage.java      # Product Detail Page page object model
├── steps/
│   └── RalphLaurenSteps.java        # Step definitions for BDD scenarios
└── test/
    └── RalphLaurenNavigationTest.java # Test class with various navigation scenarios

scenarios/
└── ralph_lauren_navigation.feature  # BDD feature file for Ralph Lauren navigation

resources/
└── ralph_lauren_locators.properties # Locators for Ralph Lauren website elements
```

## Page Object Models

### BasePage.java
- Contains common functionality shared across all pages
- Handles cookie consent, page loading, navigation, and element waiting
- Provides utility methods for scrolling, element verification, and page operations

### RalphLaurenHomePage.java
- Manages homepage elements and interactions
- Includes navigation elements (Men's, Women's, Kids' sections)
- Handles search functionality
- Provides methods to navigate to product categories and select products

### RalphLaurenPDPPage.java
- Manages Product Detail Page elements and interactions
- Handles product information display (title, price, description)
- Manages product options (size, color, quantity selection)
- Provides methods for adding products to cart and wishlist

## Step Definitions

### RalphLaurenSteps.java
Contains comprehensive step definitions for BDD scenarios:

#### Homepage Navigation Steps:
- `I open the Ralph Lauren website`
- `I should see the Ralph Lauren homepage`
- `I search for {searchTerm}`
- `I navigate to Men's/Women's/Kids' section`

#### Product Detail Page Steps:
- `I click on the first product`
- `I should see the Product Detail Page`
- `I should see product title containing {text}`
- `I should see the product price`
- `I select size {size}`
- `I select color {color}`
- `I set quantity to {quantity}`
- `I add the product to cart`
- `I add the product to wishlist`

## Feature Files

### ralph_lauren_navigation.feature
Contains multiple BDD scenarios:
1. **Basic Navigation**: Open homepage and navigate to PDP
2. **Search Flow**: Search for product and navigate to PDP
3. **Category Navigation**: Navigate to different sections (Men's, Women's, Kids')
4. **Complete Product Selection**: Full flow with size, color, and quantity selection

## Test Classes

### RalphLaurenNavigationTest.java
Contains test methods for various navigation scenarios:
- `testOpenHomepageAndNavigateToPDP()`
- `testSearchProductAndNavigateToPDP()`
- `testNavigateToMensSectionAndSelectProduct()`
- `testNavigateToWomensSectionAndSelectProduct()`
- `testNavigateToKidsSectionAndSelectProduct()`
- `testCompleteProductSelectionFlow()`
- `testGetProductInformation()`

## Configuration

### Application Properties
- Updated `env.baseurl` to `https://www.ralphlauren.com/`
- Maintains existing QAF framework configuration

### Locators
- Comprehensive locators file with data-testid attributes
- Alternative locators for different page structures
- Covers all major elements on homepage and PDP

## Usage

### Running BDD Scenarios
```bash
mvn test -Dtest=*RalphLaurenNavigationTest
```

### Running Specific Feature
```bash
mvn test -Dcucumber.options="--tags @RalphLauren"
```

### Running Smoke Tests
```bash
mvn test -Dcucumber.options="--tags @Smoke"
```

## Key Features

1. **Comprehensive Page Object Model**: Well-structured page objects with clear separation of concerns
2. **Robust Step Definitions**: Reusable step definitions for common navigation patterns
3. **Flexible Locators**: Multiple locator strategies for different page structures
4. **Error Handling**: Proper error handling and element verification
5. **BDD Support**: Full BDD support with readable feature files
6. **Extensible Design**: Easy to extend for additional functionality

## Dependencies

- QAF Framework (latest version)
- Selenium WebDriver (latest version)
- WebDriverManager (latest version)
- TestNG for test execution

## Notes

- The implementation uses data-testid attributes for reliable element identification
- Cookie consent handling is included for GDPR compliance
- Page loading waits are implemented for better test stability
- The framework supports both programmatic and BDD test execution
- All step definitions are properly annotated with @QAFTestStep for QAF integration