package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.pages.NotificationMassagesPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessage extends BaseClass{
    @Test
    public void notificationMessage(){

        LandingPage lp = new LandingPage(driver);
        NotificationMassagesPage nmp = new NotificationMassagesPage(driver);

        lp.getNotificationMessages().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding Page URL Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.NOTIFICATION_MASSAGE_LINK);
        System.out.println("Link is Valid");

        nmp.getClickHere().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //flash alert test validation Page Url
        String flashAlert1 = nmp.getFlashAlert().getText();
        System.out.println(flashAlert1);
        Assert.assertEquals(flashAlert1,"Action successful");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        nmp.getClickHere().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        String flashAlert2 = nmp.getFlashAlert().getText();
        System.out.println(flashAlert2);
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
