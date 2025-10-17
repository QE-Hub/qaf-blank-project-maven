package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Page Object Model for Ralph Lauren Product Detail Page (PDP)
 * Contains all the elements and methods related to the product detail page
 */
public class RalphLaurenPDPPage extends BasePage {

    // Product information elements
    @FindBy(locator = "css=h1[data-testid='product-title']")
    private QAFWebElement productTitle;

    @FindBy(locator = "css=span[data-testid='product-price']")
    private QAFWebElement productPrice;

    @FindBy(locator = "css=div[data-testid='product-description']")
    private QAFWebElement productDescription;

    @FindBy(locator = "css=div[data-testid='product-images']")
    private QAFWebElement productImages;

    // Size selection elements
    @FindBy(locator = "css=div[data-testid='size-selector']")
    private QAFWebElement sizeSelector;

    @FindBy(locator = "css=button[data-testid='size-option']")
    private QAFWebElement sizeOptions;

    // Color selection elements
    @FindBy(locator = "css=div[data-testid='color-selector']")
    private QAFWebElement colorSelector;

    @FindBy(locator = "css=button[data-testid='color-option']")
    private QAFWebElement colorOptions;

    // Add to cart elements
    @FindBy(locator = "css=button[data-testid='add-to-cart']")
    private QAFWebElement addToCartButton;

    @FindBy(locator = "css=button[data-testid='add-to-wishlist']")
    private QAFWebElement addToWishlistButton;

    // Quantity selector
    @FindBy(locator = "css=select[data-testid='quantity-selector']")
    private QAFWebElement quantitySelector;

    @FindBy(locator = "css=input[data-testid='quantity-input']")
    private QAFWebElement quantityInput;

    // Product details elements
    @FindBy(locator = "css=div[data-testid='product-details']")
    private QAFWebElement productDetails;

    @FindBy(locator = "css=div[data-testid='size-chart']")
    private QAFWebElement sizeChart;

    @FindBy(locator = "css=div[data-testid='shipping-info']")
    private QAFWebElement shippingInfo;

    // Breadcrumb navigation
    @FindBy(locator = "css=nav[data-testid='breadcrumb']")
    private QAFWebElement breadcrumb;

    // Related products
    @FindBy(locator = "css=div[data-testid='related-products']")
    private QAFWebElement relatedProducts;

    // Constructor
    public RalphLaurenPDPPage() {
        super();
    }

    /**
     * Get the product title
     * @return String product title
     */
    public String getProductTitle() {
        return productTitle.getText();
    }

    /**
     * Get the product price
     * @return String product price
     */
    public String getProductPrice() {
        return productPrice.getText();
    }

    /**
     * Get the product description
     * @return String product description
     */
    public String getProductDescription() {
        return productDescription.getText();
    }

    /**
     * Select a size for the product
     * @param size the size to select
     */
    public void selectSize(String size) {
        if (sizeSelector.isPresent()) {
            sizeSelector.click();
            // Find and click the specific size option
            QAFWebElement sizeOption = new QAFWebElement("css=button[data-testid='size-option'][data-value='" + size + "']");
            if (sizeOption.isPresent()) {
                sizeOption.click();
            }
        }
    }

    /**
     * Select a color for the product
     * @param color the color to select
     */
    public void selectColor(String color) {
        if (colorSelector.isPresent()) {
            colorSelector.click();
            // Find and click the specific color option
            QAFWebElement colorOption = new QAFWebElement("css=button[data-testid='color-option'][data-value='" + color + "']");
            if (colorOption.isPresent()) {
                colorOption.click();
            }
        }
    }

    /**
     * Set the quantity for the product
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        if (quantityInput.isPresent()) {
            quantityInput.clear();
            quantityInput.sendKeys(String.valueOf(quantity));
        } else if (quantitySelector.isPresent()) {
            quantitySelector.selectByVisibleText(String.valueOf(quantity));
        }
    }

    /**
     * Add the product to cart
     */
    public void addToCart() {
        addToCartButton.click();
        waitForPageToLoad();
    }

    /**
     * Add the product to wishlist
     */
    public void addToWishlist() {
        addToWishlistButton.click();
        waitForPageToLoad();
    }

    /**
     * Verify if the PDP is loaded
     * @return boolean
     */
    public boolean isPDPLoaded() {
        return productTitle.isPresent() && productTitle.isDisplayed() && 
               productPrice.isPresent() && productPrice.isDisplayed();
    }

    /**
     * Verify if the product title contains specific text
     * @param expectedText the expected text
     * @return boolean
     */
    public boolean isProductTitleContains(String expectedText) {
        return productTitle.getText().toLowerCase().contains(expectedText.toLowerCase());
    }

    /**
     * Get the breadcrumb text
     * @return String breadcrumb text
     */
    public String getBreadcrumbText() {
        return breadcrumb.getText();
    }

    /**
     * Check if size selector is available
     * @return boolean
     */
    public boolean isSizeSelectorAvailable() {
        return sizeSelector.isPresent() && sizeSelector.isDisplayed();
    }

    /**
     * Check if color selector is available
     * @return boolean
     */
    public boolean isColorSelectorAvailable() {
        return colorSelector.isPresent() && colorSelector.isDisplayed();
    }

    /**
     * Check if add to cart button is enabled
     * @return boolean
     */
    public boolean isAddToCartEnabled() {
        return addToCartButton.isPresent() && addToCartButton.isEnabled();
    }
}