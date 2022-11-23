package com.internet.herokuapp.testCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotOfAnElement extends BaseClass{
    @Test
    public void screenShotOfAnElement() throws IOException {

        //Taking Specific web Element Screen Shoot
        WebElement ele = driver.findElement(By.cssSelector("body > div:nth-child(2) > a > img"));

        //Get entire Page Screenshot
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        //Get the location of element on the page
        Point point = ele.getLocation();

        //Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getWidth();

        //Corp The entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),eleWidth,eleHeight);
        ImageIO.write(eleScreenshot,"png",screenshot);

        //Copy the element Screenshot to disk
        File screenshotLocation = new File("C:\\Users\\eeeeeeeeeeeeeeeeeeee\\New folder\\Images.Screenshot1.png");
        FileUtils.copyFile(screenshot, screenshotLocation);


    }
}
