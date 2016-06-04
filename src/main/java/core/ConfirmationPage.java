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


package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class ConfirmationPage extends Commons{

	String url_v1=null;
	String first_name_id=null;
	String last_name_id=null;
	
	String email_id=null;
	String phone_number_id=null;
	
	String checkbox_id=null;
	String	gender_male_id=null;
	String gender_female_id=null;
	String state_id=null;
	String button_submit=null;
	
	String conf_first_name_id=null;
	String conf_last_name_id=null;
	String conf_email_id=null;
	
	String conf_phone_number_id=null;
	String conf_button_back=null;
	
	String state_conf=null;
	String gender_conf=null;
	String terms_conf=null;
	
	String button_reset=null;
	

	
	String copyright_id=null;
	String copyright_expected=null;
	String test_case_id = "TC-002.0";
	static int test_case_count=0;
	//static boolean  TurnOffLogWarning;
	//test_case_id+test_case_count
	
//	String fname_expected=null;
//	String lname_expected=null;
//	String email_expected=null;
//	String phone_expected=null;
//	String state_expected=null;
	String gender_expected=null;
	String terms_expected=null;
	String CSVV[][];



	WebDriver driver=null;
	String handle;
	String parentHandle;
	
	//String proFile = "./src/main/resources/SingUpPageV0.properties";
	//String proFile = "./src/main/resources/SingUpPageV1.properties";
	//String proFile = "./src/main/resources/ConfirmationPageV1.properties";
	ConfirmationPage_PageFactory PF;

	//Constructor 1	
		public ConfirmationPage(WebDriver parent) 
		{
	        this.driver = parent;
	        PF=PageFactory.initElements(this.driver, ConfirmationPage_PageFactory.class);
	        //this.copyright_id=super.copyright_id;
	        }

	//Constructor 2	
		public ConfirmationPage(WebDriver parent, boolean HTMLunit) 
		{
	        this.driver = parent;
	        PF=PageFactory.initElements(this.driver, ConfirmationPage_PageFactory.class);
	        //String test_case_id = "TC-002.0";
	      //  this.copyright_id=super.copyright_id;
	        if (HTMLunit)
	        {
	        	HtmlUnitLoggingOff();
	        }
	        }


		@Override
		public void readProperties (String file_path) 

		{
			//new Object properties		
					try{
					Properties properties = new Properties();
					
					properties.load(new FileInputStream(file_path));
					
					url_v1 = properties.getProperty("url_v1");
					first_name_id = properties.getProperty("first_name_id"); 
					last_name_id = properties.getProperty("last_name_id"); 
					
					email_id = properties.getProperty("email_id"); 
					phone_number_id = properties.getProperty("phone_number_id"); 
					button_submit = properties.getProperty("button_submit"); 
					
					conf_first_name_id = properties.getProperty("conf_first_name_id"); 
					conf_last_name_id = properties.getProperty("conf_last_name_id"); 
					conf_email_id = properties.getProperty("conf_email_id"); 
					
					conf_phone_number_id = properties.getProperty("conf_phone_number_id"); 
					conf_button_back = properties.getProperty("conf_button_back");
					button_reset=properties.getProperty("button_reset");
					
					checkbox_id=properties.getProperty("checkbox_id");
					gender_male_id=properties.getProperty("gender_male_id");
					gender_female_id=properties.getProperty("gender_female_id");
					state_id=properties.getProperty("state_id");
					
					state_conf=properties.getProperty("state_conf");
					gender_conf=properties.getProperty("gender_conf");
					terms_conf=properties.getProperty("terms_conf");
					
					copyright_id=properties.getProperty("copyright_id");
					copyright_expected=properties.getProperty("copyright_text");
					
					
					if ( properties.isEmpty() || 
							(url_v1==null) ||
							(first_name_id==null) ||
							(last_name_id==null) ||
							
							(email_id==null) ||
							(phone_number_id==null) ||
							(button_submit==null) ||
							
							(conf_first_name_id==null) ||
							(conf_last_name_id==null) ||
							(conf_email_id==null) ||
							
							(conf_phone_number_id==null) ||
							(conf_button_back==null) ||
							(button_reset==null) ||
							
							(checkbox_id==null) ||
							(gender_male_id==null) ||
							(gender_female_id==null) ||
							
							(state_id==null) ||
							(state_conf==null) ||
							(gender_conf==null) ||
							(terms_conf==null) ||
							(copyright_id==null) ||
							
							(copyright_expected==null)
						)
					{
						System.out.println("Warning File is Empty or not correct ! --> \""+file_path+"\""); System.exit(1);
						}

//					else
//					{
//						System.out.println("File read completed!");
//					}
					
					} 
	 
					catch (FileNotFoundException e) {
						System.out.println("Method 'readProperties()' - BLOCK");
						System.out.println();
						System.out.println(e.getMessage());
					}
					catch (IOException e) {
						System.out.println("Method 'readProperties()' - BLOCK");
						System.out.println();
						System.out.println(e.getMessage());
					}
						
					
					//END readProperties	
		}
		

		
		public void before()
		{
			driver.get(url_v1);
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}

		//Enter data
		
		
		public void after(){
			
			driver.close();
			driver.quit();
			System.out.println("All Test Cases - DONE");
}		
		
	
		
		
		public void enterData(String[] data){
		
			try{
			//Reset
			//driver.findElement(By.id(button_reset)).click();
			inputValueField(button_reset,null,PF.reset_button_pf);
						
			//first name
			inputValueField(first_name_id,data[0],PF.fname_pf);
						
			//last name
			inputValueField(last_name_id,data[1],PF.lname_pf);
			
			//email
			inputValueField(email_id,data[2],PF.email_pf);
						
			//phone
			inputValueField(phone_number_id,data[3],PF.phone_pf);
			
			
			//gender
			if("Male".equals(data[4]))
				//if (((data[4]!=null)||(data[4]!=" ")) && (data[4]=="Male"))
				
			{
			gender_expected="Male";
			inputValueField(gender_male_id,data[4],PF.g_male_pf);
			}
			
			//if(gender_expected=="Female"){
			if("Female".equals(data[4]))	
			//if (((data[4]!=null)||(data[4]!=" ")) && (data[4]=="Female"))
			{
			gender_expected="Female";
			inputValueField(gender_female_id,data[4],PF.g_female_pf);
			}
			
			//state
			inputValueField(state_id,data[5],PF.state_pf);
			
			//Agreed
			//if(data[6].contains("true"))
			if("true".equals(data[6]))
			{
			terms_expected="Agreed";
			inputValueField(checkbox_id,data[6],PF.checkbox_pf);
			}
			
			//Submit
			inputValueField(button_submit,null,PF.submit_button_pf);
			
			}
			catch (NoSuchElementException e) {
				System.out.println("Method 'enterData()' - BLOCK");
				System.out.println();
				System.out.println(e.getMessage());
			}
		}
		
		
		public boolean checkAllFields(String[] data)
		{
			//boolean result=false;
			test_case_count++;
			
			String fname_actual =getValueField(conf_first_name_id,PF.fname_conf_pf);
			String lname_actual	=getValueField(conf_last_name_id,PF.lname_conf_pf);
			String email_actual =getValueField(conf_email_id,PF.email_conf_pf);
			String phone_actual =getValueField(conf_phone_number_id,PF.phone_conf_pf);
			String state_actual =getValueField(state_conf,PF.state_conf_pf);
			
			String gender_actual =getValueField(gender_conf,PF.gender_conf_pf);
			String terms_actual =getValueField(terms_conf,PF.terms_conf_pf);
			


/*
//first name- data[0]
//last name- data[1]
//email- data[2]
//phone  -data[3]
 * 
//state - data[5]
//Agreed - data[6]
 * 
*/
			
		if( (data[0].equals(fname_actual)) && 
				(data[1].equals(lname_actual)) && 
				(data[2].equals(email_actual)) && 
				(data[3].equals(phone_actual)) &&
				(data[5].equals(state_actual)) &&
				(gender_expected.equals(gender_actual)) &&
				(terms_expected.equals(terms_actual))
				)
		{
			System.out.println(">>>>....");
			System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count+ " - PASSED");
			System.out.println("First name Expected/Actual: \t" + data[0]+" / "+fname_actual);
			
			System.out.println("Last name Expected/Actual: \t" + data[1]+" / "+lname_actual);
			System.out.println("Email Expected/Actual: \t" + data[2] +" / "+email_actual);
			System.out.println("Phone Expected/Actual: \t" + data[3] +" / "+phone_actual);
			System.out.println("State Expected/Actual: \t" + data[5] +" / "+state_actual);
			
			System.out.println("Gender Expected/Actual: \t" + gender_expected+" / "+gender_actual);
			System.out.println("Terms? Expected/Actual: \t" + terms_expected+" / "+terms_actual);
			System.out.println("....<<<<");
			
			System.out.println();
			return true;
		}
		
		else
		{
			System.out.println(">>>>....");
			System.out.println("Test Case ID: \t\t" + test_case_id+test_case_count+ " - FAILED");
			System.out.println("First name Expected/Actual: \t" + data[0]+" / "+fname_actual);
			
			System.out.println("Last name Expected/Actual: \t" + data[1]+" / "+lname_actual);
			System.out.println("Email Expected/Actual: \t" + data[2]+" / "+email_actual);
			System.out.println("Phone Expected/Actual: \t" + data[3]+" / "+phone_actual);
			System.out.println("State Expected/Actual: \t" + data[5] +" / "+state_actual);
			
			System.out.println("Gender Expected/Actual: \t" + gender_expected+" / "+gender_actual);
			System.out.println("Terms? Expected/Actual: \t" + terms_expected+" / "+terms_actual);
			
			System.out.println("....<<<<");
			System.out.println();	
		}
//END	TC-002.01	
			
			return false;
		}	
	
		@Override
		public boolean getCopyrightText	(String element_id, WebElement pageFactory) 
		{
			String copyright_actual=null;
			test_case_count++;
			//System.out.println(copyright_expected);
			//System.out.println(copyright_expected.substring(1, copyright_expected.length()));
			copyright_expected=copyright_expected.substring(1, copyright_expected.length());
			
			
			try{
			copyright_actual = getValueField(element_id, pageFactory);
			if (copyright_expected.equals(copyright_actual))
			{
			//System.out.println(copyright_actual);

			System.out.println(">>>>....");
			System.out.println("Test Case ID: \t\t"+this.test_case_id+test_case_count+" - PASSED");
			System.out.println("CopyRight Expected/Actual: \t" + copyright_expected+" / "+copyright_actual);
			
			System.out.println("....<<<<");
			System.out.println();
			return true;	
		} else {
			System.out.println(">>>>....");
			System.out.println("Test Case ID: \t\t" +this.test_case_id+test_case_count+ " - FAILED");
			System.out.println("CopyRight Expected/Actual: \t" + copyright_expected+" / "+copyright_actual);
			
			System.out.println("....<<<<");
			System.out.println();
		}

		} catch(NoSuchElementException e)
		{
				System.out.println("Test Case ID: \t\t" +this.test_case_id+test_case_count+ " - BLOCK");
				System.out.println();
				System.out.println(e.getMessage());
		}		
			return false;
		}
		
}
