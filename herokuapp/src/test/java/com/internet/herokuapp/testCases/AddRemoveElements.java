package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.Add_remove_elements;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddRemoveElements extends BaseClass{


    @Test
    public void addRemoveElements () {

        LandingPage lp = new LandingPage(driver);
        Add_remove_elements are = new Add_remove_elements(driver);

        //Home URL Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given" + baseLink);
        assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home URL is valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Header Validation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (lp.getAddRemoveElement().isDisplayed()) {
            String addRemoveElementsText = lp.getAddRemoveElement().getText();
            Assert.assertTrue(true,addRemoveElementsText);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        lp.getAddRemoveElement().click();

        //corresponding Page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given" + link);
        assertEquals(link, Data.BASE_URL + Data.ADD_REMOVE_ELEMENT_LINK);
        System.out.println("link is validate");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (are.getAddRemoveElementsHeader().isDisplayed()) {
            String AddRemoveHeader = are.getAddRemoveElementsHeader().getText();
            Assert.assertTrue(true, AddRemoveHeader);
        } else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        are.getAddRemoveElementsHeader().click();
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
