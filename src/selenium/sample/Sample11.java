package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.page.AgePage;
import selenium.page.AgeSubmittedPage;

import java.util.concurrent.TimeUnit;

public class Sample11 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage agePO;
    static AgeSubmittedPage ageSubmitPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        agePO = PageFactory.initElements(driver,AgePage.class);
        ageSubmitPO = PageFactory.initElements(driver,AgeSubmittedPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void scenario1()
    {
        agePO.enterName("ABC");
        agePO.enterAge("25");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, ABC, you are an adult",ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());
    }

    @Test
    public void scenario2()
    {
        agePO.enterName("Gloria");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("You haven't entered anything in age field",agePO.getErrorMessage());
        System.out.println(agePO.getErrorMessage());
    }

    @Test
    public void scenario3()
    {
        agePO.enterName("zeel");
        agePO.enterAge("5");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, zeel, you are a kid",ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());
    }

    @Test
    public void scenario4()
    {
        agePO.enterName("ABC");
        agePO.enterAge("25");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, ABC, you are an adult",ageSubmitPO.getMessage());

        ageSubmitPO.clickOnBackBtn();
        driver.get("https://kristinek.github.io/site/examples/age");
     }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

}