package selenium.sample.day3;

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

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/loading_color");

    }

    @Test
    public void clickAndCheck(){
        WebDriverWait timeWait = new WebDriverWait(driver,15);
        WebElement btn = driver.findElement(By.cssSelector("button#start_green"));
        btn.click();

        timeWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button#start_green")));

        timeWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));
        Assert.assertEquals("Green Loaded", driver.findElement(By.xpath("//h2[@id='finish_green']")).getText());

    }

    @After
    public void tearDown() throws Exception {
//        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
