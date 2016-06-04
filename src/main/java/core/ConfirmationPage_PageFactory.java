/**
* @author Yura June2016 GHY
*
* This src, illustrates working with the homepage and
* validation functional(use JavaScript and Web Services(JSON)) and Web elements. Yura May2016 GHA
*
*Convert all WebElements to Page Factory
*
* User Agent parser - UADetector
* http://memorynotfound.com/parse-user-agent-java/
* http://uadetector.sourceforge.net/
* 
*/

package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage_PageFactory {

	//Page Factory unsupported variables :(((	
		
		

		
		//Page contains First Name text field
		@FindBy(id="id_fname")
		//@CacheLookup
		public WebElement fname_pf;
		
		//Page contains Last Name text field
		@FindBy(id="id_lname")
		//@CacheLookup
		public WebElement lname_pf;
		
		//Page contains Email Address text field
		@FindBy(id="id_email")
		//@CacheLookup
		public WebElement email_pf;
		
//		Text field "Phone"
		@FindBy(id="id_phone")
		//@CacheLookup
		public WebElement phone_pf;
		
		//id_g_radio_01
		@FindBy(id="id_g_radio_01")
		//@CacheLookup
		public WebElement g_male_pf;
		
		//id_g_radio_02
		@FindBy(id="id_g_radio_02")
		//@CacheLookup
		public WebElement g_female_pf;
		
		@FindBy(id="id_checkbox")
		//@CacheLookup
		public WebElement checkbox_pf;

		@FindBy(id="id_state")
		//@CacheLookup
		public WebElement state_pf;

		@FindBy(id="copyright")
		@CacheLookup
		public WebElement copyright_pf;
		
		@FindBy(id="id_reset_button")
		//@CacheLookup
		public WebElement reset_button_pf;
		
		@FindBy(id="id_submit_button")
		//@CacheLookup
		public WebElement submit_button_pf;
		
		@FindBy(id="id_fname_conf")
		//@CacheLookup
		public WebElement fname_conf_pf;
		
		@FindBy(id="id_lname_conf")
		//@CacheLookup
		public WebElement lname_conf_pf;
		
		@FindBy(id="id_email_conf")
		//@CacheLookup
		public WebElement email_conf_pf;
		
		@FindBy(id="id_phone_conf")
		//@CacheLookup
		public WebElement phone_conf_pf;
		
		@FindBy(id="id_back_button")
		//@CacheLookup
		public WebElement back_button_pf;
		
		@FindBy(id="id_state_conf")
		//@CacheLookup
		public WebElement state_conf_pf;
		
		@FindBy(id="id_gender_conf")
		//@CacheLookup
		public WebElement gender_conf_pf;
		
		@FindBy(id="id_terms_conf")
		//@CacheLookup
		public WebElement terms_conf_pf;
		

}
