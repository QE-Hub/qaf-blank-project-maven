package com.qmetry.qaf.example.utils;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for finding elements using multiple locator strategies
 * This helps handle different website structures and locator variations
 */
public class ElementFinder {

    /**
     * Find an element using multiple locator strategies
     * @param selectors array of CSS selectors to try
     * @return QAFWebElement first element found, or null if none found
     */
    public static QAFWebElement findElement(String... selectors) {
        for (String selector : selectors) {
            QAFWebElement element = new QAFWebElement("css=" + selector);
            if (element.isPresent()) {
                return element;
            }
        }
        return null;
    }

    /**
     * Find an element using multiple locator strategies with custom prefix
     * @param prefix CSS selector prefix (e.g., "css=", "xpath=")
     * @param selectors array of selectors to try
     * @return QAFWebElement first element found, or null if none found
     */
    public static QAFWebElement findElement(String prefix, String... selectors) {
        for (String selector : selectors) {
            QAFWebElement element = new QAFWebElement(prefix + selector);
            if (element.isPresent()) {
                return element;
            }
        }
        return null;
    }

    /**
     * Find a product link using common e-commerce patterns
     * @return QAFWebElement first product link found
     */
    public static QAFWebElement findProductLink() {
        String[] productSelectors = {
            "a[href*='product']",
            "a[href*='/p/']",
            "a[href*='/products/']",
            ".product-item a",
            ".product-tile a",
            "[class*='product-item'] a",
            "[class*='product-tile'] a",
            ".product-link",
            "[class*='product-link']"
        };
        return findElement(productSelectors);
    }

    /**
     * Find a search input field
     * @return QAFWebElement search input found
     */
    public static QAFWebElement findSearchInput() {
        String[] searchSelectors = {
            "input[type='search']",
            "input[placeholder*='search']",
            "input[placeholder*='Search']",
            ".search-input",
            "[class*='search-input']",
            "input[name*='search']",
            "input[id*='search']"
        };
        return findElement(searchSelectors);
    }

    /**
     * Find a search button
     * @return QAFWebElement search button found
     */
    public static QAFWebElement findSearchButton() {
        String[] buttonSelectors = {
            "button[type='submit']",
            "button:contains('Search')",
            ".search-button",
            "[class*='search-button']",
            "input[type='submit']",
            ".search-submit"
        };
        return findElement(buttonSelectors);
    }

    /**
     * Find navigation links (Men, Women, Kids)
     * @param category the category to find (men, women, kids)
     * @return QAFWebElement navigation link found
     */
    public static QAFWebElement findNavigationLink(String category) {
        String[] navSelectors = {
            "a[href*='" + category + "']",
            "a:contains('" + category.substring(0, 1).toUpperCase() + category.substring(1) + "')",
            ".nav-" + category,
            "[class*='" + category + "'] a",
            "nav a[href*='" + category + "']"
        };
        return findElement(navSelectors);
    }

    /**
     * Find product title on PDP
     * @return QAFWebElement product title found
     */
    public static QAFWebElement findProductTitle() {
        String[] titleSelectors = {
            "h1",
            ".product-title",
            "[class*='product-title']",
            ".product-name",
            "[class*='product-name']",
            "h1[class*='title']"
        };
        return findElement(titleSelectors);
    }

    /**
     * Find product price on PDP
     * @return QAFWebElement product price found
     */
    public static QAFWebElement findProductPrice() {
        String[] priceSelectors = {
            ".price",
            "[class*='price']",
            ".product-price",
            "[class*='product-price']",
            "[class*='cost']",
            ".cost",
            "span:contains('$')",
            "div:contains('$')"
        };
        return findElement(priceSelectors);
    }

    /**
     * Find add to cart button
     * @return QAFWebElement add to cart button found
     */
    public static QAFWebElement findAddToCartButton() {
        String[] cartSelectors = {
            "button:contains('Add to Cart')",
            "button:contains('Add to Bag')",
            ".add-to-cart",
            "[class*='add-to-cart']",
            "[class*='add-cart']",
            "button[class*='cart']",
            "input[value*='Add to Cart']"
        };
        return findElement(cartSelectors);
    }

    /**
     * Find cookie consent buttons
     * @return QAFWebElement cookie button found
     */
    public static QAFWebElement findCookieButton() {
        String[] cookieSelectors = {
            "button:contains('Accept')",
            "button:contains('Accept All')",
            "button:contains('Accept Cookies')",
            ".accept-cookies",
            "[class*='accept']",
            "button[class*='cookie']"
        };
        return findElement(cookieSelectors);
    }

    /**
     * Wait for an element to be present with timeout
     * @param element the element to wait for
     * @param timeoutSeconds timeout in seconds
     * @return boolean true if element is present within timeout
     */
    public static boolean waitForElement(QAFWebElement element, int timeoutSeconds) {
        try {
            for (int i = 0; i < timeoutSeconds; i++) {
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
}