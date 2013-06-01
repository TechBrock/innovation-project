package br.com.innovation.service;

import com.sun.jersey.api.client.UniformInterfaceException;


public class MetodoService extends BaseService{

private static String URI_WEBSERVICE_METODO = "http://localhost:8080/metodo/MetodoService";

 public <T> T consultarEstoque (Class<T> responseType, String id) throws UniformInterfaceException {
   iniciarRecurso(URI_WEBSERVICE_METODO);
        return webResource.path(java.text.MessageFormat.format("/consultarEstoque/{0}",
                              new Object[]{id})).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String consultarEstoqueString(String id) throws UniformInterfaceException {
      iniciarRecurso(URI_WEBSERVICE_METODO);
        return webResource.path(java.text.MessageFormat.format("/consultarEstoqueString/{0}",
                              new Object[]{id})).accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

}
