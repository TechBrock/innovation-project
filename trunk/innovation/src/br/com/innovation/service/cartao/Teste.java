package br.com.innovation.service.cartao;

public class Teste {
public static void main(String[] args) throws Exception {
	String numeroCartao = "4096013815682651";
	int cardId = CCUtils.getCardID(numeroCartao);
	int cardIdSelecionado = CCUtils.VISA;
	if(cardId==cardIdSelecionado){
		System.out.println("Bandeira do cartão validada!");
	}else{
		System.out.println("Bandeira inválida!");
	}
	if(CCUtils.validCC(numeroCartao)){
		System.out.println("Cartão OK");
	}else{
		System.out.println("Cartão não OK");
	}
}
}
