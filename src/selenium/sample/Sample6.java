package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample6 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
        public void findElementsByClassAll(){

        List<WebElement> list = driver.findElements(By.className("test"));
        System.out.println("Number of Elements: "+list.size());

        for(int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i).getText());
        }

        System.out.println(list.get(2).getText());

    }

    @Test
    public void findElementsByXPath(){

        WebElement xpathElement = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(xpathElement.getText());

        WebElement xpathElement1 = driver.findElement(By.xpath("//p[@class='text'][@id='dummy']"));
        System.out.println(xpathElement1.getText());

    }

    @Test
    public void findElementByCssName(){

        WebElement cssElement = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(cssElement.getText());

        WebElement cssElement1 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(cssElement1.getText());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}