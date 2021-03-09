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


    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement inputArea = driver.findElement(By.id("numb"));
        inputArea.click();
        inputArea.sendKeys("35");
        WebElement orangebtn = driver.findElement(By.className("w3-orange"));
        orangebtn.click();
        WebElement error = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too small", error.getText());

    }
    @Test
    public void errorOnNumberTooBig()
    {
        WebElement inputArea = driver.findElement(By.id("numb"));
        inputArea.click();
        inputArea.sendKeys("120");
        WebElement orangebtn = driver.findElement(By.className("w3-orange"));
        orangebtn.click();
        WebElement error = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too big", error.getText());

    }

@Test
    public void correctSquareRootWithoutRemainder()
    {
        WebElement inputArea = driver.findElement(By.id("numb"));
        inputArea.click();
        inputArea.sendKeys("81");
        WebElement orangebtn = driver.findElement(By.className("w3-orange"));
        orangebtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Square root of 81 is 9.00", message);
        alert.dismiss();

    }

    @Test
    public void correctSquareRootWithRemainder()
    {
        WebElement inputArea = driver.findElement(By.id("numb"));
        inputArea.click();
        inputArea.sendKeys("60");
        WebElement orangebtn = driver.findElement(By.className("w3-orange"));
        orangebtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Square root of 60 is 7.75", message);
        alert.dismiss();

    }



        @After
        public void tearDown () throws Exception {
         Thread.sleep(1500);

            //Close browser
            driver.quit();
        }
    }