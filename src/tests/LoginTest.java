package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.Xls_Reader;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {

	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
			

	@BeforeMethod
	public void beforeMethod() {
		lp.openBrowser();
		lp.openLogin();
	}

	@AfterMethod
	public void afterMethod() {
		lp.closeBrowser();
	}

	@Test
	public void loginWitheWrongEmailPassword() throws InterruptedException {
		lp.login(df.wrongEmail, df.wrongPassword);
		Assert.assertEquals(df.globalErr, lp.globalErr());
	}

	// @Test
	public void loginWithEmptyEmail() throws InterruptedException {
		lp.login(" ", df.wrongPassword);
		Assert.assertEquals(df.emptyEmail, lp.EmpatyEmailErr());
	}

	@Test
	public void loginWithEmptyPassword() throws InterruptedException {
		lp.login(df.wrongEmail, " ");
		Assert.assertEquals(df.emptyPassword, lp.EmptyPasswordErr());
	}

	@Test
	public void loginWithSpecialCharacterEmailTest() throws InterruptedException {
		lp.login(df.emailwithSpecialChar, df.wrongPassword);
		Assert.assertEquals(df.globalErr, lp.SpecialCharErr());
	}

}
