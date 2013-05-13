package com.example.bikeapplogin;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class RequisicoesHttp {

	public static String get(String endereco){
		
		try{
			URL url = new URL(endereco);
			URLConnection urlConn = url.openConnection();
			
			InputStream inputS = urlConn.getInputStream();
			Scanner scn = new Scanner(inputS);
			
			String jSon = scn.useDelimiter("\\A").next();

			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}

	}
	
}
