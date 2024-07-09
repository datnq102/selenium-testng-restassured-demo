package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateChallengePage extends HomePage {
    WebDriver driver;

    By challengeTitle = By.cssSelector("input#title");
    By challengeFlag = By.cssSelector(("input#flag"));
    By challengeDescription = By.cssSelector("textarea#flask-pagedown-description");
    By challengeSolution = By.cssSelector("textarea#howtosolve");
    By submitButton = By.cssSelector("button[type='submit']");
    By invalidFlagError = By.xpath("//input[@id='flag']/following-sibling::div");

    public CreateChallengePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void createChallenge(String title, String flag, String description, String solution){
        gotoChallengeOption("Create Challenge");

        driver.findElement(challengeTitle).clear();
        driver.findElement(challengeTitle).sendKeys(title);
        driver.findElement(challengeFlag).sendKeys(flag);
        driver.findElement(challengeDescription).clear();
        driver.findElement(challengeDescription).sendKeys(description);
        driver.findElement(challengeSolution).sendKeys(solution);

        driver.findElement(submitButton).click();
    }

    public boolean isInvalidFlagDisplayed() {
        return driver.findElement(invalidFlagError).isDisplayed();
    }
}

