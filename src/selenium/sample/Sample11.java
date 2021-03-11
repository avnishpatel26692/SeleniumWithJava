package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.AgePage;
import selenium.page.AgeSubmitted;

import java.util.concurrent.TimeUnit;

public class Sample11{
    static String libWithDriversLocation = System.getProperty ("user.dir") +"/lib/";
    static WebDriver driver;
    static AgePage agePO = PageFactory.initElements(driver,AgePage.class);
    static AgeSubmitted ageSubmitPO = PageFactory.initElements(driver,AgeSubmitted.class);


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
// enter name , Age and click subbmit and validate message
    @Test
    public void scenario1 () {
        agePO.enterName("ABC");
        agePO.enterAge("25");
        agePO.clickOnSubmitBtn();
        System.out.println(ageSubmitPO.getMessage());
    }
    @Test
    public void scenario2 () {
        agePO.enterName("Alex");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("HYou haven't entered anything in age field", agePO.getErrorMessage());
    }
    @Test
    public void scenario3 () {
        agePO.enterName("zeel");
        agePO.enterAge("5");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello,zeel, you are a kid", ageSubmitPO.getMessage());
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}