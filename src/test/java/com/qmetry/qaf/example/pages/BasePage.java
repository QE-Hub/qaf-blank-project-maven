package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;

/**
 * Base Page Object Model class
 * Contains common functionality and elements shared across all pages
 */
public abstract class BasePage {

    protected QAFWebDriver driver;

    // Common elements that might appear on any page
    @FindBy(locator = "main.header")
    protected QAFWebElement mainHeader;

    @FindBy(locator = "main.footer")
    protected QAFWebElement mainFooter;

    @FindBy(locator = "cookie.accept")
    protected QAFWebElement cookieAcceptButton;

    @FindBy(locator = "cookie.reject")
    protected QAFWebElement cookieRejectButton;

    // Constructor
    public BasePage() {
        this.driver = (QAFWebDriver) getDriver();
    }

    /**
     * Get the current WebDriver instance
     * @return QAFWebDriver
     */
    protected QAFWebDriver getDriver() {
        return (QAFWebDriver) getDriver();
    }

    /**
     * Wait for page to load completely
     */
    protected void waitForPageToLoad() {
        try {
            Thread.sleep(2000); // Wait for 2 seconds for page to load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Handle cookie consent popup
     */
    public void handleCookieConsent() {
        if (cookieAcceptButton.isPresent() && cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
            waitForPageToLoad();
        }
    }

    /**
     * Check if the page is loaded by verifying main header presence
     * @return boolean
     */
    public boolean isPageLoaded() {
        return mainHeader.isPresent() && mainHeader.isDisplayed();
    }

    /**
     * Get page title
     * @return String page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get current URL
     * @return String current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Navigate back to previous page
     */
    public void navigateBack() {
        driver.navigate().back();
        waitForPageToLoad();
    }

    /**
     * Refresh the current page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        waitForPageToLoad();
    }

    /**
     * Scroll to an element
     * @param element the element to scroll to
     */
    protected void scrollToElement(QAFWebElement element) {
        if (element.isPresent()) {
            element.scrollIntoView();
        }
    }

    /**
     * Wait for an element to be present
     * @param element the element to wait for
     * @param timeoutInSeconds timeout in seconds
     * @return boolean true if element is present within timeout
     */
    protected boolean waitForElementPresent(QAFWebElement element, int timeoutInSeconds) {
        try {
            for (int i = 0; i < timeoutInSeconds; i++) {
                if (element.isPresent()) {
                    return true;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

    /**
     * Wait for an element to be visible
     * @param element the element to wait for
     * @param timeoutInSeconds timeout in seconds
     * @return boolean true if element is visible within timeout
     */
    protected boolean waitForElementVisible(QAFWebElement element, int timeoutInSeconds) {
        try {
            for (int i = 0; i < timeoutInSeconds; i++) {
                if (element.isPresent() && element.isDisplayed()) {
                    return true;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }
}