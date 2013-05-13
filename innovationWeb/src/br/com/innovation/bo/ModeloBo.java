package br.com.innovation.bo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import br.com.innovation.dao.ModeloDao;
import br.com.innovation.dao.PrecoDao;
import br.com.innovation.vo.ModeloVo;
public class ModeloBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1474734586843485729L;
	private ModeloVo modeloInsert = new ModeloVo();
	private ModeloVo modeloUpdate = new ModeloVo();
	private UploadedFile img1;
	private UploadedFile img2;
	private UploadedFile img3;
	private UploadedFile img4;
	private boolean img1Valida = true;
	private boolean img2Valida = true;
	private boolean img3Valida = true;
	private boolean img4Valida = true;
	private boolean hide1 = true;
	private boolean hide2 = true;
	private boolean hide3 = true;
	private boolean hide4 = true;
	private boolean nomeValido = true;
	private boolean qtdValido = true;
	private boolean carcValido = true;
	private boolean tamValido = true;
	private boolean aroValido = true;
	private boolean dimValido = true;
	private boolean pesoValido = true;
	private boolean infAdcValido = true;
	private boolean garantiaValido = true;
	private boolean materialValido = true;
	private boolean corValido = true;
	private boolean tipoValido = true;
	private boolean classValido = true;
	private String erroSubmit = "";
	ArrayList<String> caminhosAl = new ArrayList<String>();
	ArrayList<ModeloVo> modeloAl = new ArrayList<ModeloVo>();

	public ModeloVo getModeloInsert() {
		return modeloInsert;
	}
	public void setModeloInsert(ModeloVo modeloInsert) {
		this.modeloInsert = modeloInsert;
	}
	public ModeloVo getModeloUpdate() {
		return modeloUpdate;
	}
	public void setModeloUpdate(ModeloVo modeloUpdate) {
		this.modeloUpdate = modeloUpdate;
	}
	public UploadedFile getImg1() {
		return img1;
	}
	public void setImg1(UploadedFile img1) {
		this.img1 = img1;
	}
	public UploadedFile getImg2() {
		return img2;
	}
	public void setImg2(UploadedFile img2) {
		this.img2 = img2;
	}
	public UploadedFile getImg3() {
		return img3;
	}
	public void setImg3(UploadedFile img3) {
		this.img3 = img3;
	}
	public UploadedFile getImg4() {
		return img4;
	}
	public void setImg4(UploadedFile img4) {
		this.img4 = img4;
	}
	public boolean isImg1Valida() {
		return img1Valida;
	}
	public void setImg1Valida(boolean img1Valida) {
		this.img1Valida = img1Valida;
	}
	public boolean isImg2Valida() {
		return img2Valida;
	}
	public void setImg2Valida(boolean img2Valida) {
		this.img2Valida = img2Valida;
	}
	public boolean isImg3Valida() {
		return img3Valida;
	}
	public void setImg3Valida(boolean img3Valida) {
		this.img3Valida = img3Valida;
	}
	public boolean isImg4Valida() {
		return img4Valida;
	}
	public void setImg4Valida(boolean img4Valida) {
		this.img4Valida = img4Valida;
	}

	public boolean isHide1() {
		return hide1;
	}
	public void setHide1(boolean hide1) {
		this.hide1 = hide1;
	}
	public boolean isHide2() {
		return hide2;
	}
	public void setHide2(boolean hide2) {
		this.hide2 = hide2;
	}
	public boolean isHide3() {
		return hide3;
	}
	public void setHide3(boolean hide3) {
		this.hide3 = hide3;
	}
	public boolean isHide4() {
		return hide4;
	}
	public void setHide4(boolean hide4) {
		this.hide4 = hide4;
	}
	public boolean isNomeValido() {
		return nomeValido;
	}
	public void setNomeValido(boolean nomeValido) {
		this.nomeValido = nomeValido;
	}
	public boolean isQtdValido() {
		return qtdValido;
	}
	public void setQtdValido(boolean qtdValido) {
		this.qtdValido = qtdValido;
	}
	public boolean isCarcValido() {
		return carcValido;
	}
	public void setCarcValido(boolean carcValido) {
		this.carcValido = carcValido;
	}
	public boolean isTamValido() {
		return tamValido;
	}
	public void setTamValido(boolean tamValido) {
		this.tamValido = tamValido;
	}
	public boolean isAroValido() {
		return aroValido;
	}
	public void setAroValido(boolean aroValido) {
		this.aroValido = aroValido;
	}
	public boolean isDimValido() {
		return dimValido;
	}
	public void setDimValido(boolean dimValido) {
		this.dimValido = dimValido;
	}
	public boolean isPesoValido() {
		return pesoValido;
	}
	public void setPesoValido(boolean pesoValido) {
		this.pesoValido = pesoValido;
	}
	public boolean isInfAdcValido() {
		return infAdcValido;
	}
	public void setInfAdcValido(boolean infAdcValido) {
		this.infAdcValido = infAdcValido;
	}
	public boolean isGarantiaValido() {
		return garantiaValido;
	}
	public void setGarantiaValido(boolean garantiaValido) {
		this.garantiaValido = garantiaValido;
	}
	public boolean isMaterialValido() {
		return materialValido;
	}
	public void setMaterialValido(boolean materialValido) {
		this.materialValido = materialValido;
	}
	public boolean isCorValido() {
		return corValido;
	}
	public void setCorValido(boolean corValido) {
		this.corValido = corValido;
	}
	public boolean isTipoValido() {
		return tipoValido;
	}
	public void setTipoValido(boolean tipoValido) {
		this.tipoValido = tipoValido;
	}
	public String getErroSubmit() {
		return erroSubmit;
	}
	public void setErroSubmit(String erroSubmit) {
		this.erroSubmit = erroSubmit;
	}
	public ArrayList<ModeloVo> getModeloAl() {
		return modeloAl;
	}
	public void setModeloAl(ArrayList<ModeloVo> modeloAl) {
		this.modeloAl = modeloAl;
	}
	public boolean isClassValido() {
		return classValido;
	}

	public void setClassValido(boolean classValido) {
		this.classValido = classValido;
	}


	public String insereProduto(){
		int idProduto = 0;

		try {
			if(validaDados()){
				idProduto = new ModeloDao().insertModelo(modeloInsert);
				if(idProduto > 0){
					new PrecoDao().insert(modeloInsert.getPrecoAtual(), idProduto);
					uploads(idProduto);
					if(caminhosAl.size() > 0){
						new ModeloDao().updateImage(caminhosAl, idProduto);
						erroSubmit = "Produto inserido com sucesso!";
						return "inn004ins";
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void uploads(Integer idProduto) throws IOException{
		caminhosAl = new ArrayList<String>();
		FileOutputStream destino = null;

		if(modeloInsert.getImg1() == null){
			img1Valida = false;
		}else{
			destino = new FileOutputStream("C:\\newWork\\innovation\\WebContent\\images\\produtos\\"+idProduto+"principal.jpeg");
			destino.write(img1.getBytes(), 0, img1.getBytes().length);
			destino.flush();
			destino.close();
			caminhosAl.add("'C:/newWork/imagens_produto/"+idProduto+"principal.jpeg'");
		}

		if(modeloInsert.getImg2() != null){
			destino = new FileOutputStream("C:\\newWork\\innovation\\WebContent\\images\\produtos\\"+idProduto+"detalhe1.jpeg");
			destino.write(img1.getBytes(), 0, img1.getBytes().length);
			destino.flush();
			destino.close();
			caminhosAl.add("'C:/newWork/imagens_produto/"+idProduto+"detalhe1.jpeg'");
		}

		if(modeloInsert.getImg3() != null){
			destino = new FileOutputStream("C:\\newWork\\innovation\\WebContent\\images\\produtos\\"+idProduto+"detalhe2.jpeg");
			destino.write(img1.getBytes(), 0, img1.getBytes().length);
			destino.flush();
			destino.close();
			caminhosAl.add("'C:/newWork/imagens_produto/"+idProduto+"detalhe2.jpeg'");
		}

		if(modeloInsert.getImg4() != null){
			destino = new FileOutputStream("C:\\newWork\\innovation\\WebContent\\images\\produtos\\"+idProduto+"detalhe3.jpeg");
			destino.write(img1.getBytes(), 0, img1.getBytes().length);
			destino.flush();
			destino.close();
			caminhosAl.add("'C:/newWork/imagens_produto/"+idProduto+"detalhe3.jpeg'");
		}
	}

	public String uploadImg1() throws IOException{
		if(img1 != null ){
			modeloInsert.setImg1(img1.getBytes());
		}
		return "inn004ins";
	}
	public String uploadImg2() throws IOException{
		if(img2 != null ){
			modeloInsert.setImg2(img2.getBytes());
		}
		return "inn004ins";
	}
	public String uploadImg3() throws IOException{
		if(img2 != null ){
			modeloInsert.setImg3(img3.getBytes());
		}
		return "inn004ins";
	}
	public String uploadImg4() throws IOException{
		if(img2 != null ){
			modeloInsert.setImg4(img4.getBytes());
		}
		return "inn004ins";
	}

	public boolean validaDados() throws IOException{
		boolean ok = true;

		if(modeloInsert.getNome() == null || modeloInsert.getNome().equals("")){
			nomeValido = false;
			ok = false;
		}

		if(modeloInsert.getQuantidade() == null || modeloInsert.getQuantidade() <= 0){
			qtdValido = false;
			ok = false;
		}

		if(modeloInsert.getCaract() == null || modeloInsert.getCaract().equals("")){
			carcValido = false;
			ok = false;
		}

		if(modeloInsert.getTamanho() == null || modeloInsert.getTamanho() <= 0){
			tamValido = false;
			ok = false;
		}

		if(modeloInsert.getAro() == null || modeloInsert.getAro() <= 0){
			aroValido = false;
		}

		if(modeloInsert.getDimensao() == null || modeloInsert.getDimensao().equals("")){
			dimValido = false;
		}

		if(modeloInsert.getPeso() == null || modeloInsert.getPeso() <= 0){
			pesoValido = false;
		}

		if(modeloInsert.getInfAdc() == null || modeloInsert.getInfAdc().equals("")){
			infAdcValido = false;
		}

		if(modeloInsert.getGarantia() == null || modeloInsert.getGarantia().equals("")){
			garantiaValido = false;
		}

		if(modeloInsert.getMaterial() == null || modeloInsert.getMaterial().equals("")){
			materialValido = false;
		}
		if(modeloInsert.getIdCor() == null || modeloInsert.getIdCor() <= 0){
			corValido = false;
		}
		if(modeloInsert.getIdCor() == null || modeloInsert.getIdCor() <= 0){
			corValido = false;
		}
		if(modeloInsert.getIdTipo() == null || modeloInsert.getIdTipo() <= 0){
			tipoValido = false;
		}
		if(modeloInsert.getIdClassificacao() == null || modeloInsert.getIdClassificacao() <= 0){
			classValido = false;
		}

		return ok;
	}

	public void getModelo(){
		modeloAl = new ModeloDao().getModeloPesq(new ModeloVo());
		ArrayList<Double> precoAl = new ArrayList<Double>();
		for (ModeloVo modelo : modeloAl) {
			precoAl = new PrecoDao().getPrecoByModelo(modelo.getId());
			if(precoAl.size() == 1){
				modelo.setPrecoAtual(precoAl.get(0));
			}else if(precoAl.size() > 1){
				if(precoAl.get(0) > precoAl.get(1)){
					modelo.setPrecoAtual(precoAl.get(0));
					modelo.setPrecoMaior(0.0);
				}else{
					modelo.setPrecoAtual(precoAl.get(0));
					modelo.setPrecoMaior(precoAl.get(1));
				}
			}
		}
	}

	public void montaImagem(OutputStream strem, Object id){
		FileInputStream origem = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String caminho = null;
		byte[] array;
		int x;

		//		caminho = new ModeloDao().getCaminho((Integer) id);
		//		caminho = caminho.replace("/", "\\");

		try {
			origem = new FileInputStream("C:\\newWork\\imagens_produto\\15principal.jpeg");
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
