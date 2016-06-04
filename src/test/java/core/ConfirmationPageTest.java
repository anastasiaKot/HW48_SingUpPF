package core;

import static org.junit.Assert.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.gargoylesoftware.htmlunit.BrowserVersion;


public class ConfirmationPageTest {

	
	static ConfirmationPage Junit=new ConfirmationPage(new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11,true), true); 
	//static ConfirmationPage Junit=new ConfirmationPage(new FirefoxDriver());
	 static String[] a={"Yyy", "Chhhh","cpu@ua.fm","8507745555","Male","Florida","true"};		
			
	 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
//		System.out.println("HtmlUnitDriver");
		Junit.readProperties ("./src/main/resources/ConfirmationPageV1.properties"); 
//		Junit.Read_CSV("./src/main/resources/ConfirmationPageV1.csv");
		
//		
//		
	//open url
		Junit.before();
		Junit.enterData(a);
//		
//		String[] a={"Yyy", "Chh","cpu@ua.fm","8507745555","Male","Florida","true"};
//		Junit.enterData(a);
//		//Yyy;Chhh;cpu@ua.fm;8507745555;Male;Florida; 
//		//Vasja;Nikonenko;net11@ya.ru;4157745555;Female;California;Agreed
//		//Vasja;Nikonenko;net11@ya.ru;4157745555;;California;true
//				

//		

//		


//		

//		
//		System.out.println(e.getValueField(terms_conf));
//		
//		//Back
//		e.getValueField(conf_button_back);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		Junit.after();
	}
	
	
	//@Ignore
//	@Test
//	public void testFieldFirstName() {
//		assertEquals(a[0], Junit.getValueField(ConfirmationPage.conf_first_name_id));
//		
//	//	fail("Not yet implemented");
//	}
//	
//	
//	//@Ignore
//	@Test
//	public void testFieldLastName() {
//		assertEquals(a[1], Junit.getValueField(ConfirmationPage.conf_last_name_id));
//		
//	//	fail("Not yet implemented");
//	}
//
//	//@Ignore
//		@Test
//		public void testFieldLastNameNeg() {
//			assertEquals("Pupkin", Junit.getValueField(ConfirmationPage.conf_last_name_id));
//			
//		//	fail("Not yet implemented");
//		}
//	
//	//
//	
//	//@Ignore
//	@Test
//	public void testFieldEmail() {
//		assertEquals(a[2], Junit.getValueField(ConfirmationPage.conf_email_id));
//		
//	//	fail("Not yet implemented");
//	}
//
//	//@Ignore
//	@Test
//	public void testFieldPhoneNum() {
//		assertEquals(a[3], Junit.getValueField(ConfirmationPage.conf_phone_number_id));
//		
//	//	fail("Not yet implemented");
//	}
//
//	
//	//@Ignore
//	@Test
//	public void testFieldGender() {
//		assertEquals(a[4], Junit.getValueField(ConfirmationPage.gender_conf));
//		
//	//	fail("Not yet implemented");
//	}
//	
//	//@Ignore
//	@Test
//	public void testFieldState() {
//		assertEquals(a[5], Junit.getValueField(ConfirmationPage.state_conf));
//		
//	//	fail("Not yet implemented");
//	}
//
//	
//	//@Ignore
//		@Test
//		public void testFieldStateNeg() {
//			assertEquals("California", Junit.getValueField(ConfirmationPage.state_conf));
//			
//		//	fail("Not yet implemented");
//		}
//	//@Ignore
//	@Test
//	public void testFieldTerms() {
//		assertEquals(ConfirmationPage.terms_expected, Junit.getValueField(ConfirmationPage.terms_conf));
//		
	//	fail("Not yet implemented");
	//}

}
