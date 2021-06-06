package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ThankPage {
    @FindBy(how = How.ID, using = "message")
    private WebElement messageText;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div")
    private WebElement messageDiv;

    public String getMessageText() {
        return messageText.getText();
    }

    public String getMessageBackground() {
        return messageDiv.getCssValue("background-color");
    }

    public String getMessageTextColor() {
        return messageDiv.getCssValue("color");
    }
}
