package selenium.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class Sample8 extends Sample{

    @Test
    public void test1(){
        driver.get(URL_ACTIONS);

        List<WebElement> elements = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for(WebElement element : elements){
            assertFalse(element.isSelected());
            element.click();
            assertTrue(element.isSelected());
            element.click();
            assertFalse(element.isSelected());
        }

        WebElement element = elements.get(2);
        assertFalse(element.isSelected());
        element.click();
        assertTrue(element.isSelected());

        WebElement element1 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        assertTrue(element1.isSelected());

    }

    @Test
    public void test2(){
        driver.get(URL_ACTIONS);

        List<WebElement> elements = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        elements.forEach(element -> {
            assertFalse(element.isSelected());
            element.click();
            assertTrue(element.isSelected());
            elements.stream().filter(e1 -> !e1.equals(element)).forEach(otherElement -> {
                assertFalse(otherElement.isSelected());
            });
            element.click();
            assertTrue(element.isSelected());

        });

        // select something other than option 3
        elements.get(0).click();
        WebElement element = elements.get(2);
        assertFalse(element.isSelected());
        element.click();
        assertTrue(element.isSelected());

        WebElement element1 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio']"));
        assertTrue(element1.isSelected());

    }

    @Test
    public void test3(){
        driver.get(URL_ACTIONS);

        WebElement element = driver.findElement(By.id("vfb-12"));
        Select select = new Select(element);
        assertEquals("Choose your option", select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 2");
        assertEquals("Option 2", select.getFirstSelectedOption().getText());
    }

    @Test
    public void test4(){
        driver.get(URL_ACTIONS);

        WebElement element = driver.findElement(By.id("vfb-12"));
        Select select = new Select(element);
        assertEquals("Choose your option", select.getFirstSelectedOption().getText());

        select.selectByIndex(1);
        assertEquals("Option 1", select.getFirstSelectedOption().getText());
    }

    @Test
    public void test5(){
        driver.get(URL_ACTIONS);

        WebElement element = driver.findElement(By.id("vfb-12"));
        Select select = new Select(element);
        assertEquals("Choose your option", select.getFirstSelectedOption().getText());

        select.selectByValue("value3");
        assertEquals("Option 3", select.getFirstSelectedOption().getText());
    }
}
