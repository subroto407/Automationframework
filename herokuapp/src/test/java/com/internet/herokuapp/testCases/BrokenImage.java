package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.BrokenImagePage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImage extends BaseClass{
    @Test
    public void brokenImage(){

        LandingPage lp = new LandingPage(driver);
        BrokenImagePage bip = new BrokenImagePage(driver);

        lp.getBrokenImages().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.BROKEN_IMAGE_LINK);
        System.out.println("Link Is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if (bip.getHeader1().isDisplayed()){
            String header1 = bip.getHeader1().getText();
            Assert.assertEquals(header1,Data.BROKEN_IMAGE_HEADER);
            System.out.println("Header Text Is Valid");
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Broken Image Validation Including(http Response,Broken Image Link)
        List<WebElement> elementList = driver.findElements(By.tagName("img"));

        for (int i=0; i < elementList.size();i++){
            Response response = RestAssured.given().contentType("application/json")
                    .get(elementList.get(i).getAttribute("src"));
            System.out.println("HTTP Response Is:"+ response.getStatusCode());

            if (elementList.get(i).getAttribute("naturalWidth").equals("0")){
                System.out.println(elementList.get(i).getAttribute("src")+"Is Broken.");
            }
            else {
                System.out.println(elementList.get(i).getAttribute("src")+"Is Not Broken");
            }
        }

        driver.navigate().to(Data.BASE_URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
