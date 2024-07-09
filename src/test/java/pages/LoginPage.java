package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By username = By.id("identifier");
    By password = By.id("password");
    By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}
