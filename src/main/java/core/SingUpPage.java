/**
* @author Yura May2016 GHY
*
* This src, illustrates working with the homepage and
* validation functional(use JavaScript and Web Services(JSON)) and elements of homepage. Yura May2016 GHA
*
* User Agent parser - UADetector
* http://memorynotfound.com/parse-user-agent-java/
* http://uadetector.sourceforge.net/
* 
*/


//HtmlUnit - Prototype

package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SingUpPage extends Commons {

	//Page Factory unsupported variables :(((	
	//facebook_image_link_id 
	//@FindBy(id="facebook_image_link_id")
	//@CacheLookup
	//static WebElement facebook_image_link_pf;
	
	
	//String proFile = "./src/main/resources/SingUpPageV0.properties";
	//String proFile = "./src/main/resources/SingUpPageV1.properties";
	//String proFile = "./src/main/resources/ConfirmationPageV1.properties";
	//String [] dataOfPerson=null;
	SingUp_PageFactory PF;

	//Constructor 1	
		public SingUpPage(WebDriver parent) 
		{
	        this.driver = parent;
	        //SingUp_PageFactory 
	        PF=PageFactory.initElements(this.driver, SingUp_PageFactory.class);
	        }

	//Constructor 2	
	//If use HtmlUnit Turn Off WARNINGS	
		public SingUpPage(WebDriver parent,  boolean HTMLunit) 
		{
	        this.driver = parent;
	        //SingUp_PageFactory 
	        PF=PageFactory.initElements(this.driver, SingUp_PageFactory.class);
	        
	//Create 
	        if (HTMLunit)
	        {
	        	HtmlUnitLoggingOff();
	        }
	        }
	
		
//Steps before we RUN check
		public void before(String url)
		{
			//Page Factory
			try{
			//PF = PageFactory.initElements(driver, SingUp_PageFactory.class);
			}
			catch(NoSuchElementException e)
			{
					//driver.quit();	
					System.out.println("Work of Page Factory - BLOCK");
					System.out.println();
					System.out.println(e.getMessage());
			}	
			
			
			//GET Location, WebServecing, return my Internet Ip address
			 GEO=whereIam(myIP());
			
			//GET Weather, WebServecing, use 
			 Weather=Weather(GEO[2], GEO[3]);
			
			city_expected=regExp(regex_city,GEO[0]);
			//System.out.println(city_expected);
			icon_weather_expected=regExp(regex_icon_url,Weather[1]);
			
			//RUN site V0 and read
		
			//geoLocation_actual
			//icon_weather_actual
			//tempTemp
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			
		}
		
	
		
		public void singUp_v0(String url)
		{
			handle=newTab(url);
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

			switchToWindow(handle);
			try {

				//"City, Region"
				//geoLocation_actual = driver.findElement(By.id(current_location_id)).getText();
				geoLocation_actual = PF.current_location_id_pf.getText();
				
				//static String 
				//city_expected=regExp("\\b[A-Z]{1}[a-z]+",GEO[0]);
								
				icon_weather_actual=regExp(regex_icon_url,  PF.weather_icon_pf.getAttribute("src"));
				tempTemp=regExp(regex_temperature, PF.temperature_pf.getText());
				
				closeNewTab(parentHandle, handle);
		 	
				} catch(NoSuchElementException e)
				{
						//driver.quit();	
						System.out.println("Can't read url: "+url_v0+" - BLOCK");
						System.out.println();
						System.out.println(e.getMessage());
				}	
			
		}
		

		
		
//TC-001.01	Sign Up(v1)	01	Sign Up page html title is: "Welcome to Sign Up v1 ".		
	public String titleValidation(){
		
		String title_sing_up_actual=null;
		try
		{
		title_sing_up_actual= driver.getTitle();
		test_case_count++;
		
	
			} catch(NoSuchElementException e)
			{
					System.out.println("Test Case ID: \t\t" +test_case_id+test_case_count+ " - BLOCK");
					System.out.println();
					System.out.println(e.getMessage());
			}		
		return title_sing_up_actual;
		}
//END TC-001.01	
		
//		Verify Facebook image link, page  title : "Welcome to Facebook - Login In, Sign Up or Learn More".
//TC-001.02
	public String titleValidationF(String image_link_id)
	{
		test_case_count++;
		String title_actual_facebook=null;

			//If Element exist -- work, if not Error
			if (checkExistElement_id(image_link_id))
			{

		//Page Factory
		handle=newTab(PF.facebook_image_link_pf.getAttribute("href"));
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		switchToWindow(handle);
 
		title_actual_facebook=driver.getTitle();
		closeNewTab(parentHandle, handle);
			
			}
		return title_actual_facebook;
	}
	
	
//END TC-001.02		
	
//		Verify Twitter image link, page  title : " Twitter ".
//
//		Verify Flickr image link, page  title : "Flickr, a Yahoo company | Flickr - Photo Sharing!".
//		Verify YouTube image link, page  title : "YouTube ".
	
//		Verify Error handling First Name field. Leave field blank.

	// TODO firstNameE
	public String firstNameE(){
	

	String erorr_fname_empty_actual=null;	
//		try{

	test_case_count++;
	
	//reset
	inputValueField(button_reset, null, PF.reset_button_pf);
	
		//driver.findElement(By.id(button_id)).click();
	inputValueField(button_submit, null, PF.submit_button_pf);
		//PF.submit_button_pf.click();
		
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		erorr_fname_empty_actual = PF.ErrorLine_pf.getText();

		return erorr_fname_empty_actual;
}
	//END TC-001.03		
	
	
//		Verify Error handling Last Name field. Leave field blank.
//		Verify Error handling Email Address field. Leave field blank.
//		Verify Error handling Phone Number field. Leave field blank.
//
//		Page Confirmation contain correct all entry data (First Name, Last Name, Email Address, Phone Number)
//		New quote appears every new load of the page (quotes: shortest- 67 chars; longest - 103 chars)

//		Page contains dynamic text (Client’s City and State) (example: "Saratoga, CA")
//
//TC-001.05
//
	public String getCity(String city_region_id)
	{
		test_case_count++;
		
		//Check Elements
		//checkExistElement_id(city_region_id);
				
		String city_actual=null;
	    
		
		//regEx only for city!
		//\b[A-Z]{1}[a-z]+
		//San Francisko, CA
			
		city_actual= regExp(regex_city, geoLocation_actual);

	return 	city_actual;
	}

	
	//TC-01.31	Page contains dynamic text Client’s OS & Browser
	//Dynamic text (Client’s OS & Browser) id = os_browser	
	//Page contains dynamic text Client’s OS (example: "Windows 7")
	//Page contains dynamic text Browser (example: "Firefox 46")		
	public String getOS_Browser(){
		
		String OS_Browser_actual=null;
		test_case_count++;
	try
			{
			//String 
			//OS_Browser_expected = checkOS()+" & "+checkBrowser();
			
			OS_Browser_actual = PF.os_browser_pf.getText();
						
			} catch(NoSuchElementException e)
			{
					System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count+ " - BLOCK");
					System.out.println();
					System.out.println(e.getMessage());
			}
			catch(NullPointerException e)
			{
					System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count+ " - BLOCK");
					System.out.println();
					System.out.println(e.getMessage());
			}
			catch(StringIndexOutOfBoundsException e)
			{
					System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count+ " - BLOCK");
					System.out.println();
					System.out.println(e.getMessage());
			}
			
			return OS_Browser_actual;
	}

	public String getDate(){	
		test_case_count++;
	
		String data_actual=null;
		try{
			
		test_case_count++;	
		data_actual=regExp(regex_data, PF.current_data_pf.getText());


		} catch(NoSuchElementException e)
		{
				//driver.quit();	
				System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count + " - BLOCK");
				System.out.println();
				System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
				//driver.quit();	
				System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count + " - BLOCK");
				System.out.println();
				System.out.println(e.getMessage());
		}	
	
	return data_actual;
	}
