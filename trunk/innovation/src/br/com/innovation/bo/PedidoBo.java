package br.com.innovation.bo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;


import br.com.innovation.dao.ModeloDao;
import br.com.innovation.dao.PedidoDao;
import br.com.innovation.vo.ModeloVo;
import br.com.innovation.vo.PedidoVo;

public class PedidoBo {
	private Integer idUser;
	private Integer idCompra;
	private ArrayList<PedidoVo> pedidoAl = new ArrayList<PedidoVo>();
	private ArrayList<ModeloVo> modeloAl = new ArrayList<ModeloVo>();


	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public ArrayList<PedidoVo> getPedidoAl() {
		return pedidoAl;
	}

	public void setPedidoAl(ArrayList<PedidoVo> pedidoAl) {
		this.pedidoAl = pedidoAl;
	}
	public ArrayList<ModeloVo> getModeloAl() {
		return modeloAl;
	}

	public void setModeloAl(ArrayList<ModeloVo> modeloAl) {
		this.modeloAl = modeloAl;
	}

	public String getPedidoByUser(){
		if(idUser != null && idUser > 0){
			pedidoAl = new PedidoDao().getPedido(idUser);
			return "inn011";
		}else{
			return null;
		}

	}

	public String getItemPedido(){
		modeloAl = new PedidoDao().getItemCompra(idCompra);
		return "inn011detalhe";
	}

	public void montaImagem(OutputStream strem, Object id){
		String principal = null;
		String principalNew = null;
		FileInputStream origem = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] array;
		int x;

		if((Integer) id != null && (Integer) id > 0){
			principal = new ModeloDao().getCaminho("img_1",(Integer) id);
			principalNew = principal.substring(principal.lastIndexOf("/")+1,principal.length());

			try {
				origem = new FileInputStream("C:\\newWork\\imagens_produto\\"+principalNew);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				while((x = origem.read()) > -1){
					out.write(x);
				}

				out.close();
				origem.close();
				array = out.toByteArray();
				strem.write(array);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
