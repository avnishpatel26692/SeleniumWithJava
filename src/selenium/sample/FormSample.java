package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormSample {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void numberTooSmall () {
        WebElement enterNum = driver.findElement(By.id("numb"));
        enterNum.sendKeys("10");
        driver.findElement(By.className("w3-btn")).click();

        WebElement getError = driver.findElement(By.id("ch1_error"));
        String text1 = getError.getText();
        Assert.assertEquals("Number is too small",text1);
    }

    @Test
    public void numberTooBig () {
        WebElement enterNum = driver.findElement(By.id("numb"));
        enterNum.sendKeys("101");
        driver.findElement(By.className("w3-btn")).click();

        WebElement getError = driver.findElement(By.id("ch1_error"));
        String text1 = getError.getText();
        Assert.assertEquals("Number is too big",text1);

    }

    @Test
    public void numberInRange () {
        WebElement enterNum = driver.findElement(By.id("numb"));
        enterNum.sendKeys("81");
        driver.findElement(By.className("w3-btn")).click();

        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        alertOnOpen.dismiss();
        Assert.assertEquals("Square root of 81 is 9.00",getText);

    }

    @Test
    public void numberInRange2() {
        WebElement enterNum = driver.findElement(By.id("numb"));
        enterNum.sendKeys("70");
        driver.findElement(By.className("w3-btn")).click();

        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        alertOnOpen.dismiss();
        Assert.assertEquals("Square root of 70 is 8.37",getText);

    }    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}





