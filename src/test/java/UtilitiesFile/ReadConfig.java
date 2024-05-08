package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	String path="C:\\Users\\TSL\\Desktop\\java\\core java workspace\\seleniumFramework\\Configuration\\Config.Properties";
	public ReadConfig()
	{
		FileInputStream fn=null;
		try {
			fn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro=new Properties();
		try {
			pro.load(fn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String geturl()
	{
		String s1=pro.getProperty("BaseURL");
		if(s1!=null)
		{
			return s1;
		}
		else
		{
			throw new RuntimeException("url not found");
		}
	}
		public String getBrowser()
		{
			String s1=pro.getProperty("Browser");
			if(s1!=null)
			{
				return s1;
			}
			else
			{
				throw new RuntimeException("Browser not found");
			}
		}
	}


