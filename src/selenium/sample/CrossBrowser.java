package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrossBrowser {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        //running in Chrome
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver();

//        //running in Firefox
//        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
//        driver = new FirefoxDriver();
//
//        //running in IE browser
//        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
//        driver = new InternetExplorerDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }


    @Test
    public void verifyTask2() {
        WebElement para3 = driver.findElement(By.cssSelector("p.w3-pink"));
        //font-size
        System.out.println(para3.getCssValue("font-size"));
        Assert.assertEquals("15px", para3.getCssValue("font-size"));
        //font family
        System.out.println(para3.getCssValue("font-family"));
        Assert.assertEquals("Verdana, sans-serif", para3.getCssValue("font-family"));
        //background-color
        System.out.println(para3.getCssValue("background-color"));
        Assert.assertEquals("rgba(233, 30, 99, 1)", para3.getCssValue("background-color"));
    }

    @Test
    public void browserFunctionality() throws Exception {
        Thread.sleep(2500);
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().setSize(new Dimension(800,600));
        Thread.sleep(2500);

        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        Thread.sleep(2500);

        driver.navigate().back(); // to actions page
        Thread.sleep(2500);

        driver.navigate().forward(); // to locators page
        Thread.sleep(2500);

    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
