package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.ContextMenuPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends BaseClass{
    @Test
    public void contextMenu(){

        //Reference Variable And Creating Object
        LandingPage lp = new LandingPage(driver);
        ContextMenuPage cmp = new ContextMenuPage(driver);

        //Home Url Validation
        String baseLink = driver.getCurrentUrl();
        System.out.println("Given"+baseLink);
        Assert.assertEquals(baseLink, Data.BASE_URL);
        System.out.println("Home URL is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Context Menu Text Validation In Base Page
        if (lp.getContextMenu().isDisplayed()){
            String contextMenuText = lp.getContextMenu().getText();
            Assert.assertTrue(true,contextMenuText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }
        lp.getContextMenu().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if (cmp.ContextMenuHeader.isSelected()){
            String contextMenuHeaderText = cmp.getContextMenuHeader().getText();
            Assert.assertTrue(true,contextMenuHeaderText);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //paragraph1 validation
        if(cmp.ContextMenuParagraph1.isDisplayed()){
            String contextMenuParagraph1Text = cmp.getContextMenuParagraph1().getText();
            Assert.assertTrue(true,contextMenuParagraph1Text);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Paragraph2 Validation
        if (cmp.ContextMenuParagraph2.isSelected()){
            String contextMenuParagraph2Text = cmp.getContextMenuParagraph2().getText();
            Assert.assertTrue(true,contextMenuParagraph2Text);
        }
        else {
            System.out.println(Data.NEGATIVE_ERROR_MASSAGE);
        }

        //Right Click
        Actions actions = new Actions(driver);
        actions.contextClick(cmp.getBox()).perform();

        //Accept Alert
        System.out.println(driver.switchTo().alert().getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Accept Alert
        driver.switchTo().alert().accept();
        System.out.println("Alert Accepted");
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
