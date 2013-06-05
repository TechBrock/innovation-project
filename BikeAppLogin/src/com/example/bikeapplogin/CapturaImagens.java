package com.example.bikeapplogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class CapturaImagens extends Activity{
	
	public View getImage(Context cont, String caminho) {
		setContentView(R.layout.webview); 
		
		WebView webV = new WebView(cont);
		
		WebSettings webS = webV.getSettings();
		webS.setSavePassword(false);
		webS.setSaveFormData(false);
		webS.setJavaScriptEnabled(true);
		webS.setSupportZoom(false);
		webV.loadUrl(caminho);
		
		return webV;
	}

}
