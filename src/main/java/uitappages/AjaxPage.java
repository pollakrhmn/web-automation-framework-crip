package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjaxPage extends CommonAPI {

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#ajaxButton")
    private WebElement ajaxButton;

    public AjaxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void clickLogo(){ click(logo); }
    public void clickHome(){
        click(home);
    }
    public void clickResources(){
        click(resources);
    }
    public void clickAjaxButton(){ click(ajaxButton); }


}