package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.LoginSignUp;
import com.internet.herokuapp.utilities.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAbleToClickOnCreateNewAccount extends BaseClass{
    @Test
    public void userAbleToClickOnCreateNewAccount(){

        LoginSignUp lisp = new LoginSignUp(driver);
        if (lisp.getCreateNewAccount().isDisplayed()){
            String createNewAccountText = lisp.getCreateNewAccount().getText();
            Assert.assertEquals(createNewAccountText,Data.CREATE_NEW_ACCOUNT);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        lisp.getCreateNewAccount().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
