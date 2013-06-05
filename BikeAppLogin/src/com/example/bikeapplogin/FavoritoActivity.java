package com.example.bikeapplogin;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FavoritoActivity extends Activity{

	public ItemListAdapter fvAdapter;
	private DBHelper db;
	private ArrayList<WebFavorito> wFav;
	private capturaImagens cap;
	private int idUsuario;
	private FavoritoService favoritoService;
	
	public FavoritoActivity (){
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favoritos);
		Bundle extras = getIntent().getExtras();
		idUsuario = extras.getInt("id_usuario");
		cap = new capturaImagens();
		
		favoritoService = (FavoritoService) new FavoritoService(FavoritoActivity.this, idUsuario, wFav).execute();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wFav= favoritoService.getFavorito();

		//itens que recebem o objeto	
		//for (WebFavorito webFavorito : wFav) {
		//	wFav.add(webFavorito);
		//}
		
		ListView listaPedidos = (ListView) findViewById(R.id.listaFavoritos);
		this.fvAdapter = new ItemListAdapter(this, R.layout.listafavorito, wFav);	
		listaPedidos.setAdapter(this.fvAdapter);
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
    
    public class ItemListAdapter extends ArrayAdapter<WebFavorito>{
    	
    	private ArrayList<WebFavorito> lstFav;
    	private FavoritoExcluiService favoritoExcluiService;
    	private String conteudo = null;

		public ItemListAdapter(Context context, int textViewResourceId, ArrayList<WebFavorito> wFavItem) {
			super(context, textViewResourceId, wFavItem);
			// TODO Auto-generated constructor stub
			this.lstFav = wFavItem;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View listaView = convertView;
			ImageView imgFavorita;
			ImageView imgFavoritaDel;
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listafavorito, null);
				
				imgFavorita = (ImageView) listaView.findViewById(R.id.imagemFavorito);
				Bitmap bm = Bitmap.createBitmap(cap.getImage(this.getContext(), lstFav.get(position).getCaminhoImg1()).getDrawingCache());
				imgFavorita.setImageBitmap(bm);
				
				imgFavoritaDel = (ImageView) listaView.findViewById(R.id.btFavorito);
				imgFavoritaDel.setOnClickListener(new ImageView.OnClickListener()
													{
														@Override
														public void onClick(View v) {
															// TODO Auto-generated method stub															
															favoritoExcluiService = (FavoritoExcluiService) new FavoritoExcluiService(FavoritoActivity.this, idUsuario, conteudo).execute();
															try {
																Thread.sleep(5000);
															} catch (InterruptedException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
															conteudo = favoritoExcluiService.getFavorito();
															delFavorito (conteudo);
														}
													}
												  );
				TextView descricao = (TextView) listaView.findViewById(R.id.nomebike);
				descricao.setText(lstFav.get(position).getNomeItem());
				
			}
			
			return listaView;	
				
		}
		
		private void delFavorito (String fav){
			if("true".equals(fav)){			
				Toast.makeText(this.getContext(), "Este item não é mais favorito!", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this.getContext(), "Não foi possível deletar este item dos favoritos!", Toast.LENGTH_LONG).show();
			}
		}
	}
	
}
