package com.example.bikeapplogin;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class teste extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.teste);
		
		WebView web = new WebView(this);
		WebSettings w = web.getSettings();
		w.setSavePassword(false);
		w.setSaveFormData(false);
		w.setJavaScriptCanOpenWindowsAutomatically(true);
		w.setSupportZoom(false);
		
		web.loadUrl("http://www.google.com.br");
		//lucas
		
		setContentView(web);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	/*
	View itemView;
	
	public teste (View w){
		LayoutInflater callPop = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
		itemView = callPop.inflate(R.layout.item, null);
		
		final PopupWindow pop = new PopupWindow(itemView);
		
		ImageView ImgSair = (ImageView) itemView.findViewById(R.id.btSairPopBike);
		ImgSair.setOnClickListener(new ImageView.OnClickListener()
				{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						pop.dismiss();	
					}
				});	
		
		pop.showAsDropDown(w, 2, -1);
	}
	*/
	
	/*
	 *     View itemView;
    
    	public void callCompras (View v){
    	//goToActivity(ComprasActivity.class);
    	LayoutInflater callPop = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
		itemView = callPop.inflate(R.layout.item, null);
		
		final PopupWindow pop = new PopupWindow(itemView);
		
		ImageView ImgSair = (ImageView) itemView.findViewById(R.id.btSairPopBike);
		ImgSair.setOnClickListener(new ImageView.OnClickListener()
				{
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						pop.dismiss();	
					}
				});	
		
		pop.showAsDropDown(v, 50, -30);
	*/
	
}
