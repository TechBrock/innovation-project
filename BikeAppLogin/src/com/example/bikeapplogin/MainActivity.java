package com.example.bikeapplogin;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.bikeapplogin.buscaPerfilTeste.PerfilInfo;

import android.os.AsyncTask;
import android.os.Bundle;
//import android.annotation.SuppressLint;
//import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity{
	
	private DBHelper db;
	WebUsuario user;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        user = new WebUsuario();
		new PerfilInfo().execute();

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
        
        newActivity.putExtra("usuario", user); //**************************** put extras passando o objeto
        
        startActivity(newActivity);
    }
    
    public void enter (View v){
    	
    	EditText usr = (EditText) findViewById(R.id.user);
    	EditText psw = (EditText) findViewById(R.id.password);
    	
    	if((usr.getText().toString().trim().length() > 0) || (psw.getText().toString().trim().length() > 0)){
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
    }
    
    public class PerfilInfo extends AsyncTask<WebUsuario, Void, WebUsuario[]> {
		private ProgressDialog barraCarregar;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			barraCarregar = new ProgressDialog(MainActivity.this);
			barraCarregar.show();
		}
		
		@Override
		protected void onPostExecute(WebUsuario[] result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(result != null){
				
			}
			
			barraCarregar.dismiss();
		}

		@Override
		protected WebUsuario[] doInBackground(WebUsuario... params) {
			// TODO Auto-generated method stub
			
			String urlInfoPerfil = "http:\\www."; //************************ URL do web service
			String conteudo = RequisicoesHttp.get(urlInfoPerfil);
			
			WebUsuario[] usuarios = null;
			
			try {
				JSONArray request = new JSONArray(conteudo);
				
				usuarios = new WebUsuario[request.length()];
				
				for (int i = 0; i < request.length(); i++){
					JSONObject usuario = request.getJSONObject(i);
					
					user.setId(usuario.getInt("id"));
					user.setNome(usuario.getString("nome"));
					user.setSobrenome(usuario.getString("sobrenome"));
					user.setDataNascimento((Date) usuario.get("dataNascimento"));
					user.setSexo((Character) usuario.get("sexo"));
					user.setCpf(usuario.getString("cpf"));
					user.setApelido(usuario.getString("apelido"));
					user.setEmail(usuario.getString("email"));
					user.setSenha(usuario.getString("senha"));
					user.setAtivo((Character) usuario.get("ativo"));
					user.setReceberEmail((Character) usuario.get("receberEmail"));
					user.setIdPerfil(usuario.getInt("idPerfil"));
					
					usuarios[i] = user;
				}
					
				return usuarios;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
		}
		
	}
}
