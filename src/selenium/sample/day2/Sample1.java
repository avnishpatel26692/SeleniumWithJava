package selenium.sample.day2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();}

        @Test
        public void findElementByClassAll(){

        List<WebElement> list = driver.findElements(By.className("test"));
            System.out.println("Number of elements: "+ list.size());

            for(int i = 0; i< list.size();i++){
                System.out.println(list.get(i).getText());
            }

            System.out.println("3rd element: "+ list.get(3).getText());

        }

        @Test
        public void findElementByXPath(){
            WebElement el = driver.findElement(By.xpath("//div[@id='nonStandartText']/*[contains(@class,'text amazing')]"));
            System.out.println(el.getText());


            WebElement el2 = driver.findElement(By.xpath("//p[@class='text'][@id='dummy']"));
            System.out.println(el2.getText());

        }

        @Test
        public void findElementByCssName(){
            WebElement el1 = driver.findElement(By.cssSelector("div#nonStandartText> .amazing"));
            System.out.println(el1.getText());

            WebElement el2 = driver.findElement(By.cssSelector(".text#dummy"));
            System.out.println(el2.getText());

        }



        @After
        public void tearDown() throws Exception {
            Thread.sleep(3000);

            //Close browser
            driver.quit();
        }
}
