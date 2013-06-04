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
	private WebUsuario usuario;
	private String usr;
	private	String psw;
	private String conteudo = null;
	private PerfilService perfilService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfil);
		
		Cursor crs = null;
        
        try{
        
        	db = new DBHelper(this);

        	SQLiteDatabase slc = db.getReadableDatabase();
        	crs = slc.rawQuery("SELECT USUARIO, SENHA FROM LOGIN", null);
        	crs.moveToFirst();

        	if (crs.getCount() > 0){
        		usr = crs.getString(0);
        		psw = crs.getString(1);
        	}
        }catch(Exception ex){
        	Toast.makeText(this, "Registros não encontrados na tabela !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
        try {
			loadPerfil ();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadPerfil () throws InterruptedException{
		
		perfilService = (PerfilService) new PerfilService(PerfilActivity.this, usr, psw, conteudo, usuario).execute();
		Thread.sleep(5000);
		usuario = perfilService.getUsuario();
		perfil();
	}
	
	@SuppressLint("NewApi")
	private void perfil(){
		try{
			
			TextView nome = (TextView) findViewById(R.id.vNome);
			TextView sobrenome = (TextView) findViewById(R.id.vSobrenome);
			TextView dataNasc = (TextView) findViewById(R.id.vDataNasc);
			TextView sexo = (TextView) findViewById(R.id.vSexo);
			TextView cpf = (TextView) findViewById(R.id.vCpf);
			TextView apelido = (TextView) findViewById(R.id.vApelido);
			TextView email = (TextView) findViewById(R.id.vEmail);
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

			if(!usuario.getAtivo().toString().isEmpty()){

				//informações usuário
				if(!usuario.getNome().isEmpty())
					nome.setText(usuario.getNome());
				if(!usuario.getSobrenome().isEmpty())
					sobrenome.setText(usuario.getSobrenome());
				if(!usuario.getDataNascimento().toString().isEmpty())
					dataNasc.setText(usuario.getDataNascimento().toString());
				if(!usuario.getSexo().toString().isEmpty())
					sexo.setText(usuario.getSexo());
				if(!usuario.getCpf().toString().isEmpty())
					cpf.setText(usuario.getCpf());
				if(!usuario.getApelido().toString().isEmpty())
					apelido.setText(usuario.getApelido());
				if(!usuario.getEmail().isEmpty())
					email.setText(usuario.getEmail());
				if(!usuario.getReceberEmail().toString().isEmpty())
					receberEmail.setText(usuario.getReceberEmail());

				//informações telefone
				if (Integer.bitCount(usuario.getTelefoneResidencial()) == 10){
					telResidencial.setText(String.format("%s-%s-%s", getString(usuario.getTelefoneResidencial()).substring(1,2), getString(usuario.getTelefoneResidencial()).substring(3,6), getString(usuario.getTelefoneResidencial()).substring(7,10)));
				} else {
					telResidencial.setText(usuario.getTelefoneResidencial());
				}
				
				if (Integer.bitCount(usuario.getTelefoneCelular()) > 10){
					telCelular.setText(String.format("%s-%s-%s", getString(usuario.getTelefoneCelular()).substring(1,2), getString(usuario.getTelefoneCelular()).substring(3,6), getString(usuario.getTelefoneCelular()).substring(7,11)));
				} else if (Integer.bitCount(usuario.getTelefoneCelular()) == 10){
					telCelular.setText(String.format("%s-%s-%s", getString(usuario.getTelefoneCelular()).substring(1,2), getString(usuario.getTelefoneCelular()).substring(3,6), getString(usuario.getTelefoneCelular()).substring(7,10)));
				} else {
					telCelular.setText(usuario.getTelefoneCelular());
				}
				
				if (Integer.bitCount(usuario.getTelefoneRecado()) > 10){
					telRecado.setText(String.format("%s-%s-%s", getString(usuario.getTelefoneRecado()).substring(1,2), getString(usuario.getTelefoneRecado()).substring(3,6), getString(usuario.getTelefoneRecado()).substring(7,11)));
				} else if (Integer.bitCount(usuario.getTelefoneRecado()) == 10){
					telRecado.setText(String.format("%s-%s-%s", getString(usuario.getTelefoneRecado()).substring(1,2), getString(usuario.getTelefoneRecado()).substring(3,6), getString(usuario.getTelefoneRecado()).substring(7,10)));
				} else {
					telRecado.setText(usuario.getTelefoneRecado());
				}

				//informações endereço
				if(!usuario.getLogradouro().isEmpty())
					logradouro.setText(usuario.getLogradouro());
				if(!usuario.getTipo().isEmpty())
					tipo.setText(usuario.getTipo());
				if(!usuario.getCep().isEmpty())
					cep.setText(usuario.getCep());
				if(!usuario.getEstado().isEmpty())
					estadoProvincia.setText(usuario.getEstado());
				if(!usuario.getCidade().isEmpty())
					cidadeProvincia.setText(usuario.getCidade());
				if(!usuario.getBairro().isEmpty())
					bairro.setText(usuario.getBairro());
				if(!usuario.getNumero().isEmpty())
					numero.setText(usuario.getNumero());
				if(!usuario.getComplemento().isEmpty())
					complemento.setText(usuario.getComplemento());
				if(!usuario.getInformacoesAdicionais().isEmpty())
					infoAdicionais.setText(usuario.getInformacoesAdicionais());
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
	
	private void goToActivityIdUsuario(Class<? extends Activity> activityClass, int idUsuario) {
        Intent newActivity = new Intent(this, activityClass);
        newActivity.putExtra("id_usuario", idUsuario);
        startActivity(newActivity);
    }  
    
    public void callCompras (View v){
    	goToActivityIdUsuario(FavoritoActivity.class, usuario.getId());
    }
    
    public void callOfertas (View v){
    	goToActivityIdUsuario(FavoritoActivity.class, usuario.getId());
    } 
   
    public void callFavoritos (View v){
    	goToActivityIdUsuario(FavoritoActivity.class, usuario.getId());
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
        	Toast.makeText(this, "Não existe usuário logado !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
    	
    	goToActivity(MainActivity.class);
    }
    
    public void callEditar (View v){
    	Intent newActivity = new Intent(PerfilActivity.this, PerfilPersonalizadoActivity.class);
		newActivity.putExtra("Usuario", usuario);
    }
    
    
	
}
