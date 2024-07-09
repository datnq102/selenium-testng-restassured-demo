package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void testLogin(String username, String password){
        loginPage.login(username, password);
        Assert.assertTrue(homePage.isProfileDisplayed());
    }

}
