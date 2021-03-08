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

public class Sample6 {
    String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement field = driver.findElement(By.id("numb"));
        field.sendKeys("1");
        WebElement orangeButton = driver.findElement(By.className("w3-orange"));
        orangeButton.click();
        WebElement errorElement = driver.findElement(By.id("ch1_error"));
        String actualText = errorElement.getText();
        Assert.assertEquals("Number is too small", actualText);
    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement field = driver.findElement(By.id("numb"));
        field.sendKeys("125");
        WebElement orangeButton = driver.findElement(By.className("w3-orange"));
        orangeButton.click();
        WebElement errorElement = driver.findElement(By.id("ch1_error"));
        String actualText = errorElement.getText();
        Assert.assertEquals("Number is too big", actualText);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement field = driver.findElement(By.id("numb"));
        field.sendKeys("64");
        WebElement orangeButton = driver.findElement(By.className("w3-orange"));
        orangeButton.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        Assert.assertEquals("Square root of 64 is 8.00", message);
    }

    @Test
    public void correctSquareRootWithRemainder() {
        WebElement field = driver.findElement(By.id("numb"));
        field.sendKeys("65");
        WebElement orangeButton = driver.findElement(By.className("w3-orange"));
        orangeButton.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        Assert.assertEquals("Square root of 65 is 8.06", message);
    }
}
