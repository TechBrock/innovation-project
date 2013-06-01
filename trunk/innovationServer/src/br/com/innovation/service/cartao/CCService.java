package br.com.innovation.service.cartao;

public class CCService {

	/**
	 * Função: validarNumero
	 * Valida se o número do cartão digitado é válido, tanto em questão de haver somente números
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
	 * Função: validarBandeira
	 * Valida se o número do cartão digitado se refere a bandeira selecionada (Enum BandeiraCC) 
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
	 * Função: validarNumeroCartao
	 * Valida se o número do cartão digitado é válido, conforme regras de geração desse número
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
	
	


