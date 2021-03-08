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

public class Activity6 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement numField = driver.findElement(By.id("numb"));
        numField.sendKeys("40");
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too small", errorMessage.getText());
    }

    //.errorOnNumberTooBig
    //TODO: enter number which is too big, check that correct error is seen
    @Test
    public void errorOnNumberTooBig() {
            WebElement numField = driver.findElement(By.id("numb"));
            numField.sendKeys("102");
            WebElement submitButton = driver.findElement(By.tagName("button"));
            submitButton.click();
            WebElement errorMessage = driver.findElement(By.id("ch1_error"));
            Assert.assertEquals("Number is too big", errorMessage.getText());
        }



    //correctSquareRootWithoutRemainder
    //TODO: enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder,
    // e.g. 2 is square root of 4),
    // then and press submit and check that correct no error is seen and check that square root is calculated correctly
    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement numField = driver.findElement(By.id("numb"));
        numField.sendKeys("64");
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("8.00"));
        alert.accept();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        Assert.assertFalse(errorMessage.isDisplayed());
    }

    //correctSquareRootWithRemainder
    //TODO: enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder,
    // e.g. 1.732.. is square root of 3) and press submit, then check that correct no error is seen and
    // check that square root is calculated correctly
    @Test
    public void correctSquareRootWithRemainder() {
        WebElement numField = driver.findElement(By.id("numb"));
        numField.sendKeys("60");
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("7.75"));
        alert.accept();
        WebElement errorMessage = driver.findElement(By.id("ch1_error"));
        Assert.assertFalse(errorMessage.isDisplayed());

    }
}
