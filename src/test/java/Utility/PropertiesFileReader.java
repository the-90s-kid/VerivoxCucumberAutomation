package Utility;

//Author Chinmaya Bhagwat mail : bhagwatchinmaya@gmail.com

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	public Properties getProperty() throws IOException
	{
		
		String projectPath = System.getProperty("user.dir");		
        Properties properties = new Properties();
        try {        	 
            properties.load(new FileInputStream(projectPath + 
    				"/src/main/java/resources/data.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return properties;	
	}

}
