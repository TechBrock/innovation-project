package com.example.bikeapplogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Gallery;
import android.widget.AdapterView; 
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import android.view.ViewGroup.LayoutParams; 

@SuppressWarnings("deprecation")
public class ImagensActivity extends Activity implements ViewFactory{
	
	//private int[] fig = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4};
	private int[] fig = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4};
	private ImageSwitcher imgSw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagens);
		
		imgSw = (ImageSwitcher) findViewById(R.id.imagemOptions);
		imgSw.setFactory(this);
		imgSw.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
		imgSw.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
		
		Gallery gall = (Gallery) findViewById(R.id.galeriaImagens);
		gall.setAdapter(new ImagemAdapter(this, fig, new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)));
		gall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
				// TODO Auto-generated method stub
				imgSw.setImageResource(fig[position]);
			}
									
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	@Override
	public View makeView() {
		// TODO Auto-generated method stub
		
		ImageView imgVw = new ImageView(this);
		imgVw.setBackgroundColor(0xF25E65);
		imgVw.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imgVw.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));     

		return imgVw;
	}
	
}
