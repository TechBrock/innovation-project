package com.example.bikeapplogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class ItemFavoritoService extends AsyncTask<String, Void, String> {

	private ProgressDialog barraCarregar;
	private Context cont;
	private int idUsuario;
	private int idModelo;
	private String requisicao;
	
	public ItemFavoritoService(Context ctx, int idUsuario, int idModelo, String rsq){
		this.cont = ctx;
		this.idUsuario = idUsuario;
		this.idModelo = idModelo;
		this.requisicao = rsq;
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
		
		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/setitemfavorito/";
		
		if( idUsuario != 0 && idModelo != 0){
			String urlInfoPerfil = String.format("%s%s-%s", url, idUsuario, idModelo);
			requisicao = RequisicoesHttp.getString(urlInfoPerfil);
		}
		return requisicao;			
	}
	
	public String getFavorito (){
		return requisicao;
	}
	
}
