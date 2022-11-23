package com.internet.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage{
    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }

    //Forgot Password Header
    @FindBy(css = "#content > div > h2")
    public WebDriver forgotPasswordHeader;
    public WebDriver getForgotPasswordHeader(){
        return forgotPasswordHeader;
    }
    //EmailField
    @FindBy(css = "#email")
    public WebDriver emailField;
    public WebDriver getEmailField(){
        return emailField;
    }
    //passwordRetrieveButton
    @FindBy(css = "#form_submit > i")
    public WebDriver passwordRetrieveButton;
    public WebDriver getPasswordRetrieveButton(){
        return passwordRetrieveButton;
    }
}
