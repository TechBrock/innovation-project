package com.example.bikeapplogin;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Bundle;


public class ConnectionNetwork extends Activity{
	
	public static ConnectivityManager conn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		conn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	}
	
	public boolean checkConnect (){
		
		ConnectivityManager conn = conn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		
		if(conn.getNetworkInfo(0).getState() == State.CONNECTED){
			return true;
		} else if (conn.getNetworkInfo(1).getState() == State.CONNECTED){
			return true;
		}else{
			return false;
		}
	}
	
}
