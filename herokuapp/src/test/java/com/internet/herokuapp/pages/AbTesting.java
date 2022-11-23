package com.internet.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbTesting extends BasePage{
    public AbTesting(WebDriver driver){
        super(driver);
    }

    //Ab Test Variation Header1
    @FindBy(css = "#content > div > h3")
    public WebElement abTestVariationHeader1;
    public WebElement getAbTestVariationHeader1(){
        return abTestVariationHeader1;
    }
    //Ab Test Variation Paragraph
    @FindBy(css = "#content > div > p")
    public WebElement abTestVariationParagraph;
    public WebElement getAbTestVariationParagraph(){
        return abTestVariationParagraph;
    }
}
