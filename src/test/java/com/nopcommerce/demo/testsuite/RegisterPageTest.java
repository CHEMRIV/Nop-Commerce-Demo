package com.nopcommerce.demo.testsuite;

import com.google.inject.RestrictedBindingSource;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {

    RegisterPage registerPage;
    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage=new ComputerPage();
        desktopsPage=new DesktopsPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegister();
        String expectedMsg = "Register";
        String actualMsg = registerPage.setVerifyRegisterMsg();
        Assert.assertEquals(expectedMsg, actualMsg, "No match found");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        homePage.clickOnRegister();
        String expectedMsg = "Register";
        String actualMsg = registerPage.setVerifyRegisterMsg();
        Assert.assertEquals(actualMsg, expectedMsg, "User should not navigate to register page");
        registerPage.clickOnRegisterButton();
        String expectedFirstNameFieldError = "First name is required.";
        String actualFirstNameFieldError = registerPage.firstNameErrorMsg();
        Assert.assertEquals(expectedFirstNameFieldError, actualFirstNameFieldError, "No match found");
        String expectedLastNameFieldError = "Last name is required.";
        String actualLastNameFieldError = registerPage.lastNameErrorMsg();
        Assert.assertEquals(expectedLastNameFieldError, actualLastNameFieldError, "No match found");
        String expectedEmailFieldError = "Email is required.";
        String actualEmailFieldError = registerPage.emailErrorMsg();
        Assert.assertEquals(expectedEmailFieldError, actualEmailFieldError, "No match found");
        String expectedPasswordFieldError = "Password is required.";
        String actualPasswordFieldError = registerPage.passwordErrorMsg();
        Assert.assertEquals(expectedPasswordFieldError, actualPasswordFieldError, "No match found");
        String expectedConformPasswordFieldError = "Password is required.";
        String actualConformPasswordFieldError = registerPage.conformPasswordErrorMsg();
        Assert.assertEquals(expectedConformPasswordFieldError, actualConformPasswordFieldError, "No match found");
    }

    @Test(groups = {"sanity","regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegister();
        registerPage.clickOnRegisterButton();
        registerPage.clickOnGenderButton();
        registerPage.enterFirstName("Shinee");
        registerPage.enterLastName("Shah");
        registerPage.enterEmailAddress("shahh1234@gmail.com");
        registerPage.enterPassword("123456");
        registerPage.enterConformPassword("123456");
        registerPage.clickOnFinalRegisterButton();
        String expectedMsg = "Your registration completed";
        String actualMsg = registerPage.verifyMsgOfSuccessfullyRegister();
        Assert.assertEquals(expectedMsg,actualMsg, "Registration not done");

    }




}
