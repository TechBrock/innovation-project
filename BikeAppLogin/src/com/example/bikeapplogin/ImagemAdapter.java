package com.example.bikeapplogin;

import android.content.Context; 
import android.view.View; 
import android.view.ViewGroup; 
import android.view.ViewGroup.LayoutParams; 
import android.widget.BaseAdapter; 
import android.widget.ImageView;

public class ImagemAdapter extends BaseAdapter{
	
	private Context contX;
	private final int[] imgs;
	private final LayoutParams paramters;
	
	public ImagemAdapter (Context ctx, int[] images, LayoutParams params) {
		this.contX = ctx;
		this.imgs = images;
		this.paramters = params;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgs.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View viewConvert, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ImageView image = new ImageView(contX);
		image.setImageResource(imgs[position]);
		image.setAdjustViewBounds(true);
		image.setLayoutParams(paramters);
		
		return image;
	}

}
