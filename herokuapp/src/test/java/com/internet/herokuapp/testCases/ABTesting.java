package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTesting extends BaseClass{

    @Test

    public void aBTesting() {
        LandingPage lp = new LandingPage(driver);

        //Landing Page URL validation

        String baseUrl = driver.getCurrentUrl();
        System.out.println(baseUrl);
        Assert.assertEquals(baseUrl, Data.BASE_URL);
        System.out.println(Data.POSITIVE_MASSAGE);

        //validating ABTesting button

        if (lp.getAbTesting().isDisplayed())
        {
            String abTesting = lp.getAbTesting().getText();
            Assert.assertEquals("A/B Testing", abTesting);
            lp.getAbTesting().click();
            System.out.println("ABTesting button is visible and clickable");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //corresponding page url validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+ link);
        Assert.assertEquals(link,Data.BASE_URL+Data.AB_TEST_LINK);
        System.out.println("Link is validate");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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