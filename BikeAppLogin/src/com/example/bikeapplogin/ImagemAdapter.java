package com.example.bikeapplogin;

import java.util.List;

import android.content.Context; 
import android.graphics.Bitmap;
import android.view.View; 
import android.view.ViewGroup; 
import android.view.ViewGroup.LayoutParams; 
import android.widget.BaseAdapter; 
import android.widget.ImageView;

public class ImagemAdapter extends BaseAdapter{
	
	private Context contX;
	//private final int[] imgs;
	private List<String> imgs;
	private final LayoutParams paramters;
	private capturaImagens cap;
	
	public ImagemAdapter (Context ctx, List<String> imagens, LayoutParams params) {
		this.contX = ctx;
		this.imgs = imagens;
		this.paramters = params;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgs.toArray().length;
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
		Bitmap bm = Bitmap.createBitmap(cap.getImage(contX, imgs.get(position)).getDrawingCache());
		image.setImageBitmap(bm);
		image.setAdjustViewBounds(true);
		image.setLayoutParams(paramters);
		
		return image;
	}

}
