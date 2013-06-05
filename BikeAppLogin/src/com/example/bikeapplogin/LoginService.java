package com.example.bikeapplogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class LoginService extends AsyncTask<String, Void, String> {
	private ProgressDialog barraCarregar;
	private Context cont;
	private String user;
	private String password;
	private String requisicao;
	
	public LoginService(Context ctx, String usr, String psw, String rqs){
		this.cont = ctx;
		this.user = usr;
		this.password = psw;
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
		
		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/getlogin/";
		
		if( user != null && password != null){
			String urlInfoPerfil = String.format("%s%s-%s", url, user, password);
			requisicao = RequisicoesHttp.getString(urlInfoPerfil);
		}
		return requisicao;			
	}
	
	public String getUsuario (){
		return requisicao;
	}
}
