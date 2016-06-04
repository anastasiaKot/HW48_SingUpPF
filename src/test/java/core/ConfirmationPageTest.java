package core;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class ConfirmationPageTest {

	
	//static ConfirmationPage JunitTest=new ConfirmationPage(new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11,true), true);
	//static WebDriver driver=new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11,true);
	static WebDriver driver=new FirefoxDriver();
	static ConfirmationPage JunitTest=new ConfirmationPage(driver);
	static String [] dataOfPerson=null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		JunitTest.readProperties ("./src/main/resources/ConfirmationPageV1.properties");
		dataOfPerson=JunitTest.read2DimensionsArray(JunitTest.Read_CSV("./src/main/resources/ConfirmationPageV1.csv"), 0);
		
		//open url
		JunitTest.before(JunitTest.url_v1);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
		JunitTest.after(driver);
	}
	
	@Ignore
	@Test
	public void testGetCopyrightText() {
		
		assertTrue( JunitTest.getCopyrightText(JunitTest.copyright_id,JunitTest.PF.copyright_pf));
		//fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testCheckAllFields() {
		JunitTest.enterData(dataOfPerson);
		assertTrue( JunitTest.checkAllFields(dataOfPerson));
		//fail("Not yet implemented");

	}

}
