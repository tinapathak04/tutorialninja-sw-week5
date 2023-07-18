package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.pages.LaptopsAndNotebooks;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {


    Desktops desktops;
    LaptopsAndNotebooks books;
    MyAccount account;


    @BeforeMethod(alwaysRun = true)
    public void init(){
        desktops = new Desktops();
        books = new LaptopsAndNotebooks();
        account = new MyAccount();
    }


    @Test(groups = {"sanity","regression"})
    public void verifyProductArrangeInAlphaBaticalOrder(){
        desktops.clickOnSelectLink();
        desktops.clickOnShowAllDesktop();
        desktops.sortByPosition();
        String expectedText = "Name: Z to A";
        String actualText = desktops.verifyText();
        Assert.assertEquals(actualText,expectedText,"Text not found");
    }
    @Test(groups = {"sanity","smoke","regression"})
    public void  verifyProductAddedToShoppingCartSuccessFully() {
        desktops.clickOnSelectLink();
        desktops.clickOnShowAllDesktop();
        desktops.position();
        desktops.clickOnProduct();
        String expectedText = "Name: A to Z";
        String actualText = desktops.verifyText2();
        Assert.assertEquals(actualText, expectedText, "Text not found");
        desktops.selectDate();
        desktops.quantity();
        desktops.addInCart();
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!";
        String actualText1 = desktops.verifyMessageSuccess();
        Assert.assertEquals(actualText1, expectedText1, "Text not found");
        desktops.shoppingCart();
        String expectedText2 = "Shopping Cart";
        String actualText2 = desktops.verifyCart();
        Assert.assertEquals(actualText2, expectedText2, "Text not found");

        String expectedText3 = "HP LP3065";
        String actualText3 = desktops.ProductNameVarification();
        Assert.assertEquals(actualText3, expectedText3, "Text not found");

        String expectedText4 = "2022-11-30";
        String actualText4 = desktops.deliveryDate();
        Assert.assertEquals(actualText4, expectedText4, "Text not found");

        String expectedText5 = "Product21";
        String actualText5 = desktops.modelVerification();
        Assert.assertEquals(actualText5, expectedText5, "Text not found");

        String expectedText6 = "$122.00";
        String actualText6 = desktops.totalVerification();
        Assert.assertEquals(actualText6, expectedText6, "Text not found");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        books.mouseHoverOnTabs();
        books.clickOnShowAllList();
        books.storeAllProductPrice();
        books.sortByReverseProduct();
        String expectedText = "Price (High > Low)";
        String actualText = books.verifyByPrice();
        Assert.assertEquals("Message not found", expectedText, actualText);
    }
    @Test(groups = {"regression"})
    public void verifyThatUserPlaceOrderSuccessfully(){

        books.mouseHoverOnTabs();
        books.clickOnShowAllList();
        books.storeAllProductPrice();
        books.sortByReverseProduct();
        books.selectByProduct();
        String expectedText = "McBook";
        String actualText = books.TextMcBook();
        Assert.assertEquals("Message not found", expectedText, actualText);
        books.clickAddCart();

        String expectedText1 = "Success: You have added MacBook to your shopping cart!";
        String actualText1 = books.verifyBySuccess();
        Assert.assertEquals("Message not found", expectedText1, actualText1);

        books.clickOnLinkShoppingCart();
        String expectedText2 = "Shopping Cart";
        String actualText2 = books.verifyByTextShoppingCart();
        Assert.assertEquals("Message not found", expectedText2, actualText2);

        String expectedText3 = "McBook";
        String actualText3 = books.TextMcBook();
        Assert.assertEquals("Message not found", expectedText3, actualText3);

        books.changeQuantity();
        books.clickOnUpdate();

        String expectedText4 = "Success: You have modified your shopping cart!";
        String actualText4 = books.verifyTextOnModifiedShoppingCart();
        Assert.assertEquals("Message not found", expectedText4, actualText4);

        String expectedText5 = "$1,204.00";
        String actualText5 = books.verifyTotalPrice();
        Assert.assertEquals("Message not found", expectedText5, actualText5);

        books.clickOnCheckout();

        String expectedText6 = "Checkout";
        String actualText6 = books.verifyTextCheckout();
        Assert.assertEquals("Message not found", expectedText6, actualText6);

        String expectedText7 = "New Customer";
        String actualText7 = books.verifyTextNewCustomer();
        Assert.assertEquals("Message not found", expectedText7, actualText7);

        books.clickOnGuestCheckout();
        books.clickOnContinueTab();
        books.typeName();
        books.typeSurname();
        books.typeEmail();
        books.enterTelephone();
        books.enterAddress1();
        books.enterAddress2();
        books.typeCity();
        books.typePostCode();
        books.enterCountry();
        books.enterZone();
        books.clickOnContinue();
        books.enterComment();
        books.clickOnCheckBox();
        books.clickOnContinueButton();
        String expectedText8 = "Warning: Payment method required!";
        String actualText8 = books.warningMessage();
        Assert.assertEquals("Message not found", expectedText8, actualText8);
    }
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        account.clickOnAccountLink();
        account.selectMyAccountOptions("Register");

        String expectedText = "Register Account";
        String actualText = account.verifyOnRegisterLink();
        Assert.assertEquals("Message not found", expectedText, actualText);

    }
    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        account.clickOnAccountLink();
        account.selectMyAccountOptions("Login");

        String expectedText = "Returning Customer";
        String actualText = account.VerifyReturningCustomer();
        Assert.assertEquals("Message not found", expectedText, actualText);

    }
    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully(){
        account.clickOnAccountLink();
        account.selectMyAccountOptions("Register");
        books.typeName();
        books.typeSurname();
        books.typeEmail();
        books.enterTelephone();
        account.enterPassword();
        account.enterConfirmPassword();
        account.selectByYes();
        account.clickOnCheckBox();
        account.clickButtonWithContinue();

        String expectedText = "Your Account Has Been Created!";
        String actualText = account.verifyTheMassage();
        Assert.assertEquals("Message not found", expectedText, actualText);

        account.clickOnTheContinue();
        account.clickOnAccountLink();
        account.selectMyAccountOptions("Logout");

        String expectedText1 = "Account Logout";
        String actualText1 = account.verifyAccountLogout();
        Assert.assertEquals("Message not found", expectedText1, actualText1);
        account.clickButtonWithContinue();
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        account.clickOnAccountLink();
        account.selectMyAccountOptions("Login");
        books.typeEmail();
        account.enterPassword();
        account.clickOnLoginButton();
        account.clickOnAccountLink();
        account.selectMyAccountOptions("Logout");

        String expectedText = "Account Logout";
        String actualText = account.verifyAccountLogout();
        Assert.assertEquals("Message not found", expectedText, actualText);

        account.clickButtonWithContinue();

    }


}
