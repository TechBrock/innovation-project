package com.example.bikeapplogin;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
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
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ItensActivity extends Activity {
	
	private ArrayList<String> item;
	public ItemListAdapter itAdapter;
	
	public ItensActivity() {
		// TODO Auto-generated constructor stub
		item = new ArrayList<String>();
		
		//itens que recebem o objeto
		
		item.add("Descrição 1");
		item.add("Descrição 2");
		item.add("Descrição 3");
		item.add("Descrição 4");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itens);

		ListView listaItens = (ListView) findViewById(R.id.listaItens);
		this.itAdapter = new ItemListAdapter(this, R.layout.listaitens, item);	
		listaItens.setAdapter(this.itAdapter);
	}	
	
	public void adicionaIten (){
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
		
		private ArrayList<String> lstItem;

		public ItemListAdapter(Context context, int textViewResourceId, ArrayList<String> itens) {
			super(context, textViewResourceId, itens);
			// TODO Auto-generated constructor stub
			
			this.lstItem = itens;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View listaView = convertView;
			ImageView imgBike;
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listaitens, null);
				
				imgBike = (ImageView) listaView.findViewById(R.id.rotulobike);
				imgBike.setOnClickListener(new ImageView.OnClickListener()
						{
					
							View itemView;
					
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								goToActivity(ItemActivity.class);
								/*
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
								
								pop.showAsDropDown(v, 2, -1);
								*/
							}
						});
			}

			//String str = lstItem.get(position); //pega as informações de cada objeto
			
			//contextualização de cada item
				
			imgBike = (ImageView) listaView.findViewById(R.id.rotulobike);
			Drawable dbImgItem = getResources().getDrawable(R.drawable.bike);
			imgBike.setImageDrawable(dbImgItem);
			//top.setText(str.getNome());
			
			TextView descricao = (TextView) listaView.findViewById(R.id.nomebike);
			descricao.setText("DESCRICAO");
			
			return listaView;	
				
		}
	}
}
