package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiddenLayersPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(HiddenLayersPage.class);
    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy (css = "#greenButton")
    private WebElement greenButton;

    @FindBy (css = "#blueButton")
    private WebElement blueButton;

    public HiddenLayersPage(WebDriver driver){
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

    public void clickBothButtons(){
        click(greenButton);
        LOG.info("Green button click successful");
        click(blueButton);
        LOG.info("Blue button click successful");
    }
    public boolean checkGreenClickable() {
        LOG.info("Green button is clickable successful");
        return checkEnabled(greenButton);
    }

    public boolean checkBlueClickable() {
        LOG.info("Blue button is clickable successful");
        return checkEnabled(blueButton);
    }
}
