package selenium.sample;

import org.junit.After;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.AgePage;
import selenium.page.AgeSubmitedPage;
import java.util.concurrent.TimeUnit;

public class Sample11{

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage ageTest;
    static AgeSubmitedPage ageSub;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        ageTest = PageFactory.initElements(driver,AgePage.class);
        ageSub = PageFactory.initElements(driver,AgeSubmitedPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void scenario1(){
        ageTest.enterName("BOLD");
        ageTest.enterAge("21");
        ageTest.clickOnSubmitButton();
        System.out.println(ageSub.getMessage());
    }
    @Test
    public void scenario2(){
        ageTest.enterName("Johny");
        ageTest.clickOnSubmitButton();
        Assert.assertEquals("You haven't entered anything in age field",ageTest.getErrorMessage());
    }
    @Test
    public void scenario3(){
        ageTest.enterName("zeel");
        ageTest.enterAge("5");
        ageTest.clickOnSubmitButton();
        Assert.assertEquals("Hello, zeel, you are a kid",ageTest.getMessage());
    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}