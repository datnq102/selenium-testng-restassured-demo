package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyChallengePage extends HomePage {
    WebDriver driver;

    By myChallengeTitles = By.cssSelector("div.card-header > span");

    public MyChallengePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean isChallengeDisplayed(String challengeTitle){
        gotoChallengeOption("My");
        List<WebElement> challenges = driver.findElements(myChallengeTitles);
        for(WebElement challenge : challenges){
            if(challenge.getText().equals(challengeTitle)){
                return true;
            }
        }
        return false;
    }
}

