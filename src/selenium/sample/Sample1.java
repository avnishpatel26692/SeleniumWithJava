package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver: chrome driver & folder location
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        WebDriver driver = new ChromeDriver(); //create object of the Chrome driver

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number"); //means which url I want to open

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS); //to set waiting time to load the page <25 sec
        driver.manage().window().maximize(); //will maximize the browser screen if I load the page

        /*driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
        driver.findElement(By.xpath("//input[@type = `submit`]")).click();*/

//        System.out.println(driver.findElement(By.id("h1")).getText());
//        //get title of page
        System.out.println(driver.getTitle()); // to get the title on of opened site tab in browser
//
//        //get URL of current page
        System.out.println(driver.getCurrentUrl()); //returns current url of the site
//
//        //Sleep for 10 seconds : without this closes web-page immediately, this one sets time to show
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
