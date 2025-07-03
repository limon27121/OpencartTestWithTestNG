package TestClasses;

import PageObject.Home_Page;
import PageObject.Login_Page;
import PageObject.MyAccount_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class TC002_LogIn_Page extends Base_Class{

    @Test
    public void Verify_Log_in(){
        logger.info("----starting TC002 log in test ");
        try {
            //home page
            Home_Page hm=new Home_Page(driver);
            hm.Click_MyAccount();
            hm.click_Login();

            //log in page
            Login_Page lg=new Login_Page(driver);
            lg.email_add(p.getProperty("email"));
            lg.password(p.getProperty("password"));
            lg.login();

            //my account

            MyAccount_Page macc=new MyAccount_Page(driver);
            Boolean msg=macc.my_account_page();
            Assert.assertTrue(msg);
        }
        catch (Exception e){
           Assert.fail();
        }

        logger.info("----finished TC002 log in test");

    }

}
