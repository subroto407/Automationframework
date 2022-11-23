package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.FileUploadCorrespondingPage;
import com.internet.herokuapp.pages.FileUploadPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload extends BaseClass{
    @Test
    public void fileUpload() throws AWTException {

        LandingPage lp = new LandingPage(driver);
        FileUploadPage fup = new FileUploadPage(driver);
        FileUploadCorrespondingPage fucp = new FileUploadCorrespondingPage(driver);

        //How "driver.get(Data.FILE_UPLOAD_URL)" Redirecting to #File_Upload Page?
        //driver.get(Data.FILE_UPLOAD_URL);

        //Corresponding Page Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+link);
        Assert.assertEquals(link,Data.FILE_UPLOAD_URL);
        System.out.println("Link is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lp.getFileUpload().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Validate file Name After The Upload
        fup.getChooseFileButton().sendKeys(Data.FILE_UPLOAD_PATH);
        fup.getUploadButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Header Validation
        if (fup.getFileUploadPageHeader1().isDisplayed()){
            String header = fup.getFileUploadPageHeader1().getText();
            Assert.assertEquals(header,Data.FILE_UPLOAD_CORRESPONDING_HEADER);
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
        driver.navigate().back();

        //Drag And Drop Upload
        WebElement inputField = driver.findElement((By.cssSelector("#drag-drop-upload")));
        inputField.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Robot robot = new Robot();
        //Using String Selection Class To Store the Path of the file
        StringSelection filePath = new StringSelection(Data.FILE_UPLOAD_PATH);

        //Copy the stored path from the string selection, Also Opening the System ClipBoard.
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);

        //Now Press CTRL
        robot.keyPress(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Now press V
        robot.keyPress(KeyEvent.VK_V);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //Now Release V
        robot.keyRelease(KeyEvent.VK_V);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Now Release CTRL
        robot.keyRelease(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Now press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File Uploaded Successfully");

        //Navigate Back To Url
        driver.navigate().to(Data.BASE_URL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
