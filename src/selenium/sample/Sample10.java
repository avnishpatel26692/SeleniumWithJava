package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample10 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }
    //Task1
    //1) click on start loading green button
    //2) check that button does not appear
    //3) wait until text found "Green Loaded"
    @Test
    public void loadingColor(){
        driver.findElement(By.id("start_green")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("start_green")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@id='finish_green']")));
    }





    @After
    public void tearDown() throws Exception {

        //Close browser
        driver.quit();
    }
}
