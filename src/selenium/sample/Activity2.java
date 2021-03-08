package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Activity2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/locators");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        System.out.println(driver.findElement(By.id("heading_2")).getText());
        System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value"));
        System.out.println(driver.findElement(By.tagName("h2")).getAttribute("id"));
        System.out.println(driver.findElement(By.className("text")).getText());

        Thread.sleep(5000);
        driver.quit();

    }
}
