package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.FormAuthPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuth extends BaseClass{
    @Test
    public void formAuth(){

        LandingPage lp = new LandingPage(driver);
        FormAuthPage fap = new FormAuthPage(driver);

        lp.getFormAuthentication().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Home URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.FORM_AUTHENTICATION_LINK);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header1 Validation
        if (fap.getFormAuthenticationHeader1().isDisplayed()){
            String header1 = fap.getFormAuthenticationHeader1().getText();
            Assert.assertEquals(header1,Data.FORM_AUTHENTICATION_HEADER1);
            System.out.println("Header1 Text is Valid");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Header2 Validation
        if (fap.getFormAuthenticationHeader2().isDisplayed()){
            String header2 = fap.getFormAuthenticationHeader2().getText();
            Assert.assertEquals(header2,Data.FORM_AUTHENTICATION_HEADER2);
            System.out.println("Header2 Text Is Valid");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Sending Values
        fap.getUsernameField().sendKeys(Data.FORM_AUTHENTICATION_USER_NAME);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fap.getPasswordInputField().sendKeys(Data.FORM_AUTHENTICATION_PASSWORD);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fap.getLoginButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Alert Taxt Validation
        String text = fap.getAlert().getText();
        System.out.println(text);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Assert.assertEquals(text,Data.FORM_AUTHENTICATION_ALERT_TEXT);
        driver.navigate().to(Data.BASE_URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
