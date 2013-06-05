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
	private CapturaImagens cap;
	private int idUsuario;
	private ItensService itemService;
	
	public ItensActivity(){
		// TODO Auto-generated constructor stub		
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
		Bundle extras = getIntent().getExtras();
		idUsuario = extras.getInt("id_usuario");
		cap = new CapturaImagens();
		
		itemService = (ItensService) new ItensService(ItensActivity.this, wItens).execute();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wItens= itemService.getItem();

		//itens que recebem o objeto	
		//for (WebItem webItem : wItens) {
		//	wItens.add(webItem);
		//}
	
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
        	Toast.makeText(this, "Impossível deletar Login!", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
    	
    	goToActivity(MainActivity.class);
    }

    public class ItensListAdapter extends ArrayAdapter<WebItem>{
		
		private ArrayList<WebItem> lstItem;

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
				Bitmap bm = Bitmap.createBitmap(cap.getImage(this.getContext(), lstItem.get(position).getCaminhoImg1()).getDrawingCache());
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
			descricao.setText(lstItem.get(position).getNome());
			
			return listaView;	
				
		}
	}
    
}
