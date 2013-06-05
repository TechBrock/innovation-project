package com.example.bikeapplogin;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class CompraService extends AsyncTask<WebCompra, Void, WebCompra[]>{
	
	private ProgressDialog barraCarregar;
	private Context cont;
	private int iduser;
	private JSONArray requisicao;
	private ArrayList<WebCompra> comp;
		
	public CompraService(Context ctx, int id, ArrayList<WebCompra> wcp){
		this.cont = ctx;
		this.iduser = id;
		this.comp = wcp;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();

		barraCarregar = new ProgressDialog(cont);
		barraCarregar.show();
	}

	@Override
	protected void onPostExecute(WebCompra[] result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

		if(result != null){

		}

		barraCarregar.dismiss();
	}

	@Override
	protected WebCompra[] doInBackground(WebCompra... params) {
		// TODO Auto-generated method stub

		String url = "http://ec2-54-232-215-79.sa-east-1.compute.amazonaws.com:8080/metodo/service/getcompra/";

		if( iduser != 0){

			String urlInfoPerfil = String.format("%s%s", url, iduser);
			requisicao = RequisicoesHttp.getJsonArray(urlInfoPerfil);
		}

		WebCompra[] pedidos = null;


		try {
			JSONArray request = requisicao;

			pedidos = new WebCompra[request.length()];

			for (int i = 0; i < request.length(); i++){
				JSONObject pedido = request.getJSONObject(i);

				comp.get(i).setId(pedido.getInt("id"));
				comp.get(i).setOrdemCompra(pedido.getInt("ordemcompra"));
				comp.get(i).setQtdParcelas(pedido.getInt("qtdparcelas"));
				comp.get(i).setValorFrete(pedido.getString("valorfrete"));
				comp.get(i).setValorCompra(pedido.getString("valorcompra"));
				comp.get(i).setPrazo(pedido.getInt("prazoentrega"));
				comp.get(i).setDataPedido(pedido.getString("datapedido"));
				comp.get(i).setDataEntrega(pedido.getString("dataentrega"));
				comp.get(i).setMeioPagamento(pedido.getString("meiopagamento"));
				comp.get(i).setTipoFrete(pedido.getString("tipofrete"));
				comp.get(i).setItens(pedido.getString("itens"));
				comp.get(i).setQuantidade(pedido.getInt("quantidade"));

				pedidos[i] = comp.get(i);
			}

			return pedidos;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public ArrayList<WebCompra> getCompra (){
		return comp;
	}

}
