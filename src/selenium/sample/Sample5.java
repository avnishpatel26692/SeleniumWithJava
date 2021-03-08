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
    public void alertOnOpeningPage()
    {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Booooooooo!",message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("heading"));
        Assert.assertEquals("This page is alerted", text.getText());
    }

    @Test
    public void alertOnclickingButton()
    {
        WebElement redBtn = driver.findElement(By.className("w3-red"));
        redBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("I am an alert box!", message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("", text.getText());
    }

    @Test
    public void popUpConfirm()
    {
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
    public void popUpDenied()
    {
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
    public void popUpEnterNumber()
    {
        WebElement yellowBtn = driver.findElement(By.className("w3-khaki"));
        yellowBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Please enter a number", message);
        alert.sendKeys("26");
        alert.accept();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(text.getText().contains("instead of 26"));
    }




    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}

