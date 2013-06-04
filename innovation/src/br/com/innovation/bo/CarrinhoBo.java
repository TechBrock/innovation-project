package br.com.innovation.bo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.codehaus.jettison.json.JSONObject;
import org.richfaces.component.html.HtmlDataGrid;
import br.com.innovation.dao.EnderecoDao;
import br.com.innovation.dao.ModeloDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.service.GoogleService;
import br.com.innovation.vo.CarrinhoVo;
import br.com.innovation.vo.EnderecoVo;
import br.com.innovation.vo.ModeloVo;
import br.com.innovation.vo.UsuarioVo;

public class CarrinhoBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1771701788440661022L;

	CarrinhoVo carrinhoVo = new CarrinhoVo();
	CarrinhoVo carrinhoRemove = new CarrinhoVo();
	ModeloVo modeloVo = new ModeloVo();
	ArrayList<CarrinhoVo> carrinhoAl = new ArrayList<CarrinhoVo>();
	UsuarioVo usuVo = new UsuarioVo();
	EnderecoVo enderecoChegada = new EnderecoVo();
	private Integer qtdCart = 0;
	private Double totalProd = 0.0;
	private Double totalCart = 0.0;
	private Double totalFrete = 0.0;
	private Integer qtdItems = 0;
	
	private Integer idUser;
	
	public CarrinhoVo getCarrinhoVo() {
		return carrinhoVo;
	}

	public void setCarrinhoVo(CarrinhoVo carrinhoVo) {
		this.carrinhoVo = carrinhoVo;
	}

	public CarrinhoVo getCarrinhoRemove() {
		return carrinhoRemove;
	}

	public void setCarrinhoRemove(CarrinhoVo carrinhoRemove) {
		this.carrinhoRemove = carrinhoRemove;
	}

	public ArrayList<CarrinhoVo> getCarrinhoAl() {
		return carrinhoAl;
	}

	public void setCarrinhoAl(ArrayList<CarrinhoVo> carrinhoAl) {
		this.carrinhoAl = carrinhoAl;
	}

	public ModeloVo getModeloVo() {
		return modeloVo;
	}

	public void setModeloVo(ModeloVo modeloVo) {
		this.modeloVo = modeloVo;
	}

	public Integer getQtdCart() {
		return qtdCart;
	}

	public void setQtdCart(Integer qtdCart) {
		this.qtdCart = qtdCart;
	}
	public Double getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(Double totalCart) {
		this.totalCart = totalCart;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	public Double getTotalFrete() {
		return totalFrete;
	}

	public void setTotalFrete(Double totalFrete) {
		this.totalFrete = totalFrete;
	}

	public Double getTotalProd() {
		return totalProd;
	}

	public void setTotalProd(Double totalProd) {
		this.totalProd = totalProd;
	}

	public Integer getQtdItems() {
		return qtdItems;
	}

	public void setQtdItems(Integer qtdItems) {
		this.qtdItems = qtdItems;
	}

	public String addToCart(){
		totalCart = 0.0;
		boolean add = true;
		Double totalKm = calcFrete();
		carrinhoVo.setIdModelo(modeloVo.getId());
		carrinhoVo.setPrecoModelo(modeloVo.getPrecoAtual());
		carrinhoVo.setNomeModelo(modeloVo.getNome());
		carrinhoVo.setIdTipoItem(modeloVo.getIdTipo()); 
		carrinhoVo.setQtdModelo(1);
		carrinhoVo.setValorTotal(carrinhoVo.getPrecoModelo());
		
		for (CarrinhoVo cart : carrinhoAl) {
			if(cart.getIdModelo().intValue() == carrinhoVo.getIdModelo().intValue()){
				add = false;
				break;
			}
		}

		if(add){
			carrinhoAl.add(carrinhoVo);
		}

		for (CarrinhoVo cart : carrinhoAl) {
			
			totalCart += cart.getValorTotal();
		}
		getCalcValorTotal();
		carrinhoVo = new CarrinhoVo();
		return null;

	}
	
	public String removeToCart(){
		carrinhoAl.remove(carrinhoRemove);
		return getCalcValorTotal();
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

	public String getCalcValorTotal(){
		totalCart = 0.0;
		totalProd = 0.0;
		totalFrete = 0.0;
		qtdItems = 0;
		
		double freteKm = calcFrete()/100;
		
		
		for (CarrinhoVo cart : carrinhoAl) {
			qtdItems += cart.getQtdModelo();
			if(carrinhoVo.getIdModelo() != null && carrinhoVo.getIdModelo().intValue() > 0){
				if(cart.getIdModelo().intValue() == carrinhoVo.getIdModelo().intValue()){
					cart.setValorTotal(carrinhoVo.getPrecoModelo()*carrinhoVo.getQtdModelo());
				}
			}
		}

		for (CarrinhoVo cart : carrinhoAl) {
			
			if(cart.getIdTipoItem() != null && cart.getIdTipoItem().intValue() == 1){
				if(freteKm <=1){
					setTotalFrete(8.57 * qtdItems);
				}else{
					setTotalFrete((freteKm * 8.57)* qtdItems);
				}
				
			}else{
				if(freteKm <=1){
					setTotalFrete(8.57 * qtdItems);
				}else{
					setTotalFrete((freteKm * 4.25) * qtdItems);
				}
			}
			totalProd += cart.getValorTotal();
			totalCart += cart.getValorTotal()+totalFrete;
		}
		carrinhoVo = new CarrinhoVo();

		return "inn004carrinho";
	}

	
	
	public String zeraCarrinho(){
		carrinhoVo = new CarrinhoVo();
		carrinhoRemove = new CarrinhoVo();
		carrinhoAl = new ArrayList<CarrinhoVo>();
		carrinhoAl.clear();
		idUser = 0;
		totalCart = 0.0;
		qtdCart = 0;
		
		return null;
	}
	
		
	public Double calcFrete(){
		String dist;
		char teste = '"';
		
		usuVo = new UsuarioDao().getUsuarioById(carrinhoVo.getIdUsuario());
		enderecoChegada = new EnderecoDao().getEndByUser(carrinhoVo.getIdUsuario());

		  
		EnderecoVo enderecoPartida = new EnderecoVo();
		  enderecoPartida.getCidade().getEstado().setNome("SP");
		  enderecoPartida.setCep("09640000");
		  
		  if(enderecoChegada.getCep()!=null){
			  GoogleService service = new GoogleService();
			  JSONObject distancia = service.consultarDistanciaJSON(JSONObject.class, enderecoPartida, enderecoChegada);
			  System.out.println(distancia);
			  
			  dist = distancia.toString().substring(distancia.toString().indexOf(teste+"distance"+teste+":{"+teste+"text"+teste+":"), distancia.toString().indexOf("km"));
			  dist = dist.replace(teste+"distance"+teste+":{"+teste+"text"+teste+":"+teste, "");
			  System.out.println(dist); 
			  return Double.parseDouble(dist);
		  }
		  return 0.;
	}
	
	public void restartCarrinho(){
		carrinhoAl.clear();
		carrinhoRemove = new CarrinhoVo();
		carrinhoVo = new CarrinhoVo();
	}

}
