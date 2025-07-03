package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends  Base_Page {
  WebDriver driver;

  //constructor
    public Login_Page(WebDriver driver) {
        super(driver);
    }


    //locators

    @FindBy(xpath="//input[@id='input-email']")
    WebElement link_email_add;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement link_password;

    @FindBy(xpath="//input[@value='Login']")
    WebElement login_button;

    //action methods
    public void email_add(String email){
        link_email_add.sendKeys(email);
    }

    public void password(String password){
        link_password.sendKeys(password);
    }

    public void login(){
        login_button.click();
    }


}
