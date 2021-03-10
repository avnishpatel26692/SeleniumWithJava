package selenium.sample;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPage {

@FindBy(how = How.ID, using = "name")
private WebElement yourName;

@FindBy(how = How.ID, using = "age")
    private WebElement yourAge;

@FindBy(how = How.ID, using = "language")
    private WebElement yourLanguage;

@FindBy(how = How.ID, using = "gender")
    private WebElement yourGenre;

@FindBy(how = How.ID, using = "option")
    private WebElement yourOption;

@FindBy(how = How.ID, using = "comment")
    private WebElement yourComment;

@FindBy(how = How.XPATH, using = "//button[text() = 'Yes']")
    private WebElement YesBtn;

@FindBy(how = How.XPATH, using = "//button[text() = 'No']")
    private WebElement NoBtn;

@FindBy(how = How.ID, using = "message")
    private WebElement message;

@FindBy(how = How.XPATH, using = "//div[contains(@class='w3-green')]")
    private WebElement messageBoxBox;

@FindBy(how = How.XPATH, using = "//div[contains(@class='w3-green')]")
    private WebElement messageBox;


    public void clickOnYesBtn(){

        YesBtn.click();
    }

    public void clickOnNoBtn(){

        NoBtn.click();
    }

    public void enterName (String name)
    {
        yourName.sendKeys(name);

    }
    public String getName() {

        return yourName.getText();
    }

    public String getAge() {

        return yourAge.getText();
    }

    public String getLanguage(){
        return yourLanguage.getText();
    }

    public String getGender(){
        return yourGenre.getText();
    }

    public String getOption(){
        return yourOption.getText();
    }

    public String getComment(){
        return yourComment.getText();
    }


    public String getYesButtonBackGroundColor()
    {
        return YesBtn.getCssValue("background-color");
    }

    public String getYesButtonTextColor()
    {
        return YesBtn.getCssValue("color");
    }
    public String getNoButtonBackGroundColor()
    {
        return NoBtn.getCssValue("background-color");
    }

    public String getNoButtonTextColor()
    {
        return NoBtn.getCssValue("color");
    }

    public String getMessage(){
        return message.getText();
    }


    public String getMessageTextColor()
    {
        return messageBox.getCssValue("color");
    }

    public String getMessageBoxColor()
    {
        return messageBox.getCssValue("color");
    }


}
