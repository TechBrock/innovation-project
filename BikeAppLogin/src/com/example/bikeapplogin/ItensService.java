package com.example.bikeapplogin;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class ItensService extends AsyncTask<WebItem, Void, WebItem[]> {
	
	private ProgressDialog barraCarregar;
	private Context cont;
	private WebItem item;
	private String requisicao;
	
	public ItensService(Context ctx, WebItem item){
		this.cont = ctx;
		this.item = item;
	}
	
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		barraCarregar = new ProgressDialog(cont);
		barraCarregar.show();
	}
	
	@Override
	protected void onPostExecute(WebItem[] result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		if(result != null){
			barraCarregar.dismiss();
		}			
	}

	@Override
	protected WebItem[] doInBackground(WebItem... params) {
		// TODO Auto-generated method stub
		
		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/getitens/";
		
		String urlInfoPerfil = String.format("%s", url);
		requisicao = RequisicoesHttp.get(urlInfoPerfil);
		
		WebItem[] itens = null;
		
		
		try {
			JSONArray request = new JSONArray(requisicao);
			
			itens = new WebItem[request.length()];
			
			for (int i = 0; i < request.length(); i++){
				JSONObject itm = request.getJSONObject(i);

				item.setId(itm.getInt("id"));
				item.setNome(itm.getString("nome"));
				item.setCaracteristica(itm.getString("caracteristica"));
				item.setTamanho(itm.getString("tamanho"));
				item.setDimensao(itm.getString("dimensao"));
				item.setPeso(itm.getString("peso"));
				item.setAro(itm.getInt("aro"));
				item.setInformacoesAdicionais(itm.getString("adicionais"));
				item.setGarantia(itm.getString("garantia"));
				item.setMaterial(itm.getString("material"));
				item.setClassificacao(itm.getString("classificacao"));
				item.setTipoItem(itm.getString("tipoitem"));
				item.setCaminhoImg1(itm.getString("caminhoimg1"));
				item.setCaminhoImg2(itm.getString("caminhoimg2"));
				item.setCaminhoImg3(itm.getString("caminhoimg3"));
				item.setCaminhoImg4(itm.getString("caminhoimg4"));		

				itens[i] = item;
			}
				
			return itens;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public WebItem getItem (){
		return item;
	}
	
}
