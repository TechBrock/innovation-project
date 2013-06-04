package br.com.innovation.bo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import org.ajax4jsf.component.html.HtmlPage;
import org.apache.commons.mail.EmailException;
import br.com.innovation.dao.CompraDao;
import br.com.innovation.dao.EnderecoDao;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.service.boleto.BoletoService;
import br.com.innovation.service.cartao.CCService;
import br.com.innovation.utils.Email;
import br.com.innovation.vo.CarrinhoVo;
import br.com.innovation.vo.CartaoVo;
import br.com.innovation.vo.CompraVo;
import br.com.innovation.vo.EnderecoVo;
import br.com.innovation.vo.TelefoneVo;
import br.com.innovation.vo.UsuarioVo;

public class CompraBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4349708120638447587L;
	UsuarioVo usuVo = new UsuarioVo();
	CarrinhoVo carrinhoVo = new CarrinhoVo();
	ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();
	public boolean eCartao= false;
	private byte[] arrayBoleto;
	Integer idUsuario;
	Double valorCarrinho = 0.0;
	CompraVo compraIns = new CompraVo();
	CartaoVo cartaoVo = new CartaoVo();
	String erroSubmit;
	private Integer qtdParcelas;
	private Double valorFrete;
	private Double valorProd;
	private Double valorParcelado;
	private Integer qtdProdutos;
	private String dataValidade;
	private EnderecoVo endVo = new EnderecoVo();
	private ArrayList<CarrinhoVo> carrinhoAl = new ArrayList<CarrinhoVo>();
	private boolean showBoleto;
	private boolean controlePopup;

	public UsuarioVo getUsuVo() {
		return usuVo;
	}
	public void setUsuVo(UsuarioVo usuVo) {
		this.usuVo = usuVo;
	}
	public CarrinhoVo getCarrinhoVo() {
		return carrinhoVo;
	}
	public void setCarrinhoVo(CarrinhoVo carrinhoVo) {
		this.carrinhoVo = carrinhoVo;
	}
	public ArrayList<TelefoneVo> getTelAl() {
		return telAl;
	}
	public void setTelAl(ArrayList<TelefoneVo> telAl) {
		this.telAl = telAl;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Double getValorCarrinho() {
		return valorCarrinho;
	}
	public void setValorCarrinho(Double valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}
	public boolean iseCartao() {
		return eCartao;
	}
	public void seteCartao(boolean eCartao) {
		this.eCartao = eCartao;
	}
	public CartaoVo getCartaoVo() {
		return cartaoVo;
	}
	public void setCartaoVo(CartaoVo cartaoVo) {
		this.cartaoVo = cartaoVo;
	}
	public String getErroSubmit() {
		return erroSubmit;
	}
	public void setErroSubmit(String erroSubmit) {
		this.erroSubmit = erroSubmit;
	}
	public Integer getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Double getValorProd() {
		return valorProd;
	}
	public void setValorProd(Double valorProd) {
		this.valorProd = valorProd;
	}
	public Double getValorParcelado() {
		return valorParcelado;
	}
	public void setValorParcelado(Double valorParcelado) {
		this.valorParcelado = valorParcelado;
	}
	public Integer getQtdProdutos() {
		return qtdProdutos;
	}
	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public ArrayList<CarrinhoVo> getCarrinhoAl() {
		return carrinhoAl;
	}
	public void setCarrinhoAl(ArrayList<CarrinhoVo> carrinhoAl) {
		this.carrinhoAl = carrinhoAl;
	}
	public EnderecoVo getEndVo() {
		return endVo;
	}
	public void setEndVo(EnderecoVo endVo) {
		this.endVo = endVo;
	}

	public boolean isShowBoleto() {
		return showBoleto;
	}
	public void setShowBoleto(boolean showBoleto) {
		this.showBoleto = showBoleto;
	}
	public HtmlPage getInitTable(){
		usuVo = new UsuarioDao().getUsuarioById(idUsuario);
		telAl = new TelefoneDao().getTelefoneByUser(idUsuario);
		endVo = new EnderecoDao().getEndByUser(idUsuario);
		return null;
	}
	
	public void setInitTable(HtmlPage table){}
	
	public String zeraCompra(){
		usuVo = new UsuarioVo();
		telAl.clear();
		endVo = new EnderecoVo();
		
		return null;
	}
	
	public String finalizarBoleto(){
		qtdParcelas = 1;
		finalizarCompra(1, endVo.getId(), usuVo.getId());
		popularBoleto();
		new CarrinhoBo().restartCarrinho();
		return null;
	}

	public void gerarBoleto(OutputStream stream, Object id){		
		try {
			stream.write(arrayBoleto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void popularBoleto(){
		idUsuario = (Integer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id");  
		if(idUsuario != null){
			endVo = new EnderecoDao().getEndByUser(idUsuario);
			usuVo = new UsuarioDao().getUsuarioById(idUsuario);
			telAl = new TelefoneDao().getTelefoneByUser(idUsuario);
			arrayBoleto = BoletoService.gerarBoleto(usuVo, endVo,valorCarrinho);
		}
	}
	
	public byte[] getArrayBoleto() {
		return arrayBoleto;
	}
	public void setArrayBoleto(byte[] arrayBoleto) {
		this.arrayBoleto = arrayBoleto;
	}
	public String comprar(){

		if(idUsuario == null || idUsuario <= 0){
			return "inn002";
		}else{
			usuVo = new UsuarioDao().getUsuarioById(idUsuario);
			telAl = new TelefoneDao().getTelefoneByUser(idUsuario);
			endVo = new EnderecoDao().getEndByUser(idUsuario);
			return "inn004compra";
		}
	}

	public String finalizarCompra(Integer tipoPag, Integer idEnd, Integer idUser){
		Integer idcompra = 0;
		String acao = null;
		
		ArrayList<Integer> compraProd = new ArrayList<Integer>();
		compraIns.setAprovado('N');
		compraIns.setDesconto(0.0);
		compraIns.setIdEnderecoEntrega(idEnd);
		compraIns.setIdMeioPagamento(tipoPag);
		compraIns.setIdJuros(1);
		compraIns.setIdTipoFrete(1);
		compraIns.setIdUsuario(idUsuario);
		compraIns.setOrdemCompra((int) (new Date().getTime()/1000));
		compraIns.setPrazo(10);
		compraIns.setQtdParcelas(qtdParcelas);
		compraIns.setValorFrete(valorFrete);
		compraIns.setValorCompra(valorProd);
		idcompra = new CompraDao().insertCompra(compraIns);
		
		compraProd = new ArrayList<Integer>();
		if(idcompra > 0){
			for (CarrinhoVo cart : carrinhoAl) {
				for(int x = 0; x < cart.getQtdModelo();x++)
				compraProd.add(new CompraDao().insertCompraProduto(idcompra, cart.getIdModelo(), 1));
			}
		}
		
		if(compraProd.size() > 0){
			try {
				Email.enviaEmailCompra(compraIns.getOrdemCompra(), usuVo.getApelido(), usuVo.getEmail());
				acao = "inn004confirm";
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
		new CarrinhoBo().restartCarrinho();
		return acao;
		
	}


	public String validarCartao(){
		
		UsuarioVo usuVo = new UsuarioVo();
		EnderecoVo endVo = new EnderecoVo();
		usuVo = new UsuarioDao().getUsuarioById(idUsuario);
		endVo = new EnderecoDao().getEndByUser(idUsuario);
		String acao = null;
		
		int bandeira = cartaoVo.getBandeira();
		String numeroCartao = cartaoVo.getNumero();
		if(CCService.validarNumero(numeroCartao)){
			if(CCService.validarBandeira(numeroCartao, bandeira)){
				if(CCService.validarNumeroCartao(numeroCartao, bandeira)){
					if(dataOk()){
						acao = finalizarCompra(2, endVo.getId(), usuVo.getId());
						setErroSubmit("Cartão Validado!");
					}else{
						setErroSubmit("Cartão inválido!");
					}
				}else{
					setErroSubmit("Cartão inválido!");
				}
			}else{
				setErroSubmit("Cartão inválido!");
			}
		}else{
			setErroSubmit("Cartão inválido!");
			
		}
		return acao;
	}
	
	public String calcParcelas(){
		valorParcelado = (valorCarrinho / qtdParcelas);
		return null;
	}
	
	public boolean dataOk(){
		boolean ok = true;
		String mesAtual;
		String anoAtual;
		String mesCartao;
		String anoCartao;
		

		DateFormat frmMes = new SimpleDateFormat("MM");
		DateFormat frmAno = new SimpleDateFormat("yyyy");
		mesAtual = frmMes.format(new Date());
		anoAtual = frmAno.format(new Date());
		
		mesCartao = dataValidade.substring(0,2);
		anoCartao = dataValidade.substring(3,7);
		
		System.out.println(mesCartao);
		System.out.println(anoCartao);
		
		if(Integer.parseInt(anoCartao) < Integer.parseInt(anoAtual)){
			ok = false;
		}else if(Integer.parseInt(anoCartao) == Integer.parseInt(anoAtual)){
			if(Integer.parseInt(mesCartao) <= Integer.parseInt(mesAtual)){
				ok = false;
			}
		}
		return ok;
	}
	
	public String abrirBoleto(){
		setControlePopup(true);
		return "inn004compra";
	}
	public boolean isControlePopup() {
		boolean retorno = controlePopup;
		controlePopup = false;
		return retorno;
	}
	public void setControlePopup(boolean controlePopup) {
		this.controlePopup = controlePopup;
	}
	
	
}
