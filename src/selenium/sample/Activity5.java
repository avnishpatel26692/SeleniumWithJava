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

public class Activity5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }
//alertOnOpeningPage - open “Alerted page”, catch alert, check the text of alert, accept alert, check heading of the page
    @Test
    public void alertOnOpeningPage(){
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement element = driver.findElement(By.id("heading"));
        System.out.println(element.getText());
        Assert.assertEquals("This page is alerted", element.getText());

    }
    //alertOnclickingButton - open “Alert and pop-ups”, click on element with className “w3-red”,
    // catch alert, check its text, accept it, check text of element with id “textForAlerts”
    @Test
    public void alertOnClickingButton(){
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement alertButton = driver.findElement(By.className("w3-red"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement textForAlerts = driver.findElement(By.id("textForAlerts"));
        System.out.println(textForAlerts.getText());
        Assert.assertEquals("", textForAlerts.getText());

    }
    //popUpConform - open “Alert and pop-ups”, click on element with className “w3-teal”,
    // catch alert, check its text, accept it, check text of element with id “textForAlerts”
    @Test
    public void popUpConfirm(){
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement alertButton = driver.findElement(By.className("w3-teal"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement textForAlerts = driver.findElement(By.id("textForAlerts"));
        System.out.println(textForAlerts.getText());
        Assert.assertEquals("Why on earth have you agreed to it?!", textForAlerts.getText());

    }
    //popUpDeny - open “Alert and pop-ups”, click on element with className “w3-teal”,
    // catch alert, check its text, deny it, check text of element with id “textForAlerts”
    @Test
    public void popUpDeny(){
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement alertButton = driver.findElement(By.className("w3-teal"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        WebElement textForAlerts = driver.findElement(By.id("textForAlerts"));
        System.out.println(textForAlerts.getText());
        Assert.assertEquals("You have dared to deny me!!!", textForAlerts.getText());

    }
    //5.popUpEnterNumber - open “Alert and pop-ups”, click on element with className “w3-khaki”, catch alert, check its text,
    // send a number as a String via sendKeys and accept alert, check text of element with id “textForAlerts”
    @Test
    public void popUpEnterNumber(){
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement alertButton = driver.findElement(By.className("w3-khaki"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("12");
        alert.accept();
        WebElement textForAlerts = driver.findElement(By.id("textForAlerts"));
        System.out.println(textForAlerts.getText());
        Assert.assertTrue(textForAlerts.getText().contains("instead of 12"));
    }
}
