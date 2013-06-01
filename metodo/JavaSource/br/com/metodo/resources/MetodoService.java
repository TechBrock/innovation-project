package br.com.metodo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.com.metodo.service.impl.AndroidService;
import br.com.metodo.service.impl.ProdutoService;
import br.com.metodo.service.vo.ProdutoVo;
import br.com.metodo.service.vo.Usuario;

@Path("/MetodoService")
public class MetodoService {
	
	@GET
    @Produces("application/json")
    @Path("/consultarEstoque/{id}")
    public JSONObject consultarEstoque(@PathParam("id") String id) throws JSONException{
		
		ProdutoService produtoService = new ProdutoService();
		ProdutoVo produtoRetorno = produtoService.consultarEstoque(id);
		
		return produtoRetorno.toJson();
		
    }
	
	@GET
    @Produces("text/plain")
    @Path("/consultarEstoqueString/{id}")
    public String consultarEstoqueString(@PathParam("id") String id) throws JSONException{
		
		ProdutoService produtoService = new ProdutoService();
		String produtoRetorno = produtoService.consultarEstoqueString(id);
		
		return produtoRetorno;
		
    }
	
	
	/**Métodos do Android*/
	
	@GET
    @Produces("text/plain")
    @Path("/getlogin/{email}-{senha}")
    public String getLogin(@PathParam("email") String email,@PathParam("senha") String senha) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		if(androidService.getLogin(email, senha)){
			return "true";
		}else if(!androidService.getLogin(email, senha)){
			return "false";
		}
		return "";
		
    }
	
	@GET
	@Produces("application/json")
    @Path("/getusuario/{email}-{senha}")
    public JSONObject getUsuario(@PathParam("email") String email,@PathParam("senha") String senha) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		Usuario retorno = androidService.getUsuario(email, senha);
		
		return retorno.toJson();
		
    }
	
	@GET
    @Produces("text/plain")
    @Path("/updateusuario/{usuario}")
    public String updateUsuario(@PathParam("usuario") JSONObject usuario) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		String retorno = androidService.verificarLogin("", "");
		
		
		return retorno;
		
    }
	
	@GET
	@Produces("application/json")
    @Path("/getitens")
    public JSONObject getItens() throws JSONException{
		
		AndroidService androidService = new AndroidService();
		String retorno = androidService.verificarLogin("", "");
		
		return null;
	}
	
	@GET
    @Produces("text/plain")
    @Path("/setitemfavorito/{usuario}-{id}")
    public String setItemFavorito(@PathParam("usuario") String idUsuario, @PathParam("id") String idItem) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		String retorno = androidService.verificarLogin("", "");
		
		
		return retorno;
		
    }
	
	
	@GET
	@Produces("application/json")
    @Path("/getcompras/{id}")
    public JSONObject getCompras(@PathParam("id") String idUsuario) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		String retorno = androidService.verificarLogin("", "");
		
		return null;
	}
	
	@GET
	@Produces("application/json")
    @Path("/getfavoritos/{id}")
    public JSONObject getFavoritos(@PathParam("id") String idUsuario) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		String retorno = androidService.verificarLogin("", "");
		
		return null;
	}
	
	@GET
    @Produces("text/plain")
    @Path("/delfavoritos/{usuario}-{id}")
    public String delFavoritos(@PathParam("usuario") String idUsuario, @PathParam("id") String idItem) throws JSONException{
		
		AndroidService androidService = new AndroidService();
		String retorno = androidService.verificarLogin("", "");
		
		
		return retorno;
		
    }
}
