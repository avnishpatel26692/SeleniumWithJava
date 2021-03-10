package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmitPage {

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.XPATH, using = "//button[text()='BACK']")
    private WebElement backBtn;

    public String getMessage() {
        return message.getText();
    }

    public void clickOnBack() {
        backBtn.click();

    }
}
