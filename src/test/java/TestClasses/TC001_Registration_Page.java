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
        logger.info("------- starting registration page test case");
        try {
            Home_Page hp = new Home_Page(driver);
            hp.Click_MyAccount();
            logger.info("click on My account");
            hp.Click_Registration();
            logger.info("click on registration link ");
            Registration_Page rg = new Registration_Page(driver);
            logger.info("provide personal information");
            rg.fillup_personal_information("limon", "alam", Registration_Page.RandomUtils.randomString(5), "01623692274", "27121");
            logger.info("valided expected message");
            String text = rg.msg();
            if (text.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else {
                logger.error("test failed");
                logger.debug("debug logs....");
                Assert.assertTrue(false);
            }

        }
        catch (Exception e){
             Assert.fail();
        }
        logger.info("------- Finished registration page test case");
    }

    }

