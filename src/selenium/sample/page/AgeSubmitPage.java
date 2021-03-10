package selenium.sample.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgeSubmitPage {
    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.XPATH, using = "//h2[@id='message']")
    private WebElement btn;

    public String getMassege(){
        return message.getText();
    }

    public void clickBack(){
        btn.click();
    }
}
