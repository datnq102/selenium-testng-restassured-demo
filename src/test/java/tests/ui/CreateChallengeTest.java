package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateChallengeTest extends BaseTest {

    @Test
    @Parameters({"username", "password"})
    public void testCreateChallenge(String username, String password) {
        loginPage.login(username, password);
        createChallengePage.createChallenge(challengeTitle, challengeFlag, challengeDescription, challengeSolution);
        Assert.assertTrue(myChallengePage.isChallengeDisplayed(challengeTitle));
    }

    @Test
    @Parameters({"username", "password"})
    public void testCreateChallengeWithInvalidFlag(String username, String password) {
        loginPage.login(username, password);
        createChallengePage.createChallenge(challengeTitle, "invalid-flag", challengeDescription, challengeSolution);
        Assert.assertTrue(createChallengePage.isInvalidFlagDisplayed());
    }

}

