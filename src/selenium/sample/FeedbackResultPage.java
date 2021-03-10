package selenium.sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class FeedbackResultPage {
    @FindBy(how = How.CSS, using = "button.w3-green")
    private WebElement yesBtn;
    @FindBy(how = How.CSS, using = "button.w3-red")
    private WebElement noBtn;
    @FindBy(how = How.CSS, using = "div.description")
    private List<WebElement> formFields;

    public String getFormFields(int index) {
        return formFields.get(index).getText();
    }

    public void clickYesBtn(){
        yesBtn.click();
    }
    public String getYesBtnBckgrColor(){
        return yesBtn.getCssValue("background-color");
    }
    public String getYesBtnLetterColor() {
        return yesBtn.getCssValue("color");
    }
    public void clickNoBtn(){
        noBtn.click();
    }
    public String getNoBtnBckgrColor(){
        return noBtn.getCssValue("background-color");
    }
    public String getNoBtnLetterColor() {
        return noBtn.getCssValue("color");
    }
}
