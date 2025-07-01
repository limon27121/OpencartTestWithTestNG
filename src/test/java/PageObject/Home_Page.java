package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Page {
    WebDriver driver;
    //constructor
    public Home_Page(WebDriver driver){
        super(driver);

    }

    //locators


    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement link_my_account;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement link_registration;

    //Action_Methods

    public void Click_MyAccount(){
        link_my_account.click();
    }

    public void Click_Registration(){
        link_registration.click();
    }


}
