package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.HorizontalSliderPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSlider extends BaseClass{
    @Test
    public void horizontalSlider(){

        LandingPage lp = new LandingPage(driver);
        HorizontalSliderPage hsp = new HorizontalSliderPage(driver);

        lp.getHorizontalSlider().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding Page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.HORIZONTAL_SLIDER_LINK);
        System.out.println("Link Is Valid");
        System.out.println("Header Text is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if ( hsp.getHorizontalSliderHeader().isDisplayed()){
            String header1 = hsp.getHorizontalSliderHeader().getText();
            Assert.assertEquals(header1,Data.HORIZONTAL_SLIDER_HEADER1);
            System.out.println("header text is Valid");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        WebElement slider = driver.findElement(By.cssSelector("#content > div > div > input[type=range]"));

        //Using Action Class TO drag the slider
        //Horizontal slider Validation
        Actions move = new Actions(driver);
        Actions action = (Actions) move.dragAndDropBy(slider,20,0).build();
        action.perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Slider Value Validation
        String value =driver.findElement(By.cssSelector("#range")).getText();
        System.out.println("Dragged Value"+value);
        String val ="2.5";
        Assert.assertEquals(value,val );

        }
    }
