package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyAccount extends Utility {

     @CacheLookup
     @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
     List<WebElement> accountOption;

     @CacheLookup
     @FindBy(xpath ="//span[contains(text(),'My Account')]" )
     WebElement clickAccountLink;

     @CacheLookup
     @FindBy(xpath ="//h1[contains(text(),'Register Account')]" )
     WebElement verifyRegister;

     @CacheLookup
     @FindBy(xpath ="//h2[contains(text(),'Returning Customer')]" )
     WebElement textReturningCustomer;

     @CacheLookup
     @FindBy(id ="input-password" )
     WebElement password;

     @CacheLookup
     @FindBy(id ="input-confirm" )
     WebElement confirmPassword;

     @CacheLookup
     @FindBy(xpath ="//fieldset[3]//input" )
     WebElement selectOnYes;

     @CacheLookup
     @FindBy(xpath ="//div[@class = 'buttons']//input[@name='agree']" )
     WebElement clickCheckBox;

     @CacheLookup
     @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
     WebElement clickContinue;

     @CacheLookup
     @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
     WebElement verifyMassage;

     @CacheLookup
     @FindBy(xpath ="//a[contains(text(),'Continue')]" )
     WebElement continueWithClick;

     @CacheLookup
     @FindBy(xpath ="//h1[contains(text(),'Account Logout')]" )
     WebElement verifyLogout;

     @CacheLookup
     @FindBy(xpath ="//form[contains(@action,'login')]//input[@type='submit']" )
     WebElement clickLoginButton;






    public void selectMyAccountOptions(String option){
        List<WebElement> myAccountList = getListOfElements(accountOption);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(accountOption);
        }

    }


    public void clickOnAccountLink(){
         clickOnElement(clickAccountLink);
    }
    public String verifyOnRegisterLink(){
        return getTextFromElement(verifyRegister);
    }
    public String VerifyReturningCustomer(){
        return getTextFromElement(textReturningCustomer);
    }
    public void enterPassword(){
        sendTextToElement(password,"tp123");
    }
    public void enterConfirmPassword(){
        sendTextToElement(confirmPassword,"tp123");
    }
    public void selectByYes(){
        selectByContainsTextFromDropDown((By) selectOnYes,"Yes");
    }
    public void clickOnCheckBox(){
        clickOnElement(clickCheckBox);
    }
    public void clickButtonWithContinue(){
        clickOnElement(clickContinue);
    }
    public String verifyTheMassage(){
        return getTextFromElement(verifyMassage);
    }
    public void clickOnTheContinue(){
        clickOnElement(continueWithClick);
    }
    public String verifyAccountLogout(){
        return getTextFromElement(verifyLogout);
    }
    public void clickOnLoginButton(){
        clickOnElement(clickLoginButton);
    }

    }

