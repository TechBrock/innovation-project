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
	
	public PerfilService(Context ctx, String usr, String psw, String rqs, WebUsuario wus){
		this.cont = ctx;
		this.userLogin = usr;
		this.password = psw;
		this.requisicao = rqs;
		this.user = wus;
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

		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/getusuario/";
		//String url = String.format("%sid%s:%s21%s,%snome%s:%sLucas%s,%ssobrenome%s:%sTeste13%s,%sdatanascimento%s:%s2013-06-02%s,%ssexo%s:%sM%s,%scpf%s:%s5%s,%sapelido%s:%sLucasT13%s,%semail%s:%st%s,%sativo%s:%sS%s,%sreceberemail%s:%sN%s,%stelefoneresidencial%s:%s0%s,%stelefonecelular%s:%s0%s,%stelefonerecado%s:%s0%s,%slogradouro%s:%sAmancio de Carvalho%s,%stipologradouro%s:%sRua%s,%scep%s:%s09456786%s,%sestado%s:%sSão Paulo%s,%sbairro%s:%sBaeta Neves%s,%scidade%s:%sSão Bernardo do Campo%s,%snumero%s:%s123%s,%scomplemento%s:%sapto. 2%s,%sinformacoes%s:%sPrximo ao Sonda%s", "\"");
		
		if( userLogin != null && password != null){
		
			String urlInfoPerfil = String.format("%s%s-%s", url, userLogin, password);
			requisicao = RequisicoesHttp.get(urlInfoPerfil);
		}

		WebUsuario[] usuarios = null;
		
		
		try {
			JSONArray request = new JSONArray(url);//requisicao);
			
			usuarios = new WebUsuario[request.length()];
			
			for (int i = 0; i < request.length(); i++){
				JSONObject usuario = request.getJSONObject(i);
				
				
				user.setId(usuario.getInt("id"));
				user.setNome(usuario.getString("nome"));
				user.setSobrenome(usuario.getString("sobrenome"));
				user.setDataNascimento((Date) usuario.get("dataNascimento"));
				user.setSexo( usuario.getString("sexo"));
				user.setCpf(usuario.getString("cpf"));
				user.setApelido(usuario.getString("apelido"));
				user.setEmail(usuario.getString("email"));
				user.setAtivo(usuario.getString("ativo"));
				user.setReceberEmail(usuario.getString("receberEmail"));
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
