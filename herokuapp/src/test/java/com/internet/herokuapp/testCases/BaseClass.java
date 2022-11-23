package com.internet.herokuapp.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static void main (String[] args) {}

        public WebDriver driver;

        @BeforeClass
        public void beforeclass () {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @BeforeMethod
        public void beforemethod () {
            driver.navigate().to("https://the-internet.herokuapp.com/");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        @AfterMethod
        public void aftermethod () {
            System.out.println("test run properly");
        }
        @AfterClass
        public void afterclass () {
            driver.quit();
        }
}
