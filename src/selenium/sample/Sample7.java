package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample7{

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void getTextFontSize(){
        WebElement txtSize = driver.findElement(By.cssSelector("#nonStandartParagraph>p.paragraph.lucky.w3-pink"));
        String size=txtSize.getCssValue("font-size");
        String font=txtSize.getCssValue("font-family");
        String color=txtSize.getCssValue("color");
        System.out.println("Color is "+color+" Font-size "+size+" Font-family "+font);
        Assert.assertEquals("15px",size);
        Assert.assertEquals("Verdana, sans-serif",font);
        Assert.assertEquals("rgba(255, 255, 255, 1)",color);
    }

    @Test
    public void browserFunctionality() throws Exception
    {
        Thread.sleep(2500);
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().setSize(new Dimension(800, 600));
        Thread.sleep(2500);

        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        Thread.sleep(2500);

        driver.navigate().back();
        Thread.sleep(2500);

        driver.navigate().forward();
        Thread.sleep(2500);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}