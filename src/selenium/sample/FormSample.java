package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SubmitElement;

import java.util.concurrent.TimeUnit;

public class FormSample {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }
    private void alert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void errorOnNumberTooSmall () {
        WebElement enterNumber = driver.findElement(By.id("numb"));
        enterNumber.sendKeys("12");
        driver.findElement(By.className("w3-btn")).click();

        WebElement getError = driver.findElement(By.id("ch1_error"));
        String text1 = getError.getText();
        Assert.assertEquals("Number is too small", text1);
    }

    @Test
    public void errorOnNumberTooBig () {
        WebElement enterNumber = driver.findElement(By.id("numb"));
        enterNumber.sendKeys("108");
        driver.findElement(By.className("w3-btn")).click();

        WebElement getError = driver.findElement(By.id("ch1_error"));
        String text2 = getError.getText();
        Assert.assertEquals("Number is too big", text2);

    }

    @Test
    public void squareRootWithoutRemainder () {
        WebElement enterNum = driver.findElement(By.id("numb"));
        enterNum.sendKeys("64");
        driver.findElement(By.className("w3-btn")).click();

        Alert alertOpen = driver.switchTo().alert();
        String getText = alertOpen.getText();
        alertOpen.accept();
        Assert.assertEquals("Square root of 64 is 8.00", getText);

    }

    @Test
    public void nsquareRootWithRemainder() {
        WebElement enterNum = driver.findElement(By.id("numb"));
        enterNum.sendKeys("70");
        driver.findElement(By.className("w3-btn")).click();

        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        alertOnOpen.dismiss();
        Assert.assertEquals("Square root of 61 is 7.81",getText);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}