package com.internet.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{
    public FramePage(WebDriver driver){
        super(driver);
    }

    //Nested Frames
    @FindBy(linkText = "Nested Frames")
    public WebElement nestedFrames;
    public WebElement getNestedFrames(){
        return nestedFrames;
    }

    //iFrame
    @FindBy(linkText = "iFrame")
    public WebElement iFrame;
    public WebElement getiFrame(){
        return iFrame;
    }
}
