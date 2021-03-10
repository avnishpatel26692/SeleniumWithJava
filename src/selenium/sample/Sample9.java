
package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Sample9 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void threadsleepwait() throws Exception {
        Thread.sleep(15000);
        driver.findElement(By.xpath("//p[contains(text),'What is this magic? It's dev magic~')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());


    }



    @Test
    public void implicitWait() {
        //implicit wait is maximum time it will wait for "driver.findElement()" method. if found earlier it continues.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample1() {
        //Presence of Element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample2() {
        //Visibility of Element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }


    @Test
    public void explicitWaitExample3() {
        //invisibility of Element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'changes color')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample4() {
        //check Attributes Example: color of text
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: rgb(119, 119, 119);"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void loadingColor1() {
        //1) click on start loading green button
        //2) check that button does not appear
        //3) wait until text found "Green Loaded"
        driver.findElement(By.id("start_green")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green")));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("h2[id='finish_green']")));
    }


    @After
    public void tearDown() throws Exception {

        //Close browser
        driver.quit();

    }
}