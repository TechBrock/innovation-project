package com.example.bikeapplogin;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ItensActivity extends Activity {
	
	//private ArrayList<String> item;
	//public ItemListAdapter itAdapter;
	public  ItensListAdapter itAdapter;
	public WebItem webItemcaminhoImg;
	public ArrayList<String> imgs, nomes;
	private DBHelper db;
	private ArrayList<WebItem> wItens;
	private capturaImagens cap;
	private int idUsuario;
	
	public ItensActivity(){
		// TODO Auto-generated constructor stub
		cap = new capturaImagens();
		wItens = new ArrayList<WebItem>();
		imgs = new ArrayList<String>();
		nomes = new ArrayList<String>();

		//itens que recebem o objeto	
		for (WebItem webItem : wItens) {
			wItens.add(webItem);
			imgs.add(webItem.getCaminhoImg1());
			nomes.add(webItem.getNome());
		}
		
		//item = new ArrayList<String>();
		//item.add("Descrição 1");
		//item.add("Descrição 2");
		//item.add("Descrição 3");
		//item.add("Descrição 4");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itens);

		ListView listaItens = (ListView) findViewById(R.id.listaItens);
		this.itAdapter = new ItensListAdapter(this, R.layout.listaitens, wItens);	
		listaItens.setAdapter(this.itAdapter);
		
		Bundle extras = getIntent().getExtras();
		idUsuario = extras.getInt("id_usuario");
	}	
	
	public void adicionaIten (){
	}
	
	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
	
	private void goToActivityIdUsuarioItem(Class<? extends Activity> activityClass, int idUsuario) {
		Intent newActivity = new Intent(this, activityClass);
        newActivity.putExtra("id_usuario", idUsuario);
        startActivity(newActivity);
    }
	
    public void callPerfil (View v){
    	goToActivity(PerfilActivity.class);
    } 
    
    public void callOfertas (View v){
    	goToActivity(ItensActivity.class);
    } 
    
    public void callCompras (View v){
    	goToActivityIdUsuarioItem(ComprasActivity.class, idUsuario);
    } 
   
    public void callFavoritos (View v){
    	goToActivityIdUsuarioItem(FavoritoActivity.class, idUsuario);
    }
    
    public void callLogin (View v){
    	Cursor crs = null;
        
        try{
        
        	db = new DBHelper(this);

        	SQLiteDatabase slc = db.getReadableDatabase();
        	SQLiteDatabase dlt = db.getWritableDatabase();
        	crs = slc.rawQuery("SELECT USUARIO FROM LOGIN", null);
        	crs.moveToFirst();

        	if (crs.getCount() > 0){
        		dlt.delete("LOGIN", null, null);
        		goToActivity(PerfilActivity.class);
        	}
        }catch(Exception ex){
        	Toast.makeText(this, "Campo Usuário ou senha em branco !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
    	
    	goToActivity(MainActivity.class);
    }

    public class ItensListAdapter extends ArrayAdapter<WebItem>{
		
		private ArrayList<WebItem> lstItem;// = new ArrayList<WebItem>();

		public ItensListAdapter(Context context, int textViewResourceId, ArrayList<WebItem> itens) {
			super(context, textViewResourceId, itens);
			// TODO Auto-generated constructor stub
			this.lstItem = itens;
		}
		
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			View listaView = convertView;
			ImageView imgBike;
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listaitens, null);
				
				imgBike = (ImageView) listaView.findViewById(R.id.rotulobike);
				Bitmap bm = Bitmap.createBitmap(cap.getImage(this.getContext(), imgs.get(position)).getDrawingCache());
				imgBike.setImageBitmap(bm);
				imgBike.setOnClickListener(new ImageView.OnClickListener()
											{
												@Override
												public void onClick(View v) {
													// TODO Auto-generated method stub
													//goToActivity(ItemActivity.class);
													Intent newActivity = new Intent(ItensActivity.this, ItemActivity.class);
													newActivity.putExtra("Item", lstItem.get(position));
													newActivity.putExtra("id_usuario", idUsuario);
													startActivity(newActivity);
												}
						                  	}
										  );
			}
			
			TextView descricao = (TextView) listaView.findViewById(R.id.nomebike);
			descricao.setText(nomes.get(position));
			
			return listaView;	
				
		}
	}
    
}
