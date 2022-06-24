package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClickPage extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(ClickPage.class);
    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy (css = "#badButton")
    private WebElement blueDOMButton;

    public ClickPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void clickLogo(){
        click(logo);
        LOG.info("Page Logo click successful");
    }
    public void clickHome(){
        click(home);
        LOG.info("Home button click successful");
    }
    public void clickResources(){
        click(resources);
        LOG.info("Resources link click successful");
    }
    public void clickDOM(){
        click(blueDOMButton);
        LOG.info("Button click successful");
    }
    public boolean checkDOMClickable() {
        LOG.info("DOM button is clickable successful");
        return checkEnabled(blueDOMButton);
    }
}
