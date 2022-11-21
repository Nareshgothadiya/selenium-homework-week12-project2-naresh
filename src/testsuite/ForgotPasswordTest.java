package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class ForgotPasswordTest extends Utility {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        clickOnElement(By.xpath("//p[text()='Forgot your password? ']"));

        //this is expected from our requirment
        String expectedTextMessage = "Reset Password";

        //find the welcome text elements and get text
        String actualmessage = getTextFromElement(By.xpath("(//button[contains(@class,'oxd-button oxd-button--large')])[2]"));

        //Validate Actual and expected text
        Assert.assertEquals(expectedTextMessage, actualmessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
