package com.hc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyReader {
	
	private static PropertyReader HealthcarePropertyReader;
	public  Properties properties;
	
	private PropertyReader(){
		
	}
	
	public static PropertyReader getHealthcarePropertyReader(){
		if(HealthcarePropertyReader==null)
		{
			HealthcarePropertyReader=new PropertyReader();
		}
		return HealthcarePropertyReader;
	}
		public static void main(String args[]){
			PropertyReader propertyReader=new PropertyReader();
			String baselocation=propertyReader.getProperty(HealthCareConstants.BASE_LOCATION);
			System.out.println("baselocation :"+baselocation);
			propertyReader.getAllProperties();
		}
	public  Properties loadProperties(){
	try {
		File file = new File("C:/Users/AdiVenkataReddy/Desktop/HelthCare/resources/HealthCare.properties");
		FileInputStream fileInput = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInput);
		fileInput.close();
		printProperties();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return properties;
	}
	private  void printProperties(){
		Enumeration enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) {
			String key = (String) enuKeys.nextElement();
			String value = properties.getProperty(key);
			System.out.println(key + ": " + value);
		}
	}
	public String getProperty(String key){
			loadProperties();
			if(properties!=null)
			{
				return properties.getProperty(key);
			}
			return null;
			
	}
			public Properties getAllProperties(){
			System.out.println("properties:" +properties);
			return properties;
			
		}
	
	
	
	



}
