package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.ForgotPasswordPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPassword extends BaseClass{
    @Test
    public void forgotPassword(){

        LandingPage lp = new LandingPage(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);

        lp.getForgetPassword().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Corresponding Page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link, Data.BASE_URL+Data.FORGOT_PASSWORD_LINK);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation


        //Forgot Password

    }
}
