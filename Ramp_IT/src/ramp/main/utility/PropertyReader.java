package ramp.main.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	static Properties globalProperyReader ;
	
	public static void loadGlobalProperties(){
		try {
			globalProperyReader = new Properties();
			File propertyFile = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+"properties"+System.getProperty("file.separator")+"GlobalRamp.property");
			InputStream in = new FileInputStream(propertyFile);
			globalProperyReader.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getGlobalProperty(String propertKey){
		return globalProperyReader.getProperty(propertKey);
	}
	
	public static void setGlobalProperty(String key, String value){
		globalProperyReader.setProperty(key, value);
	}

}
