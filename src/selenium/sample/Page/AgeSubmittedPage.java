package selenium.sample.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmittedPage {

    @FindBy(how = How.ID, using = "message")
    private WebElement message;


    @FindBy(how = How.XPATH, using = "//button[text() = 'Back']")
    private WebElement backBtn;

    public String getMessage()
    {

        return message.getText();
    }

    public void clickOnBackBtn(){

        backBtn.click();
    }
}
