package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        driver.manage().deleteAllCookies();
        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessFully() {
        homePage.clickOnLogInButton();
        String expectedMsg = "Welcome, Please Sign In!";
        String actualMsg = homePage.verifyMsg();
        Assert.assertEquals(expectedMsg, actualMsg, "No match found");

    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessageWithInValidCredentials() {
        homePage.clickOnLogInButton();
        loginPage.enterEmailId("beena123@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLogInButton();
        String expectedMsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMsg = loginPage.verifyErrorMsg();
        Assert.assertEquals(expectedMsg, actualMsg, "No match found");
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.clickOnLogInButton();
        loginPage.enterEmailId("animal@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLogInButton();
        String expectedMsg = "Log out";
        String actualMsg = loginPage.verifyLogOutButton();
        Assert.assertEquals(expectedMsg, actualMsg, "No match found");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
        homePage.clickOnLogInButton();
        loginPage.enterEmailId("animal123@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLogInButton();
        loginPage.clickLogOutButton();
        String expectedMsg = "Log in";
        String actualMsg = homePage.verifyLogIn();
        Assert.assertEquals(expectedMsg, actualMsg, "No match found");
    }



}

