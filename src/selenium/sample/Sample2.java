package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;

public class Sample2 extends Sample{

    @Test
    public void findElements() {
        driver.get(URL_LOCATOR);

        String attribute = driver.findElement(By.id("heading_2")).getText();
        System.out.println(attribute);

        String value = driver.findElement(By.name("randomButton1")).getAttribute("value");
        System.out.println(value);

        String tagid = driver.findElement(By.tagName("h2")).getAttribute("id");
        System.out.println(tagid);

        String classtext = driver.findElement(By.className("text")).getText();
        System.out.println(classtext);
    }
}
