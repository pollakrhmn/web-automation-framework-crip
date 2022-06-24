package uitaptests;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.*;

public class PageRedirects extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(PageRedirects.class);

    @Test //T-12
    public void scrollbarsToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickScrollBars();
        ScrollbarsPage autoPage = new ScrollbarsPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-11
    public void dynamicIDToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickDynamicId();
        DynamicIDPage autoPage = new DynamicIDPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-10
    public void ajaxToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickAjaxData();
        AjaxPage autoPage = new AjaxPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-9
    public void visibilityToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-8
    public void overlappedToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickOverlappedElement();
        OverlappedElementPage autoPage = new OverlappedElementPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-7
    public void classAttributeToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickClassAttribute();
        ClassAttributePage autoPage = new ClassAttributePage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-6
    public void clientSideToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickClientSideDelay();
        ClientDelayPage autoPage = new ClientDelayPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-5
    public void dynamicTableToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickDynamicTable();
        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-4
    public void sampleAppToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickSampleApp();
        SampleAppPage autoPage = new SampleAppPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-3
    public void hiddenLayersToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickHiddenLayers();
        HiddenLayersPage autoPage = new HiddenLayersPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-2
    public void mouseOverToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickMouseOver();
        MouseOverPage autoPage = new MouseOverPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

    @Test //T-1
    public void textInputToHome() {
        HomePage home = new HomePage(getDriver());
        home.clickTextInput();
        TextInputPage autoPage = new TextInputPage(getDriver());
        autoPage.clickHome();
        String expectedUrlLink = "http://uitestingplayground.com/home";
        Assert.assertEquals(expectedUrlLink, getUrlLink());
        LOG.info("Webpage match successful");
    }

}
