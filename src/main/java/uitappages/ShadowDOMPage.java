package uitappages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShadowDOMPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(ShadowDOMPage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(tagName = "button")
    private WebElement guidGeneratorLink;

    @FindBy(xpath = "//*[@id=\"buttonCopy\"]/i")
    private WebElement copyLink;


    public ShadowDOMPage(WebDriver driver) {
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

    public void clickGUIDGenerator() {
        click(guidGeneratorLink);
        LOG.info("GUID Generator click successful");
    }

    public void clickCopy() {
        click(copyLink);
        LOG.info("Copy button click successful");
    }

//    public String readGeneratedGUID() {
//        String generatedGUID = guidText.getAttribute("generated");
//        System.out.println(generatedGUID);
//        return generatedGUID;
//    }

    public void typeInGUIDTextBox(String textInput) {
        WebElement shadowHost = getDriver().findElement(By.cssSelector("#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement guidText = shadowRoot.findElement(By.cssSelector("input.edit-field[id='edit-field']"));
        guidText.sendKeys(textInput);
        LOG.info(textInput + "typed into GUID textbox successful");
    }

}
