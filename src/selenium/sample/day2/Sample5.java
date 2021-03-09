package selenium.sample.day2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();}
    @Test
    public void selectOptionByText() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select(dropdown);
        Assert.assertEquals("Choose your option",obj.getFirstSelectedOption().getText());

        obj.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2",obj.getFirstSelectedOption().getText());


    }
    @Test
    public void selectOptionByIndex() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select(dropdown);
        Assert.assertEquals("Choose your option",obj.getFirstSelectedOption().getText());

        obj.selectByIndex(1);
        Assert.assertEquals("Option 1",obj.getFirstSelectedOption().getText());

    }
    @Test
    public void selectOptionByValue() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select(dropdown);
        Assert.assertEquals("Choose your option",obj.getFirstSelectedOption().getText());

        obj.selectByValue("value3");
        Assert.assertEquals("Option 3",obj.getFirstSelectedOption().getText());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
