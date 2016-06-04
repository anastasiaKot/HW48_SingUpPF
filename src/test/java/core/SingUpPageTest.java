package core;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class SingUpPageTest {

	static WebDriver driver=new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11,true);
	static SingUpPage JunitTest=new SingUpPage(driver, true);
	static String [] dataOfPerson=null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	
	JunitTest.readProperties ("./src/main/resources/SingUpPageV1.properties");
	dataOfPerson=JunitTest.read2DimensionsArray(JunitTest.Read_CSV("./src/main/resources/SingUpPageV1.csv"), 0);
	
	//open url
	JunitTest.before(JunitTest.url_v1);
	
	//Read geo location from SingUpV0
	JunitTest.singUp_v0(JunitTest.url_v0);
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//close url
				//close WebDriver
				JunitTest.after(driver);
		
	}

	//@Ignore
	@Test
	public void testTitleValidation() {
		assertEquals(JunitTest.title_expected_sing_up, JunitTest.titleValidation());
		//fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testTitleValidationF() {
		assertEquals(JunitTest.facebook_expected_title, JunitTest.titleValidationF(JunitTest.facebook_image_link_id));
	}

	//@Ignore
	@Test
	public void testFirstNameE() {
		assertEquals(JunitTest.erorr_fname_empty_expected, JunitTest.firstNameE());
	}

	//@Ignore
	@Test
	public void testGetCity() {
		assertEquals( JunitTest.city_expected, JunitTest.getCity(JunitTest.current_location_id));
	}
	
	//@Ignore
	@Test
	public void testGetCityNeg() {
		assertEquals( "San Jose", JunitTest.getCity(JunitTest.current_location_id));
	}

	//@Ignore
	@Test
	public void testGetOS_Browser() {
		
		String OS_Browser_expected = JunitTest.checkOS()+" & "+JunitTest.checkBrowser();
		assertEquals( OS_Browser_expected, JunitTest.getOS_Browser());
}

	//@Ignore
	@Test
	public void testGetDate() {
		assertEquals( JunitTest.data_expected, JunitTest.getDate());
		//fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testGetWeatherIcon() {
		assertTrue( JunitTest.getWeatherIcon());
		//fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testGetTemperature() {
		assertTrue( JunitTest.getTemperature());
		//fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testLastNameE() {
		//dataOfPerson[]
		//First Name; Last Name; Email; phone_number, Gender, State, Terms
		assertEquals( JunitTest.erorr_lname_empty_expected, JunitTest.lastNameE(dataOfPerson[0]));
		//fail("Not yet implemented");
	}

	//@Ignore
	@Test
	public void testGetCopyrightText() {
		assertTrue( JunitTest.getCopyrightText(JunitTest.copyright_id,JunitTest.PF.copyright_pf));
		//fail("Not yet implemented");
	}

}
