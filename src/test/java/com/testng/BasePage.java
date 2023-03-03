package com.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

public class BasePage {
    public static WebDriver driver;

    public static void setUpBrowser(String url) {
        String systemName = System.getProperty("os.name");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriverManager.chromedriver().setup();
        if (systemName.contains("Mac")) {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
        } else if (systemName.contains("windows")) {
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
        } else {
            chromeOptions.addArguments(Arrays.asList("--headless", "--dosan-gpu"));
            chromeOptions.addArguments("window-size=1920,1080");
            driver = new ChromeDriver(chromeOptions);
            driver.manage().deleteAllCookies();
            driver.get(url);
        }
        System.out.println("Browser has been setup");
    }

    public static void teardown() {
        driver.close();
        driver.quit();
        System.out.println("Driver closed and quit");
    }
}

