package com.example.bikeapplogin;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class WebUsuario {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	
	private int id = 0;
	private String nome = "t";
	private String sobrenome = "t";
	private Date dataNascimento;
	private String sexo = "S";
	private String cpf = "t";
	private String apelido = "t";
	private String email = "t";
	private String senha = "t";
	private String ativo = "S";
	private String receberEmail = "S";
	private int telefoneResidencial = 0;
	private int telefoneCelular = 0;
	private int telefoneRecado = 0;
	private String cep = "t";
	private String tipo = "t";
	private String logradouro = "t";
	private String numero = "t";
	private String complemento = "t";
	private String bairro = "t";
	private String informacoesAdicionais = "t";
	private String cidade = "t";
	private String estado = "t";
	
	public SimpleDateFormat getFormat() {
		return format;
	}
	public void setFormat(SimpleDateFormat format) {
		this.format = format;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getReceberEmail() {
		return receberEmail;
	}
	public void setReceberEmail(String receberEmail) {
		this.receberEmail = receberEmail;
	}
	public int getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(int telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public int getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(int telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public int getTelefoneRecado() {
		return telefoneRecado;
	}
	public void setTelefoneRecado(int telefoneRecado) {
		this.telefoneRecado = telefoneRecado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}
	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}