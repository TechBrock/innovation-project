package com.example.bikeapplogin;

import java.util.ArrayList;

import com.example.bikeapplogin.ComprasActivity.ItemListAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FavoritoActivity extends Activity{
	
	private ArrayList<String> item;
	public ItemListAdapter fvAdapter;
	
	public FavoritoActivity (){
		// TODO Auto-generated constructor stub
		item = new ArrayList<String>();
				
		//itens que recebem o objeto
				
		item.add("Item 1");
		item.add("Item 2");
		item.add("Item 3");
		item.add("Item 4");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favoritos);
		
		ListView listaPedidos = (ListView) findViewById(R.id.listaFavoritos);
		this.fvAdapter = new ItemListAdapter(this, R.layout.listafavorito, item);	
		listaPedidos.setAdapter(this.fvAdapter);
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
    
    public void callCompras (View v){
    	goToActivity(ComprasActivity.class);
    } 
   
    public void callFavoritos (View v){
    	goToActivity(FavoritoActivity.class);
    }
    
    public void callLogin (View v){
    	goToActivity(MainActivity.class);
    }
    
    public class ItemListAdapter extends ArrayAdapter<String>{

		public ItemListAdapter(Context context, int textViewResourceId, ArrayList<String> itens) {
			super(context, textViewResourceId, itens);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View listaView = convertView;
			ImageView imgFavorita;
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listafavorito, null);
				
				imgFavorita = (ImageView) listaView.findViewById(R.id.btFavorito);
				imgFavorita.setOnClickListener(new ImageView.OnClickListener()
						{
					
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								
								//validar se é favorito pelo id do objeto e não desta forma abaixo MUDAR ISSO
								
								ImageView imgEstrela = (ImageView) findViewById(R.id.btFavorito);
								Drawable dbImgItem = getResources().getDrawable(R.drawable.logoestrela);
								
								if(imgEstrela.getDrawable().getChangingConfigurations() == dbImgItem.getChangingConfigurations()){
									Drawable dbImgestrelaInvertida = getResources().getDrawable(R.drawable.logoestrelainvertida);
									imgEstrela.setImageDrawable(dbImgestrelaInvertida);
									//goToActivity(ItemActivity.class);
								}else{
									imgEstrela.setImageDrawable(dbImgItem);
								}
							}
						});
			}
			
			return listaView;	
				
		}
	}
	
}
