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
    public void FormSample() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement textInput = driver.findElement(By.id("numb"));
        textInput.click();
        textInput.sendKeys("30");
        textInput.getText();

        WebElement Btn = driver.findElement(By.className("w3-btn"));
        Btn.click();
        WebElement text = driver.findElement(By.id("ch1_error"));
        Assert.assertTrue(text.getText().contains("Number is too small"));
    }

    @Test
    public void errorOnNumberTooBig() {
        WebElement textInput = driver.findElement(By.id("numb"));
        textInput.click();
        textInput.sendKeys("500");
        textInput.getText();

        WebElement Btn = driver.findElement(By.className("w3-btn"));
        Btn.click();
        WebElement text = driver.findElement(By.id("ch1_error"));
        Assert.assertTrue(text.getText().contains("Number is too big"));
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
        WebElement textInput = driver.findElement(By.id("numb"));
        textInput.click();
        textInput.sendKeys("81");
        textInput.getText();

        WebElement Btn = driver.findElement(By.className("w3-btn"));
        Btn.click();
//        WebElement text = driver.findElement(By.className("w3-input"));
//        Assert.assertTrue(text.getText().contains("Square root of 81 is 9.00"));
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Square root of 81 is 9.00", message);
        alert.accept();
    }
    @Test
    public void correctSquareRootWithRemainder() {
        WebElement textInput = driver.findElement(By.id("numb"));
        textInput.click();
        textInput.sendKeys("73");
        textInput.getText();

        WebElement Btn = driver.findElement(By.className("w3-btn"));
        Btn.click();
//        WebElement text = driver.findElement(By.className("w3-input"));
//        Assert.assertTrue(text.getText().contains("Square root of 81 is 9.00"));
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Square root of 73 is 8.54", message);
        alert.accept();
    }


    @After
    public void tearDown () throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
