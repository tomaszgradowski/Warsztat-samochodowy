package pl.cars.controller;

import java.net.MalformedURLException;
import java.net.URL;

public class smstest {

	public static void main(String[] args) {
	
		//https://api.smsapi.pl/sms.do?to=665872197&message=test&test=0&access_token=FrdBslodVhAE9sedO2UZxfCHOlaW6QG4mPEH6ePg
		
		
		try {
			URL url  = new URL("https://api.smsapi.pl/sms.do");
			
			System.out.println(url.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
