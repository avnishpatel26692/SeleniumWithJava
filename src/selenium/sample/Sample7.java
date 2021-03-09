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

public class Sample7 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void verifyFontSize() {
        WebElement para4 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        //font size
        System.out.println(para4.getCssValue("font-ize"));
        Assert.assertEquals("15px", para4.getCssValue("font-size"));

        //font family
        System.out.println(para4.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif", para4.getCssValue("font-family"));

        //background-color
        System.out.println(para4.getCssValue("background-color"));
        Assert.assertEquals("rgba(103, 58, 183, 1)", para4.getCssValue("background-color"));

        //color
        System.out.println(para4.getCssValue("color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)", para4.getCssValue("color"));
    }

    @Test
    public void browserFunctionality() throws InterruptedException {
        Thread.sleep(2500);
        driver.get("https://kristinek.github.io/site/examples/actions");
        Thread.sleep(2500);

        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        Thread.sleep(2500);

        driver.navigate().back();
        Thread.sleep(2500);

        driver.navigate().forward();
        Thread.sleep(2500);

    }
}
