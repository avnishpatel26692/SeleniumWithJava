package selenium.sample.day3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Sample1 {
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
    public void timeOut() throws Exception{

        Thread.sleep(15000);
        Assert.assertEquals("What is this magic? It's dev magic~",
                driver.findElement(By.xpath("//p")).getText());


    }
    @Test
    public void implicit(){
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//p[contains(text(),'dev magic')]"));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p[contains(text(),'dev magic')]")).getText());

    }
    @Test
    public void explicit1(){
        WebDriverWait timeWait = new WebDriverWait(driver,15);
        timeWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(text(),'dev magic')]")));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p[contains(text(),'dev magic')]")).getText());
    }
    @Test
    public void explicit2(){
        WebDriverWait timeWait = new WebDriverWait(driver,15);
        timeWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[contains(text(),'changes')]")));
        Assert.assertEquals("What is this magic? It's dev magic~",
                driver.findElement(By.xpath("//p")).getText());

    }
    @Test
    public void explicit3(){
        WebDriverWait timeWait = new WebDriverWait(driver,15);
        timeWait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style","color: green;"));
        Assert.assertEquals("This text magicly changes color",
                driver.findElement(By.xpath("//p")).getText());

    }
    @After
    public void tearDown() throws Exception {
//        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
