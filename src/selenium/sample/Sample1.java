package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample1 {
    static String libWithDriversLocationWin = System.getProperty("user.dir") + "\\lib\\";
    static String libWithDriversLocationMac = System.getProperty("user.dir") + "/lib/";

    static final String URL_SITE = "https://kristinek.github.io/site/";
    static final String URL_LOCATOR = "https://kristinek.github.io/site/examples/locators";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocationMac + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get(URL_SITE);

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//        driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
//        driver.findElement(By.xpath("//input[@type = `submit`]")).click();

        System.out.println(driver.findElement(By.id("h1")).getText());
//        //get title of page
        System.out.println(driver.getTitle());
//
//        //get URL of current page
        System.out.println(driver.getCurrentUrl());
//
//        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
