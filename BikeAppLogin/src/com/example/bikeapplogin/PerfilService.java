package com.example.bikeapplogin;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class PerfilService extends AsyncTask<WebUsuario, Void, WebUsuario[]> {
	private ProgressDialog barraCarregar;
	private Context cont;
	private String userLogin;
	private String password;
	private String requisicao;
	private WebUsuario user;
	
	public PerfilService(Context ctx, String usr, String psw, String rqs){
		this.cont = ctx;
		this.userLogin = usr;
		this.password = psw;
		this.requisicao = rqs;
		
		user = new WebUsuario();
	}
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		barraCarregar = new ProgressDialog(cont);
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

		if( user != null && password != null){
			String urlInfoPerfil = String.format("http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/MetodoService/getusuario/%s-%s", userLogin, password);
			requisicao = RequisicoesHttp.get(urlInfoPerfil);
		}

		WebUsuario[] usuarios = null;
		
		
		try {
			JSONArray request = new JSONArray(requisicao);
			
			usuarios = new WebUsuario[request.length()];
			
			for (int i = 0; i < request.length(); i++){
				JSONObject usuario = request.getJSONObject(i);
				
				
				user.setId(usuario.getInt("id"));
				user.setNome(usuario.getString("nome"));
				user.setSobrenome(usuario.getString("sobrenome"));
				user.setDataNascimento((Date) usuario.get("dataNascimento"));
				//user.setSexo((Character) usuario.get("sexo"));
				user.setSexo( usuario.getInt("sexo"));
				user.setCpf(usuario.getString("cpf"));
				user.setApelido(usuario.getString("apelido"));
				user.setEmail(usuario.getString("email"));
				//user.setAtivo((Character) usuario.get("ativo"));
				user.setAtivo(usuario.getInt("ativo"));
				//user.setReceberEmail((Character) usuario.get("receberEmail"));
				user.setReceberEmail(usuario.getInt("receberEmail"));
				user.setTelefoneResidencial(usuario.getInt("telefoneresidencial"));
				user.setTelefoneCelular(usuario.getInt("telefonecelular"));
				user.setTelefoneRecado(usuario.getInt("telefonerecado"));
				user.setLogradouro(usuario.getString("logradouro"));
				user.setTipo(usuario.getString("tipologradouro"));
				user.setCep(usuario.getString("cep"));
				user.setEstado(usuario.getString("estado"));
				user.setBairro(usuario.getString("bsirro"));
				user.setCidade(usuario.getString("cidade"));
				user.setNumero(usuario.getString("numero"));
				user.setComplemento(usuario.getString("complemento"));
				user.setInformacoesAdicionais(usuario.getString("informacoes"));

				usuarios[i] = user;
			}
				
			return usuarios;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public WebUsuario getUsuario (){
		return user;
	}
	
}
