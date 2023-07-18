package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooks extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[text()='Laptops & Notebooks']")
    WebElement mouseHoverOnLaptop;

    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks" )
    WebElement clickOnShowAll;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']" )
    List<WebElement> getAllProductPrice;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']" )
    List< WebElement> sortReverse;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']" )
    WebElement verifyProductPrice;

    @CacheLookup
    @FindBy(linkText = "MacBook" )
    WebElement selectProduct;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement verifyTextMcBook;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']" )
    WebElement clickOnAddCart;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible" )
    WebElement verifySuccess;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickOnShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1" )
    WebElement verifyTextShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]" )
    WebElement changeQty;

    @CacheLookup
    @FindBy(xpath ="//button[contains(@data-original-title, 'Update')]" )
    WebElement clickUpdate;

    @CacheLookup
    @FindBy(xpath ="//div[@id='checkout-cart']/div[1]" )
    WebElement textModifyCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]" )
    WebElement verifytotal;

    @CacheLookup
    @FindBy(xpath ="//a[contains(text(),'Checkout')]" )
    WebElement clickCheckout;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement textCheckout;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement textNewCustomer;

    @CacheLookup
    @FindBy(xpath ="//input[@value='guest']" )
    WebElement clickingByGuestCheckout;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;

    @CacheLookup
    @FindBy(xpath ="//input[@id='button-account']" )
    WebElement name;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']" )
    WebElement surname;

    @CacheLookup
    @FindBy(xpath ="//input[@id='input-payment-email']" )
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']" )
    WebElement telephone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address1;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-2']")
    WebElement address2;

    @CacheLookup
    @FindBy(xpath ="//input[@id='input-payment-city']" )
    WebElement city;

    @CacheLookup
    @FindBy(xpath ="//input[@id='input-payment-postcode']" )
    WebElement postcode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;

    @CacheLookup
    @FindBy(xpath ="//select[@id='input-payment-zone']" )
    WebElement zone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement clickContinue;

    @CacheLookup
    @FindBy(xpath ="//textarea[@name='comment']" )
    WebElement comment;

    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    @CacheLookup
    @FindBy(xpath ="//input[@id='button-payment-method']" )
    WebElement clickContinueButton;
    @CacheLookup
    @FindBy(xpath ="//div[text()='Warning: Payment method required!']" )
    WebElement verifyWarning;

    public void mouseHoverOnTabs() {
        mouseHoverToElement(mouseHoverOnLaptop);
    }

    public void clickOnShowAllList() {
        clickOnElement(clickOnShowAll);
    }


    public void storeAllProductPrice() {
        List<WebElement> products = getAllProductPrice;
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
    }

    public void sortByReverseProduct() {
        List<WebElement> products = sortReverse;
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        //Assert.assertEquals("Product not sorted by price High to Low", originalProductsPrice, afterSortByPrice);
    }

    public String verifyByPrice() {
        return getTextFromElement(verifyProductPrice);
    }

    public void selectByProduct() {
        selectByVisibleTextFromDropDown(selectProduct, "McBook");
    }

    public String TextMcBook() {
        return getTextFromElement(verifyTextMcBook);
    }

    public void clickAddCart() {
        clickOnElement(clickOnAddCart);
    }

    public String verifyBySuccess() {
        return getTextFromElement(verifySuccess);
    }

    public void clickOnLinkShoppingCart() {
        clickOnElement(clickOnShoppingCart);
    }

    public String verifyByTextShoppingCart() {
        return getTextFromElement(verifyTextShoppingCart);
    }

    public void changeQuantity() {
        sendTextToElement(changeQty, "2");
    }

    public void clickOnUpdate() {
        clickOnElement(clickUpdate);
    }

    public String verifyTextOnModifiedShoppingCart() {
        return getTextFromElement(textModifyCart);
    }

    public String verifyTotalPrice() {
        return getTextFromElement(verifytotal);
    }
    public void clickOnCheckout(){
        clickOnElement(clickCheckout);
    }
    public String verifyTextCheckout(){
        return getTextFromElement(textCheckout);
    }
    public String verifyTextNewCustomer(){
        return getTextFromElement(textNewCustomer);
    }
    public void clickOnGuestCheckout(){
        clickOnElement(clickingByGuestCheckout);
    }
    public void clickOnContinueTab(){
        clickOnElement(continueTab);
    }
    public void typeName(){
        sendTextToElement(name,"Tina");
    }
    public void typeSurname(){
        sendTextToElement(surname,"Pathak");
    }
    public void typeEmail(){
        sendTextToElement(email,"tinaP@yahoo.com");
    }
    public void enterTelephone(){
        sendTextToElement(telephone,"07867854422");
    }
    public void enterAddress1(){
        sendTextToElement(address1,"Flat 4");
    }
    public void enterAddress2(){
        sendTextToElement(address2,"Christchurch avenue");
    }
    public void typeCity(){
        sendTextToElement(city,"London");
    }
    public void typePostCode(){
        sendTextToElement(postcode,"HA0 1TR");
    }
    public void enterCountry(){
        sendTextToElement(country,"United Kingdom");
    }
    public void enterZone(){
        sendTextToElement(zone,"Greater London");
    }
    public void clickOnContinue(){
        clickOnElement(clickContinue);
    }
    public void enterComment(){
        sendTextToElement(comment,"If no one open the door,please drop at Flat no 5.Thank you!");
    }
    public void clickOnCheckBox(){
        clickOnElement(checkBox);
    }
    public void clickOnContinueButton(){
        clickOnElement(clickContinueButton);
    }
    public String warningMessage(){
        return getTextFromElement(verifyWarning);
    }

}













