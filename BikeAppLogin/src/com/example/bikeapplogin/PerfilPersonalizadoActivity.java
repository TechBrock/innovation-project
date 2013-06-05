package com.example.bikeapplogin;

import com.example.bikeapplogin.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class PerfilPersonalizadoActivity extends Activity{
	
	private PerfilMergeService perfilMergeService;
	private String conteudo = null;
	private WebUsuario wUser;
	
	EditText nm;
	EditText sn;
	EditText dtnasc;
	RadioButton sx1;
	RadioButton sx2;
	EditText cpf ;
	EditText apl;
	EditText email;
	CheckBox rcEmail;
	EditText telRes;
	EditText telCel;
	EditText telRec;
	EditText cep;
	EditText tp;
	EditText lg;
	EditText comp;
	EditText br;
	EditText info;
	EditText cid;
	EditText est;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfilpersonalizado);

		Intent ItensExtra= getIntent();
		wUser = (WebUsuario) ItensExtra.getSerializableExtra("Usuario");
		
		nm = (EditText) findViewById(R.id.vNomeEdit);
		sn = (EditText) findViewById(R.id.vSobrenomeEdit);
		dtnasc = (EditText) findViewById(R.id.vDataNascEdit);
		sx1 = (RadioButton) findViewById(R.id.vsexoEdit1);
		sx2 = (RadioButton) findViewById(R.id.vSexoEit2);
		cpf = (EditText) findViewById(R.id.vCpfEdit);
		apl = (EditText) findViewById(R.id.vApelidoEdit);
		email = (EditText) findViewById(R.id.vEmailEdit);
		rcEmail = (CheckBox) findViewById(R.id.vReceberEmailEdit);
		telRes = (EditText) findViewById(R.id.vTelResidencialEdit);
		telCel = (EditText) findViewById(R.id.vTelCelularEdit);
		telRec = (EditText) findViewById(R.id.vTelRecadoEdit);
		cep = (EditText) findViewById(R.id.vCepEdit);
		tp = (EditText) findViewById(R.id.vTipoEdit);
		lg = (EditText) findViewById(R.id.vLogradouroEdit);
		comp = (EditText) findViewById(R.id.vComplementoEdit);
		br = (EditText) findViewById(R.id.vBairroEdit);
		info = (EditText) findViewById(R.id.vInformarEdit);
		cid = (EditText) findViewById(R.id.vCidadeEdit);
		est = (EditText) findViewById(R.id.vEstadoEdit);
		
		nm.setText(wUser.getNome());
		sn.setText(wUser.getSobrenome());
		dtnasc.setText(wUser.getNome());
		
		if (wUser.getSexo().equals("M")){
			sx1.setChecked(true);
			sx2.setChecked(false);
		} else if (wUser.getSexo().equals("F")){
			sx1.setChecked(false);
			sx2.setChecked(true);
		}
		
		cpf.setText(wUser.getCpf());
		apl.setText(wUser.getApelido());
		email.setText(wUser.getEmail());
		
		if (wUser.getReceberEmail().equals("S")){
			rcEmail.setChecked(true);
		}

		telRes.setText(wUser.getTelefoneResidencial());
		telCel.setText(wUser.getTelefoneCelular());
		telRec.setText(wUser.getTelefoneRecado());
		cep.setText(wUser.getCep());
		tp.setText(wUser.getTipo());
		lg.setText(wUser.getLogradouro());
		comp.setText(wUser.getComplemento());
		br.setText(wUser.getBairro());
		info.setText(wUser.getInformacoesAdicionais());
		cid.setText(wUser.getCidade());
		est.setText(wUser.getEstado());

	}
	
	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
	
	public void callSalvarPerfil (View v){
		
		wUser.setNome(nm.getText().toString());
		wUser.setSobrenome(sn.getText().toString());
		wUser.setDataNascimento(dtnasc.getText().toString());
		
		if (sx1.isChecked() && !sx2.isClickable()){
			wUser.setSexo("M");
		} else if (!sx1.isChecked() && sx2.isClickable()){
			wUser.setSexo("F");
		}
		
		wUser.setCpf(cpf.getText().toString());
		wUser.setApelido(apl.getText().toString());
		wUser.setEmail(email.getText().toString());
		
		if (rcEmail.isChecked()){
			wUser.setReceberEmail("S");
		}

		wUser.setTelefoneResidencial(Integer.parseInt(telRes.getText().toString()));
		wUser.setTelefoneCelular((Integer.parseInt(telRes.getText().toString())));
		wUser.setTelefoneRecado(Integer.parseInt(telRes.getText().toString()));
		wUser.setCep(cep.getText().toString());
		wUser.setTipo(tp.getText().toString());
		wUser.setLogradouro(lg.getText().toString());
		wUser.setComplemento(comp.getText().toString());
		wUser.setBairro(br.getText().toString());
		wUser.setInformacoesAdicionais(info.getText().toString());
		wUser.setCidade(cid.getText().toString());
		wUser.setEstado(est.getText().toString());
		
		perfilMergeService = (PerfilMergeService) new PerfilMergeService(PerfilPersonalizadoActivity.this, wUser, conteudo).execute();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conteudo = perfilMergeService.getUsuario();
		
		if("true".equals(conteudo)){			
			Toast.makeText(this, "Sua alterações foram salvas com sucesso!", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Não foi salvar suas alterações!", Toast.LENGTH_LONG).show();
		}
    }
    
    public void callCancelarPerfil (View v){
    	confirmarExclusao();
    }

    public AlertDialog confirmarExclusao() {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Cancelar");
    	builder.setMessage("Deseja cancelar as alterações ?");
    	builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
							    		@Override
							    		public void onClick(DialogInterface dialog, int which) {
							    			goToActivity(PerfilActivity.class);
							    		}
    								}
    							 );
    	builder.setNegativeButton("Não", null);
    	
    	return builder.create();
    }
    
}
