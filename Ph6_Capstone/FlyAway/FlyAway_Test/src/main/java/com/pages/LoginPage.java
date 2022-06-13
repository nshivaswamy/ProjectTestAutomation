package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

        WebDriver driver;

        @FindBy(xpath = "//input[@name='email_id']")
        private WebElement emailIDTextBox;

        @FindBy(xpath = "//h3[normalize-space()='FLYAWAY - DASHBOARD']")
        private WebElement FlyAwayDashBoardPresent;

        @FindBy(xpath = "//input[@name='pwd']")
        private WebElement passwordTextBox;

        @FindBy(xpath = "//button[normalize-space()='Login']")
        private WebElement submitButton;

        @FindBy(xpath = "//a[normalize-space()='Home']")
        private WebElement HomeLink;


        public LoginPage(WebDriver driver) {
                PageFactory.initElements(driver, this);
                this.driver = driver;
        }

        public void loginActivity(String uname, String pwd) throws InterruptedException {
                emailIDTextBox.sendKeys(uname);
                passwordTextBox.sendKeys(pwd);
                submitButton.click();

                WebDriverWait wait = new WebDriverWait(driver, 30);
                wait.until(ExpectedConditions.visibilityOf(FlyAwayDashBoardPresent));

                System.out.println("Fly Away DashBoard Present");

        }

        public void clickHome() {
                HomeLink.click();
                System.out.println("Clicked Home Link ");
        }


}
