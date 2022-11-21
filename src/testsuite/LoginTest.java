package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"), "Admin");
        sendTextToElement(By.name("password"), "admin123");
        clickOnElement(By.xpath("//button[contains(@class,'oxd-button oxd-button--medium')]"));

        //this is expected from our requirment
        String expectedTextMessage = "Dashboard";

        //find the welcome text elements and get text
        String actualmessage = getTextFromElement(By.xpath("//h6[contains(@class,'oxd-text oxd-text--h6')]"));

        //Validate Actual and expected text
        Assert.assertEquals(expectedTextMessage, actualmessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
