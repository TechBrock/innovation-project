package com.example.bikeapplogin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class PerfilActivity extends Activity{
	
	private DBHelper db;
	
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
    
    
    public void callCompras (View v){
    	goToActivity(ComprasActivity.class);
    }
    
    public void callOfertas (View v){
    	goToActivity(ItensActivity.class);
    } 
   
    public void callFavoritos (View v){
    	goToActivity(FavoritoActivity.class);
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
    
    public void callEditar (View v){
    	goToActivity(PerfilPersonalizadoActivity.class);
    }
	
}
