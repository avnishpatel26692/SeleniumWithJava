package selenium.sample.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.util.List;

public class FeedBackPage  {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameBack;

    @FindBy(how = How.ID, using = "age")
    private WebElement ageBack;

    // Checkbox as a list
    @FindBy(how = How.ID, using = "language")
    private WebElement language;

    //RadioBtn
    @FindBy(how = How.ID, using = "gender")
    private WebElement gender;

    //Dropdown
    @FindBy(how = How.ID, using = "option")
    private WebElement opinionBack;

    //Comment
    @FindBy(how = How.ID, using = "comment")
    private WebElement commentBack;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[1]")
    private WebElement yesBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[2]")
    private WebElement noBtn;

    @FindBy(how = How.ID, using = "message")
    private WebElement message;

    @FindBy(how = How.XPATH, using="//*[@id='fb_thx']/div/div[2]")
    private WebElement buttonDiv;

    @FindBy(how = How.XPATH, using = "//button[text() = 'No']")
    private WebElement NoBtn;


    public String getName()
    {
        return  nameBack.getText();
    }


    public String getAge()
    {
        return ageBack.getText();
    }

    public String getLang(){
        return language.getText();
    }
    public String getGender(){
        return gender.getText();
    }
    public String getOption(){
        return opinionBack.getText();
    }
    public String getComment(){
        return commentBack.getText();
    }

    public void pressYes(){
        yesBtn.click();
    }
    public void pressNo(){
        noBtn.click();
    }
    public String getMsg(){
        return message.getText();
    }
    public String getMsgBgColor(){
        return message.getCssValue("background-color");
    }
    public String getMsgTxtColor(){
        return message.getCssValue("color");
    }
    public String getBtnTextColor(){
        return buttonDiv.getCssValue("color");
    }
    public String getYesBgColor(){
        return yesBtn.getCssValue("background-color");
    }
    public String getNoBgColor(){
        return noBtn.getCssValue("background-color");
    }

}