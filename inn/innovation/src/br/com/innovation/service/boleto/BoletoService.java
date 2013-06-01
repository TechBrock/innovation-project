package br.com.innovation.service.boleto;

import java.io.File;
import java.util.Calendar;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.Sacado;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;
import br.com.innovation.vo.BoletoVo;
import br.com.innovation.vo.EnderecoVo;
import br.com.innovation.vo.UsuarioVo;

public class BoletoService {
	
	public static byte[] gerarBoleto(UsuarioVo usuBoleto, EnderecoVo endBoleto, Double totalCarrinho, Integer idCompra){
		
		BoletoVo boletoVo = new BoletoVo();
		Calendar dataAtual = Calendar.getInstance();
		boletoVo.setIdCliente(usuBoleto.getId());
		//boletoVo.setIdCompra(compra.getId());
		boletoVo.setIdCompra(idCompra);
		boletoVo.setValorBoleto(totalCarrinho);
		//boletoVo.setValorBoleto(compra.getValor());
			
		boletoVo.setDataDocumento(dataAtual.getTime());
		boletoVo.setDataProcessamento(dataAtual.getTime());
		Calendar dataVencimento = Calendar.getInstance();
		dataVencimento.add(Calendar.DAY_OF_MONTH, 5);
		boletoVo.setDataVencimento(dataVencimento.getTime());
		
		Datas datas = Datas.newDatas()
	            .withDocumento(dataAtual.get(Calendar.DAY_OF_MONTH), dataAtual.get(Calendar.MONTH)+1, dataAtual.get(Calendar.YEAR))
	            .withProcessamento(dataAtual.get(Calendar.DAY_OF_MONTH), dataAtual.get(Calendar.MONTH)+1, dataAtual.get(Calendar.YEAR))
	            .withVencimento(dataAtual.get(Calendar.DAY_OF_MONTH)+5, dataAtual.get(Calendar.MONTH)+1, dataAtual.get(Calendar.YEAR));

		Emissor emissor = Emissor.newEmissor()  
				.withCedente("METALÚRGICA MÉTODO LTDA.")  
				.withAgencia(1111).withDvAgencia('1')  
				.withContaCorrente(11111)  
				.withNumConvenio(1111111)  
				.withDvContaCorrente('X')  
				.withCarteira(18)  
				.withNossoNumero(1000000);  
		
		
		Sacado sacado = Sacado.newSacado()  
				.withNome(usuBoleto.getNome()+" "+usuBoleto.getSobrenome())
				.withCpf(usuBoleto.getCpf())  
				.withEndereco(endBoleto.getLogradouro()+","+endBoleto.getNumero()+" - "+endBoleto.getComplemento())  
				.withBairro(endBoleto.getBairro())  
				.withCep(endBoleto.getCep())  
				.withCidade(endBoleto.getNomeCidade())  
				.withUf(endBoleto.getUf());  

		Banco banco = new BancoDoBrasil();  

		//boletoVo.setId(new BoletoDao().insertBoleto(boletoVo));
		boletoVo.setId(1);
		Boleto boleto = Boleto.newBoleto()  
				.withBanco(banco)  
				.withDatas(datas)  
				.withDescricoes("")  
				.withEmissor(emissor)  
				.withSacado(sacado)  
				.withValorBoleto(boletoVo.getValorBoleto())
				//.withValorBoleto()
				.withInstrucoes("SR. CAIXA,"
						,"FAVOR NÃO RECEBER ESTE DOCUMENTO EM HIPÓTESE ALGUMA"
						,"BOLETO GERADO ATRAVÉS DO SISTEMA INNOVATION"
						, "***BOLETO MERAMENTE ILUSTRATIVO, DE CUNHO ACADÊMICO***"
						,"METALÚRGICA MÉTODO - QUALIDADE ACIMA DE TUDO")  
				.withLocaisDePagamento("***BOLETO MERAMENTE ILUSTRATIVO, DE CUNHO ACADÊMICO***")  
				.withNoDocumento(String.valueOf(boletoVo.getId()));

		BoletoGenerator gerador = new BoletoGenerator(boleto);  

		// Para gerar um array de bytes a partir de um PNG
		
		String nomeArquivo = gerarNomeArquivo(boletoVo);
		//String nomeArquivo = gerarNomeArquivo(nome,valor);
		gerador.toPNG(new File("C:\\boletos\\"+nomeArquivo));
		
		byte[] bPNG = gerador.toPNG();
//		gerarArquivo(gerador.toPNG(),"C:\\boletos\\teste.png");	
//		
//		gerador.toPDF(new File("C:\\boletos\\teste.pdf"));
//		gerarArquivo(gerador.toPDF(),"C:\\boletos\\teste.pdf");
//		fazerDownloadArquivo("C:\\boletos\\teste.pdf", nomeArquivo);
		
		return bPNG;
	}
	
	
	private static String gerarNomeArquivo(BoletoVo boleto){
		StringBuffer sb = new StringBuffer();
		sb.append(boleto.getIdCliente());
		sb.append(boleto.getId());
		sb.append(boleto.getIdCompra());
		sb.append(".png");
		return sb.toString();
	}
	
	private static String gerarNomeArquivo(String nome, double valor){
		StringBuffer sb = new StringBuffer();
		sb.append(nome);
		sb.append(valor);
		sb.append(".png");
		return sb.toString();
	}
	
	private static UsuarioVo getUsuario(String nome){
		UsuarioVo usuario = new UsuarioVo();
		usuario.setId(1);
		usuario.setNome("Vitor");
		usuario.setCpf("111.111.111-11");
		
		return usuario;
	}
	
	private static UsuarioVo getUsuario(){
		UsuarioVo usuario = new UsuarioVo();
		usuario.setId(1);
		usuario.setNome("Vitoooooooooooooooooooooooooooooooooooor");
		usuario.setCpf("111.111.111-11");
		
		return usuario;
	}
	
	private static EnderecoVo getEndereco(){
		EnderecoVo endereco = new EnderecoVo();
		endereco.setLogradouro("Rua do Sacramento");
		endereco.setNumero("316");
		endereco.setComplemento("Apt 32");
		endereco.setCep("09640-000");
		endereco.getCidade().setNome("São Bernardo do Campo");
		endereco.getCidade().getEstado().setNome("SP");
		
		return endereco;
	}
	
	/** Constante que representa o tipo do contentType para realizar o download. */
	public final static String CONTENT_TYPE = "application/download";
	
	/** Constante que representa o nome do atributo a ser adicionado no header. */
	public final static String HEADER_NOME = "Content-Disposition";
	
	/** Constante que representa o valor do atributo a ser adicionado no header. */
	public final static String HEADER_VALOR = "attachment; filename=";

}
