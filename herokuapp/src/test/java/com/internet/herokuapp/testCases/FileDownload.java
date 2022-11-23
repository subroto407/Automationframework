package com.internet.herokuapp.testCases;

import com.internet.herokuapp.pages.FileDownloadPage;
import com.internet.herokuapp.pages.LandingPage;
import com.internet.herokuapp.utilities.Data;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileDownload extends BaseClass{
    @Test
    public void fileDownload() throws AWTException {
        LandingPage lp = new LandingPage(driver);
        FileDownloadPage fdp = new FileDownloadPage(driver);

        lp.getFileDownload().click();

        //home Url Validation
        String link = driver.getCurrentUrl();
        System.out.println("Given"+ Data.BASE_URL+Data.DOWNLOAD_LINK);
        System.out.println("Home Url is Valid");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fdp.getTextFileDownload().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //File Download Validation
        Robot robot = new Robot();

        //Now Press CTRL
        robot.keyPress(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Now Press J
        robot.keyPress(KeyEvent.VK_J);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Now Release
        robot.keyRelease(KeyEvent.VK_J);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Now Release J
        robot.keyRelease(KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        File filePath = new File(Data.DOWNLOAD_FILE_PATH);
        File[] totalFiles = filePath.listFiles();
        for (File file:totalFiles){
            if(file.getName().equals("Maven project.txt")){
                String fileName = fdp.getTextFileDownload().getText();
                System.out.println(fileName+"File Is DownLoaded");
                break;
            }
        }
    }
}
