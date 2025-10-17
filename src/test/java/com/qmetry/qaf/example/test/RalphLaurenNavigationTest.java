package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.example.steps.RalphLaurenSteps.*;

import org.testng.annotations.Test;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/**
 * Test class for Ralph Lauren website navigation
 * Contains test methods for various navigation scenarios
 */
public class RalphLaurenNavigationTest extends WebDriverTestCase {

    /**
     * Test to open Ralph Lauren homepage and navigate to PDP
     */
    @Test(description = "Open Ralph Lauren homepage and navigate to PDP")
    public void testOpenHomepageAndNavigateToPDP() {
        openRalphLaurenHomepage();
        verifyRalphLaurenHomepageLoaded();
        clickFirstProduct();
        verifyPDPLoaded();
        verifyProductPriceDisplayed();
        verifyAddToCartButtonEnabled();
    }

    /**
     * Test to search for product and navigate to PDP
     */
    @Test(description = "Search for product and navigate to PDP")
    public void testSearchProductAndNavigateToPDP() {
        openRalphLaurenHomepage();
        searchForProduct("polo shirt");
        clickFirstProduct();
        verifyPDPLoaded();
        verifyProductTitleContains("polo");
    }

    /**
     * Test to navigate to Men's section and select product
     */
    @Test(description = "Navigate to Men's section and select product")
    public void testNavigateToMensSectionAndSelectProduct() {
        openRalphLaurenHomepage();
        navigateToMensSection();
        clickFirstProduct();
        verifyPDPLoaded();
        verifySizeSelectorAvailable();
        verifyColorSelectorAvailable();
    }

    /**
     * Test to navigate to Women's section and select product
     */
    @Test(description = "Navigate to Women's section and select product")
    public void testNavigateToWomensSectionAndSelectProduct() {
        openRalphLaurenHomepage();
        navigateToWomensSection();
        clickFirstProduct();
        verifyPDPLoaded();
        verifyProductPriceDisplayed();
    }

    /**
     * Test to navigate to Kids' section and select product
     */
    @Test(description = "Navigate to Kids' section and select product")
    public void testNavigateToKidsSectionAndSelectProduct() {
        openRalphLaurenHomepage();
        navigateToKidsSection();
        clickFirstProduct();
        verifyPDPLoaded();
        verifyAddToCartButtonEnabled();
    }

    /**
     * Test complete product selection flow
     */
    @Test(description = "Complete product selection flow")
    public void testCompleteProductSelectionFlow() {
        openRalphLaurenHomepage();
        clickFirstProduct();
        verifyPDPLoaded();
        selectProductSize("M");
        selectProductColor("Blue");
        setProductQuantity(2);
        verifyAddToCartButtonEnabled();
        addProductToCart();
        verifyPDPLoaded();
    }

    /**
     * Test to get product information
     */
    @Test(description = "Get product information")
    public void testGetProductInformation() {
        openRalphLaurenHomepage();
        clickFirstProduct();
        verifyPDPLoaded();
        
        String productTitle = getProductTitle();
        String productPrice = getProductPrice();
        
        System.out.println("Product Title: " + productTitle);
        System.out.println("Product Price: " + productPrice);
        
        // Verify that product information is not empty
        assert productTitle != null && !productTitle.isEmpty() : "Product title should not be empty";
        assert productPrice != null && !productPrice.isEmpty() : "Product price should not be empty";
    }
}