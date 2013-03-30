package br.com.mb;

import br.com.dao.CadUsuarioDao;
import br.com.vo.CadUsuarioVo;

public class CadUsuarioMb {
	
	CadUsuarioVo cusuvo = new CadUsuarioVo();
	
	public CadUsuarioVo getCusuvoCadUsuarioVo() {
		return cusuvo;
	}
	public void setCusuvoCadUsuarioVo(CadUsuarioVo cusuvo) {
		this.cusuvo = cusuvo;
	}


	public void inserir(){
		new CadUsuarioDao().insert(cusuvo);
	}
	
	public void alterar(){
		new CadUsuarioDao().update(cusuvo);
	}
	
	public void buscar(){
		new CadUsuarioDao().getUsuario(cusuvo.getCpf());
	}
	
}
	
