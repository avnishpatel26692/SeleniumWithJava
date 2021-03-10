package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;






public class Sample3 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void assertEqualsExamples() throws Exception {

        //where you compare text “Heading 1“ with text from element with id “heading_1” via “assertEquals”

        WebElement heading1 = driver.findElement(By.id("heading_1"));
        String actualValue = heading1.getText();
        String expectValue = "Heading 1";
        Assert.assertEquals("This should be failed", expectValue, actualValue);
    }

    @Test
    public void assertTrueExamples() {

        //assertTrue with “String.equals()”, “String.contains()”, “String. equalsIgnoreCase()”

        String expectValue = "This is a button";
        WebElement btn = driver.findElement(By.name("randomButton1"));
        String actualValue = btn.getAttribute("value");
        Assert.assertTrue(actualValue.equalsIgnoreCase(expectValue));

    }

    @Test
    public void assertFalseExamples() {

        //assertFalse with “!String.equals()”, “String.equals(“not”)”, “String. contains(“not”)”

        String expectValue = "This is a button 2";
        WebElement btn = driver.findElement(By.name("randomButton2"));
        String actualValue = btn.getAttribute("value");
        Assert.assertFalse(actualValue.contains(expectValue));

    }

    @Test
    public void fail() {

        //see how fail() works
        Assert.fail();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //close browser
        driver.quit();
    }
}














