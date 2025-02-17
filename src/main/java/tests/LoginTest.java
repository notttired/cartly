package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        // Add login test logic
    }
}