//Page contains dynamic text Client’s OS (example: "Windows 7")
//Dynamic text (Client’s OS & Browser) id = os_browser	
//Page contains dynamic text Browser (example: "Firefox 46")	
		
	// regex \b\/\w*\.\D{3,4} --> \\b\\/\\w*\\.\\D{3,4}
	public boolean getWeatherIcon(){
		test_case_count++;
		
		try
	{
		
		if(icon_weather_expected.equals(icon_weather_actual))
		{
			return true;
		}
		
	}
	catch(NoSuchElementException e)
	{
			System.out.println("Test Case ID: \t\t" +  test_case_id+test_case_count+ " - BLOCK");
			System.out.println();
			System.out.println(e.getMessage());
	}	

	return false;
	}
//TC-01.34	Page contains dynamic text Client’s current temperature, in Fahrenheit
//64 F	
//Dynamic text (Client’s current temperature, in Fahrenheit) =	id_temperature		
	public boolean getTemperature()
	{
	test_case_count++;
		
		float temp_actual=Float.parseFloat(tempTemp);
		float temp_expected=Float.parseFloat(Weather[0]);
		
		//1%-->0.01f, 10%-->0.1f
		float deviation=0.01f;
		
		//IF  temp_actual+-1% from 'temp_expected'
		if((temp_actual>=(temp_expected)*(1.0-deviation)) && ((temp_actual<=(temp_expected)*(1.0+deviation))))
		{
			return true;
		}
		
	return false;	
	}
			
	public String lastNameE(String inputValue){
		

		String erorr_lname_empty_actual=null;	

		test_case_count++;
		
		//Reset
		inputValueField(button_reset, null, PF.reset_button_pf);
		
		inputValueField(first_name_id,inputValue,PF.fname_pf);
			
		inputValueField(button_submit,null,PF.submit_button_pf);

		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		erorr_lname_empty_actual = PF.ErrorLine_pf.getText();
						
		return erorr_lname_empty_actual;
	}
			
	

}
