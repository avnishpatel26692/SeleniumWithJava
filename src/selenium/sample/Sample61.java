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

public class Sample61 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearAfter() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void findElementsByClassAll() {
        //find All Elements with class "test"
        List<WebElement> List = driver.findElements(By.className("test"));

        //To print number of Elements
        System.out.println("number of Elements: " + List.size());

        //To print All Elements
        for(int i=0; i<List.size(); i++) {
            System.out.println(List.get(1).getText());
        }

        //Getting 3rd Element
        System.out.println("3rd Element is " + List.get(2).getText());
    }
    @Test
    public void findElementByXPath() {
        WebElement xpathElement1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(xpathElement1.getText());

        WebElement xpathElement2 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(xpathElement2.getText());
    }

    @Test
    public void findElementByCssName() {
        WebElement cssElement = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(cssElement.getText());

        WebElement cssElement2 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(cssElement2.getText());
    }

}

