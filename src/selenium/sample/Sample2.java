package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";


    @Test
    public void goToHomepage() throws Exception {
        //define driver: chrome driver & folder location
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        WebDriver driver = new ChromeDriver(); //create object of the Chrome driver

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators"); //means which url I want to open
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); //to set waiting time to load the page <25 sec
        driver.manage().window().maximize(); //will maximize the browser screen if I load the page

        //added new code: 1.by id
        System.out.println(driver.findElement(By.id("heading_2")).getText());
        //added new code: 2.by name

        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value"));
        //will return this is a button
        //added new code: 3.by TagName

        System.out.println(driver.findElement(By.tagName("h2")).getAttribute("id"));
        //added new code: 4.by ClassName

        System.out.println(driver.findElement(By.className("text")).getText());

//
//        //get(2) will return the 3rd element (0=1st element)
//        driver.findElements(By.className("text")).get(2);
//        driver.findElements(By.id("heading2"));
//
//        //get Text - returns text between 2 tags:
//        driver.findElement(By.className("twoTest")).getText();
//
//        driver.findElement(By.tagName("input"));
//        //if findElemenstS - will returrn all with name "input".

//        //Sleep for 10 seconds : without this closes web-page immediately, this one sets time to show
        Thread.sleep(5000);

        //Close browser.
        driver.quit();
    }
}
