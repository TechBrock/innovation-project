package com.example.bikeapplogin;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class ItensService extends AsyncTask<WebItem, Void, WebItem[]> {
	
	private ProgressDialog barraCarregar;
	private Context cont;
	private ArrayList<WebItem> item;
	private JSONArray requisicao;
	
	public ItensService(Context ctx, ArrayList<WebItem> item){
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
		requisicao = RequisicoesHttp.getJsonArray(urlInfoPerfil);
		
		WebItem[] itens = null;
		
		
		try {
			JSONArray request = requisicao;
			
			itens = new WebItem[request.length()];
			
			for (int i = 0; i < request.length(); i++){
				JSONObject itm = request.getJSONObject(i);

				item.get(i).setId(itm.getInt("id"));
				item.get(i).setNome(itm.getString("nome"));
				item.get(i).setCaracteristica(itm.getString("caracteristica"));
				item.get(i).setTamanho(itm.getString("tamanho"));
				item.get(i).setDimensao(itm.getString("dimensao"));
				item.get(i).setPeso(itm.getString("peso"));
				item.get(i).setAro(itm.getInt("aro"));
				item.get(i).setInformacoesAdicionais(itm.getString("adicionais"));
				item.get(i).setGarantia(itm.getString("garantia"));
				item.get(i).setMaterial(itm.getString("material"));
				item.get(i).setClassificacao(itm.getString("classificacao"));
				item.get(i).setTipoItem(itm.getString("tipoitem"));
				item.get(i).setCaminhoImg1(itm.getString("caminhoimg1"));
				item.get(i).setCaminhoImg2(itm.getString("caminhoimg2"));
				item.get(i).setCaminhoImg3(itm.getString("caminhoimg3"));
				item.get(i).setCaminhoImg4(itm.getString("caminhoimg4"));		

				itens[i] = item.get(i);
			}
				
			return itens;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	
	public ArrayList<WebItem> getItem (){
		return item;
	}
	
}
