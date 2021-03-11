package selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AgePage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameText;

    @FindBy(how = How.CSS, using = "input#age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'w3-btn')]")
    private WebElement submitBtn;

    @FindBy(how = How.ID, using = "error")
    private WebElement errorMsg;

    public void enterName (String Name){
        nameText.clear();
        nameText.sendKeys();
    }
    public void enterAge (String Age){
        ageText.sendKeys();
    }
    public void clickOnSubmitBtn (){
        submitBtn.click();
    }
    public String getErrorMessage (){
       return errorMsg.getText();
    }
}
