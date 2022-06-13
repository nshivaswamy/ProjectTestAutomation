package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
    WebDriver driver;
    @FindBy(xpath = "//h3")
    private WebElement DashboardPageHeader;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement HomeLink;

    @FindBy(xpath = "//a[normalize-space()='Login/Signup']")
    private WebElement LoginSignup;

    @FindBy(name = "source")
    private WebElement SrcSelector;

    @FindBy(name = "destination")
    private WebElement DestSelector;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement SubmitButton;

    @FindBy(xpath = "//a[normalize-space()='Book Flight']")
    private WebElement BookFlightLink;

    // Open the Home Page of the FlyAway
    public DashBoardPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver;
    }
    
    public String GetHeading() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(DashboardPageHeader));
        System.out.println("Dashboard Page Heading is : " + DashboardPageHeader.getText());
        return DashboardPageHeader.getText();
	}


}
