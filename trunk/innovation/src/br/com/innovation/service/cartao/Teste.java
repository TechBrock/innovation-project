package br.com.innovation.service.cartao;

public class Teste {
public static void main(String[] args) throws Exception {
	String numeroCartao = "4096013815682651";
	int cardId = CCUtils.getCardID(numeroCartao);
	int cardIdSelecionado = CCUtils.VISA;
	if(cardId==cardIdSelecionado){
		System.out.println("Bandeira do cart�o validada!");
	}else{
		System.out.println("Bandeira inv�lida!");
	}
	if(CCUtils.validCC(numeroCartao)){
		System.out.println("Cart�o OK");
	}else{
		System.out.println("Cart�o n�o OK");
	}
}
}
