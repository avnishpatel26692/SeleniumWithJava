package selenium.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class Page {
    public String getText(WebElement element) {
        return element.getText();
    }

    public WebElement getSelectedOption(WebElement select) {
        return getSelector(select).getFirstSelectedOption();
    }

    protected Select getSelector(WebElement element) {
        return new Select(element);
    }

    public String getBackgroundColor(WebElement element){
        return element.getCssValue("background-color");
    }

    public String getColor(WebElement element){
        return element.getCssValue("color");
    }
}
