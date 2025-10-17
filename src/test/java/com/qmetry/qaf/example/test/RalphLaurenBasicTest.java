package com.qmetry.qaf.example.test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.example.pages.RalphLaurenHomePage;
import com.qmetry.qaf.example.utils.ElementFinder;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.testng.annotations.Test;

/**
 * Basic test to verify Ralph Lauren website accessibility
 * This test will help identify what elements are actually available on the real website
 */
public class RalphLaurenBasicTest extends WebDriverTestCase {

    @Test(description = "Test Ralph Lauren website accessibility")
    public void testRalphLaurenWebsiteAccessibility() {
        // Open the website
        RalphLaurenHomePage homePage = new RalphLaurenHomePage();
        homePage.openHomePage();
        
        // Wait for page to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Test different element finders
        System.out.println("=== Testing Element Finders ===");
        
        // Test search input
        QAFWebElement searchInput = ElementFinder.findSearchInput();
        if (searchInput != null) {
            System.out.println("✓ Search input found: " + searchInput.getTagName());
        } else {
            System.out.println("✗ Search input not found");
        }
        
        // Test search button
        QAFWebElement searchButton = ElementFinder.findSearchButton();
        if (searchButton != null) {
            System.out.println("✓ Search button found: " + searchButton.getTagName());
        } else {
            System.out.println("✗ Search button not found");
        }
        
        // Test navigation links
        String[] categories = {"men", "women", "kids"};
        for (String category : categories) {
            QAFWebElement navLink = ElementFinder.findNavigationLink(category);
            if (navLink != null) {
                System.out.println("✓ " + category + " link found: " + navLink.getText());
            } else {
                System.out.println("✗ " + category + " link not found");
            }
        }
        
        // Test product links
        QAFWebElement productLink = ElementFinder.findProductLink();
        if (productLink != null) {
            System.out.println("✓ Product link found: " + productLink.getAttribute("href"));
        } else {
            System.out.println("✗ Product link not found");
        }
        
        // Test cookie button
        QAFWebElement cookieButton = ElementFinder.findCookieButton();
        if (cookieButton != null) {
            System.out.println("✓ Cookie button found: " + cookieButton.getText());
        } else {
            System.out.println("✗ Cookie button not found");
        }
        
        // Print page title and URL
        System.out.println("\n=== Page Information ===");
        System.out.println("Page Title: " + getDriver().getTitle());
        System.out.println("Current URL: " + getDriver().getCurrentUrl());
        
        // Test if we can find any links on the page
        QAFWebElement anyLink = new QAFWebElement("css=a");
        if (anyLink.isPresent()) {
            System.out.println("✓ Found at least one link on the page");
        } else {
            System.out.println("✗ No links found on the page");
        }
        
        // Test if we can find any buttons on the page
        QAFWebElement anyButton = new QAFWebElement("css=button");
        if (anyButton.isPresent()) {
            System.out.println("✓ Found at least one button on the page");
        } else {
            System.out.println("✗ No buttons found on the page");
        }
        
        System.out.println("\n=== Test completed ===");
    }
}