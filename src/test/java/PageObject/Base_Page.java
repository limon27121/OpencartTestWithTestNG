package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Page {

    WebDriver driver;
    public Base_Page(WebDriver driver){
        this.driver=driver;
        //mandatory for page factory approach
        PageFactory.initElements(driver,this);
    }
}
