package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.FramePage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrames extends BaseClass{
    @Test
    public void nestedFrames(){

        LandingPage lp = new LandingPage(driver);
        FramePage fp = new FramePage(driver);

        lp.getFrames().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.FRAMES_LINK);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fp.getNestedFrames().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Frame Validation
        //Switch to Top Frame
        driver.switchTo().frame("frame-top");

        //Switch to Left Frame
        driver.switchTo().frame("frame-left");
        String leftFrameText = driver.findElement(By.cssSelector("body")).getText();
        System.out.println("You are in"+ leftFrameText+"Frame");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Switch to top frame then right frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        String rightFrameText = driver.findElement(By.cssSelector("body")).getText();
        System.out.println("You Are in"+rightFrameText+"Frame");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Switch to top frame then middle frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        String middleFrameText = driver.findElement(By.cssSelector("body")).getText();
        System.out.println("You are in"+middleFrameText+"Frame");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Switch to page then bottom frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-Bottom");
        String bottomFrameText = driver.findElement(By.cssSelector("body")).getText();
        System.out.println("You are in"+bottomFrameText+"Frame");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
