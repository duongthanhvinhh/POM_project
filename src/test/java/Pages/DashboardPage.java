package Pages;

import Utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        //new LogInPage(driver);
        new WebUI(driver);
    }
    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public void openProject(){
        WebUI.clickElement(menuProject);
    }
    public void openTasks(){
        WebUI.clickElement(menuTasks);

    }
}
