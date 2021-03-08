package selenium.sample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sample6 extends Sample{
    @Override
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocationMac + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

        WebElement numb = driver.findElement(By.id("numb"));
        numb.sendKeys("24");
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void test2(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

        WebElement numb = driver.findElement(By.id("numb"));
        numb.sendKeys("224");
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void test3(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

        WebElement numb = driver.findElement(By.id("numb"));
        numb.sendKeys("64");
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
        alert.accept();
        assertTrue(driver.findElement(By.id("ch1_error")).getText().isEmpty());
    }

    @Test
    public void test4(){
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

        WebElement numb = driver.findElement(By.id("numb"));
        numb.sendKeys("66.33");
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();


        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 66.33 is 8.14", alert.getText());
        alert.accept();
        assertTrue(driver.findElement(By.id("ch1_error")).getText().isEmpty());
    }
}
