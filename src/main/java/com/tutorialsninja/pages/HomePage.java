package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*" )
    List<WebElement> allListOfTopMenu;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Desktops']" )
    WebElement selectLink;

    @CacheLookup
    @FindBy(linkText ="Show AllDesktops" )
    WebElement mouseHover;

    @CacheLookup
    @FindBy(linkText = "Desktops" )
    WebElement desktopText;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Laptops & Notebooks']")
    WebElement laptopAndNoteBooksLink;

    @CacheLookup
    @FindBy(linkText = "Show AllLaptops & Notebooks")
    WebElement mouseHverOnShowAll;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopText;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Components']")
    WebElement componentsLink;

    @CacheLookup
    @FindBy(linkText = "Show AllComponents")
    WebElement mouseHoverOnComponents;

    @CacheLookup
    @FindBy(linkText = "Components" )
    WebElement ComponentsText;

    public void selectMenu(String menu){
        List<WebElement> topMenuList = getListOfElements(allListOfTopMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = getListOfElements(allListOfTopMenu);
        }
        clickOnElement(By.linkText(menu));
    }


    public void clickOnSelectLink(){
        clickOnElement(selectLink);
    }
    public void clickOnShowAllDesktop(){
        mouseHoverToElement(mouseHover);
    }
    public String verifyText(){
        return getTextFromElement(desktopText);
    }
    public void clickOnLaptopAndNotebooks(){
        clickOnElement(laptopAndNoteBooksLink);
    }
    public void clickOnShowAllLaptops(){
        mouseHoverToElement(mouseHverOnShowAll);
    }
    public String verifyText1(){
        return getTextFromElement(laptopText);
    }
    public void clickOnComponents(){
        clickOnElement(componentsLink);
    }
    public void clickOnAllShowComponents(){
        mouseHoverToElement(mouseHoverOnComponents);
    }
    public String verifyText2(){
        return getTextFromElement(ComponentsText);
    }

}
