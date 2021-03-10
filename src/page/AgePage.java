package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePage {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameText;

//    WebDriver driver = new ChromeDriver();
//    public void method1() {
//        WebElement nameText = driver.findElement(By.id("name"));
//    }

    @FindBy(how = How.CSS, using = "input#age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'w3-btn')]")
    private WebElement submit;

    @FindBy(how = How.ID, using = "error")
    private WebElement error;

    public void enterName(String name) {
        nameText.clear();
        nameText.sendKeys(name);

    }

    public void enterAge(String age) {
        ageText.sendKeys(age);
    }

    public void clickOnSubmit() {
        submit.click();
    }

    public String getErrorMessage() {
        return error.getText();

    }



}
