package selenium.sample.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameText;

    @FindBy(how = How.CSS, using = "input#age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'w3-btn')]")
    private WebElement submitBtn;

    @FindBy(how = How.ID, using ="error")
    private WebElement errorMsg;

    public void enterName(String name)
    {
        nameText.clear();
        nameText.sendKeys(name);
    }

    public void enterAge(String age)
    {

        ageText.sendKeys(age);
    }

    public void clickOnSubmitBtn()
    {

        submitBtn.click();
    }

    public String getErrorMessage(){

        return errorMsg.getText();
    }
}
