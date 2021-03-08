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
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }
    @Test
    public void alertOnclickingButton(){
        WebElement btn = driver.findElement(By.className("w3-red"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("I am an alert box!",alert.getText());
        alert.accept();

        WebElement bodyText = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(bodyText.getText().isEmpty());

    }

    @Test
    public void popUpConform(){
        WebElement btn = driver.findElement(By.className("w3-red"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("I am an alert box!",alert.getText());
        alert.dismiss();

        WebElement bodyText = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(bodyText.getText().isEmpty());

    }

    @Test
    public void popUpDeny(){
        WebElement btn = driver.findElement(By.className("w3-teal"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Press a button!",alert.getText());
        alert.accept();

        WebElement bodyText = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("Why on earth have you agreed to it?!",bodyText.getText());

    }

    @Test
    public void popUpEnterNumber(){

        WebElement btn = driver.findElement(By.className("w3-khaki"));
        btn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Please enter a number",alert.getText());
        alert.sendKeys("44");
        alert.accept();

        WebElement bodyText = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(bodyText.getText().contains("instead of 44"));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
