package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page.AgePage;
import page.AgeSubmitPage;

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
        driver.manage().window().maximize();
    }
    //enter name, age

    @Test
    public void scenario1() {
        agePO.enterName("ABC");
        agePO.enterAge("25");
        agePO.clickOnSubmit();
        Assert.assertEquals("Hello, ABC, you are an adult", ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());
    }
    @Test
    public void scenario2() {
        agePO.enterName("nsd");
        agePO.clickOnSubmit();
        Assert.assertEquals("You haven't entered anything in age field", agePO.getErrorMessage());
        System.out.println(agePO.getErrorMessage());
    }

    @Test
    public void scenario3() {
        agePO.enterName("Kirill");
        agePO.enterAge("2");
        agePO.clickOnSubmit();
        Assert.assertEquals("Hello, Kirill, you are a kid", ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
