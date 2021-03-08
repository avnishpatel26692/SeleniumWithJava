package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Sample4 extends Sample{

    @Test
    public void test1(){
        driver.get(URL_ACTIONS);
        WebElement text = driver.findElement(By.id("text"));
        System.out.println("text: " + text.getText());
        System.out.println("value: " + text.getAttribute("value"));

        text.sendKeys(Keys.chord("another text"));
        System.out.println("text: " + text.getText());
        System.out.println("value: " + text.getAttribute("value"));

        text.clear();
        text.sendKeys(Keys.chord("completely different text"));
        System.out.println("text: " + text.getText());
        System.out.println("value: " + text.getAttribute("value"));
    }


}
