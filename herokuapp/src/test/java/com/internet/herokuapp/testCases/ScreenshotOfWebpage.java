package com.internet.herokuapp.testCases;

import com.internet.herokuapp.utilities.Data;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotOfWebpage extends BaseClass{
    @Test
    public void screenshotOfWebpage() throws IOException {

        //Taking Screenshot full page
        driver.get(Data.BASE_URL+Data.HORIZONTAL_SLIDER_LINK);
        File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("C:\\Users\\eeeeeeeeeeeeeeeeeeee\\New folder\\Images.Screenshots3.png"));
    }
}
