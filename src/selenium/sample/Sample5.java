package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

public class Sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }

    @Test
    public void Test5() {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        Alert alert1 = driver.switchTo().alert();
        String message = alert1.getText();
        Assert .assertEquals("Booooooooo!", message);
        alert1.dismiss();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("",text);
    }
    @Test
    public void Test56() {
        WebElement red = driver.findElement(By.className("w3-red"));
        red.click();
        Alert alert1 = driver.switchTo().alert();
        String message1 = alert1.getText();
        Assert.assertEquals("I am an alert box!", message1);
        alert1.accept();
        WebElement newText = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("", newText);
    }
    @Test
    public void popUpConfirm(){
        WebElement newElement = driver.findElement(By.className("w3-teal"));
        newElement.click();
        Alert alert2 = driver.switchTo().alert();
        String message2 = alert2.getText();
        alert2.accept();
        WebElement checkText = driver.findElement(By.id("textForElert"));
        Assert.assertEquals("", checkText);
    }
    @Test
    public void popUpDeny(){
        WebElement newElement1 = driver.findElement(By.className("w3-teal"));
        newElement1.click();
        Alert alert3 = driver.switchTo().alert();
        String message2 = alert3.getText();
        Assert.assertEquals("Please enter a number",message2);
        alert3.dismiss();
        WebElement checkText = driver.findElement(By.id("textForElert"));
        Assert.assertEquals("", checkText);
    }
    @Test
    public void popUpEnterNumber(){

        WebElement newElement2 = driver.findElement(By.className("w3-khaki"));
        newElement2.click();
        Alert alert4 = driver.switchTo().alert();
        String message3 = alert4.getText();
        Assert.assertEquals("Please enter a number",message3);
        newElement2.sendKeys("eight");
        alert4.accept();
        WebElement textCheck = driver.findElement(By.id("textForAlerts"));
        String textEnteredOrNot = textCheck.getText();
        Assert.assertEquals("",textEnteredOrNot);

    }
}