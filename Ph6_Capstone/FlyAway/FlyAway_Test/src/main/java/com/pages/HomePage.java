package com.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
        WebDriver driver;
        String URL = "http://localhost:8080/FlyAway/home";

        @FindBy(xpath = "//h3")
        private WebElement HomePageHeader;

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
        public HomePage(WebDriver driver) {
                PageFactory.initElements(driver, this);
                this.driver = driver;
                driver.get(URL);
        }
        
        public String GetHeading() {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(HomePageHeader));
            System.out.println("Home Page Heading is : " + HomePageHeader.getText());
            return HomePageHeader.getText();
		}


        public void EnterSource(String Source){
                Select srcSelect = new Select(SrcSelector);
                srcSelect.selectByVisibleText(Source);

                System.out.println("Selected Source : " + Source);

        }

        public void EnterDestination(String Destination){
                Select destSelect = new Select(DestSelector);
                destSelect.selectByVisibleText(Destination);

                System.out.println("Selected Destination : " + Destination);

        }

        public void ClickSubmit(){
                SubmitButton.click();
                System.out.println("Clicked Submit Button");
        }

        public void ClickBookFlight() {
                BookFlightLink.click();
                System.out.println("Clicked Book Flight Link for selected Flight");
        }

        public void CheckForError() {

                String ErrorLoginText = "Error, You need to login before booking a flight";

                boolean isTheTextPresent = driver.getPageSource().contains(ErrorLoginText);
                assertTrue(isTheTextPresent);

                System.out.println(ErrorLoginText + " - Message is Shown");

        }


        public void CheckForNoError() {

                String ConfirmationText = "Your card will be charged an amount of ";

                boolean isTheTextPresent = driver.getPageSource().contains(ConfirmationText );
                assertTrue(isTheTextPresent);

                System.out.println(ConfirmationText + " - Message is Shown");

        }



        public void clickHome() {
                HomeLink.click();
                System.out.println("Clicked Home Link ");
        }

        public void clickLoginSignUp() {
                LoginSignup.click();
                System.out.println("Clicked Login/Signup Link ");
        }


}
