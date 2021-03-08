package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample2 {

        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

        @Test
        public void findElement() throws Exception {
            //define driver
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
            WebDriver driver = new ChromeDriver();

            //open test homepage
//        driver.get("https://google.com");
            driver.get("https://kristinek.github.io/site/examples/locators");

            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();

//            driver.findElement(By.name("randomButton1")); //return first elements
//            driver.findElement(By.className("text"));
//            driver.findElement(By.className("text")).get(2); //return 3rd indeks
//
//            driver.findElement(By.id("heading_2")); //locator by id
//            driver.findElement(By.name("randomButton1")).getAttribute("value"); // will get btn name
//            driver.findElement(By.className("twoTest")).getText(); // will get text between tags
//            driver.findElement(By.tagName("input")); // locator by tagName

            System.out.println(driver.findElement(By.id("heading_2")).getText()); // locator by id
            System.out.println(driver.findElement(By.name("randomButton1")).getAttribute("value")); // locator by id
            System.out.println(driver.findElement(By.tagName("h2")).getAttribute("id"));
            System.out.println(driver.findElement(By.className("text")).getText());

        /*driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
        driver.findElement(By.xpath("//input[@type = `submit`]")).click();*/

            System.out.println(driver.findElement(By.id("h1")).getText());
//        //get title of page
            System.out.println(driver.getTitle());
//
//        //get URL of current page
            System.out.println(driver.getCurrentUrl());
//
//        //Sleep for 10 seconds
            Thread.sleep(5000);

            //Close browser- Anna
            driver.quit();
        }


}
