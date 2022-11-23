package com.internet.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage{
    public FileDownloadPage(WebDriver driver){
        super(driver);
    }

    //File Download Header
    @FindBy(css = "#content > div > h3")
    public WebElement fileDownloadHeaderText;
    public  WebElement getFileDownloadHeaderText(){
        return fileDownloadHeaderText;
    }

    //Sample Txt_File
    @FindBy(linkText = "deneme.txt")
    public WebElement textFileDownload;
    public WebElement getTextFileDownload(){
        return textFileDownload;
    }

    //Csv_File
    @FindBy(css = "#content > div > a:nth-child(12)")
    public WebElement csvFileDownload;
    public WebElement getCsvFileDownload(){
        return csvFileDownload;
    }

    //Csv file linkText
    @FindBy(linkText = "logo.png")
    public WebElement pngFileDownload;
    public WebElement getPngFileDownload(){
        return pngFileDownload;
    }
}
