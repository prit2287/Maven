package com.mt.modules;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mt.pages.FlightFinderPage;
import com.mt.pages.LoginPage;

public class Login 
{
	@Parameters({"usernm","passwd"})
	@Test
	public void executeLogin(String username, String password)
	{
		LoginPage lgpg= new LoginPage();
		lgpg.loadLoginpage();
		lgpg.enterUsername(username);
		lgpg.enterPassword(password);
		lgpg.clickonLogin();
		
		FlightFinderPage fg=new FlightFinderPage();
		fg.loadFlightFinderpage();
		fg.verifyFlightFinderimg();
		fg.clickonsignoff();


	}

}
