package tests.ui;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateChallengePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyChallengePage;

public class BaseTest {
    Faker faker = new Faker();
    String challengeTitle = "Challenge Number #" + faker.number().randomNumber();
    String challengeFlag = "CTFlearn{something-here}";
    String challengeDescription = "This is the challenge description";
    String challengeSolution = "This is the solution for the challenge";

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CreateChallengePage createChallengePage;
    MyChallengePage myChallengePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ctflearn.com/user/login");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        createChallengePage = new CreateChallengePage(driver);
        myChallengePage = new MyChallengePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
