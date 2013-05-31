























































































package br.com.innovation.bo;

import br.com.innovation.service.CorreiosService;
import br.com.innovation.vo.EnderecoVo;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CorreiosService correio = new CorreiosService();
		EnderecoVo enderecoVo = new EnderecoVo();
		enderecoVo = correio.consultarEndereco("09340685");
		new UsuarioBo().inserirEnd(enderecoVo);
		
	}

}
