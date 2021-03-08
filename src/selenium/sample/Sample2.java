package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void findElements() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        WebDriver driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //findElementByID
        System.out.println(driver.findElement(By.id("heading_2")).getText());

        //findElementByName
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value"));

        //findElementByTagName
        System.out.println(driver.findElement(By.tagName("h2")).getAttribute("id"));

        //findElementByClassName
        System.out.println(driver.findElement(By.className("text")).getText());


//        //Sleep for 3 seconds
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
