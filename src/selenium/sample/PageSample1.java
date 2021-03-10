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

public class PageSample1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage agePO;
    static AgeSubmitPage ageSubmitPO ;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        agePO = PageFactory.initElements(driver,AgePage.class);
        ageSubmitPO = PageFactory.initElements(driver,AgeSubmitPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @Test
    public void validateAdultAgeMessage(){
        agePO.enterName("Greg");
        agePO.enterAge("33");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, Greg, you are an adult",ageSubmitPO.getMassege());

        System.out.println(ageSubmitPO.getMassege());
    }

    @Test
    public void validateErrorMessage(){
        agePO.enterName("Greg");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("You haven't entered anything in age field",agePO.getErrorMsg());

    }
    @Test
    public void validateKidAgeMessage(){
        agePO.enterName("Zeel");
        agePO.enterAge("5");
        agePO.clickOnSubmitBtn();
        Assert.assertEquals("Hello, Zeel, you are a kid",ageSubmitPO.getMassege());
    }
    @After
    public void tearDown() throws Exception {
//        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
