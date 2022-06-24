package uitappages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DynamicTablePage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(DynamicTablePage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//p[contains(text(),'Chrome CPU:')]")
    private WebElement valueChromeCPU;

    public DynamicTablePage(WebDriver driver) {
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

    public void tableData(){
        List <WebElement> col = getDriver().findElements(By.xpath("//span[contains(text(),'Name')]"));
        System.out.println("Total number of columns are " + col.size());
    }

    public String readChromeValue(){
        String actualText = valueChromeCPU.getText();
        LOG.info(actualText + " is the load value");
        return actualText;
    }

}
