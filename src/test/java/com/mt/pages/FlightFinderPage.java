package com.mt.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mt.config.Config;
import com.mt.utility.LaunchApp;

public class FlightFinderPage
{
	@FindBy(how=How.XPATH,using ="//img[@src='/images/masts/mast_flightfinder.gif']")
	WebElement objflightfinder;

	@FindBy(how=How.LINK_TEXT,using ="SIGN-OFF")
	WebElement objsignoff;

	public void loadFlightFinderpage()
	{
		PageFactory.initElements(Config.driver,this);
	}
	public void verifyFlightFinderimg()
	{
		boolean flag=objflightfinder.isDisplayed();
		System.out.println("Flight Finder image is displayed");
		System.out.println("Load finder image displayed");
		System.out.println("Load and displayed");
	}
	public void clickonsignoff()
	{
		objsignoff.click();
	}
	public static void main(String[] args) throws IOException
	{
		LaunchApp lc= new LaunchApp();
		lc.openBrowser("chrome");
		lc.EnterApplicationURL("http://www.newtours.demoaut.com/mercurywelcome.php");
		lc.maximizeBrowser();
		lc.waittillLoginpageLoaded(15);
		
		LoginPage lg= new LoginPage();
		lg.loadLoginpage();
		lg.enterUsername("prit2287");
		lg.enterPassword("Pritam@1987");
		lg.clickonLogin();
		
		FlightFinderPage ffp=new FlightFinderPage();
		ffp.loadFlightFinderpage();
		ffp.verifyFlightFinderimg();
		ffp.clickonsignoff();

	}
	

}
