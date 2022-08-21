package TestCases;

import Common.BaseTest;
import Pages.DashboardPage;
import Pages.LogInPage;
import Utils.WebUI;import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ProjectTest extends BaseTest{
    //private WebDriver driver; Nen nho la trong Test chi dung dung 1 cai driver cua BaseTest thoi. ko khai bao driver cho nay
    private LogInPage logInPage;
    private DashboardPage dashboardPage;
    @BeforeMethod
    public void setUpTest() {
        logInPage = new LogInPage(driver);
        new WebUI(driver);
        System.out.println("run here");
    }

    @Test
    void TestOpenProject() {
        dashboardPage = logInPage.LogIn("https://hrm.anhtester.com", "admin01", "123456");
        dashboardPage.openProject();
        /*
        1. Login
        2. Click Project in Dashboard Page
         */
        //Tao su lien ket trang thong qua viec gan dau = tu doi tuong trang = ham da lien ket. Khong can khoi tao trang dashboardPage = new DashboardPage(driver) nua

    }
}
