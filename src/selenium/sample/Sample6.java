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

        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        WebDriver driver;

        @Before
        public void initBrowser() {
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
            driver = new ChromeDriver();
            driver.get("https://kristinek.github.io/site/examples/locators");

        }

        @Test
        public void findElementByClassAll () {

            List <WebElement> list = driver.findElements(By.className("test"));
            System.out.println("number of elems: " + list.size());

            for(int i=0; i<list.size(); i++){
                System.out.println(list.get(i).getText());
            }
            System.out.println(list.get(2).getText());


        }

        @Test
        public void findElementByXPath () {
            WebElement elem1 = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
            String text1 = elem1.getText();
            System.out.println(text1);
        }

        @Test
        public void findElementByCssName () {
            WebElement elem1 = driver.findElement(By.cssSelector("div#nonStandartText > .amazing"));
            String text1 = elem1.getText();
            System.out.println(text1);
            WebElement elem2 = driver.findElement(By.cssSelector(".text#dummy"));
            String text2 = elem1.getText();
            System.out.println(text2);
        }








    @After
        public void tearDown() throws Exception {
            Thread.sleep(5000);

            //Close browser
            driver.quit();
        }

    }

