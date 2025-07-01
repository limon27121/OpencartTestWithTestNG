package TestClasses;

import PageObject.Base_Page;
import PageObject.Home_Page;
import PageObject.Registration_Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class TC001_Registration_Page extends  Base_Class{

//test methods
    @Test
    public void verify_Account() {
        Home_Page hp = new Home_Page(driver);
        hp.Click_MyAccount();
        hp.Click_Registration();
        Registration_Page rg = new Registration_Page(driver);
        rg.fillup_personal_information("limon", "alam", Registration_Page.RandomUtils.randomString(5), "01623692274", "27121");
        String text = rg.msg();
        //assertion
        Assert.assertEquals(text,"Your Account Has Been Created!");
    }




    }

