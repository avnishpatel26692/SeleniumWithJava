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

public class Sample9_1 {

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
        public void sleepWait() throws Exception {
            Thread.sleep(10000);
            driver.findElement(By.xpath("//a[@id='magic_text']/p[contains(@style,'')]"));
            Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());

        }

        @Test
        public void implicit() {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//a[@id='magic_text']/p[contains(@style,'')]]"));
            Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
        }

        @Test
        public void explicit() {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='magic_text']/p[contains(@style,'')]")));
            Assert.assertEquals("This text magicly changes color",driver.findElement(By.xpath("//p")).getText());

        }

    @Test
    public void explicit2()
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='magic_text']/p[contains(@style,'')]")));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }


    @Test
    public void explicit3()
    {
        //invisibility of Element
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='magic_text']/p[contains(@style,'')]")));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void explicit4()
    {
        //check Attributes Example: color of text
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.attributeContains(By.xpath("//p"),"style","color: rgb(119, 119, 119);"));
        Assert.assertEquals("What is this magic? It's dev magic~",driver.findElement(By.xpath("//p")).getText());
    }




        @After
        public void tearDown() throws Exception {

            //Close browser
            driver.quit();
        }
}
