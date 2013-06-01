package br.com.innovation.service.cartao;

public class CCService {

	/**
	 * Fun��o: validarNumero
	 * Valida se o n�mero do cart�o digitado � v�lido, tanto em quest�o de haver somente n�meros
	 * quanto no tamanho.
	 * @param numeroCartao
	 * @return
	 */
	public static boolean validarNumero(String numeroCartao){
		if(CCUtils.isNumber(numeroCartao) && numeroCartao.length()==16){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Fun��o: validarBandeira
	 * Valida se o n�mero do cart�o digitado se refere a bandeira selecionada (Enum BandeiraCC) 
	 * @param numeroCartao
	 * @param bandeira
	 * @return
	 */
	public static boolean validarBandeira(String numeroCartao,int bandeira){
		BandeiraCC bandeiraCC = null;
		if(bandeira == 0){
			bandeiraCC = BandeiraCC.VISA;
		}else if(bandeira == 1){
			bandeiraCC = BandeiraCC.MASTERCARD;
		}else if(bandeira == 3){
			bandeiraCC = BandeiraCC.AMERICAN_EXPRESS;
		}
		if(validarNumero(numeroCartao)){
			if(CCUtils.getCardID(numeroCartao)==bandeiraCC.getCodigoBandeira()){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	/**
	 * Fun��o: validarNumeroCartao
	 * Valida se o n�mero do cart�o digitado � v�lido, conforme regras de gera��o desse n�mero
	 * @param numeroCartao
	 * @param bandeira
	 * @return
	 */
	public static boolean validarNumeroCartao(String numeroCartao, int bandeira){
		try {
			if(validarNumero(numeroCartao)){
				if(validarBandeira(numeroCartao, bandeira)){
					return CCUtils.validCC(numeroCartao);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
	
	


