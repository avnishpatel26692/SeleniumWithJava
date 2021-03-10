package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.page.AgePage;
import selenium.sample.page.AgeSubmittedPage;

import java.util.concurrent.TimeUnit;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage agePO = PageFactory.initElements(driver,AgePage.class);
    static AgeSubmittedPage ageSubmitPO = PageFactory.initElements(driver,AgeSubmittedPage.class);
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        agePO = PageFactory.initElements(driver, AgePage.class);
        ageSubmitPO = PageFactory.initElements(driver, AgeSubmittedPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void scenario01(){
        agePO.enterName("ABAB");
        agePO.enterAge("31");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, ABAB, you are an adult", ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());
    }

    ////1. enter Name
    ////2. click on submit Button
    ////3. validate the error message "You haven't entered anything in age field"
    @Test
    public void scenario02(){
        agePO.enterName("XYZ");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("You haven't entered anything in age field", agePO.getErrorMessage());
        System.out.println("=== warning printed===");


    }
    //Task: 3
    ////1. enter Name = zeel
    ////2. enter Age = 5
    ////3. click on submit button
    ////4. validate success message "Hello, zeel, you are a kid"
    @Test
    public void scenario03() {
        agePO.enterName("zeel");
        agePO.enterAge("5");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, zeel, you are a kid", ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //Close browser
        driver.quit();
    }
}
