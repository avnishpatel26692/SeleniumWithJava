package selenium.sample.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedbackSubmittedPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameIs;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageIs;

    @FindBy(how = How.ID, using = "language")
    private WebElement languagesAre;

    @FindBy(how = How.ID, using = "gender")
    private WebElement genderIs;

    @FindBy(how = How.ID, using = "option")
    private WebElement opinionIs;

    @FindBy(how = How.ID, using = "comment")
    private WebElement commentIs;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[1]")
    private WebElement yesBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[2]")
    private WebElement noBtn;

    @FindBy(how = How.ID, using = "message")
    private WebElement msg;

    @FindBy(how = How.XPATH, using="//*[@id='fb_thx']/div/div[2]")
    private WebElement btnDiv;

    public String getName()
    {
        return  nameIs.getText();
    }

    public String getAge()
    {
        return ageIs.getText();
    }

    public String getLang(){
        return languagesAre.getText();
    }
    public String getGender() {
        return genderIs.getText();
    }
    public String getOpinion(){
        return opinionIs.getText();
    }
    public String getComment(){
        return commentIs.getText();
    }
    public void pressYes(){
        yesBtn.click();
    }
    public void pressNo(){
        noBtn.click();
    }
    public String getMsg(){
        return msg.getText();
    }
    public String getMsgBgColor(){
        return msg.getCssValue("background-color");
    }
    public String getMsgTxtColor(){
        return msg.getCssValue("color");
    }
    public String getBtnTextColor(){
        return btnDiv.getCssValue("color");
    }
    public String getYesBgColor(){
        return yesBtn.getCssValue("background-color");
    }
    public String getNoBgColor(){
        return noBtn.getCssValue("background-color");
    }
}
