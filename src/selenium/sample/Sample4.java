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

public class Sample4 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void clickButtonAndSeeOrHideText() throws Exception {
        WebElement showButton = driver.findElement(By.id("show_me"));
        WebElement showText = driver.findElement(By.id("show_text"));
        WebElement hideButton = driver.findElement(By.id("hide_text"));

        String value = "";
        Assert.assertFalse( hideButton.isEnabled());

    }

    @Test
    public void test2() {
        String expectedValue = "Heading 1";
        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualValue = heading1.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }
}

