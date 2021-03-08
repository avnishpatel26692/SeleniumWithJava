package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample2 {
}
package selenium.sample;


        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.concurrent.TimeUnit;

public class Sample1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    @Test
    public void goToHomepage() throws Exception {
        //define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriverusr");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
        driver.findElement(By.xpath("//input[@type = `submit`]")).click();*/
        System.out.println(driver.findElement(By.id("heading_2")).getText());

        System.out.println(driver.findElement(By.name("randombutton1")).getAttribute("value"));
        System.out.println(driver.findElement(By.tagName("h2")).getAttribute("id"));

//dri
//        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}