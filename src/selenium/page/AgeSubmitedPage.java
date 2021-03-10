package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmitedPage {

    @FindBy(how = How.ID, using = "message")
    private WebElement msg;

    @FindBy(how = How.XPATH, using = "//button[text()='Back']")
    private WebElement backBtn;

    public String getMessage(){
        return msg.getText();
    }

    public void clickOnBackBtn(){
        backBtn.click();
    }
}
