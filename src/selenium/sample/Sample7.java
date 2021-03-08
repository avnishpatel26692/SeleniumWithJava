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

public class Sample7 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void errorOnNumberTooSmall(){
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.sendKeys("23");
        WebElement btn = driver.findElement(By.className("w3-btn"));
        btn.click();
        WebElement errorOut = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too small",errorOut.getText());
    }
    @Test
    public void errorOnNumberTooBig(){
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.sendKeys("111");
        WebElement btn = driver.findElement(By.className("w3-btn"));
        btn.click();
        WebElement errorOut = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too big",errorOut.getText());

    }
    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.sendKeys("81");
        WebElement btn = driver.findElement(By.className("w3-btn"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        //Assert.assertFalse(alert.getText().contains("00"));
        Assert.assertTrue(alert.getText().contains("Square root of 81 is 9.00"));
        alert.accept();
    }
    @Test
    public void correctSquareRootWithRemainder(){
        WebElement textBox = driver.findElement(By.id("numb"));
        textBox.sendKeys("71");
        WebElement btn = driver.findElement(By.className("w3-btn"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertFalse(alert.getText().contains("00"));
        alert.accept();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
