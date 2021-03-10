package selenium.page;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage ageP0;
    static AgeSubmitPage ageSubmitP0;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");

        driver = new ChromeDriver();
        ageP0 = PageFactory.initElements(driver, AgePage.class);
        ageSubmitP0 = PageFactory.initElements(driver, AgeSubmitPage.class);

        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //enters name, age and clicks submit
    @Test
    public void test1(){
        ageP0.enterName("Egils");
        ageP0.enterAge("27");
        ageP0.clickOnSubmitBtn();
        ageSubmitP0.getMessage();
        Assert.assertEquals("Hello, Egils, you are an adult",ageSubmitP0.getMessage());
        System.out.println(ageSubmitP0.getMessage());
    }
    //Enter only name and get error message
    @Test
    public void test2(){
        ageP0.enterName("Egils");
        ageP0.clickOnSubmitBtn();
        ageP0.getErrorMessage();
        Assert.assertEquals("You haven't entered anything in age field",ageP0.getErrorMessage());
        System.out.println(ageP0.getErrorMessage());
    }
    @Test
    public void scenario3() {
        ageP0.enterName("Egils2");
        ageP0.enterAge("5");
        ageP0.clickOnSubmitBtn();
        Assert.assertEquals("Hello, Egils2, you are a kid", ageSubmitP0.getMessage());
        System.out.println(ageSubmitP0.getMessage());
    }



    @After
    public void tearDown() throws Exception {

        //Close browser
        driver.quit();
    }
}


