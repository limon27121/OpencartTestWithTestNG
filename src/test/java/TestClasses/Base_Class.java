package TestClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
//import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;


public class Base_Class {
    WebDriver driver;
    public Logger logger; //log4j
    public Properties p;



    @BeforeClass
    @Parameters({"os","browser"})
    void setUp(String os, String br) throws IOException {
        //load config.prop file
        FileReader file1=new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file1);



       //for logger which store log in logs file
        logger = LogManager.getLogger(Base_Class.class);
        switch (br.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser name, launching Chrome as default");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("appUrl")); //read url from config.properties file
        driver.manage().window().maximize();
    }
    @AfterClass
    void tear_Down(){
        driver.quit();
    }
    //user defined method
    public class RandomUtils {

        private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final Random RANDOM = new Random();

        public static String randomString(int length) {
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append(CHARS.charAt(RANDOM.nextInt(CHARS.length())));
            }
            String sb1=sb+"@gmail.com";
            return sb1.toString();
        }

    }
}
