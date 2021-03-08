package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample6{
    static String libWithDriversLocation = System.getProperty ("user.dir") +"/lib/";

    WebDriver driver;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void errorNumberTooSmall() throws Exception {
        WebElement expectedValue = driver.findElement(By.id("numb"));
        expectedValue.sendKeys("3");
        WebElement button = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
        button.click();
        String expectedText = "Number is too small";
        String actualText = button.getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void errorNumberTooBig() throws Exception {
        WebElement entryField2 = driver.findElement(By.id("numb"));
        entryField2.sendKeys("101");
        WebElement button2 = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
        button2.click();
        String expectedText1 = "Number is too big";
        String actualText = entryField2.getText();
        Assert.assertEquals(expectedText1, actualText);
    }
    @Test
    public void SquareRootWithoutRemainder() throws Exception {
        WebElement entryField3 = driver.findElement(By.id("numb"));
        entryField3.sendKeys("64");
        WebElement button3 = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
        button3.click();
        String expectedText2 = "";
        String actualText = entryField3.getText();
        Assert.assertEquals(expectedText2, actualText);

    }
    @Test
    public void SquareeRootWithRemainder() throws Exception {
        WebElement entryField4 = driver.findElement(By.id("numb"));
        entryField4.sendKeys("65");
        WebElement button4 = driver.findElement(By.className("w3-btn w3-orange w3-margin"));
        button4.click();
        String expectedText3 = "";
        String actualText1 = entryField4.getText();
        Assert.assertEquals(expectedText3, actualText1);


    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}