package br.com.innovation.bo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.richfaces.component.html.HtmlDataGrid;

import br.com.innovation.dao.FavoritoDao;
import br.com.innovation.dao.ModeloDao;
import br.com.innovation.vo.FavoritoVo;

public class FavoritoBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4397698024955085396L;
	private FavoritoVo favoritoVo = new FavoritoVo();
	private ArrayList<FavoritoVo> favoritoAl = new ArrayList<FavoritoVo>();
	private Integer countFav;
	private Integer idUsuario ;
	private Integer idRemove;
	private String acao = null;
	
	
	
	public FavoritoVo getFavoritoVo() {
		return favoritoVo;
	}

	public void setFavoritoVo(FavoritoVo favoritoVo) {
		this.favoritoVo = favoritoVo;
	}

	public ArrayList<FavoritoVo> getFavoritoAl() {
		return favoritoAl;
	}

	public void setFavoritoAl(ArrayList<FavoritoVo> favoritoAl) {
		this.favoritoAl = favoritoAl;
	}

	public Integer getCountFav() {
		return countFav;
	}

	public void setCountFav(Integer countFav) {
		this.countFav = countFav;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdRemove() {
		return idRemove;
	}

	public void setIdRemove(Integer idRemove) {
		this.idRemove = idRemove;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	

	public String addToFavorite(){
		
		int existe = 0;
		
		if(favoritoVo.getIdUsuario()== null || favoritoVo.getIdUsuario() == 0){
			return "inn002";
		}else{
			existe = new FavoritoDao().getExist(favoritoVo.getIdUsuario(), favoritoVo.getIdModelo());
			if(existe == 0){
				new FavoritoDao().insert(favoritoVo);
				countFav = new FavoritoDao().getCountFavorites(favoritoVo.getIdUsuario());
			}
		}
		return null;
		
	}
	
	public HtmlDataGrid getInitTable(){
		getFavotiteByUser();
		return null;
	}
	
	public void setInitTable(HtmlDataGrid table){}
	
	public String  removeToFavorite(){
		new FavoritoDao().remove(idRemove);
		countFav = new FavoritoDao().getCountFavorites(idRemove);
		return "inn004fav";
	}
	
	public String getFavotiteByUser(){
		favoritoAl = new FavoritoDao().getFavoriteByUser(idUsuario);
		return acao;
		
	}
	
	public void montaImagem(OutputStream strem, Object id){
		String principal = null;
		String principalNew = null;
		FileInputStream origem = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] array;
		int x;

		if((Integer) id != null && (Integer) id > 0){
			principal = new ModeloDao().getCaminho("img_1",(Integer) id);
			principalNew = principal.substring(principal.lastIndexOf("/")+1,principal.length());

			try {
				origem = new FileInputStream("C:\\newWork\\imagens_produto\\"+principalNew);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				while((x = origem.read()) > -1){
					out.write(x);
				}

				out.close();
				origem.close();
				array = out.toByteArray();
				strem.write(array);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
}
