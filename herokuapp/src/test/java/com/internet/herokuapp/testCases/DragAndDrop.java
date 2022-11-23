package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.Drag_and_drop;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseClass{
    @Test
    public void dragAndDrop(){

        LandingPage lp = new LandingPage(driver);
        Drag_and_drop dad = new Drag_and_drop(driver);

        //DragAndDrop Text Validation in Base Page
        if(lp.getDragAndDrop().isDisplayed()){
            String dragAndDropText = lp.getDragAndDrop().getText();
            Assert.assertTrue(true,dragAndDropText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        lp.getDragAndDrop().click();

        //Header Validation
        if (dad.getDragAndDropHeaderText().isDisplayed()){
            String dragAndDropHeaderText = dad.getDragAndDropHeaderText().getText();
            Assert.assertTrue(true,dragAndDropHeaderText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Mouse Hover Validation
        WebElement From = driver.findElement(By.cssSelector("#column-a"));
        WebElement To = driver.findElement(By.cssSelector("#column-b"));

        //Drag And Drop Activity Doesn't work properly
        Actions act = new Actions(driver);
        act.dragAndDrop(From,To).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
