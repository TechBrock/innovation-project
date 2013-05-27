package br.com.innovation.service;

import br.com.innovation.vo.EnderecoVo;

import com.sun.jersey.api.client.UniformInterfaceException;

public class GoogleService extends BaseService {

	private static final String URI_WEBSERVICE_GOOGLE_DIRECTIONS = "http://maps.googleapis.com/maps/api/directions/";
	
	private static final String PAIS_BRASIL = "Brazil";
	
	private String gerarUriGoogleDirections(EnderecoVo enderecoPartida, EnderecoVo enderecoChegada){
		return URI_WEBSERVICE_GOOGLE_DIRECTIONS + TIPO_DOCUMENTO_JSON + 
				"?origin=" + enderecoPartida.getCidade().getEstado().getNome()+ "+" + enderecoPartida.getCep() +"+"+ PAIS_BRASIL + 
				"&destination=" + enderecoChegada.getCidade().getEstado().getNome() + "+" + enderecoChegada.getCep() +"+"+ PAIS_BRASIL + "&sensor=false";
	}
	
	public <T> T consultarDistanciaJSON(Class<T> responseType, EnderecoVo enderecoPartida, EnderecoVo enderecoChegada) throws UniformInterfaceException{
		iniciarRecurso(gerarUriGoogleDirections(enderecoPartida,enderecoChegada));
		System.out.println("******"+gerarUriGoogleDirections(enderecoPartida,enderecoChegada)+"******");
		return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
