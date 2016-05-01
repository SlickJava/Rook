package com.slickjava.rook.security;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class EncryptionProperties {
	
	private FileReader encrypt;
	private Properties props = new Properties();
	private String key;
	private String IV;
	
	public EncryptionProperties()
	{
		try {
			encrypt = new FileReader("encrypt.properties");
			props.load(encrypt);
			key = props.getProperty("key");
			IV = props.getProperty("iv");
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getKey() {
		return key;
	}

	public String getIV() {
		return IV;
	}
	
	


}
