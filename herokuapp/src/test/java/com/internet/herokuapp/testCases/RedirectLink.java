package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.pages.RedirectLinkPage;
import com.internet.herokuapp.pages.StatusCodePage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RedirectLink extends BaseClass{
    @Test
    public void redirectLink(){

        LandingPage lp = new LandingPage(driver);
        RedirectLinkPage rlp = new RedirectLinkPage(driver);
        StatusCodePage scp = new StatusCodePage(driver);

        lp.getRedirectLink().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //URL Validate
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.REDIRECT_LINK);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Header1 Text Validation
        if (rlp.getHeader1().isDisplayed()) {
            String header1 = rlp.getHeader1().getText();
            Assert.assertEquals(header1, Data.REDIRECTION_PAGE_HEADER_1);
            System.out.println("Header Text is Valid");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Url Validation for status code 200
        scp.getRedirectLink200().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String statusCode200Link = driver.getCurrentUrl();
        System.out.println("Given"+statusCode200Link);
        Assert.assertEquals(statusCode200Link,Data.STATUS_CODE_200_LINK);
        System.out.println("status code 200 link is valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scp.getClickHere().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //URL Validation for status code 301
        scp.getRedirectLink301().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String statusCode301Link = driver.getCurrentUrl();
        System.out.println("Given"+statusCode301Link);
        Assert.assertEquals(statusCode301Link,Data.STATUS_CODE_301_LINK);
        System.out.println("Status code 300 link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scp.getClickHere().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //URL Validation for status code 404
        scp.getRedirectLink404().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String statusCode404link = driver.getCurrentUrl();
        System.out.println("Given"+statusCode404link);
        Assert.assertEquals(statusCode404link,Data.STATUS_CODE_404_LINK);
        System.out.println("status code 404 link is valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scp.getClickHere().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //URL Validation for status code 500
        scp.getRedirectLink500().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String statusCode500Link = driver.getCurrentUrl();
        System.out.println("Given"+statusCode500Link);
        Assert.assertEquals(statusCode500Link,Data.STATUS_CODE_500_LINK);
        System.out.println("status code 500 link is valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scp.getClickHere().click();
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
