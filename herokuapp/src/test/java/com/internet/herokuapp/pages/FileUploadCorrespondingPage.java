package com.internet.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadCorrespondingPage extends BasePage{
    public FileUploadCorrespondingPage(WebDriver driver){
        super(driver);
    }

    //File Upload Corresponding Page
    @FindBy(css = "#content > ul > li:nth-child(18) > a")
    public WebElement fileUploadCorrespondingPage;
    public WebElement getFileUploadCorrespondingPage(){
        return fileUploadCorrespondingPage;
    }
}
