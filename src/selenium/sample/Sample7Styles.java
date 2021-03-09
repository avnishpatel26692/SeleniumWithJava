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

public class Sample7Styles {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before

    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void verifyFontSize() {
        WebElement element = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        element.getCssValue("font-size");
        System.out.println(element.getCssValue("font-size"));
    }
    @Test
    public void verifyParagraph7(){
        WebElement element = driver.findElement(By.cssSelector("p.w3-pink"));
        Assert.assertEquals("15px", element.getCssValue("font-size"));
        Assert.assertEquals("Verdana, sans-serif", element.getCssValue("font-family"));
        Assert.assertEquals("rgba(255, 255, 255, 1)", element.getCssValue("color"));

    }
}
