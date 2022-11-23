package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.JavaScriptAlertsPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.annotations.Test;

public class JavaScriptAlert extends BaseClass{
    @Test
    public void javaScriptAlert(){

        LandingPage lp = new LandingPage(driver);
        JavaScriptAlertsPage jsap = new JavaScriptAlertsPage(driver);

        lp.getJavaScriptAlerts().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Alert for Text Validation
        jsap.getClickForJSAlert().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Accept Alert
        System.out.println(driver.switchTo().alert().getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Accept Alert
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.PrintIn("Click For JS Alert Button Alert Accepted");
        System.out.println("JSAlert Result Text : "+jsap.getResultText().getText());


        //JS Alert Text Validation
        jsap.getClickForJSConfirm().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Accept Alert
        System.out.println(driver.switchTo().alert().getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Accept Alert
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Click For JS Confirm Button Alert Accepted");
        System.out.println("JS ConfirmResult Text :"+ jsap.getResultText().getText());

        //JS Prompt Text Validation
        jsap.getClickForJSPrompt().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Accept Alert
        System.out.println(driver.switchTo().alert().getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Accept Alert
        driver.switchTo().alert().sendKeys("Hi everyone");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JS Prompt Result Text :"+ jsap.getResultText().getText());
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
