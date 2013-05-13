package com.example.bikeapplogin;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class buscaPerfil extends Activity{
	
	WebUsuario user;
	
	public buscaPerfil() {
		// TODO Auto-generated constructor stub
		
		user = new WebUsuario();
		
		new PerfilInfo().execute();
		
	}
	
	public WebUsuario getUsuario (){
		return user;
	}
	
	public class PerfilInfo extends AsyncTask<WebUsuario, Void, WebUsuario[]> {
		private ProgressDialog barraCarregar;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			barraCarregar = new ProgressDialog(buscaPerfil.this);
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
			
			String urlInfoPerfil = "http:\\www.";
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
