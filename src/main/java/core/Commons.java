package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

//PageFactory
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.VersionNumber;
import net.sf.uadetector.service.UADetectorServiceFactory;

public class Commons {

	String url_v0=null;
	String url_v1=null;
	String title_expected_sing_up=null;

	String facebook_image_link_id=null;
	String facebook_expected_title=null;
	String twitter_image_link_id=null;

	String twitter_title=null;
	String flickr_image_link_id=null;
	String flickr_title=null;

	String youtube_image_link_id=null;
	String youtube_title=null;
	String first_name_id=null;

	//String last_name_id=null;
	//String email_id=null;
	//String phone_number_id=null;

	String quotes_id=null;
	String current_location_id=null;
	String weather_icon_xpath=null;

	String current_data_id=null;
	String os_browser_id=null;
	String button_submit=null;

	String temperature_id=null;
	String erorr_fname_empty_expected=null;
	String erorr_lname_empty_expected=null;
	
	String erorr_email_empty_expected=null;
	String erorr_phone_empty_expected=null;
	String fname_error_id=null;
	
	String copyright_id=null;
	String copyright_expected=null;
			//"© 2016 learn2test.net";
	String test_case_id = null;
	
	static int test_case_count=0; 
	
	WebDriver driver=null;
	String handle;
	String parentHandle;
	
	static int instanceCount = 0;
	String GEO[]=new String[5];
	String Weather[] = new String[2];
	
	//"City, Region"
	String geoLocation_actual=null;
	String city_expected=null;
	
	String icon_weather_actual=null;
	String icon_weather_expected=null;
	String tempTemp=null;
	
	String regex_icon_url=null;
	String regex_temperature=null;
	//String title_expected_sing_up=null;
	
	String regex_city=null;
	String regex_data=null;
	String terms_expected=null;
	
	
	SingUp_PageFactory PF = PageFactory.initElements(this.driver, SingUp_PageFactory.class);
	UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
	
	//String proFile = "./src/main/resources/SingUpPageV0.properties";
	//String proFile = "./src/main/resources/SingUpPageV1.properties";
	//String proFile = "./src/main/resources/ConfirmationPageV1.properties";
	
	
	
	
	
					public void readProperties (String file_path) 

