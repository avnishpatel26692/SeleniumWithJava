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

import java.util.concurrent.TimeUnit;

public class Sample5 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Test
    public void alertOnOpening() {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Booooooooo!", message);
        alert.accept();
        WebElement text = driver.findElement(By.id("heading"));
        Assert.assertEquals("This page is alerted", text.getText());
    }

    @Test
    public void alertOnclickingButton() {
        WebElement alertSummoningBtn = driver.findElement(By.className("w3-red"));
        alertSummoningBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("", text.getText());
    }

    @Test
    public void popUpConform() {
        WebElement clickToEnterNumber = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumber.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("12");
        alert1.accept();
        WebElement confirmationText = driver.findElement(By.id("textForAlerts"));
        System.out.println(confirmationText.getText());
    }

    @Test
    public void popUpDeny() {
        WebElement confOrDenial = driver.findElement(By.className("w3-teal"));
        confOrDenial.click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.accept();
        WebElement confirmationText = driver.findElement(By.id("textForAlerts"));
        System.out.println(confirmationText.getText());

        WebElement confOrDenial1 = driver.findElement(By.className("w3-teal"));
        confOrDenial1.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.dismiss();
        WebElement dismissText = driver.findElement(By.id("textForAlerts"));
        System.out.println(dismissText.getText());
    }

    @Test
    public void popEnterNumber() {
        WebElement clickToEnterNumber = driver.findElement(By.className("w3-khaki"));
        clickToEnterNumber.click();
        Alert alert4 = driver.switchTo().alert();
        System.out.println(alert4.getText());

        alert4.sendKeys("10");
        alert4.accept();
        WebElement confirmationText = driver.findElement(By.id("textForAlerts"));
        System.out.println(confirmationText.getText());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}