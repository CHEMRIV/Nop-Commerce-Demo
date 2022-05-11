package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends TestBase {

    RegisterPage registerPage;
    HomePage homePage;
    LoginPage loginPage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage=new ComputerPage();
        desktopsPage=new DesktopsPage();
        buildYourOwnComputerPage =new BuildYourOwnComputerPage();
    }



    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        homePage.clickOnComputer();
        String expectedMsg = "Computers";
        String actualMsg = computerPage.verifyComputer();
        Assert.assertEquals(expectedMsg,actualMsg, "Computer is not Visible");
    }
    @Test(groups = {"smoke","regression"})
    public void  verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.clickOnComputer();
        desktopsPage.clickOnDesktop();
        String expectedMsg = "Desktops";
        String actualMsg = desktopsPage.verifyTextDesktop();
        Assert.assertEquals(expectedMsg,actualMsg, "Desktop is not Visible");
    }
    @Test(dataProvider = "buildYouOwnComputer", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
                                                                                            processor, String ram, String hdd, String os, String software) throws InterruptedException {

        homePage.clickOnComputer();
        desktopsPage.clickOnDesktop();
        buildYourOwnComputerPage.clickOnBuildCop();
        buildYourOwnComputerPage.getBuildYourComputer();
        buildYourOwnComputerPage.processorDropDown(processor);
        buildYourOwnComputerPage.ramDropDown(ram);
        buildYourOwnComputerPage.clickHddRadio(hdd);
        buildYourOwnComputerPage.osRadioButton(os);
        buildYourOwnComputerPage.acrobatSoftWareBox(software);
        buildYourOwnComputerPage.addToCard();

        String actual = buildYourOwnComputerPage.getAddToCartBarMessage();
        String expected = "The product has been added to your shopping cart";
        Assert.assertEquals(actual, expected);

    }

    }


