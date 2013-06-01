package br.com.metodo.service.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


@XmlRootElement
public class ProdutoVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5571668887693468603L;
	private Integer id;
	private Integer idWeb;
	private Integer quantidade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdWeb() {
		return idWeb;
	}
	public void setIdWeb(Integer idWeb) {
		this.idWeb = idWeb;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public JSONObject toJson() throws JSONException{
        JSONObject json = new JSONObject();
        json.put("id", getIdWeb());
        json.put("quantidade", getQuantidade());
        
        return json;
    }
}
