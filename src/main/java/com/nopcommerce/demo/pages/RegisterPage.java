package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class RegisterPage extends Utility {
    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement verifyRegisterMsg;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement registerButton;
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameError;
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameError;
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailError;
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordError;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement conformPasswordError;




    public String setVerifyRegisterMsg() {
        return getTextFromElement(verifyRegisterMsg);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }

    public String firstNameErrorMsg() {
        return getTextFromElement(firstNameError);
    }

    public String lastNameErrorMsg() {
        return getTextFromElement(lastNameError);
    }

    public String emailErrorMsg() {
        return getTextFromElement(emailError);
    }

    public String passwordErrorMsg() {
        return getTextFromElement(passwordError);
    }

    public String conformPasswordErrorMsg() {
        return getTextFromElement(conformPasswordError);
    }

    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement genderButton;
    public void clickOnGenderButton() {
        clickOnElement(genderButton);

    }
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement firstName;
    public void enterFirstName(String name){
        sendTextToElement(firstName,name);
    }

    @FindBy(xpath = "//input[@id='LastName']")
    WebElement lastName;
    public void enterLastName(String name1){
        sendTextToElement(lastName,name1);
    }
    @FindBy(xpath = "//input[@id='Email']")
    WebElement email;
    public void enterEmailAddress(String email1){
        sendTextToElement(email,email1);
    }
    @FindBy(xpath = "//input[@id='Password']")
    WebElement password;
    public void enterPassword(String password1){
        sendTextToElement(password,password1);
    }
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement conformPassword;
    public void enterConformPassword(String confPassword){
        sendTextToElement(conformPassword,confPassword);
    }
    @FindBy(xpath = "//button[@id='register-button']")
    WebElement register1;
    public void clickOnFinalRegisterButton(){
        clickOnElement(register1);
    }
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement verifyMsgOfSuccessfullyRegister;
    public String verifyMsgOfSuccessfullyRegister(){
        return getTextFromElement(verifyMsgOfSuccessfullyRegister);

    }






}



