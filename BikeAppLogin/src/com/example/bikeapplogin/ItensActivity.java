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

	public  ItensListAdapter itAdapter;
	public WebItem webItemcaminhoImg;
	private DBHelper db;
	private ArrayList<WebItem> wItens;
	private capturaImagens cap;
	private int idUsuario;
	
	public ItensActivity(){
		// TODO Auto-generated constructor stub
		cap = new capturaImagens();
		wItens = new ArrayList<WebItem>();

		//itens que recebem o objeto	
		for (WebItem webItem : wItens) {
			wItens.add(webItem);
		}
		
		//item = new ArrayList<String>();
		//item.add("Descri��o 1");
		//item.add("Descri��o 2");
		//item.add("Descri��o 3");
		//item.add("Descri��o 4");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itens);
		
		Bundle extras = getIntent().getExtras();
		idUsuario = extras.getInt("id_usuario");
		
		//itservice = (ItensService) new ItensService(this).execute();

		ListView listaItens = (ListView) findViewById(R.id.listaItens);
		this.itAdapter = new ItensListAdapter(this, R.layout.listaitens, wItens);	
		listaItens.setAdapter(this.itAdapter);
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
        	Toast.makeText(this, "Campo Usu�rio ou senha em branco !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
    	
    	goToActivity(MainActivity.class);
    }

    public class ItensListAdapter extends ArrayAdapter<WebItem>{
		
		private ArrayList<WebItem> lstItem;// = new ArrayList<WebItem>();
		private WebItem it;
		private ItensService itemService;

		public ItensListAdapter(Context context, int textViewResourceId, ArrayList<WebItem> itens) {
			super(context, textViewResourceId, itens);
			// TODO Auto-generated constructor stub
			this.lstItem = itens;
		}
		
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			it = lstItem.get(position);
			View listaView = convertView;
			ImageView imgBike;
			
			itemService = (ItensService) new ItensService(ItensActivity.this, it).execute();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			it = itemService.getItem();
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listaitens, null);
				
				imgBike = (ImageView) listaView.findViewById(R.id.rotulobike);
				Bitmap bm = Bitmap.createBitmap(cap.getImage(this.getContext(), it.getCaminhoImg1()).getDrawingCache());
				imgBike.setImageBitmap(bm);
				imgBike.setOnClickListener(new ImageView.OnClickListener()
											{
												@Override
												public void onClick(View v) {
													// TODO Auto-generated method stub
													//goToActivity(ItemActivity.class);
													Intent newActivity = new Intent(ItensActivity.this, ItemActivity.class);
													newActivity.putExtra("Item", it);
													newActivity.putExtra("id_usuario", idUsuario);
													startActivity(newActivity);
												}
						                  	}
										  );
			}
			
			TextView descricao = (TextView) listaView.findViewById(R.id.nomebike);
			descricao.setText(it.getNome());
			
			return listaView;	
				
		}
	}
    
}
