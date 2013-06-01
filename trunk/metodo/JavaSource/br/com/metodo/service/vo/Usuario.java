package br.com.metodo.service.vo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private char sexo;
	private String cpf;
	private String apelido;
	private String senha;
	private String email;
	private char ativo;
	private char receberEmail;
	private int telefoneResidencial;
	private int telefoneCelular;
	private int telefoneRecado;
	private String logradouro;
	private String tipoLogradouro;
	private String cep;
	private String estado;
	private String bairro;
	private String cidade;
	private String numeroEndereco;
	private String complementoEndereco;
	private String informacoesAdicionais;

	public JSONObject toJson() throws JSONException{
        JSONObject json = new JSONObject();
        json.put("id", getId());
        json.put("nome", getNome());
        json.put("sobrenome", getSobrenome());
        json.put("datanascimento", getDataNascimento());
        json.put("sexo", getSexo());
        json.put("cpf",getCpf());
        json.put("apelido",getApelido());
        //D„„„!! Passar a senha n„o, nÈ? rsss
        //json.put("senha",getSenha());
        json.put("email",getEmail());
        json.put("ativo",getAtivo());
        json.put("receberemail",getReceberEmail());
        json.put("telefoneresidencial",getTelefoneResidencial());
        json.put("telefonecelular",getTelefoneCelular());
        json.put("telefonerecado",getTelefoneRecado());
        json.put("logradouro", getLogradouro());
        json.put("tipologradouro",getTipoLogradouro());
        json.put("cep",getCep());
        json.put("estado",getEstado());
        json.put("bairro",getBairro());
        json.put("cidade",getCidade());
        json.put("numero",getNumeroEndereco());
        json.put("complemento",getComplementoEndereco());
        json.put("informacoes",getInformacoesAdicionais());
        
        return json;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}

	public void setReceberEmail(char receberEmail) {
		this.receberEmail = receberEmail;
	}

	public void setTelefoneResidencial(int telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public void setTelefoneCelular(int telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public void setTelefoneRecado(int telefoneRecado) {
		this.telefoneRecado = telefoneRecado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public char getAtivo() {
		return ativo;
	}

	public char getReceberEmail() {
		return receberEmail;
	}

	public int getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public int getTelefoneCelular() {
		return telefoneCelular;
	}

	public int getTelefoneRecado() {
		return telefoneRecado;
	}
	
	
	
}
