package selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePage {


    @FindBy(how = How.ID, using ="name")
    private WebElement nameText;

    WebDriver driver = new ChromeDriver();

    @FindBy(how = How.CSS, using= "input#age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'w3-btn')]")
    private WebElement btn;

    @FindBy(how = How.ID, using="error")
    private WebElement errorMsg;

    @FindBy(how = How.ID, using="message")
    private WebElement msg;

    public void enterName(String name){
        nameText.clear();
        nameText.sendKeys(name);
    }

    public void enterAge(String age){
        ageText.sendKeys(age);
    }

    public void clickOnSubmitButton(){
        btn.click();
    }
    public String getErrorMessage(){
        return errorMsg.getText();
    }
    public String getMessage(){
        return msg.getText();
    }
}
