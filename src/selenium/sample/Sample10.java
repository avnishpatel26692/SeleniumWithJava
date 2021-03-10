package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sample10 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    //1) click on start loading green button
    //2) check that button does not appear
    //3) wait until text found "Green Loaded"

    @Test
    public void explicitWait() {
        WebElement button = driver.findElement(By.xpath("//button[@id='start_green']"));
        button.click();
        Assert.assertFalse(button.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='green_loader']/h2")));
        Assert.assertEquals("Green Loaded", driver.findElement(By.xpath("//div[@id='green_loader']/h2")).getText());

    }
}
