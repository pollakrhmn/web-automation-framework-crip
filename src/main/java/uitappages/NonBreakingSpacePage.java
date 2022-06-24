package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonBreakingSpacePage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(NonBreakingSpacePage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy (css = "body:nth-child(2) section:nth-child(2) div.container > button.btn.btn-primary:nth-child(6)")
    private WebElement myButton;

    public NonBreakingSpacePage(WebDriver driver){
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
    public void clickMyButton(){
        click(myButton);
        LOG.info("'My Button' button click successful");
    }
    public boolean checkMyButton(){
        if (checkDisplayed(myButton)){
            LOG.info("Start button clickable successful");
        };
        return checkEnabled(myButton);
    }
}