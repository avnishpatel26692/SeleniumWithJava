package selenium.sample;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class Sample3 extends Sample{

    @Test
    public void test1(){
        driver.get(URL_ACTIONS);

        assertEquals(URL_ACTIONS, driver.getCurrentUrl());
        driver.findElement(By.cssSelector("a[title='Link 1']")).click();
        assertEquals("https://kristinek.github.io/site/examples/link1", driver.getCurrentUrl());
        assertEquals("Link Page 1", driver.findElement(By.id("h1")).getText());

    }

    @Test
    public void clearText(){
        driver.get(URL_ACTIONS);

        WebElement show_me = driver.findElement(By.id("show_me"));
        assertFalse(show_me.isDisplayed());
        WebElement show_text = driver.findElement(By.id("show_text"));
        assertTrue(show_text.isEnabled());
        WebElement hide_text = driver.findElement(By.name("hide_text"));
        assertFalse(hide_text.isEnabled());

        show_text.click();
        assertTrue(show_me.isDisplayed());
        assertFalse(show_text.isEnabled());
        assertTrue(hide_text.isEnabled());

        hide_text.click();
        assertFalse(show_me.isDisplayed());
        assertTrue(show_text.isEnabled());
        assertFalse(hide_text.isEnabled());
    }

    @Test
    public void test3(){
        driver.get(URL_ACTIONS);

        WebElement element = driver.findElement(By.name("vfb-10"));
        assertEquals("This is a text area", element.getText());
        element.sendKeys(Keys.chord("abcd"));
        assertEquals("This is a text areaabcd", element.getAttribute("value"));
        System.out.println("Text: " + element.getText());
        element.clear();
        element.sendKeys(Keys.chord("abcd"));
        assertEquals("abcd", element.getAttribute("value"));
        System.out.println("Text: " + element.getText());
    }

}
