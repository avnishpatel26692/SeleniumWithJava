package selenium.sample.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgePage {
//define all elements
    @FindBy(how = How.ID, using = "name")
    private WebElement nameText;

    @FindBy(how = How.CSS, using = "input#age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'w3-btn')]")
    private WebElement submitBtn;

    @FindBy(how = How.ID, using = "error")
    private WebElement errorMsg;

    //define all methods
    public void enterName(String name) {
        nameText.click();
        nameText.sendKeys(name);
    }

    public void enterAge(String age) {
        ageText.sendKeys(age);
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }

}
