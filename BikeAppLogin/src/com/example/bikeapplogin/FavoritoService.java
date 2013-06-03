package com.example.bikeapplogin;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;


public class FavoritoService extends AsyncTask <WebFavorito, Void, WebFavorito[]>{

	private ProgressDialog barraCarregar;
	private Context cont;
	private int iduser;
	private String requisicao;
	private WebFavorito wfavorito;
	
	public FavoritoService(Context ctx, int id, String rqs, WebFavorito wF ){
		this.cont = ctx;
		this.iduser = id;
		this.requisicao = rqs;
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
			requisicao = RequisicoesHttp.get(urlInfoPerfil);
		}

		WebFavorito[] favoritos = null;
		
		
		try {
			JSONArray request = new JSONArray(requisicao);
			
			favoritos = new WebFavorito[request.length()];
			
			for (int i = 0; i < request.length(); i++){
				JSONObject favorito = request.getJSONObject(i);
				
				wfavorito.setId(favorito.getInt("id"));
				wfavorito.setNomeItem(favorito.getString("nomitem"));
				wfavorito.setCaminhoImg1("caminhoimg1");

				favoritos[i] = wfavorito;
			}
				
			return favoritos;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public WebFavorito getFavorito(){
		return wfavorito;
	}
	
}
