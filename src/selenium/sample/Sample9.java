package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sample9 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/sync");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void threadSleepWait() throws Exception {
        Thread.sleep(10000);//Wait for program for 15 second irrespective any condition(Hard Wait)
        System.out.println("After 10 second");
    }

    @Test
    public void implicitlyWait() throws Exception {
        //Implicit wait is maximum time it will wait for "driver.findElement() method, if found earlier it continues.
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p[contains(text(),'dev magic')]")).getText());

    }
    @Test
    public void explicitWait1() {
        //Presence of Element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p[contains(text(),'dev magic')]")).getText());
    }

    @Test
    public void explicitWait2() {
        //Visibility elements
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWait3() {
        //Invisible elements
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'changes color')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWait4() {
        //check Attributes example: color of text
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: rgb(119, 119, 119);"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

}
