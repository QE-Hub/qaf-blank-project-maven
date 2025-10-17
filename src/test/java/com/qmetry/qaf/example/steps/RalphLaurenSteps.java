package com.qmetry.qaf.example.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.example.pages.RalphLaurenHomePage;
import com.qmetry.qaf.example.pages.RalphLaurenPDPPage;

import static com.qmetry.qaf.automation.step.CommonStep.*;

/**
 * Step definitions for Ralph Lauren website navigation
 * Contains all the step definitions for BDD scenarios
 */
public class RalphLaurenSteps {

    private RalphLaurenHomePage homePage;
    private RalphLaurenPDPPage pdpPage;

    /**
     * Step definition to open Ralph Lauren homepage
     */
    @QAFTestStep(description = "I open Ralph Lauren homepage")
    public void openRalphLaurenHomepage() {
        homePage = new RalphLaurenHomePage();
        homePage.openHomePage();
        // Wait a bit for page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        homePage.handleCookieConsent();
    }

    /**
     * Step definition to navigate to Ralph Lauren homepage
     */
    @QAFTestStep(description = "navigate to Ralph Lauren homepage")
    public void navigateToRalphLaurenHomepage() {
        openRalphLaurenHomepage();
    }

    /**
     * Step definition to open Ralph Lauren website
     */
    @QAFTestStep(description = "I open the Ralph Lauren website")
    public void openRalphLaurenWebsite() {
        openRalphLaurenHomepage();
    }

    /**
     * Step definition to verify homepage is loaded
     */
    @QAFTestStep(description = "I should see the Ralph Lauren homepage")
    public void verifyRalphLaurenHomepageLoaded() {
        if (homePage == null) {
            homePage = new RalphLaurenHomePage();
        }
        verifyTrue(homePage.isHomePageLoaded(), "Ralph Lauren homepage should be loaded");
    }

    /**
     * Step definition to search for a product
     * @param searchTerm the search term
     */
    @QAFTestStep(description = "I search for {0}")
    public void searchForProduct(String searchTerm) {
        if (homePage == null) {
            homePage = new RalphLaurenHomePage();
        }
        homePage.searchForProduct(searchTerm);
    }

    /**
     * Step definition to navigate to Men's section
     */
    @QAFTestStep(description = "I navigate to Men's section")
    public void navigateToMensSection() {
        if (homePage == null) {
            homePage = new RalphLaurenHomePage();
        }
        homePage.navigateToMensSection();
    }

    /**
     * Step definition to navigate to Women's section
     */
    @QAFTestStep(description = "I navigate to Women's section")
    public void navigateToWomensSection() {
        if (homePage == null) {
            homePage = new RalphLaurenHomePage();
        }
        homePage.navigateToWomensSection();
    }

    /**
     * Step definition to navigate to Kids' section
     */
    @QAFTestStep(description = "I navigate to Kids' section")
    public void navigateToKidsSection() {
        if (homePage == null) {
            homePage = new RalphLaurenHomePage();
        }
        homePage.navigateToKidsSection();
    }

    /**
     * Step definition to click on the first product
     */
    @QAFTestStep(description = "I click on the first product")
    public void clickFirstProduct() {
        if (homePage == null) {
            homePage = new RalphLaurenHomePage();
        }
        pdpPage = homePage.clickFirstProduct();
    }

    /**
     * Step definition to navigate to Product Detail Page
     */
    @QAFTestStep(description = "I navigate to Product Detail Page")
    public void navigateToPDP() {
        clickFirstProduct();
    }

    /**
     * Step definition to verify PDP is loaded
     */
    @QAFTestStep(description = "I should see the Product Detail Page")
    public void verifyPDPLoaded() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        verifyTrue(pdpPage.isPDPLoaded(), "Product Detail Page should be loaded");
    }

    /**
     * Step definition to verify product title contains specific text
     * @param expectedText the expected text
     */
    @QAFTestStep(description = "I should see product title containing {0}")
    public void verifyProductTitleContains(String expectedText) {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        verifyTrue(pdpPage.isProductTitleContains(expectedText), 
                  "Product title should contain: " + expectedText);
    }

    /**
     * Step definition to verify product price is displayed
     */
    @QAFTestStep(description = "I should see the product price")
    public void verifyProductPriceDisplayed() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        verifyTrue(pdpPage.getProductPrice() != null && !pdpPage.getProductPrice().isEmpty(), 
                  "Product price should be displayed");
    }

    /**
     * Step definition to select product size
     * @param size the size to select
     */
    @QAFTestStep(description = "I select size {0}")
    public void selectProductSize(String size) {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        pdpPage.selectSize(size);
    }

    /**
     * Step definition to select product color
     * @param color the color to select
     */
    @QAFTestStep(description = "I select color {0}")
    public void selectProductColor(String color) {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        pdpPage.selectColor(color);
    }

    /**
     * Step definition to set product quantity
     * @param quantity the quantity to set
     */
    @QAFTestStep(description = "I set quantity to {0}")
    public void setProductQuantity(int quantity) {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        pdpPage.setQuantity(quantity);
    }

    /**
     * Step definition to add product to cart
     */
    @QAFTestStep(description = "I add the product to cart")
    public void addProductToCart() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        pdpPage.addToCart();
    }

    /**
     * Step definition to add product to wishlist
     */
    @QAFTestStep(description = "I add the product to wishlist")
    public void addProductToWishlist() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        pdpPage.addToWishlist();
    }

    /**
     * Step definition to verify add to cart button is enabled
     */
    @QAFTestStep(description = "I should see add to cart button is enabled")
    public void verifyAddToCartButtonEnabled() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        verifyTrue(pdpPage.isAddToCartEnabled(), "Add to cart button should be enabled");
    }

    /**
     * Step definition to verify size selector is available
     */
    @QAFTestStep(description = "I should see size selector is available")
    public void verifySizeSelectorAvailable() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        verifyTrue(pdpPage.isSizeSelectorAvailable(), "Size selector should be available");
    }

    /**
     * Step definition to verify color selector is available
     */
    @QAFTestStep(description = "I should see color selector is available")
    public void verifyColorSelectorAvailable() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        verifyTrue(pdpPage.isColorSelectorAvailable(), "Color selector should be available");
    }

    /**
     * Step definition to get product title
     * @return String product title
     */
    @QAFTestStep(description = "I get the product title")
    public String getProductTitle() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        return pdpPage.getProductTitle();
    }

    /**
     * Step definition to get product price
     * @return String product price
     */
    @QAFTestStep(description = "I get the product price")
    public String getProductPrice() {
        if (pdpPage == null) {
            pdpPage = new RalphLaurenPDPPage();
        }
        return pdpPage.getProductPrice();
    }
}