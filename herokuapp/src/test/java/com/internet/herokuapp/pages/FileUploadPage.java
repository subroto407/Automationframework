package com.internet.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver){
        super(driver);
    }
    //Header
    @FindBy(css = "#content > div.example > h3")
    public WebElement fileUploadPageHeader1;
    public WebElement getFileUploadPageHeader1(){
        return fileUploadPageHeader1;
    }
    //Choose File Button
    @FindBy(id = "Unit-05.pdf")
    public WebElement chooseFileButton;
    public WebElement getChooseFileButton(){
        return chooseFileButton;
    }
    //Upload Button
    @FindBy(id = "file-submit")
    public WebElement uploadButton;
    public WebElement getUploadButton(){
        return uploadButton;
    }
    //dragAreaButton
    @FindBy(css = "#drag-drop-upload")
    public WebElement dragAreaButton;
    public WebElement getDragAreaButton(){
        return dragAreaButton;
    }
}
