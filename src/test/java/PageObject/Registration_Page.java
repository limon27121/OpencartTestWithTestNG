package PageObject;

import TestClasses.Base_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class Registration_Page extends Base_Page {
    public static Base_Class.RandomUtils RandomUtils;
    WebDriver driver;

    //---- -----constructor -------------
    public Registration_Page(WebDriver driver) {
        super(driver);

    }

    //locators

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement first_name;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement last_name;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement password_confirmation;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continue_button;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement account_msg;

    //--------Actions Methods----------

    public void fillup_personal_information(String f_name, String l_name, String email_add, String phone, String password1) {
        first_name.sendKeys(f_name);
        last_name.sendKeys(l_name);
        email.sendKeys(email_add);
        telephone.sendKeys(phone);
        password.sendKeys(password1);
        password_confirmation.sendKeys(password1);
        agree.click();
        continue_button.click();
    }

    public String msg() {
        try {
            return account_msg.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}