package com.example.bikeapplogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{
	
	private DBHelper db;
	private EditText usr;
	private EditText psw;
	private String conteudo = null;
	private LoginService loginService;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usr = (EditText) findViewById(R.id.user);
    	psw = (EditText) findViewById(R.id.password);

        Cursor crs = null;
        
        try{
        
        	db = new DBHelper(this);

        	SQLiteDatabase slc = db.getReadableDatabase();
        	crs = slc.rawQuery("SELECT USUARIO FROM LOGIN", null);
        	crs.moveToFirst();

        	if (crs.getCount() > 0){
        		goToActivity(PerfilActivity.class);
        	}
        }catch(Exception ex){
        	Toast.makeText(this, "Campo Usuário ou senha em branco !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
        
    }
    
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	db.close();
    	super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
	
	public void enter (View v) throws InterruptedException{
		loginService = (LoginService) new  LoginService(MainActivity.this, usr.getText().toString(), psw.getText().toString(), conteudo).execute();
    	Thread.sleep(20000);
    	conteudo = loginService.getUsuario();
    	login ();
    }
	
	public void login (){
    	
    	//Toast.makeText(this, conteudo, Toast.LENGTH_LONG).show();
    	
    	if("true".equals(conteudo)){
    		if ((usr.getText().toString().trim().length() > 0) && (psw.getText().toString().trim().length() > 0)){
    			SQLiteDatabase sql = db.getWritableDatabase();
    		
    			ContentValues conteudo = new ContentValues();
    			conteudo.put("USUARIO", usr.getText().toString());
    			conteudo.put("SENHA", psw.getText().toString());
    		
    			sql.insert("LOGIN", null, conteudo);
    		
    			usr.setText("");
    			psw.setText("");
    
    			goToActivity(PerfilActivity.class); 

    		} else {
    			Toast.makeText(this, "Campo Usuário ou senha em branco !", Toast.LENGTH_SHORT).show();
    		}   
    	} else {
    		Toast.makeText(this, "Usuário ou senha invalidos !", Toast.LENGTH_SHORT).show();
    	}
	};
}
