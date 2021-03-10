package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.page.AgePage;
import selenium.sample.page.AgeSubmitPage;

import java.util.concurrent.TimeUnit;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage agePO;
    static AgeSubmitPage ageSubmitPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        agePO = PageFactory.initElements(driver, AgePage.class);
        ageSubmitPO = PageFactory.initElements(driver, AgeSubmitPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    @Test
    public void scenario1(){
        agePO.enterName("ABC");
        agePO.enterAge("25");
        agePO.clickOnSbmBtn();
        System.out.println(ageSubmitPO.getMessage());
    }
    @Test
    public void task2(){
        agePO.enterName("Natalja");
        agePO.clickOnSbmBtn();
        System.out.println(agePO.getErrorMessage());
        Assert.assertEquals("You haven't entered anything in age field", agePO.getErrorMessage());
    }
    @Test
    public void task3(){
        agePO.enterName("Natalja");
        agePO.enterAge("5");
        agePO.clickOnSbmBtn();
        System.out.println(ageSubmitPO.getMessage());
        Assert.assertEquals("Hello, Natalja, you are a kid", ageSubmitPO.getMessage());
    }
    @Test
    public void task03(){
        agePO.enterName("Natalja");
        agePO.enterAge("19");
        agePO.clickOnSbmBtn();
        System.out.println(ageSubmitPO.getMessage());
        Assert.assertEquals("Hello, Natalja, you are a teenager", ageSubmitPO.getMessage());
    }

    @After
    public void tearDown()  {
//        Thread.sleep(1500);
        //Close browser
        driver.quit();
    }
}
