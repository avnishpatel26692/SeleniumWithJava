package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample9 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/sync");

    }

    @Test
    public void threadSleepWait() throws Exception {
        Thread.sleep(10000); // wait for the program for 10 seconds irrespective any conditions (Hard wait)
        System.out.println("After 10 seconds");
    }

    @Test
    public void implicitWait() {
        // implicit wait is maximum time it will wait for "driver.findElement()" method. if found earlier it continue
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic)]"));
        Assert.assertEquals("What is this magic? It's dev magic", driver.findElement(By.xpath("//p[contains(text(),'dev magic)]")).getText());

    }

    @Test
    public void explicitWait() {
        //presence of element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic)]")));
        Assert.assertEquals("What is this magic? It's dev magic", driver.findElement(By.xpath("//p[contains(text(),'dev magic)]")).getText());
    }

    @Test
    public void explicitWaitExample2(){
        //visibility of element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic)]")));
        Assert.assertEquals("What is this magic? It's dev magic", driver.findElement(By.xpath("//p[contains(text(),'dev magic)]")).getText());

    }

    @Test
    public void explicitWaitExample3(){
        //invisibility of element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'changes color)]")));
        Assert.assertEquals("What is this magic? It's dev magic", driver.findElement(By.xpath("//p[contains(text(),'dev magic)]")).getText());

    }

    @Test
    public void explicitWaitExample4(){
        //check Attributes of element: color of text
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style", "color: rgb(119, 119, 119)"));
        Assert.assertEquals("What is this magic? It's dev magic", driver.findElement(By.xpath("//p")).getText());

    }

    @Test
    public void explicitWaitAnnaTest() {
        //presence of element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'What')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p[contains(text(),'What')]")).getText());
    }

    //1) click on start loading green button
    //2) check that button does not appear
    //3) wait until text found "Green Loaded"
    @Test
    public void explicitWaitAnnaTest2() {
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        //1. click on start loading green btn
        driver.findElement(By.id("start_green")).click();
        //2. check that button does not appear
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green")));
        //3. wait until text found "Green Loaded"
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));
    }

    @After
    public void tearDown() throws Exception {
        //Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
