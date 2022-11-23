package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.Basic_auth;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuth extends BaseClass {
    @Test
    public void basicAuth() {
        LandingPage lp = new LandingPage(driver);
        Basic_auth ba = new Basic_auth(driver);

        //Home Url Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given" + baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home URL Is Validate");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //BasicAuth Text Validation in Base Page
        if (lp.getBasicAuth().isDisplayed()) {
            String basicAuthText = lp.basicAuth.getText();
            Assert.assertTrue(true, basicAuthText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        lp.getBasicAuth().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if (ba.getBasicAuthWebElementHeader1().isDisplayed()) {
            String basicAuthHeaderText = ba.getBasicAuthWebElementHeader1().getText();
            Assert.assertTrue(true, basicAuthHeaderText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Paragraph Validation
        if (ba.getBasicAuthWebElementParagraph().isDisplayed()) {
            String basicAuthParagraphText = ba.getBasicAuthWebElementParagraph().getText();
            Assert.assertTrue(true, basicAuthParagraphText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Test Run Successfully");
    }
}
