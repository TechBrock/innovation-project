package com.example.bikeapplogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class FavoritoExcluiService extends AsyncTask <String, Void, String>{

	private ProgressDialog barraCarregar;
	private Context cont;
	private int idfavorito;
	private String requisicao;
	
	public FavoritoExcluiService(Context ctx, int id, String rqs){
		this.cont = ctx;
		this.idfavorito = id;
		this.requisicao = rqs;
	}
	
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		barraCarregar = new ProgressDialog(cont);
		barraCarregar.show();
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		if(result != null){
			barraCarregar.dismiss();
		}			
	}

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		
		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/delfavorito/";
		
		if( idfavorito != 0){
			String urlInfoPerfil = String.format("%s%s", url, idfavorito);
			requisicao = RequisicoesHttp.get(urlInfoPerfil);
		}
		return requisicao;			
	}
	
	public String getFavorito (){
		return requisicao;
	}
	
}
