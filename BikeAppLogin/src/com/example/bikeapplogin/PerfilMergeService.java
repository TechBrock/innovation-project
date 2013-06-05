package com.example.bikeapplogin;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class PerfilMergeService extends AsyncTask<String, Void, String> {
	private ProgressDialog barraCarregar;
	private Context cont;
	private String requisicao;
	private WebUsuario user;
	
	public PerfilMergeService(Context ctx, WebUsuario usr, String rqs){
		this.cont = ctx;
		this.requisicao = rqs;
		this.user = usr;
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
		
		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/updateUsuario/";
		
		String urlInfoPerfil = String.format("%s%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s-%s", url, 
												user.getId(),
												user.getNome(),
												user.getSobrenome(),
												user.getDataNascimento(),
												user.getSexo(),
												user.getCpf(),
												user.getApelido(),
												user.getEmail(),
												user.getSenha(),
												user.getAtivo(),
												user.getReceberEmail(),
												user.getTelefoneResidencial(),
												user.getTelefoneCelular(),
												user.getTelefoneRecado(),
												user.getCep(),
												user.getTipo(),
												user.getLogradouro(),
												user.getNumero(),
												user.getComplemento(),
												user.getBairro(),
												user.getInformacoesAdicionais(),
												user.getCidade(),
												user.getEstado()
											);
		
		requisicao = RequisicoesHttp.getString(urlInfoPerfil);
		
		return requisicao;			
	}
	
	public String getUsuario (){
		return requisicao;
	}
}
