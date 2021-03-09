package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample7 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/locators_different");

    }
    @Test
    public void verifyParagraph7() {
        WebElement elem1 = driver.findElement(By.cssSelector("p.w3-pink"));

        //font-size
        System.out.println(elem1.getCssValue("font-size"));
        Assert.assertEquals("15px",elem1.getCssValue("font-size"));
        //font-family
        System.out.println(elem1.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif",elem1.getCssValue("font-family"));
        //background-color
        System.out.println(elem1.getCssValue("background-color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)",elem1.getCssValue("background-color"));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
