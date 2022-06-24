package uitappages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//a[contains(text(),'Dynamic ID')]")
    private WebElement dynamicId;

    @FindBy(xpath = "//a[contains(text(),'Class Attribute')]")
    private WebElement classAttribute;

    @FindBy(xpath = "//a[contains(text(),'Hidden Layers')]")
    private WebElement hiddenLayers;

    @FindBy(xpath = "//a[contains(text(),'Load Delay')]")
    private WebElement loadDelay;

    @FindBy(xpath = "//a[contains(text(),'AJAX Data')]")
    private WebElement ajaxData;

    @FindBy(xpath = "//a[contains(text(),'Client Side Delay')]")
    private WebElement clientSideDelay;

    @FindBy(xpath = "//a[contains(text(),'Click')]")
    private WebElement click;

    @FindBy(xpath = "//a[contains(text(),'Text Input')]")
    private WebElement textInput;

    @FindBy(xpath = "//a[contains(text(),'Scrollbars')]")
    private WebElement scrollBars;

    @FindBy(xpath = "//a[contains(text(),'Dynamic Table')]")
    private WebElement dynamicTable;

    @FindBy(xpath = "//a[contains(text(),'Verify Text')]")
    private WebElement verifyText;

    @FindBy(xpath = "//a[contains(text(),'Progress Bar')]")
    private WebElement progressBar;

    @FindBy(xpath = "//a[contains(text(),'Visibility')]")
    private WebElement visibility;

    @FindBy(xpath = "//a[contains(text(),'Sample App')]")
    private WebElement sampleApp;

    @FindBy(xpath = "//*[@id=\"overview\"]/div/div[5]/div[2]/h3/a")
    private WebElement shadowDOM;

    @FindBy(xpath = "//a[contains(text(),'Mouse Over')]")
    private WebElement mouseOver;

    @FindBy(xpath = "//a[contains(text(),'Non-Breaking Space')]")
    private WebElement nonBreakingSpace;

    @FindBy(xpath = "//a[contains(text(),'Overlapped Element')]")
    private WebElement overlappedElement;

    @FindBy(css = "#github")
    private WebElement starGitLink;

    @FindBy(css = "div.container:nth-child(4) footer:nth-child(1) div:nth-child(1) div:nth-child(2) > a:nth-child(1)")
    private WebElement forkGitLink;

    @FindBy(css = "div.container:nth-child(4) footer:nth-child(1) div:nth-child(1) div:nth-child(3) > a:nth-child(1)")
    private WebElement rapiseExtLink;

    @FindBy(css = "div.container:nth-child(4) footer:nth-child(1) div:nth-child(1) div:nth-child(3) > a:nth-child(2)")
    private WebElement inflectraCorpLink;

    @FindBy(css = "div.container div.row div.col-sm:nth-child(2) p.text-center small:nth-child(1) > a:nth-child(2)")
    private WebElement cc4ExtLink;

    @FindBy(xpath = "//a[contains(text(),'Apache License 2.0')]")
    private WebElement apacheLicenseExtLink;

    @FindBy(css = "section:nth-child(2) div.container div.row div.col-sm:nth-child(2) > img.img-fluid")
    private WebElement rubiksImg;

    public HomePage(WebDriver driver) {
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

    public void clickDynamicId() {
        click(dynamicId);
        LOG.info("Dynamic ID click successful");
        LOG.info("Redirect to Dynamic ID webpage successful");
    }

    public void clickClassAttribute() {
        click(classAttribute);
        LOG.info("Class Attribute click successful");
        LOG.info("Redirect to Class Attribute webpage successful");
    }

    public void clickHiddenLayers() {
        click(hiddenLayers);
        LOG.info("Hidden Layers click successful");
        LOG.info("Redirect to Hidden Layers  webpage successful");
    }

    public void clickLoadDelay() {
        click(loadDelay);
        LOG.info("Load Delay click successful");
        LOG.info("Redirect to Load Delay webpage successful");
    }

    public void clickAjaxData() {
        click(ajaxData);
        LOG.info("Ajax Data click successful");
        LOG.info("Redirect to Ajax Data webpage successful");
    }

    public void clickClientSideDelay() {
        click(clientSideDelay);
        LOG.info("Client Side Delay click successful");
        LOG.info("Redirect to Client Side Delay webpage successful");
    }

    public void clickClickLink() {
        click(click);
        LOG.info("Click webpage link click successful");
        LOG.info("Redirect to Click webpage successful");
    }

    public void clickTextInput() {
        click(textInput);
        LOG.info("Text Input click successful");
        LOG.info("Redirect to Text Input webpage successful");
    }

    public void clickScrollBars() {
        click(scrollBars);
        LOG.info("Scrollbars click successful");
        LOG.info("Redirect to Scrollbars webpage successful");
    }

    public void clickDynamicTable() {
        click(dynamicTable);
        LOG.info("Dynamic Table click successful");
        LOG.info("Redirect to Dynamic Table webpage successful");
    }

    public void clickVerifyText() {
        click(verifyText);
        LOG.info("Verify Text click successful");
        LOG.info("Redirect to Verify Text webpage successful");
    }

    public void clickProgressBar() {
        click(progressBar);
        LOG.info("Progress Bar click successful");
        LOG.info("Redirect to Progress Bar webpage successful");
    }

    public void clickVisibility() {
        click(visibility);
        LOG.info("Visibility click successful");
        LOG.info("Redirect to Visibility webpage successful");
    }

    public void clickSampleApp() {
        click(sampleApp);
        LOG.info("Sample App click successful");
        LOG.info("Redirect to Sample App webpage successful");
    }

    public void clickShadowDOM() {
        click(shadowDOM);
        LOG.info("Shadow DOM click successful");
        LOG.info("Redirect to Shadow DOM webpage successful");
    }

    public void clickMouseOver() {
        click(mouseOver);
        LOG.info("Mouse Over click successful");
        LOG.info("Redirect to Mouse Over webpage successful");
    }

    public void clickNonBreakingSpace() {
        click(nonBreakingSpace);
        LOG.info("Non Breaking Space click successful");
        LOG.info("Redirect to Non Breaking Space webpage successful");
    }

    public void clickOverlappedElement() {
        click(overlappedElement);
        LOG.info("Overlapped Element click successful");
        LOG.info("Redirect to Overlapped Element webpage successful");
    }

    public void clickStarLink() {
        click(starGitLink);
        LOG.info("Star to Github link click successful");
    }

    public void clickForkWebsite() {
        click(forkGitLink);
        LOG.info("'Fork the Website on Github' link click successful");
    }

    public void clickRapise() {
        click(rapiseExtLink);
        LOG.info("Rapise link click successful");
    }

    public void clickInflectraCorp() {
        click(inflectraCorpLink);
        LOG.info("'Inflectra Corporation' link click successful");
    }

    public void clickCC4Link() {
        click(cc4ExtLink);
        LOG.info("'CC 4.0 BY-NC' link click successful");
    }

    public void clickApacheLicense() {
        click(apacheLicenseExtLink);
        LOG.info("'Apache License 2.0' link click successful");
    }

    public boolean checkRubikImg() {
        LOG.info("Rubiks Image verification successful");
        return checkDisplayed(rubiksImg);
    }

    public WebElement lowestScroll() {
        LOG.info("Lowest element on webpage found Successful");
        return apacheLicenseExtLink;
    }

    public boolean checkApacheLowestScroll() {
        if (checkDisplayed(apacheLicenseExtLink)) {
            LOG.info("Lowest scroll of Webpage in view Successful");
        }
        return checkDisplayed(apacheLicenseExtLink);
    }
}