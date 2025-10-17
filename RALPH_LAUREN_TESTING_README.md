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
**Important Note**: The initial locators used `data-testid` attributes which are **imaginary/placeholder** values. The actual Ralph Lauren website may not have these specific attributes.

The framework now includes:
- **ElementFinder utility class** with multiple locator strategies
- **Realistic CSS selectors** based on common e-commerce patterns  
- **Fallback mechanisms** to handle different website structures
- **Dynamic element discovery** that tries multiple selectors

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

## Important Notes

### Locator Reality Check
- **Initial `data-testid` attributes were imaginary** - they don't exist on the real Ralph Lauren website
- The framework now uses **ElementFinder utility** with multiple fallback strategies
- **Real-world testing required** to identify actual element selectors
- Use `RalphLaurenBasicTest` to discover what elements are actually available

### Framework Features
- **Dynamic element discovery** using multiple locator strategies
- **Fallback mechanisms** for different website structures
- Cookie consent handling for GDPR compliance
- Page loading waits for better test stability
- Support for both programmatic and BDD test execution
- All step definitions properly annotated with @QAFTestStep for QAF integration

### Next Steps for Real Implementation
1. Run `RalphLaurenBasicTest` to see what elements are actually available
2. Update locators based on real website structure
3. Adjust ElementFinder strategies based on findings
4. Test with actual Ralph Lauren website elements