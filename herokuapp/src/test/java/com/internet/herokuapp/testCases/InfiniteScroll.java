package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfiniteScroll extends BaseClass{
    @Test
    public void infiniteScroll(){

        LandingPage lp = new LandingPage(driver);

        lp.getInfiniteScroll().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Home Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.INFINITE_SCROLL_LINK);
        System.out.println("Link is Valid");

        //Infinite Scrollp Validation
        JavascriptExecutor js =(JavascriptExecutor) driver;
        long initialLength = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long currentLength = (long) js.executeScript("return document.body.scrollHeight");
            if (initialLength == currentLength) {
                break;
            }

            initialLength = currentLength;

            driver.navigate().back();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
