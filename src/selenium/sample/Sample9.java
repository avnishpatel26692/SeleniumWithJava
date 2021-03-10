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

    @After
    public void tearDown() throws Exception {

        driver.quit();
    }

    @Test
    public void threadSleep() throws Exception {
        Thread.sleep(10000);
        driver.findElement(By.xpath("//p[contains(text(),'What is this magic?')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'What is this magic?')]"));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitPresenceOfElement() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'What is this magic?')]")));
        Assert.assertEquals("What is this magic? It's dev magic~", driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitExampleInvisibilityOfElement() {//analogical for visibility of element
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='This text magicly changes color']")));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicitWaitByAttribute() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"), "style", "color: rgb(119, 119, 119)"));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

}
