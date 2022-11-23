package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.pages.MultipleWindowsPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows extends BaseClass{
    @Test
    public void multipleWindows(){

        LandingPage lp = new LandingPage(driver);
        MultipleWindowsPage mwp = new MultipleWindowsPage(driver);

        //Click on The internet and multiple windows page
        lp.getMultipleWindows().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.MULTIPLE_WINDOW);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        mwp.clickHere.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //New Window Page
        //System.out.println(nwp.getNewHeader().getText());
        String title = driver.getTitle();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Base Window Title :"+title);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //It will return the parent window name as a string
        String parent= driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();

        //Now iterate using Iterator

        for (String child_window : s) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("New Windows Title :" + driver.switchTo().window(child_window).getTitle());

                driver.close();
            }
        }

        //Switch to the parent window
        driver.switchTo().window(parent);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().to(Data.BASE_URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
