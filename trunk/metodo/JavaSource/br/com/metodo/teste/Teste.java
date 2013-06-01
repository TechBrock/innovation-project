package br.com.metodo.teste;

import br.com.metodo.service.impl.AndroidService;
import br.com.metodo.service.impl.ProdutoService;

public class Teste {
	public static void main(String[] args) {
		ProdutoService produtoService = new ProdutoService();
		System.out.println(produtoService.consultarEstoque("9999"));
		
		AndroidService androidService = new AndroidService();
		System.out.println(androidService.getLogin("hideaky@gmail.com","1234"));
		
		System.out.println(androidService.getUsuario("hideaky@gmail.com","123").getApelido());
	}
}
