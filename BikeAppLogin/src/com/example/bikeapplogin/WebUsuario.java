package com.example.bikeapplogin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;

@SuppressLint("SimpleDateFormat")
public class WebUsuario implements Parcelable {
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	private int id = 0;
	private String nome = "t";
	private String sobrenome = "t";
	private Date dataNascimento;
	private Character sexo = 'S';
	private String cpf = "t";
	private String apelido = "t";
	private String email = "t";
	private String senha = "t";
	private Character ativo = 'S';
	private Character receberEmail = 'S';
	private int idPerfil = 0;
	
	public WebUsuario() {
		// TODO Auto-generated constructor stub
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
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	public char getReceberEmail() {
		return receberEmail;
	}
	public void setReceberEmail(char receberEmail) {
		this.receberEmail = receberEmail;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public WebUsuario (Parcel in) throws ParseException {  
		readFromParcel(in);  
    } 

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		// TODO Auto-generated method stub
		
		out.writeInt(id);  
        out.writeString(nome);
        out.writeString(sobrenome);
        out.writeString(dataNascimento.toString());
        out.writeLong(sexo);
        out.writeString(cpf);
        out.writeString(apelido);
        out.writeString(email);
        out.writeString(senha);
        out.writeLong(ativo);
        out.writeLong(receberEmail);
        out.writeInt(idPerfil);
        
	}
	
	private void readFromParcel(Parcel in) throws ParseException {  
		  
        id = in.readInt();
        nome = in.readString();  
        sobrenome = in.readString();
        dataNascimento = (Date) format.parse(in.readString());
        //sexo = (Character) in.readLong();
        cpf = in.readString();
        apelido = in.readString();
        email = in.readString();
        senha = in.readString();
        //ativo = in.readLong();
        //receberEmail = in.readLong();
        idPerfil = in.readInt();
    }  

}
