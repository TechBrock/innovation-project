package com.example.bikeapplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class PerfilActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);
	}

	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    
    public void callPerfil (View v){
    	goToActivity(PerfilActivity.class);
    } 
    
    public void callOfertas (View v){
    	goToActivity(ItensActivity.class);
    } 
    
    View itemView;
    
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
    } 
   
    public void callFavoritos (View v){
    	goToActivity(FavoritoActivity.class);
    } 
    
    public void callLogin (View v){
    	goToActivity(MainActivity.class);
    }
    
    public void callEditar (View v){
    	goToActivity(PerfilPersonalizadoActivity.class);
    }
	
}
