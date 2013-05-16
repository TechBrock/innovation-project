package br.com.innovation.teste;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

import br.com.innovation.service.GoogleService;
import br.com.innovation.vo.EnderecoVo;

public class Teste extends HttpServlet{
 /**
  * 
  */
 private static final long serialVersionUID = 1L;

 
 
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
  
  EnderecoVo enderecoPartida = new EnderecoVo();
  enderecoPartida.setEstado("SP");
  enderecoPartida.setCep("09640000");
  
  EnderecoVo enderecoChegada = new EnderecoVo();
  enderecoChegada.setEstado("SP");
  enderecoChegada.setCep("09210320");
  
  GoogleService service = new GoogleService();
  JSONObject distancia = service.consultarDistanciaJSON(JSONObject.class, enderecoPartida, enderecoChegada);
  
  PrintWriter out = response.getWriter(); 
  
  try {
	out.println("<html> " + 
	     "<body>" + 
	      "<h1 align=center>Teste Quantidade Em Estoque</h1>" 
	      + "<br>" + "CEP : " + distancia.getString("distance")
	      //+ "<br>" + "Bairro : " + endereco.getBairro()
	//	     + "<br>" + "CEP : " + endereco.getCep()
	//	     + "<br>" + "Tipo Logradouro : " + endereco.getTipo()
	//	     + "<br>" + "Logradouro : " + endereco.getLogradouro()
	     +"</body>" + 
	    "</html>");
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

  
  }
  

}

