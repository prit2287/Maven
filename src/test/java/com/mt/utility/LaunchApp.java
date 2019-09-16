package com.mt.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mt.config.Config;

public class LaunchApp
{
Properties prop = new Properties();
	
	public void openBrowser(String browsernm) throws IOException
	{
		FileInputStream fis = new FileInputStream("E:\\Maven_POM_Design_Pattern\\src\\test\\resources\\config.properties");
		prop.load(fis);
		
		if(browsernm.equalsIgnoreCase("chrome"))
		//if(prop.getProperty("Browser").equalsIgnoreCase(browsernm))
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeexepath") );
			Config.driver= new ChromeDriver();
			System.out.println("Chrome browser is opened successfully");
		
		}else if(browsernm.equalsIgnoreCase("ie"))
		//else if(prop.getProperty("Browser").equalsIgnoreCase(browsernm))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("ieexepath"));
			Config.driver=new InternetExplorerDriver();
			System.out.println("IE browser is opened");
		}else
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxexepath"));
			Config.driver=new FirefoxDriver();
			System.out.println("Firefox browser is opened successfully");
		}		
		
	}
	
	public void EnterApplicationURL(String url)
	{
		Config.driver.get(url);
		System.out.println("Application url is entered successfully");
	}
	
	public void maximizeBrowser()
	{
		Config.driver.manage().window().maximize();
	}
	
	public void waittillLoginpageLoaded(int timeoutseconds)
	{
		Config.driver.manage().timeouts().pageLoadTimeout(timeoutseconds, TimeUnit.SECONDS);
	}
	
	
	public static void main(String[] args) throws IOException
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser("chrome");
		lc.EnterApplicationURL("http://www.newtours.demoaut.com/mercurywelcome.php");
		lc.maximizeBrowser();
		lc.waittillLoginpageLoaded(15);
	}
	

}
