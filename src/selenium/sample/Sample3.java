package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample3 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1() throws Exception {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualValue = heading1.getText();
        String expectedValue = "Heading 1";
        Assert.assertEquals(expectedValue, actualValue);
        System.out.println("Test1");
    }

    @Test
    public void assertTrueExample(){
        String expectedValue = "This is a button";
        WebElement btn = driver.findElement(By.name("randomButton1"));
        String actualValue = btn.getAttribute("value");
        Assert.assertTrue(actualValue.contains(expectedValue));
        System.out.println("Test2");
    }
    @Test
    public void assertFalseExample(){
        String expectedValue = "This is a button4";
        WebElement btn = driver.findElement(By.name("randomButton1"));
        String actualValue = btn.getAttribute("value");
        Assert.assertFalse(actualValue.contains(expectedValue));
        System.out.println("not");
    }
    @Test
    public void assertEquals() {
        String expectedValue = "Heading 1";
        WebElement h1= driver.findElement(By.id("heading_1"));
        String actualValue = h1.getText();
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void test3(){
        System.out.println("Test3");
    }
}
