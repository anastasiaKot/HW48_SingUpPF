package core;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;


public class SingUpPageTest_  {

	
	static SingUpPage JunitTest=new SingUpPage(new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11,true), true);
	
	//static SingUpPage JunitTest=new SingUpPage(new FirefoxDriver());
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		JunitTest.readProperties ("./src/main/resources/SingUpPageV1.properties");
		
	//open url
		JunitTest.before(JunitTest.url_v1);
		
		//Read geo location from SingUpV0
		JunitTest.singUp_v0(JunitTest.url_v0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		//close url
		//close WebDriver
		JunitTest.after();
	}

	//@Ignore
	@Test
	public void testTitleValidationPos() {
		
		assertEquals(JunitTest.title_expected_sing_up, JunitTest.titleValidation());
		//fail("Not yet implemented");
	}
	
//	@Ignore
//	@Test
//	public void testTitleValidationNeg() {
//		
//		assertEquals("Welcom to Yandex", JunitTest.titleValidation());
//		//fail("Not yet implemented");
//	}
//
//	@Ignore
//	@Test
//	public void testTitleValidationFPos() {
//		
//		assertEquals(SingUpPage.facebook_expected_title, JunitTest.titleValidationF(SingUpPage.facebook_image_link_id));
//		//fail("Not yet implemented");
//	}
//	
//	
//	@Ignore
//		@Test
//		public void testTitleValidationFNeg() {
//			
//			assertEquals("It's Vkontakte", JunitTest.titleValidationF(SingUpPage.facebook_image_link_id));
//			//fail("Not yet implemented");
//		}
//
//	//@Ignore
//	@Test
//	public void testFirstNameE() {
//		
//		assertEquals(SingUpPage.erorr_fname_empty_expected, JunitTest.firstNameE(SingUpPage.button_submit, SingUpPage.fname_error_id));
//		
//		//fail("Not yet implemented");
//	}
//
//	//@Ignore
//		@Test
//		public void testFirstNameENeg() {
//			
//			assertEquals("Please, close browser", JunitTest.firstNameE(SingUpPage.button_submit, SingUpPage.fname_error_id));
//			
//			//fail("Not yet implemented");
//		}
//	
//	@Ignore
//	@Test
//	public void testGetCity() {
//
//		assertEquals( SingUpPage.city_expected, JunitTest.getCity(SingUpPage.current_location_id));
//	}
//	
//	
//	@Ignore
//		@Test
//		public void testGetCityNeg() {
//
//			assertEquals( "San Jose", JunitTest.getCity(SingUpPage.current_location_id));
//		}

}
