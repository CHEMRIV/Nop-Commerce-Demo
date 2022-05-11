package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement logIn;

    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement msg;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement register;
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[1]/a[1]")
    WebElement computer;





    public void clickOnLogInButton(){
        clickOnElement(logIn);
    }
    public String verifyMsg(){
        return getTextFromElement(msg);
    }
    public String verifyLogIn(){
        return getTextFromElement(logIn);

    }
    public void clickOnRegister(){
        clickOnElement(register);
    }
    public void clickOnComputer(){
        clickOnElement(computer);
    }
}
