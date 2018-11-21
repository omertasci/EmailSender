package com.omertasci.javamail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	
	String propFileName;
	
	public ConfigLoader(String propFileName){
		this.propFileName = propFileName;
	}
	

	String result = "";
	InputStream inputStream;

	public Properties getPropValues() throws IOException {
		Properties prop = null;
		try {
			prop = new Properties();
			String propFileName = this.propFileName ; //"docs/email.properties";  // "resources/email.properties";
	
//			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			inputStream = new FileInputStream(propFileName);
	
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
}