package com.example.bikeapplogin;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class RequisicoesHttp {
	
	private static String jSon;
	private static Scanner scn;
	private static URL url;
	private static URLConnection urlConn;
	private static InputStream inputS;
	private WebUsuario usuario;

	public static String get(String endereco){
		
		try{
			url = new URL(endereco);
			urlConn = url.openConnection();
			inputS = urlConn.getInputStream();
			scn = new Scanner(inputS);
			
			jSon = scn.useDelimiter("\\A").next();

			return null;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			scn.close();
		}

	}
	
	public WebUsuario usuario (){
		usuario = new WebUsuario();
		
		
		return usuario;
	}
	
	
	
	
}
