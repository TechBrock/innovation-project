package com.example.bikeapplogin;

import java.util.ArrayList;

import com.example.bikeapplogin.ItensActivity.ItemListAdapter;

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

public class ComprasActivity extends Activity{

	private ArrayList<String> pedido;
	public ItemListAdapter pdAdapter;
	public TextView nPedido;
	
	public ComprasActivity (){
		// TODO Auto-generated constructor stub
		pedido = new ArrayList<String>();
				
		//itens que recebem o objeto
				
		pedido.add("Pedido 1");
		pedido.add("Pedido 2");
		pedido.add("Pedido 3");
		pedido.add("Pedido 4");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compras);
		
		ListView listaPedidos = (ListView) findViewById(R.id.listaPedidos);
		this.pdAdapter = new ItemListAdapter(this, R.layout.listacompras, pedido);	
		listaPedidos.setAdapter(this.pdAdapter);
		
		nPedido = (TextView) findViewById(R.id.QtdCompra);
		nPedido.setText(String.format("4 %s", nPedido.getText().toString()));
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
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listacompras, null);
			}

			
			TextView nPedido = (TextView) listaView.findViewById(R.id.numeroPedido);
			nPedido.setText("00000001");
			
			return listaView;	
				
		}
	}
	
}
