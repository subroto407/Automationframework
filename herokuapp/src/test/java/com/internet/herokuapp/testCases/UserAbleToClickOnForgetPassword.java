package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.ForgotPasswordPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.pages.LoginSignUp;
import org.testng.annotations.Test;

public class UserAbleToClickOnForgetPassword extends BaseClass{
    @Test
    public void userAbleToClickOnForgetPassword(){

        LoginSignUp lisu = new LoginSignUp(driver);
        ForgotPasswordPage fpp = new ForgotPasswordPage(driver);

        lisu.forgetPassword.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
