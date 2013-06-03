package com.example.bikeapplogin;

import org.json.JSONArray;
import org.json.JSONObject;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class CompraService extends AsyncTask<WebCompra, Void, WebCompra[]>{
	
	private ProgressDialog barraCarregar;
	private Context cont;
	private int iduser;
	private String requisicao;
	private WebCompra comp;
		
	public CompraService(Context ctx, int id, String rqs, WebCompra wcp){
		this.cont = ctx;
		this.iduser = id;
		this.requisicao = rqs;
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
			requisicao = RequisicoesHttp.get(urlInfoPerfil);
		}

		WebCompra[] pedidos = null;


		try {
			JSONArray request = new JSONArray(requisicao);

			pedidos = new WebCompra[request.length()];

			for (int i = 0; i < request.length(); i++){
				JSONObject pedido = request.getJSONObject(i);

				comp.setId(pedido.getInt("id"));
				comp.setOrdemCompra(pedido.getInt("ordemcompra"));
				comp.setQtdParcelas(pedido.getInt("qtdparcelas"));
				comp.setValorFrete(pedido.getString("valorfrete"));
				comp.setValorCompra(pedido.getString("valorcompra"));
				comp.setPrazo(pedido.getInt("prazoentrega"));
				comp.setDataPedido(pedido.getString("datapedido"));
				comp.setDataEntrega(pedido.getString("dataentrega"));
				comp.setMeioPagamento(pedido.getString("meiopagamento"));
				comp.setTipoFrete(pedido.getString("tipofrete"));
				comp.setItens(pedido.getString("itens"));
				comp.setQuantidade(pedido.getInt("quantidade"));

				pedidos[i] = comp;
			}

			return pedidos;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public WebCompra getCompra (){
		return comp;
	}

}
