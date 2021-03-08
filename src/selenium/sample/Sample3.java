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

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void assertEqualsExample () {

        WebElement heading1 = driver.findElement(By.id("Heading_1"));
        String expectedValue = "Heading 1";
        String assertedValue = heading1.getText();
        Assert.assertEquals(expectedValue,assertedValue);
    }

    @Test
    public void assertTrueExample () {
        WebElement button1 = driver.findElement(By.name("randomButton1"));
        String expectedValue = "This is a button";
        String assertedValue = button1.getAttribute("value");
        Assert.assertTrue(assertedValue.contains(expectedValue));
    }

    @Test
    public void assertFalseExample () {
        WebElement button = driver.findElement(By.id("buttonId"));
        String expectedValue = "This is a button";
        String assertedValue = button.getAttribute("value");
        Assert.assertFalse(assertedValue.contains(expectedValue));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}