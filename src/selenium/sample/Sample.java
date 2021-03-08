package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample {

    static String libWithDriversLocationMac = System.getProperty("user.dir") + "/lib/";

    static final String URL_SITE = "https://kristinek.github.io/site/";
    static final String URL_LOCATOR = "https://kristinek.github.io/site/examples/locators";

    WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("setup");
        System.setProperty("webdriver.chrome.driver", libWithDriversLocationMac + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void after(){
        driver.quit();
    }
}
