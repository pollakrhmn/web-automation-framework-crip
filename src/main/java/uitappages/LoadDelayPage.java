package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadDelayPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(LoadDelayPage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy (css = "body:nth-child(2) section:nth-child(2) div.container > h3:nth-child(1)")
    private WebElement headerTxt;

    @FindBy (css = "body:nth-child(2) section:nth-child(2) div.container > button.btn.btn-primary:nth-child(6)")
    private WebElement buttonAfterDelay;

    public LoadDelayPage(WebDriver driver){
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
    public void clickButtonAppearing(){
        click(buttonAfterDelay);
        LOG.info("Start button clickable successful");
    }
    public boolean checkButtonAfterDelay(){
        if (checkDisplayed(buttonAfterDelay)){
            LOG.info("'button after delay' clickable successful");
        };
        return checkEnabled(buttonAfterDelay);
    }

}
