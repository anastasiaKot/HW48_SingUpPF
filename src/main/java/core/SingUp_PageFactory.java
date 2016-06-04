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

public class SingUp_PageFactory {


	//Page Factory unsupported variables :(((	
	@FindBy(id="id_link_facebook")
	//@CacheLookup
	public WebElement facebook_image_link_pf;
	
	@FindBy(id="id_img_twitter")
	//@CacheLookup
	public WebElement twitter_image_link_pf;
	
	@FindBy(id="id_img_flickr")
	//@CacheLookup
	public WebElement flickr_image_link_pf;
	
	@FindBy(id="id_img_youtube")
	//@CacheLookup
	public WebElement youtube_image_link_pf;

	@FindBy(id="id_quotes")
	@CacheLookup
	public WebElement quotes_pf;

	@FindBy(id="id_current_location")
	//@CacheLookup
	public WebElement current_location_id_pf;

	@FindBy(xpath="//tbody/tr[2]/td[2]/img")
	@CacheLookup
	public WebElement weather_icon_pf;

	@FindBy(id="timestamp")
	//@CacheLookup
	public WebElement current_data_pf;
		
	@FindBy(id="os_browser")
	//@CacheLookup
	public WebElement os_browser_pf;
	
	@FindBy(id="id_submit_button")
	//@CacheLookup
	public WebElement submit_button_pf;
	
	@FindBy(id="id_temperature")
	//@CacheLookup
	public WebElement temperature_pf;

	@FindBy(id="ErrorLine")
	//@CacheLookup
	public WebElement ErrorLine_pf;
	
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
	
//	Text field "Phone"
	@FindBy(id="id_phone")
	//@CacheLookup
	public WebElement phone_pf;
	
	//id_g_radio_01
	@FindBy(id="id_g_radio_01")
	//@CacheLookup
	public WebElement g_radio_01_pf;
	
	//id_g_radio_02
	@FindBy(id="id_g_radio_02")
	//@CacheLookup
	public WebElement g_radio_02_pf;
	
	@FindBy(id="id_checkbox")
	//@CacheLookup
	public WebElement checkbox_pf;

	@FindBy(id="id_state")
	//@CacheLookup
	public WebElement state_pf;

	@FindBy(id="copyright")
	@CacheLookup
	public WebElement copyright_pf;
	
	//isDisplayed
	@FindBy(id="lname_error")
	//@CacheLookup
	public WebElement lname_error_pf;
	
	@FindBy(id="fname_error")
	//@CacheLookup
	public WebElement fname_error_pf;
	
	@FindBy(id="email_error")
	//@CacheLookup
	public WebElement email_error_pf;
	
	@FindBy(id="phone_error")
	//@CacheLookup
	public WebElement phone_error_pf;
	
	@FindBy(id="id_reset_button")
	//@CacheLookup
	public WebElement reset_button_pf;
	
	
	
}
