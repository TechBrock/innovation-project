package com.example.bikeapplogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class teste extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teste);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
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
	
}
