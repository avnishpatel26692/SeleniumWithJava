package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample7 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }
    @Test
    public void verifyFontSize(){
        WebElement para4 = driver.findElement(By.cssSelector("p.w3-deep-purple"));
        // font size
        System.out.println(para4.getCssValue("font-size"));

        // font family
        System.out.println(para4.getCssValue("font-family"));
        Assert.assertEquals("15px",para4.getCssValue("font-size"));
        System.out.println(para4.getCssValue("background-color"));
        Assert.assertEquals("rgba(103, 58, 183, 1)",para4.getCssValue("background-color"));
    }
    @Test
    public void verifyParagraph7(){
        WebElement para7 = driver.findElement(By.cssSelector("p.paragraph.lucky.w3-pink"));
        // font size - get & verify
        System.out.println(para7.getCssValue("font-size"));
        Assert.assertEquals("15px",para7.getCssValue("font-size"));
        // font family - get & verify
        System.out.println(para7.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif",para7.getCssValue("font-family"));
        // bckgr color - get & verify
        System.out.println(para7.getCssValue("background-color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)",para7.getCssValue("background-color"));

        System.out.println(para7.getCssValue("color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)",para7.getCssValue("background-color"));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}
