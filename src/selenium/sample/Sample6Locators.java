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

public class Sample6Locators {
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

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }

    //5.findElementByClassAll - where you find elements by className “test” and then print out
//•number of elements
//•the text of this elements
//•3rd element
    @Test
    public void findElementByClassAll() {
        //find All Elements with Class "test"
        List<WebElement> list = driver.findElements(By.className("test"));
//To print number of Elements
        System.out.println("number of Elements: " + list.size());
//To Print All Elements
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
//Getting 3rd Element
        System.out.println("3rd Element is : " + list.get(2).getText());
    }

    //6.findElementByXPath - where you find element by xpath:
    //•“//div[@id='nonStandartText']/*[contains(@class,'text amazing')]” and then print out the text of this element
    //•“//p[@class='text' and @id='dummy']” and then print out the text of this element
    @Test
    public void findElementByXPath() {
        WebElement text1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
        System.out.println(text1.getText());
        WebElement text2 = driver.findElement(By.xpath("//p[@class='text' and @id='dummy']"));
        System.out.println(text2.getText());
    }

    //7.findElementByCssName - where you find element by css:
//•“div#nonStandartText > .amazing” and then print out the text of this element
//•“.text#dummy” and then print out the text of this element
    @Test
    public void findElementByCssName() {
        WebElement text1 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
        System.out.println(text1.getText());
        WebElement text2 = driver.findElement(By.cssSelector(".text#dummy"));
        System.out.println(text2.getText());
    }
}