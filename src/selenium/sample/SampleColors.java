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
import java.util.concurrent.TimeUnit;
public class SampleColors {
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
    public void greenLoading(){
        WebElement grButton = driver.findElement(By.cssSelector("button#start_green"));
        grButton.click();

        //  presence of element
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button#start_green")));
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button#start_green"))));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#finish_green>label")));
        Assert.assertEquals("Green", driver.findElement(By.cssSelector("h2#finish_green>label")).getText());
    }
    @After
    public void tearDown()  {
        //Close browser
        driver.quit();
    }
}
