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
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void assetEquals() {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualVal = heading1.getText();
        String expectedVal = "Heading 1";
        Assert.assertEquals(expectedVal, actualVal);
    }

    @Test
    public void assertTrue() {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualVal = heading1.getText();
        String expectedVal = "Heading 1";
        Assert.assertTrue(expectedVal.equalsIgnoreCase(actualVal));
    }

    @Test
    public void assertFalse() {
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualVal = heading1.getText();
        String expectedVal = "Heading 2";
        Assert.assertFalse(expectedVal.equalsIgnoreCase(actualVal));
    }

        @Test
        public void failedTest1() {
            Assert.fail("This test should fail!");
        }

        @After
        public void tearDown() throws Exception {
            Thread.sleep(2000);

            //Close browser
            driver.quit();
        }

}
