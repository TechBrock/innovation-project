package br.com.metodo.service.impl;

import br.com.metodo.service.dao.ProdutoDAO;
import br.com.metodo.service.vo.ProdutoVo;

public class ProdutoService{

	private ProdutoDAO produtoDAO;
	
	public ProdutoService(){
		produtoDAO = new ProdutoDAO();
	}
	
	public ProdutoVo consultarEstoque(String id) {
		if(id==null || "".equals(id)){
			return new ProdutoVo();
		}
		return produtoDAO.consultarEstoque(Integer.parseInt(id));
	}
	
	public String consultarEstoqueString(String id) {
		if(id==null || "".equals(id)){
			return "";
		}
		return produtoDAO.consultarEstoqueString(Integer.parseInt(id));
	}
	

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
}
