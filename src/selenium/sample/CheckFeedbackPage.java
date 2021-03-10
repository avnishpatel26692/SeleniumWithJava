package selenium.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckFeedbackPage extends Page{

    @FindBy(xpath = "//*[@id=\"fb_thx\"]/div/div[1]//*[@class='description']//*[span]/*")
    private List<WebElement> descriptions;

    @FindBy(xpath = "//*[@id=\"fb_thx\"]/div/div[2]/button[1]")
    private WebElement yesButton;

    @FindBy(xpath = "//*[@id=\"fb_thx\"]/div/div[2]/button[2]")
    private WebElement noButton;

    @FindBy(id = "message")
    private WebElement message;

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public WebElement getYesButton() {
        return yesButton;
    }

    public WebElement getNoButton() {
        return noButton;
    }

    public WebElement getMessage() {
        return message;
    }
}
