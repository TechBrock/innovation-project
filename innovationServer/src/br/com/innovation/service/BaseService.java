package br.com.innovation.service;

import java.util.HashMap;
import java.util.Map;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class BaseService {
	protected WebResource webResource;
	protected Client client;
	protected String base_uri;
	protected String path;
	protected static final String TIPO_DOCUMENTO_JSON=  "json";
	protected WebResource iniciarRecurso(String base_uri){
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);
		webResource = client.resource(base_uri);
		return webResource;
	}
	protected void close(){
		client.destroy();
	}
	public Map<String, String> popularMapResultado(String resposta){
		Map<String,String> mapRetorno = new HashMap<String, String>();
		String[] array = resposta.split("&");
		String key = "";
		String value = "";
		for(String s : array){
			String[] dado = s.split("=");
			key = dado[0];
			value = dado[1];
			mapRetorno.put(key, value);
		}
		return mapRetorno;
	}
}

