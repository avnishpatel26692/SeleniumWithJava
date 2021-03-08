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

public class sample3 {
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
    public void assertEqualsExample() throws Exception {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualValue = heading1.getText();
        String expectedValue = "Heading 1";
        Assert.assertEquals("This should fail", expectedValue, actualValue);
    }

    @Test
    public void assertTrueExample(){
        String expectedValue = "This is a button";
        WebElement btn = driver.findElement(By.name("randomButton1"));
        String actualValue = btn.getAttribute("value");
        Assert.assertTrue(actualValue.contains(expectedValue));
    }

    @Test
    public void assertFalseExample(){
        String expectedValue = "This is a button2";
        WebElement btn = driver.findElement(By.name("randomButton1"));
        String actualValue = btn.getAttribute("value");
        Assert.assertFalse(actualValue.contains(expectedValue));
    }

    @Test
    public void fail(){
        Assert.fail();
    }
    @Test
    public void failWithMessage(){
        Assert.fail("This test should fail");
    }

    @Test
    public void assertEquals(){
        String ev = "Heading 1";
        WebElement h1= driver.findElement(By.id("heading_1"));
        String av = h1.getText();
        Assert.assertEquals(ev,av);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}