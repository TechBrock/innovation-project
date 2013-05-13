package com.example.bikeapplogin;
import com.example.bikeapplogin.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class PerfilPersonalizadoActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.perfilpersonalizado);
	}
	
	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
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
    			//SQLiteDatabase db = helper.getWritableDatabase();
    			//String where [] = new String[]{tarefa};
    			//db.delete("tarefa", "descricao like ?", where);
    			//tarefas.remove(tarefa);
    			//adapter.notifyDataSetChanged();
    			goToActivity(PerfilActivity.class);
    		}
    	});
    	builder.setNegativeButton("Não", null);
    	
    	return builder.create();
    }
    
}
