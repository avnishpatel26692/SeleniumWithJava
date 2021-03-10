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
    static AgePage agePagePO;
    static AgeSubmittedPage ageSubmittedPagePO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        agePagePO = PageFactory.initElements(driver, AgePage.class);
        ageSubmittedPagePO = PageFactory.initElements(driver, AgeSubmittedPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);//1.5 seconds
        //Close browser
        driver.quit();
    }

    //enter Name,
    // Age and
    // click on submit btn and
    // validate message

    @Test
    public void scenario1() {
        agePagePO.enterName("Aizhan");
        agePagePO.enterAge("30");
        agePagePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, Aizhan, you are an adult",ageSubmittedPagePO.getMessage());
        System.out.println(ageSubmittedPagePO.getMessage());
    }
    //enter Name
    //click on submit Button
    //validate the error message "You haven't entered anything in age field"

    @Test
    public void scenario2() {
        agePagePO.enterName("Olga");
        agePagePO.clickOnSubmitBtn();
        Assert.assertEquals("You haven't entered anything in age field",agePagePO.getErrorMessage());
    }

    //enter Name
    //enter Age >20
    //click on submit Button
    //validate success message "Hello, user, you are an adult"

    @Test
    public void scenario3() {
        agePagePO.enterName("Olga");
        agePagePO.enterAge("24");
        agePagePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, Olga, you are an adult",ageSubmittedPagePO.getMessage());
    }
}
