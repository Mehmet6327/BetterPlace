package betterPlace.pages;

import betterPlace.utilities.ConfigurationReader;
import betterPlace.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BetterDonatePage extends BasePage{

    @FindBy(id = "user_email")
    public WebElement userEmail;

    @FindBy(xpath = "//button[text()='Okay!']")
    public WebElement popUpButton;

    @FindBy(className = "header-login-label")
    public WebElement loginButton;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(id = "login")
    public  WebElement submitButton;

    @FindBy(xpath = "//div[@class='max-w-container mx-auto']")
    public WebElement successMessage;


    public void clickPopUp(){
       try {
           popUpButton.click();
       }catch (Exception e){

       }
    }

    public  void clickLoginButton(){
      loginButton.click();
    }

    public void login(){
        userEmail.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        submitButton.click();
    }

    public String getSuccessMessageText(){
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }


}

