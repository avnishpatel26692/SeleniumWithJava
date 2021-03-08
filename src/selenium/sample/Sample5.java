package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

    }

    @Test
    public void alertOnOpeningPage(){
        Alert alert = driver.switchTo().alert();
        String alertMessage = "Booooooooo!";
        Assert.assertEquals(alertMessage,alert.getText());
        alert.accept();
        WebElement heading = driver.findElement(By.id("heading"));
        Assert.assertEquals("This page is alerted", heading.getText());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
