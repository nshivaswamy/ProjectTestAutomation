package com.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;

public class FlyAwayTest {
	
	static WebDriver driver;
    public static HomePage homepg;

    @BeforeClass
    @BeforeSuite
    private static void startBrowser() throws InterruptedException {

            System.out.println(System.getProperty("user.dir"));
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                    System.out.println("Executing in " + os + ". Starting Driver");
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");

            }

            driver = new ChromeDriver();
//          Thread.sleep(2000);
    }
    
    @Test
    private void CheckHomePageHeading() {
    	String homePgHeading = "FLYAWAY HOMEPAGE";
    	
        homepg = new HomePage(driver);        ;
        Assert.assertEquals(homepg.GetHeading(), homePgHeading);
	}
    
    @Test(dependsOnMethods = { "CheckHomePageHeading" })
    private void SearchAndBookNoLogin() throws InterruptedException {
            homepg.EnterSource("Bangalore");
            homepg.EnterDestination("Hyderabad");
            homepg.ClickSubmit();
            homepg.ClickBookFlight();
            homepg.CheckForError();
    }

    @Test(dependsOnMethods = { "SearchAndBookNoLogin" })
    private void LoginUsingValidDetails() throws InterruptedException {
            homepg.clickLoginSignUp();
            LoginPage logPage = new LoginPage(driver);

            logPage.loginActivity("1@1.com","1");
            logPage.clickHome();
    }

    @Test(dependsOnMethods = { "LoginUsingValidDetails" })
    private void SearchAndBookWithLogin1() throws InterruptedException {
            homepg.EnterSource("Bangalore");
            homepg.EnterDestination("Chennai");
            homepg.ClickSubmit();
            homepg.ClickBookFlight();
            homepg.CheckForNoError();
    }

    @Test(dependsOnMethods = { "SearchAndBookWithLogin1" })
    private void SearchAndBookWithLogin2() throws InterruptedException {
            homepg.clickHome();
            homepg.EnterSource("Bangalore");
            homepg.EnterDestination("Hyderabad");
            homepg.ClickSubmit();
            homepg.ClickBookFlight();
            homepg.CheckForNoError();
    }

    @AfterClass
    private static void closeBrowser() {

            System.out.println("Done");
            driver.quit();
    }
}
