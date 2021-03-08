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

public class Sample5 {

    public static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void testAlert() {
        WebElement toSumButton = driver.findElement(By.className("w3-red"));
        toSumButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
    }

    @Test
    public void testAlert2() {
        /*WebElement toSumButton = driver.findElement(By.className("w3-red"));
        toSumButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();*/
        WebElement clickToEnterBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterBtn.click();
       Alert alert2 = driver.switchTo().alert();
       alert2.sendKeys("25");
       alert2.accept();
    }
    @Test
    public void alertOnOpeningPage () {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String expectedText = "Booooooooo!";
        Assert.assertEquals(expectedText, alertText);

        alert.accept();

        WebElement h1 = driver.findElement(By.id("heading"));
        String alertText1 = h1.getText();
        String expectedText1 = "This page is alerted";
        Assert.assertEquals(expectedText1, alertText1);
    }

    @Test
    public void alertOnClickingButton()
    {
        WebElement redBtn = driver.findElement(By.className("w3-red"));
        redBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("I am an alert box!", message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(text.getText().isEmpty());
    }

    @Test
    public void popUpConfirm() {
        WebElement greenBtn = driver.findElement(By.className("w3-teal"));
        greenBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Press a button!", message);
        alert.accept();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("Why on earth have you agreed to it?!", text.getText());
    }
    @Test
    public void popUpDenied() {
        WebElement greenBtn = driver.findElement(By.className("w3-teal"));
        greenBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Press a button!", message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("You have dared to deny me!!!", text.getText());
    }

    @Test
    public void popUpEnterNumber() {
        WebElement yellowBtn = driver.findElement(By.className("w3-khaki"));
        yellowBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Please enter a number", message);
        alert.sendKeys("25");
        alert.accept();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(text.getText().contains("instead of 25"));
    }
}

