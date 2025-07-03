package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_Page extends Base_Page{

    //constructor
    WebDriver driver;
    public MyAccount_Page(WebDriver driver) {
        super(driver);
    }

    //locators
    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement My_account_text;


    //action methods

    public boolean my_account_page(){
        try {
            return  My_account_text.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

}
