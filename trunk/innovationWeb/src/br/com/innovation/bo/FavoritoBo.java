package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.innovation.dao.FavoritoDao;
import br.com.innovation.vo.FavoritoVo;

public class FavoritoBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4397698024955085396L;
	private FavoritoVo favoritoVo = new FavoritoVo();
	private ArrayList<FavoritoVo> favoritoAl = new ArrayList<FavoritoVo>();
	private Integer countFav;
	
	
	
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

	public void addToFavorite(){
		 new FavoritoDao().insert(favoritoVo);
		 countFav = new FavoritoDao().getCountFavorites(favoritoVo.getIdUsuario());
		
	}
	
	public void removeToFavorite(){
		new FavoritoDao().delete(favoritoVo.getId());
		countFav = new FavoritoDao().getCountFavorites(favoritoVo.getIdUsuario());
	}
}
