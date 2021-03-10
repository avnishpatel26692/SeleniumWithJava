package selenium.sample.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.pages.AgePage;
import selenium.sample.pages.AgeSubmitPage;

import java.util.concurrent.TimeUnit;

public class Sample11 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static AgePage agePO = PageFactory.initElements(driver, AgePage.class);
    static AgeSubmitPage ageSubmitPO = PageFactory.initElements(driver, AgeSubmitPage.class);

    @Before

    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        agePO = PageFactory.initElements(driver, AgePage.class);
        ageSubmitPO = PageFactory.initElements(driver, AgeSubmitPage.class);

        driver.get("https://kristinek.github.io/site/examples/age");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void scenario1(){
        agePO.enterName("John");
        agePO.enterAge("20");
        agePO.clickSubmit();
        System.out.println(ageSubmitPO.getMessage());
    }
}
