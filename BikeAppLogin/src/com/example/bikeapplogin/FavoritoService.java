package com.example.bikeapplogin;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


public class FavoritoService extends AsyncTask <WebFavorito, Void, WebFavorito[]>{

	private ProgressDialog barraCarregar;
	private Context cont;
	private int iduser;
	private JSONArray requisicao;
	private ArrayList<WebFavorito> wfavorito;
	
	public FavoritoService(Context ctx, int id, ArrayList<WebFavorito> wF ){
		this.cont = ctx;
		this.iduser = id;
		this.wfavorito = wF;
	}
	
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		barraCarregar = new ProgressDialog(cont);
		barraCarregar.show();
	}
	
	@Override
	protected void onPostExecute(WebFavorito[] result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		if(result != null){
			barraCarregar.dismiss();
		}			
	}

	@Override
	protected WebFavorito[] doInBackground(WebFavorito... params) {
		// TODO Auto-generated method stub
		
		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/getfavorito/";
		
		if( iduser != 0){

			String urlInfoPerfil = String.format("%s%s", url, iduser);
			requisicao = RequisicoesHttp.getJsonArray(urlInfoPerfil);
		}

		WebFavorito[] favoritos = null;
		
		
		try {
			JSONArray request = requisicao;
			
			favoritos = new WebFavorito[request.length()];
			
			for (int i = 0; i < request.length(); i++){
				JSONObject favorito = request.getJSONObject(i);
				
				wfavorito.get(i).setId(favorito.getInt("id"));
				wfavorito.get(i).setNomeItem(favorito.getString("nomitem"));
				wfavorito.get(i).setCaminhoImg1("caminhoimg1");

				favoritos[i] = wfavorito.get(i);
			}
				
			return favoritos;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public ArrayList<WebFavorito> getFavorito(){
		return wfavorito;
	}
	
}
