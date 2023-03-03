package com.testng.utility;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TestUtility {

    private int timeOut = Integer.parseInt(ReadFromFiles.readFromPropertiesFile("timeout"));

    private WebDriver driver;

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementPresent(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String generateFakerFirstName(){
        Faker faker=new Faker();
        return faker.name().firstName();
    }

    public String generateFakerLastName(){
        Faker faker=new Faker();
        return faker.name().lastName();
    }

    public String generateFakerMiddleName(){
        Faker faker=new Faker();
        return faker.name().nameWithMiddle();
    }

    public String generateFakerCompany(){
        Faker faker=new Faker();
        return faker.company().name();
    }

    public String generateFakerStreet(){
        Faker faker=new Faker();
        return faker.address().streetAddress();
    }

    public String generateFakerCity(){
        Faker faker=new Faker();
        return faker.address().cityName();
    }

    public String generateFakerZipCode(){
        Faker faker=new Faker();
        return faker.address().zipCode();
    }

    public String randomEmail(){
        String generateString= RandomStringUtils.randomAlphabetic(8);
        return generateString+"@gmail.com";
    }

    public String generatePhoneNumber(){
        Faker faker=new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public String generateCellPhoneNumber(){
        Faker faker=new Faker();
        return faker.phoneNumber().cellPhone();
    }

    public String generateTile(){
        Faker faker=new Faker();
        return faker.name().title();
    }

    public String generateProductName(){
        Faker faker=new Faker();
        return  faker.commerce().productName();
    }

    public String generateOneDigitNumber(){
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(9);
            if(rand !=0) break;
        }
       return String.valueOf(rand);
    }

    public String generateDescription(){
        return RandomStringUtils.randomAlphabetic(20);
    }

    public String  generatePrice(){
        DecimalFormat df2 = new DecimalFormat("0.0");
        double min = 180.00;
        double max = 2.10;
        double rand = new Random().nextDouble();
        String result = df2.format(min + (rand * (max - min))) + "0";
        return result;

    }

    public String generateCode(){
        return RandomStringUtils.randomAlphabetic(4)+ RandomStringUtils.randomNumeric(4);
    }

    public void  selectDropDownRandomly(WebElement element) {
        Select s = new Select(element);
        Random rand = new Random();
        List<WebElement> options = s.getOptions();
        for (int i = 0; i < options.size(); i++) {
            int list = rand.nextInt(options.size());
//            System.out.println(list);
            options.get(list).click();
        }
    }

    public void selectDroDownListByIndex(WebElement element){
        Select s=new Select(element);
        s.selectByIndex(2);
    }

}
