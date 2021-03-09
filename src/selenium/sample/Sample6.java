package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample6 {


    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void findElementByClassAll() {

        //find all Elements with className "test"
        List<WebElement> list = driver.findElements(By.className("test"));

        //To print number of Elements
        System.out.println("number of elements: " + list.size());

        //To print All Elements
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
        //Getting 3rd element
        System.out.println("3rd Element is: " + list.get(2).getText());
    }

        @Test
        public void findElementByXPath() {

        WebElement xpathElement = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(xpathElement.getText());

        WebElement xpathElement1 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(xpathElement1.getText());

        }
        @Test
        public void findElementByCssName()
        {
        WebElement cssName = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(cssName.getText());

        WebElement cssName1 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(cssName1.getText());

        }


        @After
        public void tearDown () throws Exception {
            Thread.sleep(1500);

            //Close browser
            driver.quit();

    }
}