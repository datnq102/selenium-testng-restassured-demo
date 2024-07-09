package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class E2ETest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void testTheWholeFlow(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(homePage.isProfileDisplayed());
        createChallengePage.createChallenge(challengeTitle, challengeFlag, challengeDescription, challengeSolution);
        Assert.assertTrue(myChallengePage.isChallengeDisplayed(challengeTitle));
        homePage.logout();
        Assert.assertEquals(homePage.toastMessage(), "Successfully logged out");
    }

}

