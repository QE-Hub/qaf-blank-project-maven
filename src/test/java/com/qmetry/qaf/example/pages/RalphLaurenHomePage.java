package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.utils.ElementFinder;

/**
 * Page Object Model for Ralph Lauren Homepage
 * Contains all the elements and methods related to the homepage
 */
public class RalphLaurenHomePage extends BasePage {

    // Navigation elements - using realistic locators
    @FindBy(locator = "main.navigation")
    private QAFWebElement mainNavigation;

    @FindBy(locator = "men.link")
    private QAFWebElement menLink;

    @FindBy(locator = "women.link")
    private QAFWebElement womenLink;

    @FindBy(locator = "kids.link")
    private QAFWebElement kidsLink;

    @FindBy(locator = "home.link")
    private QAFWebElement homeLink;

    // Search elements
    @FindBy(locator = "search.input")
    private QAFWebElement searchInput;

    @FindBy(locator = "search.button")
    private QAFWebElement searchButton;

    // Product category elements
    @FindBy(locator = "product.grid")
    private QAFWebElement productGrid;

    @FindBy(locator = "product.link")
    private QAFWebElement productLinks;

    // Cookie consent elements
    @FindBy(locator = "accept.cookies")
    private QAFWebElement acceptCookiesButton;

    @FindBy(locator = "reject.cookies")
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
        QAFWebElement searchInputElement = ElementFinder.findSearchInput();
        QAFWebElement searchButtonElement = ElementFinder.findSearchButton();
        
        if (searchInputElement != null) {
            searchInputElement.clear();
            searchInputElement.sendKeys(searchTerm);
            
            if (searchButtonElement != null) {
                searchButtonElement.click();
            } else {
                // Try pressing Enter if no search button found
                searchInputElement.submit();
            }
            waitForPageToLoad();
        } else {
            throw new RuntimeException("Search input not found on the page");
        }
    }

    /**
     * Navigate to Men's section
     */
    public void navigateToMensSection() {
        QAFWebElement menLinkElement = ElementFinder.findNavigationLink("men");
        if (menLinkElement != null) {
            menLinkElement.click();
            waitForPageToLoad();
        } else if (menLink.isPresent()) {
            menLink.click();
            waitForPageToLoad();
        } else {
            throw new RuntimeException("Men's section link not found");
        }
    }

    /**
     * Navigate to Women's section
     */
    public void navigateToWomensSection() {
        QAFWebElement womenLinkElement = ElementFinder.findNavigationLink("women");
        if (womenLinkElement != null) {
            womenLinkElement.click();
            waitForPageToLoad();
        } else if (womenLink.isPresent()) {
            womenLink.click();
            waitForPageToLoad();
        } else {
            throw new RuntimeException("Women's section link not found");
        }
    }

    /**
     * Navigate to Kids' section
     */
    public void navigateToKidsSection() {
        QAFWebElement kidsLinkElement = ElementFinder.findNavigationLink("kids");
        if (kidsLinkElement != null) {
            kidsLinkElement.click();
            waitForPageToLoad();
        } else if (kidsLink.isPresent()) {
            kidsLink.click();
            waitForPageToLoad();
        } else {
            throw new RuntimeException("Kids' section link not found");
        }
    }

    /**
     * Click on the first product from the product grid
     * @return RalphLaurenPDPPage
     */
    public RalphLaurenPDPPage clickFirstProduct() {
        // Try multiple strategies to find a product link
        QAFWebElement firstProduct = findFirstProduct();
        if (firstProduct != null) {
            firstProduct.click();
            waitForPageToLoad();
            return new RalphLaurenPDPPage();
        } else {
            throw new RuntimeException("No product found on the page");
        }
    }

    /**
     * Find the first available product using multiple locator strategies
     * @return QAFWebElement first product found
     */
    private QAFWebElement findFirstProduct() {
        // Strategy 1: Try product links from locators file
        if (productLinks.isPresent()) {
            return productLinks;
        }
        
        // Strategy 2: Use ElementFinder utility
        return ElementFinder.findProductLink();
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