package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.CheckBoxesPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes extends BaseClass{
    @Test
    public void checkboxes (){
        LandingPage lp = new LandingPage(driver);
        CheckBoxesPage cbp = new CheckBoxesPage(driver);

        //Home Url Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given"+baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home URL Is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if (lp.getCheckBoxes().isDisplayed()){
            String checkBoxText = lp.getCheckBoxes().getText();
            Assert.assertTrue(true,checkBoxText);
        }
        lp.getCheckBoxes().click();

        //checkbox 2 selection and checkbox text validation
        if (cbp.getCheckbox2().isDisplayed()){
            System.out.println(Data.POSITIVE_MASSAGE+Data.CHECK_BOX2_SELECTED);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //checkbox 1 selected and checkbox text validation
        if (cbp.getCheckBox1().isDisplayed()){
            System.out.println(Data.POSITIVE_MASSAGE+Data.CHECK_BOX1_SELECTED);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Url validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link,Data.BASE_URL+Data.CHECK_BOX_LINK);
        System.out.println("link is valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        cbp.getCheckbox2().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cbp.getCheckBox1().click();
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
