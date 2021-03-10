package selenium.sample;

import org.junit.After;
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

    //enter Name, Age and click on submit btn and validate message
    @Test
    public void scenario1()
    {
        agePO.enterName("ABC");
        agePO.enterAge("25");
        agePO.clickOnSubmitBtn();
        System.out.println(ageSubmitPO.getMessage());
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500); //1.5 seconds

        //Close browser
        driver.quit();
    }

}
