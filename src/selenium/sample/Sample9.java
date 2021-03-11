package selenium.sample;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Sample9
{
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void threadSleep() throws Exception {
        Thread.sleep(1000);
        System.out.println("After 10 sec");
    }

    @Test
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWait2 () {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWait3() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("p")));
        Assert.assertEquals("What is this magic? It's dev magic",driver.findElement(By.xpath("//p")).getText());
    }
    @Test
    public void explicitWait4() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(), 'changes color')]")));
        Assert.assertEquals("What is this magic? It's dev magic",driver.findElement(By.xpath("//p")).getText());
    }


    @After
    public void tearDown () throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}