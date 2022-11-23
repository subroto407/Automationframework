package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.Disappering_Elements;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisappearingElements extends BaseClass{
    @Test
    public void disappearingElements() {

        LandingPage lp = new LandingPage(driver);
        Disappering_Elements de = new Disappering_Elements(driver);


        //Home URL Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given" + baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home Url is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (lp.getDisappearingElements().isDisplayed()) {
            String disappearingElementText = lp.getDisappearingElements().getText();
            Assert.assertTrue(true, disappearingElementText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        lp.getDisappearingElements().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Page Url Validation
        String disappearingElementBaseUrl = driver.getCurrentUrl();
        System.out.println(disappearingElementBaseUrl);
        Assert.assertEquals(disappearingElementBaseUrl, Data.BASE_URL + Data.DISAPPEARING_ELEMENTS);

        //Header Validation
        if (de.getDisappearingElementsHeaderText().isDisplayed()) {
            String disappearingElementHeaderText = de.getDisappearingElementsHeaderText().getText();
            System.out.println(disappearingElementHeaderText);
            Assert.assertTrue(true, disappearingElementHeaderText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Paragraph Validation
        if (de.getDisappearingElementsParagraphText().isDisplayed()) {
            String disappearingElementsParagraphText = de.getDisappearingElementsHeaderText().getText();
            Assert.assertTrue(true, disappearingElementsParagraphText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        de.getHomeTab().click();
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
        de.getAboutTab().click();
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
        de.getPortfolioTab().click();
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
        de.getContactUsTab().click();
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
