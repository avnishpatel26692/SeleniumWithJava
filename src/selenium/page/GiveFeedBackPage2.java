package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPage2 {
    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "age")
    private WebElement age;

    @FindBy(how = How.ID, using = "language")
    private WebElement languages;

    @FindBy(how = How.ID, using = "gender")
    private WebElement gender;

    @FindBy(how = How.ID, using = "option")
    private WebElement opinion;

    @FindBy(how = How.ID, using = "comment")
    private WebElement comment;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[1]")
    private WebElement yesBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[2]")
    private WebElement noBtn;

    @FindBy(how = How.ID, using = "message")
    private WebElement message;




    public String getName()
    {
        return  name.getText();
    }


    public String getAge()
    {
        return age.getText();
    }


    public String getLang(){
        return languages.getText();
    }


    public String getGender(){
        return gender.getText();
    }


    public String getOpinion(){
        return opinion.getText();
    }


    public String getComment(){
        return comment.getText();
    }



    public void pressYes(){
        yesBtn.click();
    }


    public void pressNo(){
        noBtn.click();
    }


    public String getMessage(){
        return message.getText();
    }


    public String getMessageBgColor(){
        return message.getCssValue("background-color");
    }


    public String getMessageTxtColor(){
        return message.getCssValue("color");
    }


    public String getYesBgColor(){
        return yesBtn.getCssValue("background-color");
    }
    public String getNoBgColor(){
        return noBtn.getCssValue("background-color");

}

