package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.InputsPages;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Input extends BaseClass{
    @Test
    public void input(){

        LandingPage lp = new LandingPage(driver);
        InputsPages ip = new InputsPages(driver);

        lp.getInputs().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding Page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.INPUTS_LINK);
        System.out.println("Link is Valid");

        //Entering Values
        ip.getInputField().sendKeys("123456789321654987");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ip.getInputField().clear();
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
