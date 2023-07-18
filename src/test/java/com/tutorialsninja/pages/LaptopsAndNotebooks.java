package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooks extends Utility {

    By mouseHoverOnLaptop = By.xpath("//a[text()='Laptops & Notebooks']");
    By clickOnShowAll = By.linkText("Show AllLaptops & Notebooks");
    By getAllProductPrice = By.xpath("//p[@class ='price']");
    By sortReverse = By.xpath("//p[@class ='price']");
    By verifyProductPrice = By.xpath("//select[@id='input-sort']");
    By selectProduct = By.linkText("MacBook");
    By verifyTextMcBook = By.xpath("//h1[contains(text(),'MacBook')]");
    By clickOnAddCart = By.xpath("//button[@id='button-cart']");
    By verifySuccess = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By clickOnShoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By verifyTextShoppingCart = By.xpath("//div[@id='content']//h1");
    By changeQty = By.xpath("//input[contains(@name, 'quantity')]");
    By clickUpdate = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By textModifyCart = By.xpath("//div[@id='checkout-cart']/div[1]");
    By verifytotal = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    By clickCheckout = By.xpath("//a[contains(text(),'Checkout')]");

    By textCheckout = By.xpath("//h1[contains(text(),'Checkout')]");
    By textNewCustomer = By.xpath("//h2[contains(text(),'New Customer')]");
    By clickingByGuestCheckout = By.xpath("//input[@value='guest']");
    By continueTab = By.xpath("//input[@id='button-account']");
    By name =By.xpath("//input[@id='button-account']");
    By surname = By.xpath("//input[@id='button-account']");
    By email = By.xpath("//input[@id='input-payment-email']");
    By telephone = By.xpath("//input[@id='input-payment-telephone']");
    By address1 = By.xpath("//input[@id='input-payment-address-1']");
    By address2 = By.xpath("//input[@id='input-payment-address-2']");
    By city = By.xpath("//input[@id='input-payment-city']");
    By postcode = By.xpath("//input[@id='input-payment-postcode']");
    By country = By.xpath("//select[@id='input-payment-country']");
    By zone = By.xpath("//select[@id='input-payment-zone']");
    By clickContinue =  By.xpath("//input[@id='button-guest']");
   By comment = By.xpath("//textarea[@name='comment']");
    By checkBox = By.xpath("//input[@type='checkbox']");
    By clickContinueButton = By.xpath("//input[@id='button-payment-method']");
    By verifyWarning = By.xpath("//div[text()='Warning: Payment method required!']");

    public void mouseHoverOnTabs() {
        mouseHoverToElement(mouseHoverOnLaptop);
    }

    public void clickOnShowAllList() {
        clickOnElement(clickOnShowAll);
    }


    public void storeAllProductPrice() {
        List<WebElement> products = driver.findElements(getAllProductPrice);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
    }

    public void sortByReverseProduct() {
        List<WebElement> products = driver.findElements(sortReverse);
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












