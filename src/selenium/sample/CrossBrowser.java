
package selenium.sample;

        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.ie.InternetExplorerDriver;

        import java.util.concurrent.TimeUnit;

public class CrossBrowser {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        //Running in Chrome Headless
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        //Run test in Firefox
        /*System.setProperty("webdriver.gecko.driver",libWithDriversLocation + "geckodriver.exe");
        driver = new FirefoxDriver();*/

        //Run test in IE Browser
        /*System.setProperty("webdriver.ie.driver",libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();*/

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void browserFunctionality() throws Exception
    {
        Thread.sleep(2500);
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().window().setSize(new Dimension(800, 600));
        Thread.sleep(2500);

        driver.navigate().to("https://kristinek.github.io/site/examples/locators");
        Thread.sleep(2500);

        driver.navigate().back();
        Thread.sleep(2500);

        driver.navigate().forward();
        Thread.sleep(2500);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }

}