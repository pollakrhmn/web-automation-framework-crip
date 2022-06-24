package uitaptests;

import base.CommonAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.*;

public class ExistingElement extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(ExistingElement.class);

    @Test //T22 Verify text on loaded label after pressing "Button Triggering AJAX Request"
    public void AJAXButtonText() {
        HomePage home = new HomePage(getDriver());
        home.clickAjaxData();
        AjaxPage autoPage = new AjaxPage(getDriver());
        autoPage.clickAjaxButton();
        waitFor(20);
        Assert.assertTrue(autoPage.checkAjaxText());
    }

    @Test
    //T30 Verify that clicking on "Button Triggering Client Side Logic" results in a wait-time followed by new text element on screen.
    public void verifyWaitForText() {
        HomePage home = new HomePage(getDriver());
        home.clickClientSideDelay();
        ClientDelayPage autoPage = new ClientDelayPage(getDriver());
        autoPage.clickButtonTriggering();
        waitFor(20);
        String actualTxt = getElementText("body:nth-child(2) section:nth-child(2) div.container div:nth-child(8) > p.bg-success");
        LOG.info(actualTxt + "is expected");
        String expectedResult = "Data calculated on the client side.";
        Assert.assertEquals(actualTxt, expectedResult);
        LOG.info("Text match successful");
    }

    @Test //T37 Verify text element on webpage should read "Welcome UserName!"
    public void verifyWelcomeText() {
        HomePage home = new HomePage(getDriver());
        home.clickVerifyText();
        VerifyTextPage autoPage = new VerifyTextPage(getDriver());
        Assert.assertTrue(autoPage.checkTextDisplayed());
    }

    @Test //T39 Verify "Load Delay" Header Text
    public void verifyLoadDelHeader() {
        HomePage home = new HomePage(getDriver());
        home.clickLoadDelay();
        LoadDelayPage autoPage = new LoadDelayPage(getDriver());
        String expectedHeader = "Load Delays";
        Assert.assertEquals(expectedHeader, getElementText("body:nth-child(2) section:nth-child(2) div.container > h3:nth-child(1)"));
        LOG.info("Load Delays Webpage header match with Expected successful");
    }

    @Test //T45 Verify the image of Rubiks Cube is available from source
    public void verifyRubiksImage() {
        HomePage autoPage = new HomePage(getDriver());
        LOG.info("Loading Homepage successful");
        Assert.assertTrue(autoPage.checkRubikImg());
    }

}


//    @Test //T47 Verify cell data under Name column on Dynamic Table webpage
//    public void NameColumnData() {
//        HomePage home = new HomePage(getDriver());
//        home.clickDynamicTable();
//        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
//        autoPage.tableData();
//    }
//
//    @Test //T48 Verify cell data under CPU column on Dynamic Table webpage
//    public void CPUColumnData() {
//        HomePage home = new HomePage(getDriver());
//        home.clickDynamicTable();
//        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
//    }
//
//    @Test //T49 Verify specific cell data on Dynamic Table webpage
//    public void ChromeMemoryData() {
//        HomePage home = new HomePage(getDriver());
//        home.clickDynamicTable();
//        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
//    }
//
//    @Test //T50 Verify specific cell data on Dynamic Table webpage
//    public void FireFoxMemoryData() {
//        HomePage home = new HomePage(getDriver());
//        home.clickDynamicTable();
//        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
//    }
//
//    @Test //T51 Verify specific cell data on Dynamic Table webpage
//    public void SystemMemoryData() {
//        HomePage home = new HomePage(getDriver());
//        home.clickDynamicTable();
//        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
//    }
//
//    @Test //T52 Verify specific cell data on Dynamic Table webpage
//    public void IEMemoryData() {
//        HomePage home = new HomePage(getDriver());
//        home.clickDynamicTable();
//        DynamicTablePage autoPage = new DynamicTablePage(getDriver());
//    }
//
//    @Test //T76 Verify multiple random GUID generators
//    public void multipleGUIDs() {
//        HomePage home = new HomePage(getDriver());
//        home.clickShadowDOM();
//        ShadowDOMPage autoPage = new ShadowDOMPage(getDriver());
//        autoPage.clickGUIDGenerator();
//        autoPage.clickCopy();
//        autoPage.readGeneratedGUID();
//    }