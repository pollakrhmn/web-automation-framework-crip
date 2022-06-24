package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextInputPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(TextInputPage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(css = "#newButtonName")
    private WebElement textBox;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#updatingButton")
    private WebElement textChangeButton;

    public TextInputPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLogo() {
        click(logo);
        LOG.info("Page Logo click successful");
    }

    public void clickHome() {
        click(home);
        LOG.info("Home button click successful");
    }

    public void clickResources() {
        click(resources);
        LOG.info("Resources link click successful");
    }

    public void typeInTextBox(String text) {
        textBox.clear();
        LOG.info("Text Box cleared to start typing into Successful");
        textBox.sendKeys(text);
        LOG.info(text + " ---input/typed-in successful");
    }

    public String getTextFromBox(){
        String actualText = textBox.getAttribute("value");
        LOG.info("Typed in text is now available for comparison");
        return actualText;
    }

    public void clickTextChangeButton() {
        click(textChangeButton);
        LOG.info("Text-changing button clicked successful");
    }

    public boolean checkButtonUsable() {
        if (checkEnabled(textChangeButton) && checkDisplayed(textChangeButton))
            LOG.info("Button visible successful");
            LOG.info("Button clickable successful");
        return checkEnabled(textChangeButton);
    }

    public String getTextFromButton() {
        String actualText = textChangeButton.getText();
        LOG.info("Button text is now available for comparison successfully");
        return actualText;
    }

}
