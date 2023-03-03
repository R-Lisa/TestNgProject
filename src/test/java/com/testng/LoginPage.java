package com.testng;

import com.testng.utility.ReadFromFiles;
import com.testng.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    TestUtility testUtility;

    @FindBy(id="username")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login")
    WebElement loginButton;

    static String userName= ReadFromFiles.readFromPropertiesFile("username");
    static String password=ReadFromFiles.readFromPropertiesFile("password");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        testUtility =new TestUtility(driver);
    }

    public void login(){
        testUtility.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);

        testUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);

        testUtility.waitForElementPresent(loginButton);
        loginButton.click();
    }
}
