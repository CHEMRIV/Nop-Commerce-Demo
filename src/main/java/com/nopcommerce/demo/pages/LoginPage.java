package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    WebElement emailId;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement logInButton;

    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]")
    WebElement errorMsg;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    WebElement logOutButton;

     public void enterEmailId(String email){
        sendTextToElement(emailId,email);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    public void clickOnLogInButton(){
        clickOnElement(logInButton);
    }
    public String verifyErrorMsg(){
       return getTextFromElement(errorMsg);
    }
    public String verifyLogOutButton(){
        return getTextFromElement(logOutButton);
    }
    public void clickLogOutButton(){
        clickOnElement(logOutButton);
    }
}
