package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Page Object Model for Ralph Lauren Homepage
 * Contains all the elements and methods related to the homepage
 */
public class RalphLaurenHomePage extends BasePage {

    // Navigation elements
    @FindBy(locator = "css=nav[data-testid='main-navigation']")
    private QAFWebElement mainNavigation;

    @FindBy(locator = "css=a[data-testid='men-link']")
    private QAFWebElement menLink;

    @FindBy(locator = "css=a[data-testid='women-link']")
    private QAFWebElement womenLink;

    @FindBy(locator = "css=a[data-testid='kids-link']")
    private QAFWebElement kidsLink;

    @FindBy(locator = "css=a[data-testid='home-link']")
    private QAFWebElement homeLink;

    // Search elements
    @FindBy(locator = "css=input[data-testid='search-input']")
    private QAFWebElement searchInput;

    @FindBy(locator = "css=button[data-testid='search-button']")
    private QAFWebElement searchButton;

    // Product category elements
    @FindBy(locator = "css=div[data-testid='product-grid']")
    private QAFWebElement productGrid;

    @FindBy(locator = "css=a[data-testid='product-link']")
    private QAFWebElement productLinks;

    // Cookie consent elements
    @FindBy(locator = "css=button[data-testid='accept-cookies']")
    private QAFWebElement acceptCookiesButton;

    @FindBy(locator = "css=button[data-testid='reject-cookies']")
    private QAFWebElement rejectCookiesButton;

    // Constructor
    public RalphLaurenHomePage() {
        super();
    }

    /**
     * Navigate to Ralph Lauren homepage
     */
    public void openHomePage() {
        get("/");
        waitForPageToLoad();
    }

    /**
     * Handle cookie consent popup
     */
    public void handleCookieConsent() {
        if (acceptCookiesButton.isPresent()) {
            acceptCookiesButton.click();
        }
    }

    /**
     * Search for a product
     * @param searchTerm the search term
     */
    public void searchForProduct(String searchTerm) {
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
        searchButton.click();
        waitForPageToLoad();
    }

    /**
     * Navigate to Men's section
     */
    public void navigateToMensSection() {
        menLink.click();
        waitForPageToLoad();
    }

    /**
     * Navigate to Women's section
     */
    public void navigateToWomensSection() {
        womenLink.click();
        waitForPageToLoad();
    }

    /**
     * Navigate to Kids' section
     */
    public void navigateToKidsSection() {
        kidsLink.click();
        waitForPageToLoad();
    }

    /**
     * Click on the first product from the product grid
     * @return RalphLaurenPDPPage
     */
    public RalphLaurenPDPPage clickFirstProduct() {
        productLinks.click();
        waitForPageToLoad();
        return new RalphLaurenPDPPage();
    }

    /**
     * Get the main navigation element
     * @return QAFWebElement
     */
    public QAFWebElement getMainNavigation() {
        return mainNavigation;
    }

    /**
     * Get the search input element
     * @return QAFWebElement
     */
    public QAFWebElement getSearchInput() {
        return searchInput;
    }

    /**
     * Get the product grid element
     * @return QAFWebElement
     */
    public QAFWebElement getProductGrid() {
        return productGrid;
    }

    /**
     * Verify if the homepage is loaded
     * @return boolean
     */
    public boolean isHomePageLoaded() {
        return mainNavigation.isPresent() && mainNavigation.isDisplayed();
    }
}