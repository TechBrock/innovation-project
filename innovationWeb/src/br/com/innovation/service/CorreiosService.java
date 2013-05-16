package br.com.innovation.service;

import java.util.Map;

import br.com.innovation.vo.EnderecoVo;

import com.sun.jersey.api.client.UniformInterfaceException;

public class CorreiosService extends BaseService{
	private static final String URI_WEBSERVICE_REPUBLICA_VIRTUAL = "http://cep.republicavirtual.com.br";
	private static final String PATH_WEBSERVICE_REPUBLICA_VIRTUAL_CEP = "/web_cep.php?";

	private static final String URI_WEBSERVICE_CEP_FACIL = "http://www.cepfacil.com.br";
	private static final String PATH_WEBSERVICE_CEP_FACIL_CEP = "/service/?filiacao=0EFA168D-ABD5-4EED-A381-763868E0E930";

	private static final String TIPO_DOCUMENTO_STRING = "texto";

	

	private static final String ENDERECO_ENCONTRADO = "encontrado";

	public CorreiosService(){

	}

	public CorreiosService(String base_uri, String path){
		super.base_uri = base_uri;
		super.path = path;
	}

	private String gerarUriCepFacil(String CEP, String tipoDocumento){
		return URI_WEBSERVICE_CEP_FACIL + PATH_WEBSERVICE_CEP_FACIL_CEP + "&cep=" + CEP + "&formato=" + tipoDocumento;
	}

	public <T> T consultarEnderecoJSON(Class<T> responseType, String cep) throws UniformInterfaceException{
		iniciarRecurso(gerarUriCepFacil(cep,TIPO_DOCUMENTO_JSON));
		System.out.println("******"+gerarUriCepFacil(cep,TIPO_DOCUMENTO_JSON)+"******");
		return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);

	}

	public String consultarEnderecoString(String cep) throws UniformInterfaceException{
		iniciarRecurso(gerarUriCepFacil(cep,TIPO_DOCUMENTO_STRING));
		System.out.println("******"+gerarUriCepFacil(cep,TIPO_DOCUMENTO_STRING)+"******");
		return webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);

	}

	public <T> T consultarEnderecoXML(Class<T> responseType, String cep) throws UniformInterfaceException{
		iniciarRecurso(gerarUriCepFacil(cep,TIPO_DOCUMENTO_JSON));
		System.out.println("******"+gerarUriCepFacil(cep,TIPO_DOCUMENTO_JSON)+"******");
		return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE).get(responseType);

	}

	public EnderecoVo consultarEndereco(String cep){
		EnderecoVo enderecoRetorno = new EnderecoVo();
		Map<String,String> retorno = popularMapResultado(consultarEnderecoString(cep));
		System.out.println(retorno);
		if(retorno.get("status").equals(ENDERECO_ENCONTRADO)){
			enderecoRetorno.setBairro(retorno.get("bairro"));
			enderecoRetorno.setCep(retorno.get("cep"));
			enderecoRetorno.setTipo(retorno.get("tipo"));
			enderecoRetorno.setLogradouro(retorno.get("descricao"));
			//enderecoRetorno.getCidade().getEstado().setId(EstadoEnum.getEstado(retorno.get("uf")).getId());
			return enderecoRetorno;
		}else{
			return null;
		}

	}
}

