package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.Page.AgePage;
import selenium.sample.Page.AgeSubmittedPage;

import java.util.concurrent.TimeUnit;

public class Sample11 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    static WebDriver driver;
    static AgePage agePO;
    static AgeSubmittedPage ageSubmitPO;



    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        agePO = PageFactory.initElements(driver, AgePage.class);
        ageSubmitPO = PageFactory.initElements(driver, AgeSubmittedPage.class);

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
//enter Name, Age and click on submit btn
@Test
    public void scenario1(){

        agePO.enterName("ABC");
        agePO.enterAge("36");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, ABC, you are an adult", ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());

}

    //1. enter Name
    //2. click on submit Button
    //3. validate the error message "You haven't entered anything in age field"
    @Test
    public void scenario2()
    {
        agePO.enterName("ABC");
        agePO.clickOnSubmitBtn();
        agePO.getErrorMessage();
        Assert.assertEquals("You haven't entered anything in age field", agePO.getErrorMessage());
        System.out.println(agePO.getErrorMessage());

    }

//1. enter Name = Anda
//2. enter Age = 10
//3. click on submit button
//4. validate success message "Hello, Anda, you are a kid"

    @Test
    public void scenario3()
    {
        agePO.enterName("Anda");
        agePO.enterAge("10");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, Anda, you are a kid", ageSubmitPO.getMessage());
        System.out.println(ageSubmitPO.getMessage());


    }


    @After
    public void tearDown () throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}
