package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class HomePageTest extends BaseTest {

    HomePage homepage;

    @BeforeMethod(alwaysRun = true)
    public void init(){
        homepage = new HomePage();
    }


    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homepage.selectMenu("Computer");
        homepage.clickOnSelectLink();
        homepage.clickOnShowAllDesktop();
        String expectedText = "Desktops";
        String actualText = homepage.verifyText();
        Assert.assertEquals(actualText,expectedText,"Text not found");
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homepage.clickOnLaptopAndNotebooks();
        homepage.clickOnShowAllLaptops();
        String expectedText = "Laptops & Notebooks";
        String actualText = homepage.verifyText1();
        Assert.assertEquals(actualText,expectedText,"Text not found");
    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homepage.clickOnComponents();
        homepage.clickOnAllShowComponents();
        String expectedText = "Components";
        String actualText = homepage.verifyText2();
        Assert.assertEquals(actualText,expectedText,"Text not found");


    }


}
