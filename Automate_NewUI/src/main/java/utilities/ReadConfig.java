package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	
	
	
	
	public ReadConfig() {
		
		
		File src = new File("/home/fayaz/Documents/NewReactUI/Automate_NewUI/Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e ) {
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		System.out.println(url);
		return url;
	}
	
	
	
}

