package com.internet.herokuapp.pages;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Add_remove_elements extends BasePage{
    public Add_remove_elements(WebDriver driver){
        super(driver);
    }

    //header
    @FindBy(css = "\"div#content > h3\"")
    public WebElement addRemoveElementsHeader;
    public WebElement getAddRemoveElementsHeader(){
        return addRemoveElementsHeader;
    }
    //WebElement AddElement
    @FindBy(css = "#content > div > button")
    public WebElement addElement;
    public WebElement getAddElement(){
        return addElement;
    }
    //WebElement Delete1
    @FindBy(css = "#elements > button:nth-child(1)")
    public WebElement delete1;
    public WebElement getDelete1(){
        return delete1;
    }
    //WebElement Delete2
    @FindBy(css = "#elements > button:nth-child(2)")
    public WebElement delete2;
    public WebElement getDelete2(){
        return delete2;
    }
}
