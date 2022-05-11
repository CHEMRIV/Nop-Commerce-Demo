package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopsPage extends Utility {

    public DesktopsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]")
    WebElement desktop;
    @FindBy(xpath ="//h1[contains(text(),'Desktops')]")
    WebElement desktop1;
    @FindBy(tagName = "Build your own computer")
    WebElement buildYourOwnComputer;



    public void clickOnDesktop(){
        clickOnElement(desktop);
    }

    public String verifyTextDesktop(){
       return getTextFromElement(desktop1);
    }
    public void clickOnBuildYourOwnComputer(){
        clickOnElement(buildYourOwnComputer);

    }


}
