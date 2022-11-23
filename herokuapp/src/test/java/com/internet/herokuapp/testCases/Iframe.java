package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.FramePage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe extends BaseClass{
    @Test
    public void iFrame(){

        LandingPage lp = new LandingPage(driver);
        FramePage fp = new FramePage(driver);

        lp.getFrames().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.FRAMES_LINK);
        System.out.println("Link is Valid");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fp.getiFrame().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Switch to frame
        driver.switchTo().frame("mce_0_ifr");
        WebElement txt = driver.findElement(By.cssSelector("#tinymce"));
        txt.clear();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        txt.sendKeys(Data.INPUTS_TEXT);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().defaultContent();
        driver.navigate().to(Data.BASE_URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
