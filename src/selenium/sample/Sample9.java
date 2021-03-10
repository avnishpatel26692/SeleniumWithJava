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
    }

    @Test
    public void threadsleepwait() throws Exception
    {
        Thread.sleep(15000);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample1()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }


    @Test
    public void explicitWaitExample2()
    {
        //check Attributes Example: color of text
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style","color: rgb(119, 119, 119);"));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample3()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style","color: green;"));
        Assert.assertEquals("This text magicly changes color",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample4()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'magicly')]")));
        Assert.assertEquals("This text magicly changes color",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExample5()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'changes color')]")));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

    @After
    public void tearDown()  {

        //Close browser
        driver.quit();
    }

}