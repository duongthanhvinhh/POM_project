package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utils.WebUI;

public class LogInPage {


    public LogInPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khoi tao gia tri cho class WebUI
    }

    //Sign In
    private String pageText = "Welcome to HRM system";
    private By inputEmail = By.id("iusername");
    private By inputPassword = By.id("ipassword");
    private By buttonSignIn = By.className("ladda-label");
    private WebDriver driver;

    //Forgot Password

    private By linkForgotPassword = By.xpath("//span[normalize-space()='Forgot password?']");
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmailForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.className("ladda-label");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");
    private By alertMessageResetPassword = By.xpath("//div[@class='toast-message']");
    public DashboardPage LogIn(String URL,String email,String password) {
        WebUI.navigateToURL(URL);
        WebUI.setTexts(inputEmail, email);
        WebUI.setTexts(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        return new DashboardPage(driver);
    }

    public void LogInInvalidEmail(String URL, String email, String password) {
        WebUI.navigateToURL(URL);
        WebUI.setTexts(inputEmail, email);
        WebUI.setTexts(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        //Add assert
    }

    public void LogInInvalidPassword(String URL, String email, String password) {
        WebUI.navigateToURL(URL);
        WebUI.setTexts(inputEmail, email);
        WebUI.setTexts(inputPassword, password);
        WebUI.clickElement(buttonSignIn);
        //Add assert
    }

    public void resetPassword(String URL, String emailForgot) {
        WebUI.navigateToURL(URL);
        WebUI.clickElement(linkForgotPassword);
        Assert.assertEquals(WebUI.getElementTexts(pageTextForgotPassword), "Reset your password");
        WebUI.setTexts(inputEmailForgotPassword, emailForgot);
        WebUI.clickElement(buttonReset);
        Assert.assertEquals(WebUI.getElementTexts(alertMessageResetPassword), "Main.xin_error_msg__available");
        WebUI.clickElement(linkClickHere);
    }


}
