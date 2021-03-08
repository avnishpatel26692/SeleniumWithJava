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
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.name(""));
        driver.findElements(By.className("text")).get(1);

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