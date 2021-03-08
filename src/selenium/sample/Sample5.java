package selenium.sample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Sample5 extends Sample{

    @Override
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocationMac + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("https://kristinek.github.io/site/examples/alerted_page");

        Alert alert = driver.switchTo().alert();
        assertEquals("Booooooooo!", alert.getText());
        alert.accept();
        assertEquals("This page is alerted", driver.findElement(By.id("heading")).getText());
    }

    @Test
    public void test2(){
        driver.get(URL_ALERTS);

        WebElement element = driver.findElement(By.className("w3-red"));
        element.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("I am an alert box!", alert.getText());
        alert.accept();
        assertEquals("", driver.findElement(By.id("textForAlerts")).getText());
    }

    @Test
    public void test3(){
        driver.get(URL_ALERTS);

        driver.findElement(By.className("w3-teal")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Press a button!", alert.getText());
        alert.accept();
        assertEquals("Why on earth have you agreed to it?!", driver.findElement(By.id("textForAlerts")).getText());
    }

    @Test
    public void test4(){
        driver.get(URL_ALERTS);

        driver.findElement(By.className("w3-teal")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Press a button!", alert.getText());
        alert.dismiss();
        assertEquals("You have dared to deny me!!!", driver.findElement(By.id("textForAlerts")).getText());
    }

    @Test
    public void test5(){
        driver.get(URL_ALERTS);

        driver.findElement(By.className("w3-khaki")).click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Please enter a number", alert.getText());
        alert.sendKeys("0.05549501144970015");
        alert.accept();
        
    }

}
