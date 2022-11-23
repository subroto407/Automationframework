package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.Dropdown;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDown extends BaseClass {
    @Test
    public void dropDown(){

        LandingPage lp = new LandingPage(driver);
        Dropdown dd = new Dropdown(driver);

        //Home Url Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given"+baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home Url Is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //DropDown Text Validation in Base Page
        if (lp.getDropDown().isDisplayed()){
            String dropDownText = lp.getDropDown().getText();
            Assert.assertTrue(true,dropDownText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        lp.getDropDown().click();

        //Corresponding Page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link,Data.BASE_URL+Data.DROP_DOWN_LINK);
        System.out.println("link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if (dd.getDropDownHeaderText().isDisplayed()){
            String dropDownHeaderText = dd.getDropDownHeaderText().getText();
            Assert.assertTrue(true,dropDownHeaderText);
            System.out.println("Header is Validate");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        dd.getDropDownListOption().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dd.getDropDownListOption1().click();


        //Drop Down Menu1 Text Validation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (dd.getDropDownListOption1().isDisplayed()){
            String dropDownListOption1Text = dd.getDropDownListOption1().getText();
            System.out.println("Selected :"+Data.DROP_DOWN_OPTION1_TEXT);
            Assert.assertEquals(dropDownListOption1Text,Data.DROP_DOWN_OPTION1_TEXT);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        dd.getDropDownListOption().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dd.getDropDownListOption2().click();

        //Drop Down Menu2 Text Validation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (dd.getDropDownListOption2().isDisplayed()){
            String dropDownList2Text = dd.getDropDownListOption2().getText();
            System.out.println("Selected :"+Data.DROP_DOWN_OPTION2_TEXT);
            Assert.assertEquals(dropDownList2Text,Data.DROP_DOWN_OPTION2_TEXT);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dd.getDropDownListOption().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back();

        //Creating Array
        String[] array={Data.DROP_DOWN_OPTION1_TEXT+Data.DROP_DOWN_OPTION2_TEXT};
        List<String> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("List of DropDown Element:"+list);
    }
}
