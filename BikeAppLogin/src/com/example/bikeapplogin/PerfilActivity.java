package com.example.bikeapplogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends Activity{
	
	private DBHelper db;
	private WebUsuario usuario = new WebUsuario();
	private WebTelefone telefone = new WebTelefone();
	private WebEndereco endereco = new WebEndereco();
	private WebEstado estado = new WebEstado();
	private WebCidade cidade = new WebCidade();
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);
		
		try{
			
			TextView nome = (TextView) findViewById(R.id.vNome);
			TextView sobrenome = (TextView) findViewById(R.id.vSobrenome);
			TextView dataNasc = (TextView) findViewById(R.id.vDataNasc);
			TextView sexo = (TextView) findViewById(R.id.vSexo);
			TextView cpf = (TextView) findViewById(R.id.vCpf);
			TextView apelido = (TextView) findViewById(R.id.vApelido);
			TextView email = (TextView) findViewById(R.id.vEmail);
			TextView dtUltimaModificacao = (TextView) findViewById(R.id.vUltimaModificacao);
			TextView receberEmail = (TextView) findViewById(R.id.vReceberEmail);
			TextView telResidencial = (TextView) findViewById(R.id.vTelResidencial);
			TextView telCelular = (TextView) findViewById(R.id.vTelCelular);
			TextView telRecado = (TextView) findViewById(R.id.vTelRecado);
			TextView logradouro = (TextView) findViewById(R.id.vLogradouro);
			TextView tipo = (TextView) findViewById(R.id.vTipo);
			TextView cep = (TextView) findViewById(R.id.vCep);
			TextView estadoProvincia = (TextView) findViewById(R.id.vEstado);
			TextView cidadeProvincia = (TextView) findViewById(R.id.vCidade);
			TextView bairro = (TextView) findViewById(R.id.vBairro);
			TextView numero = (TextView) findViewById(R.id.vNumero);
			TextView complemento = (TextView) findViewById(R.id.vComplemento);
			TextView infoAdicionais = (TextView) findViewById(R.id.vInformar);

			if(usuario.getAtivo() == 'S'){

				//informações usuário
				if(!usuario.getNome().isEmpty())
					nome.setText(usuario.getNome());
				if(!usuario.getSobrenome().isEmpty())
					sobrenome.setText(usuario.getSobrenome());
				if(!usuario.getDataNascimento().toString().isEmpty())
					dataNasc.setText(usuario.getDataNascimento().toString());
				//if(usuario.getSexo() != ' ')
					sexo.setText(usuario.getSexo());
				cpf.setText(usuario.getCpf());
				//if(usuario.getSexo() != ' ')
					apelido.setText(usuario.getApelido());
				if(!usuario.getEmail().isEmpty())
					email.setText(usuario.getEmail());
				//if(!usuario.getEmail().isEmpty())
				//	dtUltimaModificacao.setText("");
				//if(usuario.getReceberEmail() != ' ')
					receberEmail.setText(usuario.getReceberEmail());

				//informações telefone

				telResidencial.setText(String.format("%s-%s-%s", telefone.getDdd(), getString(telefone.getNumero()).substring(1,4), getString(telefone.getNumero()).substring(5,8)));
				if (Integer.bitCount(telefone.getNumero()) > 8){
					telCelular.setText(String.format("%s-%s-%s", telefone.getDdd(), getString(telefone.getNumero()).substring(1,5), getString(telefone.getNumero()).substring(6,9)));
				} else if (Integer.bitCount(telefone.getNumero()) == 8){
					telCelular.setText(String.format("%s-%s-%s", telefone.getDdd(), getString(telefone.getNumero()).substring(1,4), getString(telefone.getNumero()).substring(5,8)));
				}

				if (Integer.bitCount(telefone.getNumero()) > 8){
					telRecado.setText(String.format("%s-%s-%s", telefone.getDdd(), getString(telefone.getNumero()).substring(1,5), getString(telefone.getNumero()).substring(6,9)));
				} else if (Integer.bitCount(telefone.getNumero()) == 8){
					telRecado.setText(String.format("%s-%s-%s", telefone.getDdd(), getString(telefone.getNumero()).substring(1,4), getString(telefone.getNumero()).substring(5,8)));
				}

				//informações endereço

				if(!endereco.getLogradouro().isEmpty())
					logradouro.setText(endereco.getLogradouro());
				if(!endereco.getTipo().isEmpty())
					tipo.setText(endereco.getTipo());
				if(!endereco.getCep().isEmpty())
					cep.setText(endereco.getCep());
				if(!estado.getNome().isEmpty())
					estadoProvincia.setText(estado.getNome());
				if(!cidade.getNome().isEmpty())
					cidadeProvincia.setText(cidade.getNome());
				if(!endereco.getBairro().isEmpty())
					bairro.setText(endereco.getBairro());
				if(!endereco.getNumero().isEmpty())
					numero.setText(endereco.getNumero());
				if(!endereco.getComplemento().isEmpty())
					complemento.setText(endereco.getComplemento());
				if(!endereco.getInformacoesAdicionais().isEmpty())
					infoAdicionais.setText(endereco.getInformacoesAdicionais());
			} else {
				Toast.makeText(this, "Este usuário esta inativo", Toast.LENGTH_SHORT).show();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    
    public void callPerfil (View v){
    	goToActivity(PerfilActivity.class);
    } 
    
    
    public void callCompras (View v){
    	goToActivity(ComprasActivity.class);
    }
    
    public void callOfertas (View v){
    	goToActivity(ItensActivity.class);
    } 
   
    public void callFavoritos (View v){
    	goToActivity(FavoritoActivity.class);
    } 
    
    public void callLogin (View v){
    	
    	Cursor crs = null;
        
        try{
        
        	db = new DBHelper(this);

        	SQLiteDatabase slc = db.getReadableDatabase();
        	SQLiteDatabase dlt = db.getWritableDatabase();
        	crs = slc.rawQuery("SELECT USUARIO FROM LOGIN", null);
        	crs.moveToFirst();

        	if (crs.getCount() > 0){
        		dlt.delete("LOGIN", null, null);
        		//goToActivity(PerfilActivity.class);
        	}
        }catch(Exception ex){
        	Toast.makeText(this, "Campo Usuário ou senha em branco !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
    	
    	goToActivity(MainActivity.class);
    }
    
    public void callEditar (View v){
    	goToActivity(PerfilPersonalizadoActivity.class);
    }
	
}
