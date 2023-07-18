package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Desktops extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[text()='Desktops']")
     WebElement selectLink;

    @CacheLookup
    @FindBy(linkText ="Show AllDesktops" )
    WebElement mouseHover;

    @CacheLookup
    @FindBy(xpath ="//select[@id='input-sort']" )
    WebElement selectPosition;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']" )
    WebElement verifyProductOrderInDescending;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortSelectPosition;

    @CacheLookup
     @FindBy(xpath = "//a[contains(text(),'HP LP3065')]" )
    WebElement selectProduct;

    @CacheLookup
    @FindBy(linkText = "HP LP3065" )
    WebElement verifyProductText;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-calendar']" )
    WebElement selectDeliveryDate;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement enterQty;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement verifySuccess;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Shopping Cart')]")
    WebElement clickOnShoppingCart;

    @CacheLookup
    @FindBy(partialLinkText = "Shopping ")
    WebElement verifyShoppingCart;

    @CacheLookup
    @FindBy(partialLinkText = "HP ")
    WebElement verifyProductName;

    @CacheLookup
    @FindBy(xpath = "//small[text()='Delivery Date:2022-11-30']" )
    WebElement verifyDeliveryDate;

    @CacheLookup
    @FindBy(xpath = "//td[contains(text(),'Product 21')]")
    WebElement verifyModel;

    @CacheLookup
    @FindBy(xpath = "div[@class='col-sm-4 col-sm-offset-8']//td[text()='$122.00']" )
    WebElement verifyTotal;




    public void clickOnSelectLink(){
        clickOnElement(selectLink);
    }
    public void clickOnShowAllDesktop() {
        mouseHoverToElement(mouseHover);
    }
    public void sortByPosition(){
        selectByVisibleTextFromDropDown(selectPosition,"Name: Z to A");
    }
    public String verifyText(){
        return getTextFromElement(verifyProductOrderInDescending);
    }
    public void position(){
        selectByVisibleTextFromDropDown(sortSelectPosition,"Name (A - Z)");
    }
    public void clickOnProduct(){
        clickOnElement(selectProduct);
    }
    public String verifyText2(){
        return getTextFromElement(verifyProductText);
    }
    public void selectDate(){
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(selectDeliveryDate);
    }
    public void quantity(){
        sendTextToElement(enterQty,"1");
    }
    public void addInCart(){
      clickOnElement(addToCart);
    }
    public String verifyMessageSuccess(){
        return getTextFromElement(verifySuccess);
    }
    public void shoppingCart(){
        clickOnElement(clickOnShoppingCart);
    }
    public String verifyCart(){
      return getTextFromElement(verifyShoppingCart);
    }
    public String ProductNameVarification(){
        return getTextFromElement(verifyProductName);
    }
    public String deliveryDate(){
        return getTextFromElement(verifyDeliveryDate);
    }
    public String modelVerification(){
        return getTextFromElement(verifyModel);
    }
    public String totalVerification(){
        return getTextFromElement(verifyTotal);
    }

}
