package core;


import java.io.FileNotFoundException;
import java.io.IOException;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Draft_Run {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub

		String [] dataOfPerson=null;
		
	SingUpPage a=new SingUpPage(new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_8,true), true); 
	//SingUpPage a=new SingUpPage(new FirefoxDriver());
		//System.out.println("HtmlUnitDriver");
  
		//SingUpPage d=new SingUpPage(new FirefoxDriver());
		a.readProperties ("./src/main/resources/SingUpPageV1.properties"); 
		dataOfPerson=a.read2DimensionsArray(a.Read_CSV("./src/main/resources/SingUpPageV1.csv"), 0);
//		
//		//open url
a.before(a.url_v1);
//		
a.titleValidation();

a.titleValidationF(a.facebook_image_link_id);


//SingUpPage	
		//Read data from site V0
		a.singUp_v0(a.url_v0);
		//Compare city from WebServise and site SingUpV0
		a.getCity(a.current_location_id);
		a.getOS_Browser();
		
		a.getDate();
		a.getWeatherIcon();
		a.getTemperature();
		
		a.firstNameE(a.button_submit, a.fname_error_id);
		
		a.lastNameE(a.button_submit, a.fname_error_id,dataOfPerson[0]);
		
		
		a.getCopyrightText(a.copyright_id,a.PF.copyright_pf);
		
		//close url
		//close WebDriver
		a.after();

		
		//ConfirmationPage		
		ConfirmationPage b=new ConfirmationPage(new FirefoxDriver());
		//System.out.println("HtmlUnitDriver");
  
		//SingUpPage d=new SingUpPage(new FirefoxDriver());
		b.readProperties ("./src/main/resources/ConfirmationPageV1.properties"); 
		dataOfPerson=b.read2DimensionsArray(b.Read_CSV("./src/main/resources/ConfirmationPageV1.csv"), 1);
//		
//		//open url
b.before();
b.enterData(dataOfPerson);

//System.out.println(b.getValueField(b.conf_first_name_id,b.PF.fname_conf_pf));
//System.out.println(b.getValueField(b.conf_last_name_id,b.PF.lname_conf_pf));
//System.out.println(b.getValueField(b.conf_email_id,b.PF.email_conf_pf));
//System.out.println(b.getValueField(b.conf_phone_number_id,b.PF.phone_conf_pf));
//System.out.println(b.getValueField(b.gender_conf,b.PF.gender_conf_pf));
//System.out.println(b.getValueField(b.state_conf,b.PF.state_conf_pf));
//System.out.println(b.getValueField(b.terms_conf,b.PF.terms_conf_pf));
b.checkAllFields(dataOfPerson);

b.getCopyrightText(b.copyright_id,b.PF.copyright_pf);

b.after();
	}

}
