package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBack {



    @FindBy(how = How.XPATH, using = "//button[text()='Yes']")
    private WebElement yes;

    @FindBy(how = How.XPATH, using = "//button[text()='No']")
    private WebElement no;

    @FindBy(how = How.XPATH, using = "//div[@class='w3-panel w3-green']")
    private WebElement message;

    public String sendYesButtonBackgroundColor() {
        return yes.getCssValue("background-color");
    }

    public String getYesButtonColor() {
        return yes.getCssValue("border-bottom-color");
    }

    public String sendNoButtonBackgroundColor() {
        return no.getCssValue("background-color");
    }

    public String getNoButtonColor() {
        return no.getCssValue("border-bottom-color");
    }

    public void yesButtonClick() {
        yes.click();
    }

    public void noButtonClick() {
        no.click();
    }

    public String getMessage() {
        return message.getText();
    }

    public String messageBackgroundColor() {
        return message.getCssValue("background-color");
    }

    public String messageTextColor() {
        return message.getCssValue("color");
    }




}
