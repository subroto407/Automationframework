package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.HoverPages;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHover extends BaseClass{
    @Test
    public void mouseHover(){

        LandingPage lp = new LandingPage(driver);
        HoverPages hp = new HoverPages(driver);

        lp.getHovers().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Home URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.MOUSE_HOVER_LINK);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Mouse Hover Validation
        Actions actionOne = new Actions(driver);
        actionOne.moveToElement(hp.getImageOne()).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String userNameOne = hp.getNameUserOne().getText();
        System.out.println( userNameOne );

        String profileViewOne = hp.getViewProfileOne().getText();
        System.out.println( profileViewOne );
        System.out.println(" ");

        Actions actionTwo = new Actions(driver);
        actionTwo.moveToElement(hp.getImageTwo()).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String userNameTwo = hp.getNameUserTwo().getText();
        System.out.println( userNameTwo );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String profileViewTwo = hp.getViewProfileTwo().getText();
        System.out.println( profileViewTwo );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actionThree = new Actions(driver);
        actionThree.moveToElement(hp.getImageThree()).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String userNameThree = hp.getNameUserThree().getText();
        System.out.println( userNameThree );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String profileViewThree = hp.getViewProfileThree().getText();
        System.out.println( profileViewThree );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" ");

        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
