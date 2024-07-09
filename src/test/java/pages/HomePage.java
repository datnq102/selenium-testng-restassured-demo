package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By profileLink = By.cssSelector(("a#profileDropdown"));
    By challengesDropdown = By.cssSelector("li.dropdown a[data-toggle='dropdown']");
    String challengeOption = "//a[@class='dropdown-item' and contains(text(),'%s')]";
    By logoutLink = By.cssSelector("a[href='/user/logout']");
    By toastMessage = By.cssSelector("div#toast-container strong.mr-auto");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProfileDisplayed() {
        return driver.findElement(profileLink).isDisplayed();
    }

    public void gotoChallengeOption(String optionText){
        driver.findElement(challengesDropdown).click();
        driver.findElement(By.xpath(String.format(challengeOption, optionText))).click();
    }

    public void logout() {
        driver.findElement(profileLink).click();
        driver.findElement(logoutLink).click();
    }

    public String toastMessage() {
        return driver.findElement(toastMessage).getText().trim();
    }
}
