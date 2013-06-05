package com.example.bikeapplogin;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONArray;

public class RequisicoesHttp {
	
	private static String jSonString;
	private static JSONArray jSonArray;
	private static Scanner scn;
	private static URL url;
	private static URLConnection urlConn;
	private static InputStream inputS;
	private WebUsuario usuario;

	@SuppressWarnings("finally")
	public static String getString(String endereco){
		
		try{
			url = new URL(endereco);
			urlConn = url.openConnection();
			inputS = urlConn.getInputStream();
			scn = new Scanner(inputS);
			
			jSonString = scn.useDelimiter("\\A").next();

			return jSonString;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			scn.close();
			return jSonString;
		}

	}
	
	@SuppressWarnings("finally")
	public static JSONArray getJsonArray(String endereco){
		
		try{
			url = new URL(endereco);
			urlConn = url.openConnection();
			inputS = urlConn.getInputStream();
			scn = new Scanner(inputS);
			
			//jSonArray = scn.useDelimiter("\\A").next();

			return jSonArray;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			scn.close();
			return jSonArray;
		}

	}
	
	public WebUsuario usuario (){
		usuario = new WebUsuario();

		return usuario;
	}
	
	
	
	
}
