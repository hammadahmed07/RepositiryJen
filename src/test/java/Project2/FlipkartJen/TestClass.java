package Project2.FlipkartJen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestClass {
    protected WebDriver driver;
    protected HomePage homePage;
  //  protected LoginPage loginPage;
    protected Properties config;
    public ExtentReports extent;
    public ExtentTest test;
    public XSSFSheet sheet;
    
    public static final Logger logger = LogManager.getLogger(TestClass.class);
    
    @BeforeClass
    public void setUp() throws IOException {
    	
        // Initialize ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Load configuration from properties file
        config = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            config.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up WebDriver based on the browser specified in the config file
        String browser = config.getProperty("browser");
        if ("chrome".equalsIgnoreCase(browser)) {
            String chromeDriverPath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            // Configure ChromeOptions for headless mode
			
			  ChromeOptions chromeOptions = new ChromeOptions();
			//  chromeOptions.addArguments("--headless"); 
			  driver = new ChromeDriver(chromeOptions);
			 
      

        } else {
            System.out.println("Unsupported browser specified in config.properties");
            return;
        }

        driver.manage().window().maximize();

        // Initialize Page Objects
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        extent.flush();
        // Close the browser
        driver.quit();
    }
}
