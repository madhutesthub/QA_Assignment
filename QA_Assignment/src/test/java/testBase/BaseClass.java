package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //for logger
import org.apache.logging.log4j.Logger; //for logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import org.apache.logging.log4j.Logger;                   //log4j
import org.apache.logging.log4j.LogManager;               //log4j

public class BaseClass {
	
		public static WebDriver driver;           //for capture screenshot make it static other wise remove 
		public Logger logger;						//log4j
		public Properties p;
	
			@BeforeClass(groups={"Sanity"})
			@Parameters({"os","browser"})
			public void setup(@org.testng.annotations.Optional("windows") String os,
	                  @org.testng.annotations.Optional("chrome") String br) throws IOException 
			{
				//Loading config.properties file
				FileReader file=new FileReader("./resources//config.properties");
				p=new Properties();
				p.load(file);
				logger=LogManager.getLogger(this.getClass());//log4j2
				
				if(p.getProperty("execution_env").equalsIgnoreCase("remote")) 
				{
					DesiredCapabilities capabilities =new DesiredCapabilities();
					
					//os
					if(os.equalsIgnoreCase("windows")) 
					{
						capabilities.setPlatform(Platform.WIN11);
					}
					else if(os.equalsIgnoreCase("linux"))
					{
						capabilities.setPlatform(Platform.LINUX);
					}
						
					else if(os.equalsIgnoreCase("mac"))
						{
							capabilities.setPlatform(Platform.MAC);
					}
					else
					{
						System.out.println("No matching OS");
						return;
					}
					
					//browser
					switch(br.toLowerCase())
					{
					case "chrome" :capabilities.setBrowserName("chrome");break;
					case "edge" :capabilities.setBrowserName("MicrosoftEdge");break;
					case "firefox" :capabilities.setBrowserName("firefox");break;
					default:System.out.println("No matching browser");return;
					}	
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
					
				}
				if(p.getProperty("execution_env").equalsIgnoreCase("local"))
				{
				switch(br.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox" : driver=new FirefoxDriver(); break;
				default:System.out.println("Invalid browser name..");
				return;	
				}
			}
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(p.getProperty("appURL1"));//reading url from properties file
				driver.manage().window().maximize();
			}
			
			@AfterClass(groups={"Master"})
			public void tearDown() 
			{
				driver.quit();
			}

			public String randomeString() 
			{
			 String generatedString=RandomStringUtils.randomAlphabetic(8);
			 return generatedString;
			}
			
			public String randomenumber() 
			{
			 String generatednumber=RandomStringUtils.randomNumeric(10);
			 return generatednumber;
			}
			
			public String randomeAlphaNumeric() 
			{
			 String generatedString=RandomStringUtils.randomAlphabetic(5);
			 String generatednumber=RandomStringUtils.randomNumeric(5);
			 return (generatedString+"@"+generatednumber);
			}
			public String captureScreen(String tname) throws IOException {

				String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
				File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
				String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

				try {
					FileUtils.copyFile(source, new File(destination));
				} catch (Exception e) {
					e.getMessage();
				}
				return destination;

			}

			
	}