	{
		//new Object properties		
				try{
				Properties properties = new Properties();
				
				properties.load(new FileInputStream(file_path));
				
				
				url_v0 = properties.getProperty("url_v0");
				url_v1 = properties.getProperty("url_v1");
				title_expected_sing_up = properties.getProperty("title_expected_sing_up");

				facebook_image_link_id = properties.getProperty("facebook_image_link_id"); 
				facebook_expected_title = properties.getProperty("facebook_expected_title"); 
				twitter_image_link_id = properties.getProperty("twitter_image_link_id"); 

				twitter_title = properties.getProperty("twitter_title"); 
				flickr_image_link_id = properties.getProperty("flickr_image_link_id"); 
				flickr_title = properties.getProperty("flickr_title"); 

				youtube_image_link_id = properties.getProperty("youtube_image_link_id"); 
				youtube_title = properties.getProperty("youtube_title"); 
				first_name_id = properties.getProperty("first_name_id"); 

				quotes_id = properties.getProperty("quotes_id"); 
				current_location_id = properties.getProperty("current_location_id"); 
				weather_icon_xpath = properties.getProperty("weather_icon_xpath"); 

				current_data_id = properties.getProperty("current_data_id"); 
				os_browser_id = properties.getProperty("os_browser_id"); 
				button_submit = properties.getProperty("button_submit"); 

				temperature_id = properties.getProperty("temperature_id"); 
				regex_icon_url=properties.getProperty("regex_icon_url");
				regex_temperature =properties.getProperty ("regex_temperature");
				
				erorr_fname_empty_expected= properties.getProperty ("erorr_fname_empty_expected");
				fname_error_id= properties.getProperty ("fname_error_id");
				test_case_id= properties.getProperty ("test_case_id");
				
				regex_city= properties.getProperty ("regex_city");
				erorr_lname_empty_expected=properties.getProperty ("erorr_lname_empty_expected");
				erorr_email_empty_expected=properties.getProperty ("erorr_email_empty_expected");
				
				erorr_phone_empty_expected=properties.getProperty ("erorr_phone_empty_expected");
				regex_data = properties.getProperty ("regex_data");
				copyright_id = properties.getProperty ("copyright_id");
				
				copyright_expected = properties.getProperty ("copyright_text");
				
				
				//ifFileEmpty or not full	
				if ( properties.isEmpty() || 
						(url_v0==null) ||
						(url_v1==null) ||
						(title_expected_sing_up==null) ||

						(facebook_image_link_id==null) ||
						(facebook_expected_title==null) ||
						(twitter_image_link_id==null) ||

						(twitter_title==null) ||
						(flickr_image_link_id==null) ||
						(flickr_title==null) ||

						(youtube_image_link_id==null) ||
						(youtube_title==null) ||
						(first_name_id==null) ||

						(quotes_id==null) ||
						(current_location_id==null) ||
						(weather_icon_xpath==null) ||

						(current_data_id==null) ||
						(os_browser_id==null) ||
						(button_submit==null) ||

						(temperature_id==null) ||
						(regex_icon_url==null) ||
						(regex_temperature==null)||
						
						(erorr_fname_empty_expected==null) ||
						(fname_error_id==null) ||
						(test_case_id==null) ||
						
						(regex_city==null) ||
						(regex_data==null) ||
						(erorr_lname_empty_expected==null) ||
						
						(erorr_email_empty_expected==null) ||
						(erorr_phone_empty_expected==null) ||
						(copyright_id==null) ||
						
						(copyright_expected==null)
						) 
					
				{
					System.out.println("Warning File is Empty or not correct ! --> \""+file_path+"\""); System.exit(1);
					}

//				else
//				{
//					System.out.println("File read completed!");
//				}
				
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
	
					//Method Read_CSV_Files
					//Read CSV files
					//First Name; Last Name; Email; phone_number, Gender, State, Terms
					public String[][] Read_CSV(String csvPath)
					{
						String[][] CSV=null;
						try{
							
						
						BufferedReader br_csv = null;
						String line_cs = null;
						String[] column=null;
						int countLines=0;
						int countColumns=0;
						String SplitBy = ";";

					//numbers of records (line) in file
					short i=0;
					br_csv = new BufferedReader(new FileReader(csvPath));
						while((line_cs=br_csv.readLine()) !=null)
						{
							countLines++;
							column=line_cs.split(SplitBy); // ";"
							countColumns=column.length;
						}
						
						br_csv.close();
							
					CSV = new String[countLines][countColumns];
							
					br_csv = new BufferedReader(new FileReader(csvPath));


					while ((line_cs = br_csv.readLine()) != null) {

						String[] csv = line_cs.split(SplitBy);

						//numbers of columns in file
						for(short j=0;j<=countColumns-1;j++)
						{CSV[i][j] = csv[j];}
					 	i++;
						}
						
					br_csv.close();
					
				//Print for test	
					
//						for (i=0;i<=countLines-1;i++)
//					{
//							for (short j=0;j<=countColumns-1;j++)
//							{
//								System.out.print("\t\t"+CSV[i][j]);
//								
//							}
//							System.out.println();
//					}
					// throws IOException, FileNotFoundException, ArrayIndexOutOfBoundsException
						}catch (FileNotFoundException e) {
							System.out.println("Method 'Read_CSV()' - BLOCK");
							System.out.println();
							System.out.println(e.getMessage());
						}
						catch (IOException e) {
							System.out.println("Method 'Read_CSV()' - BLOCK");
							System.out.println();
							System.out.println(e.getMessage());
						}
						catch (ArrayIndexOutOfBoundsException e) {
							System.out.println("Method 'Read_CSV()' - BLOCK");
							System.out.println();
							System.out.println(e.getMessage());
						}
				// Return Array
					return CSV;
					}
				//END Method Read_CSV_Files
			
					public String[] read2DimensionsArray(String [][] before, int point)
					{ 
						
						//int startLine=0;
//						Method must return array, Just ONE Line ('a' or 'b' or 'c' or etc.) from 2 DimensionsArray
//						point={a,b or c} - number of line, start from "0"
//						a 	1;	2;	3;	4;	5;	6;	7;
//						b	1;	2;	3;	4;	5;	6;	7;
//						c 	1;	2;	3;	4;	5;	6;	7;
						//First Name; Last Name; Email; phone_number, Gender, State, Terms

						
						int lenghtOfArray=before[1].length;
						String [] goBack=new String [lenghtOfArray];
						//System.out.println(lenghtOfArray);
						
						for(int i=0;i<=lenghtOfArray-1;i++)
						{
							goBack[i]=before[point][i];
							//System.out.println(" "+goBack[i]);
						}
						
						return goBack;
					}
					
					public boolean checkExistElement_id(String element_id)
			{
						
				try{
				
					  List<WebElement> inkognito_id = driver.findElements(By.id(element_id));
					
					if ((inkognito_id.size()!=0)&&(inkognito_id.size()==1))
				{
					//System.out.println("checkExistElement_id() - true");
				return true;	
				}
				
					//if we found elements more than '1' - it's mean Duplicate
					else if (inkognito_id.size()>1)
					{
						for (int i = 0; i < inkognito_id.size(); i++) {
							System.out.println("element_id"+element_id+"-"+inkognito_id.get(i)); }
					}
				
				
				}
				
				catch(WebDriverException e)
				{
						//driver.quit();	
						System.out.println("Method 'checkExistElement_id()' - BLOCK");
						System.out.println();
						System.out.println(e.getMessage());
				}	
				
//				catch(NoSuchElementException e)
//				{
//						//driver.quit();	
//						System.out.println("Method 'checkExistElement_id()' - BLOCK");
//						System.out.println();
//						System.out.println(e.getMessage());
//				}	
				

				
				
				
				//System.out.println("checkExistElement_id() - false");
			return false;	
			}
			
			//My Function		
					public static void HtmlUnitLoggingOff()
			{
		    	//Turning HtmlUnit Warnings off 
				//BEGIN		
						LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
				        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
				        java.util.logging.Logger.getLogger("org.apache.http.client.protocol.ResponseProcessCookies").setLevel(Level.OFF);
				        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
				//END	
			}
			
			//Frankistain
			//http://automated-testing.info/t/kak-v-selenium-rabotat-s-oknom-vybora/6113
					
					public void closeNewTab(String parentHandle, String handle) {
				        switchToWindow(handle).close();
				        handle = "";
				        //Switch back to the parent window 
				        driver.switchTo().window(parentHandle);
				    }

				    public WebDriver switchToWindow(String handle) {
				        checkForClosed(handle);
				        return driver.switchTo().window(handle);
				    }
				    
				    public WebDriver switchToParent(String parentHandle, String handle) {
				        checkForClosed(handle);
				        return driver.switchTo().window(parentHandle);
				    }

				    public String getNewHandle(Set < String > oldHandles) {
				        Set < String > newHandles = driver.getWindowHandles();
				        newHandles.removeAll(oldHandles);
				        //Find the new window 
				        for (String handle: newHandles)
				            return handle;
				        return null;
				    }
				    
				    public void checkForClosed(String handle) {
				        if (handle == null || handle.equals(""))
				            throw new WebDriverException("Web Window closed or not initialized");
				    }
				    
				    public String injectAnchorTag(String id, String url) {
				        return String.format("var anchorTag = document.createElement('a'); " +
				            "anchorTag.appendChild(document.createTextNode('nwh'));" +
				            "anchorTag.setAttribute('id', '%s');" +
				            "anchorTag.setAttribute('href', '%s');" +
				            "anchorTag.setAttribute('target', '_blank');" +
				            "anchorTag.setAttribute('style', 'display:block;');" +
				            "document.getElementsByTagName('body')[0].appendChild(anchorTag);",
				            id, url
				        );
				    }

				    public String newTab(String url)
				{

				String name = "a_Web_Window_" + instanceCount++;
				 //Record old handles 
				Set < String > oldHandles = driver.getWindowHandles();
				parentHandle = driver.getWindowHandle();

				//Inject an anchor element 
				((JavascriptExecutor) driver).executeScript(injectAnchorTag(name, url));

				//Click on the anchor element 
				driver.findElement(By.id(name)).click();
				handle = getNewHandle(oldHandles);
				return handle;
				}
			
				    public String regExp(String pattern, String input) 
					{
						
						String found=null;
						try{
						Pattern currentDate = Pattern.compile(pattern);
						Matcher regex = currentDate.matcher(input);
						regex.find();
						//System.out.println(regex.group(0));
						//System.out.println(regex.group(1));
						//System.out.println(regex.group(2));
						
						found = regex.group(0);
						
						}catch(IllegalStateException e)
						{
								//driver.quit();	
								System.out.println("Method 'reGex' - BLOCK");
								System.out.println();
								System.out.println(e.getMessage());
						}
						catch(NullPointerException e)
						{
								//driver.quit();	
								System.out.println("Method 'reGex' - BLOCK");
								System.out.println();
								System.out.println(e.getMessage());
						}
						
						
						return found;
					}	
	
				  	public String currentData() 
					//throws Exception
			{
	// MMM d, yyyy
//			Example: [May 7,2016]		
				
				String pattern = "MMMM d, yyyy";
				String date = new SimpleDateFormat(pattern).format(new Date());
				return date;
			}
			
				  	
				  	//Temp
				  	//icon_url
				  	public String[] Weather (String latitude, String longtitude)
			{
			
				String Weather[] = new String[2];
			try{	

			URL webService;
			
				webService = new URL ("http://api.wunderground.com/api/ed915a71a151a38b/conditions/q/"+latitude+","+longtitude+".json");
			
			
			InputStream stream_location;

				stream_location = webService.openStream();
			
			JsonParser json_location=Json.createParser(stream_location);
			
			while (json_location.hasNext())
			{
				Event e=json_location.next();
				if(e==Event.KEY_NAME)
				{
					switch (json_location.getString())
					{
					case "temp_f":
						
						json_location.next();
						Weather[0]=json_location.getString();
						//System.out.println("Temp: "+json_location.getString());
					break;
					
					case "icon_url":
						
						json_location.next();
						Weather[1]=json_location.getString();
						//System.out.println("icon_url: "+json_location.getString());
					break;
					}
				}
			}
			}
			catch(IOException e)
			{
			System.out.println("Method 'Weather()' - BLOCK");
			System.out.println();
			System.out.println(e.getMessage());
			}
			
			return Weather;
		}
			//BEGIN TEST CASES
			
			//Must be open Page in WebDriver
					public String checkBrowser(){
						
					String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
					ReadableUserAgent a1=	parser.parse(uAgent);
					VersionNumber browserVersion = a1.getVersionNumber();
					
					String 	browes=a1.getName()+" "+browserVersion.toVersionString();
					browes= browes.replace(".0","");
					
					return browes;
						    }
								
					//Must be open Page in WebDriver
					public String checkOS()
					{
						String uAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
						ReadableUserAgent a1=	parser.parse(uAgent);
						String os =a1.getOperatingSystem().getName();
						
						return os;
					}
					
					public String myIP() 
					{
						//String GEO[]=new String[5];
						//String geoplugin_city=null;
						//String geoplugin_region=null;
						//String geoplugin_latitude=null;
						//String geoplugin_longtitude=null;

						String myIP = null;

// Try to find my ip adress using WebServices
//						$ curl 'https://api.ipify.org?format=json'
//						{"ip":"xxx.xxx.xxx.xxx"}
						
						try{

						
						URL webService= new URL ("https://api.ipify.org?format=json");
						InputStream stream_location=webService.openStream();
						JsonParser json_location=Json.createParser(stream_location);
						
						while (json_location.hasNext())
						{
							Event e=json_location.next();
							if(e==Event.KEY_NAME)
							{
								switch (json_location.getString())
								{

									case "ip":
									json_location.next();
									//System.out.print("IP: "+json_location.getString());
									myIP=json_location.getString();
									
								break;
								}
							}
						}
						
						
				
						
						}
						catch(IOException e)
						{
							System.out.println("Method 'myIP()' - BLOCK");
							System.out.println();
							System.out.println(e.getMessage());
						}
						return myIP;
						
					}
						
					public String[] whereIam (String myIP)
					{

						//geoplugin_city=null;
						//geoplugin_region=null;
						//geoplugin_latitude=null;
						//geoplugin_longtitude=null;
						//geoplugin_city, geoplugin_region

						String GEO[]=new String[5];
						
						
						try{
							
							// Try to find geo-location
							//http://www.geoplugin.net/json.gp?ip=+ip
									
							URL webService= new URL ("http://www.geoplugin.net/json.gp?ip="+myIP);
									
							InputStream	stream_location=webService.openStream();
							JsonParser json_location=Json.createParser(stream_location);
							
									while (json_location.hasNext())
									{
										Event e=json_location.next();
										if(e==Event.KEY_NAME)
										{
											switch (json_location.getString())
											{
											//geoplugin_city
											case "geoplugin_city":
												json_location.next();
												//System.out.print("City: "+json_location.getString());
												GEO[0]=json_location.getString();
											break;	
											
											//geoplugin_region
											case "geoplugin_region":
												json_location.next();
												//System.out.println("Region: "+json_location.getString());
												GEO[1]=json_location.getString();
											break;
											
											//geoplugin_latitude
											case "geoplugin_latitude":
												json_location.next();
												GEO[2]=json_location.getString();
											break;
											
											//geoplugin_longtitude
											case "geoplugin_longitude":
												json_location.next();
												GEO[3]=json_location.getString();
											break;
											
											}
										}
									}
						
									//City, Region
									GEO[4]=GEO[0]+", "+GEO[1];
									
									//Print to test
//									for(int i=0;i<GEO.length;i++)
//									{
//										System.out.print(GEO[i]+" ");
//									}
									
						}
						catch(IOException e)
						{
						System.out.println("Method 'whereIam()' - BLOCK");
						System.out.println();
						System.out.println(e.getMessage());
						}

						//geoplugin_city=null;
						//geoplugin_region=null;
						//geoplugin_latitude=null;
						//geoplugin_longtitude=null;
						//geoplugin_city, geoplugin_region
						
						
						
						return GEO;
					}
			
					public boolean inputValueField(String element_id, String input_value, WebElement pageFactory){
				boolean flag=false;
								
								//System.out.println("oK");
								switch (element_id)
								{
								case "id_fname":
									pageFactory.sendKeys(input_value);
									flag=true;
									//driver.findElement(By.id(element_id)).sendKeys(input_value);	
								break;	
								
								
								case "id_lname":
									pageFactory.sendKeys(input_value);
									flag=true;
									//driver.findElement(By.id(element_id)).sendKeys(input_value);
								break;

								case "id_email":
									pageFactory.sendKeys(input_value);
									flag=true;
									//driver.findElement(By.id(element_id)).sendKeys(input_value);
								break;
									
								case "id_phone":
									pageFactory.sendKeys(input_value);
									//driver.findElement(By.id(element_id)).sendKeys(input_value);
								break;
									
								case "id_g_radio_01":
									
								pageFactory.click();
								flag=true;
								//driver.findElement(By.id(element_id)).click();
								break;
								
								case "id_g_radio_02":
								pageFactory.click();
								flag=true;
								//driver.findElement(By.id(element_id)).click();	
									
								break;
								
								case "id_checkbox":
									//if (input_value=="true")
									if("true".equals(input_value))	
								{
									pageFactory.click();
									flag=true;
									//driver.findElement(By.id(element_id)).click();	
									terms_expected="Agreed";
									}
								break;
								
								case "id_state":
									if ((input_value!=null)||(input_value!=" "))
									{
								new Select (pageFactory.findElement(By.id(element_id))).selectByVisibleText(input_value);		
									//System.out.println("++++"+input_value);
									//System.out.println("++++"+element_id);
								//new Select (driver.findElement(By.id(element_id))).selectByVisibleText(input_value);
								//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
									}
								break;
								
								case "id_submit_button":
									//if ((input_value!=null)||(input_value!=" ")){
									
									flag=true;
									//pageFactory.submit();
									pageFactory.click();
									//driver.findElement(By.id(element_id)).submit();
									//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
									//}	
								break;
								
								//button_reset=id_reset_button
								case "id_reset_button":
									flag=true;
									pageFactory.click();
								break;
									
								//For Confirmation Page
								case "id_back_button":
									pageFactory.click();
									//driver.findElement(By.id(element_id)).click();	
									driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
								break;
									}	
									
								
											
								
						return flag;
				}
					
					public String getValueField(String element_id, WebElement pageFactory){
						
						String value_actual=null;
						try{
//						if (checkExistElement_id(element_id))
//						{
						
						switch (element_id)
						{
						case "id_fname_conf":
							value_actual = pageFactory.getText();
							//driver.findElement(By.id(element_id)).getText();
						break;	
						
						case "id_lname_conf":
							value_actual  = pageFactory.getText();
							//driver.findElement(By.id(element_id)).getText();	 
						break;		
						
						case "id_email_conf":
							value_actual  = pageFactory.getText();
							//driver.findElement(By.id(element_id)).getText();
						break;


						case "id_phone_conf":
							value_actual = pageFactory.getText(); 
							//driver.findElement(By.id(element_id)).getText(); 
						break;
							
						
						case "id_state_conf":
							value_actual = pageFactory.getText();
							//value_actual = driver.findElement(By.id(element_id)).getText(); 
						break;
						
						case "id_gender_conf":
							value_actual = pageFactory.getText();
							//value_actual = driver.findElement(By.id(element_id)).getText(); 
						break;
						
						case "id_terms_conf":
							value_actual = pageFactory.getText();
							//value_actual = driver.findElement(By.id(element_id)).getText(); 
						break;
						
						case "copyright":
							value_actual = pageFactory.getText();
							//value_actual = driver.findElement(By.id(element_id)).getText(); 
						break;
						
//						case "id_back_button":
//							pageFactory.click();
//							//driver.findElement(By.id(element_id)).click();	
//							driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//						break;
//						String state_actual = driver.findElement(By.id("id_state_conf")).getText();
//						String gender_actual=driver.findElement(By.id("id_gender_conf")).getText();
//						String terms_actual=driver.findElement(By.id("id_terms_conf")).getText();	

						
//						case "conf_button_back":
//							value_actual = driver.findElement(By.id(element_id)).getText(); 
//						break;	
						}
					
						
						//}

						}
						catch (NoSuchElementException e) {
							System.out.println("Method 'getValueField()' - BLOCK");
							System.out.println("Element_id- "+element_id);
							System.out.println("PageFactory- "+pageFactory);
						}
						
						catch (NullPointerException e) {
							System.out.println("Method 'getValueField()' - BLOCK");
							System.out.println("Element_id- "+element_id);
							System.out.println("PageFactory- "+pageFactory);}
						
						return value_actual;
						
					}
			//public String 
					
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
						System.out.println("Test Case ID: \t\t"+test_case_id+test_case_count+" - PASSED");
						System.out.println("CopyRight Expected/Actual: \t" + copyright_expected+" / "+copyright_actual);
						
						System.out.println("....<<<<");
						System.out.println();
						return true;	
					} else {
						System.out.println(">>>>....");
						System.out.println("Test Case ID: \t\t" +test_case_id+test_case_count+ " - FAILED");
						System.out.println("CopyRight Expected/Actual: \t" + copyright_expected+" / "+copyright_actual);
						
						System.out.println("....<<<<");
						System.out.println();
					}

					} catch(NoSuchElementException e)
					{
							System.out.println("Test Case ID: \t\t" +test_case_id+test_case_count+ " - BLOCK");
							System.out.println();
							System.out.println(e.getMessage());
					}		
						return false;
					}

					
					public void after(){
						
						driver.close();
						driver.quit();
						//System.out.println("All Test Cases - DONE");
					}	
					
					
					
	// END CLASS
}
