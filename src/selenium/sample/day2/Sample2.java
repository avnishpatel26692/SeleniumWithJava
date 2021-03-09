package selenium.sample.day2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();}

    @Test
    public void verifyStyle(){
        WebElement el = driver.findElement(By.cssSelector("p.w3-pink"));
        System.out.println(el.getCssValue("font-size"));
        Assert.assertEquals("15px",el.getCssValue("font-size"));

        System.out.println(el.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif", el.getCssValue("font-family"));

        System.out.println(el.getCssValue("color"));
        Assert.assertEquals("rgba(255, 255, 255, 1)",el.getCssValue("color") );

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
