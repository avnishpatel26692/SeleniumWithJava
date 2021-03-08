package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;

public class Sample1 extends Sample{

    @Test
    public void goToHomepage() throws Exception {

//        driver.findElement(By.xpath("//input[@aria-label = `Search`]")).sendKeys("some text");
//        driver.findElement(By.xpath("//input[@type = `submit`]")).click();
        driver.get(URL_SITE);
        System.out.println(driver.findElement(By.id("h1")).getText());
//        //get title of page
        System.out.println(driver.getTitle());
//
//        //get URL of current page
        System.out.println(driver.getCurrentUrl());
//
//        //Sleep for 10 seconds
        Thread.sleep(5000);

    }
}
