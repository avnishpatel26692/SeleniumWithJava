package selenium.task;

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

public class Temp {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/sync");

        wait = new WebDriverWait(driver,10);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }

    @Test
    public void withoutAnyWait() throws Exception
    {
        System.out.println("Checking for magic Text");
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//a[@id='magic_text']/p")).getText());
    }

    @Test
    public void hardWait() throws Exception
    {
        Thread.sleep(15000);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//a[@id='magic_text']/p")).getText());
    }

    @Test
    public void implicitWaitExample()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//a[@id='magic_text']/p")).getText());
    }

    @Test
    public void explicitWaitExample()
    {
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'changes color')]")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'dev magic')]")));
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic')]")));
        //wait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style", "color: rgb(119, 119, 119);"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p"),"dev magic"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//a[@id='magic_text']/p")).getText());
    }

    @Test
    public void waitForAlert()
    {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
