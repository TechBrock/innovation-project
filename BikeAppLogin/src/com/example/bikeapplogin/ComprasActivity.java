package com.example.bikeapplogin;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ComprasActivity extends Activity{

	private ArrayList<WebCompra> wCompras;
	public CompraListAdapter pdAdapter;
	public TextView nPedido;
	
	//public ArrayList<String> ordemCompra,dataEfetuado,itens,quantidade,valor,valorFrete,tipoFrete,meioPagamento,quantidadeParcelas,prazo,dataEntregue;
	private DBHelper db;
	private int idUsuario;
	
	public ComprasActivity (){
		// TODO Auto-generated constructor stub
		wCompras = new ArrayList<WebCompra>();
		
		for (WebCompra webCompra : wCompras) {
			wCompras.add(webCompra);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compras);
		
		Bundle extras = getIntent().getExtras();
		idUsuario = extras.getInt("id_usuario");
		
		ListView listaPedidos = (ListView) findViewById(R.id.listaPedidos);
		this.pdAdapter = new CompraListAdapter(this, R.layout.listacompras, wCompras);	
		listaPedidos.setAdapter(this.pdAdapter);
	}
	
	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
	
	private void goToActivityIdUsuarioItem(Class<? extends Activity> activityClass, int idUsuario) {
		Intent newActivity = new Intent(this, activityClass);
        newActivity.putExtra("id_usuario", idUsuario);
        startActivity(newActivity);
    }
    
    public void callPerfil (View v){
    	goToActivity(PerfilActivity.class);
    } 
    
    public void callOfertas (View v){
    	goToActivity(ItensActivity.class);
    } 
   
    public void callFavoritos (View v){
    	goToActivityIdUsuarioItem(FavoritoActivity.class, idUsuario);
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
        		goToActivity(PerfilActivity.class);
        	}
        }catch(Exception ex){
        	Toast.makeText(this, "Campo Usuário ou senha em branco !", Toast.LENGTH_SHORT).show();
        }finally{
        	crs.close();
        }
    	
    	goToActivity(MainActivity.class);
    }
    
    public class CompraListAdapter extends ArrayAdapter<String>{
		
		private ArrayList<WebCompra> lstCompra;
		private WebCompra compra;
		private String conteudo = null;
		private CompraService compraService;

		public CompraListAdapter(Context context, int textViewResourceId, ArrayList<WebCompra> wCompras) {
			super(context, textViewResourceId, wCompras.toArray().length);
			// TODO Auto-generated constructor stub
			this.lstCompra = wCompras;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
			compra = lstCompra.get(position);
			View listaView = convertView;
			
			compraService = (CompraService) new CompraService(ComprasActivity.this, idUsuario, conteudo, compra).execute();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			compra = compraService.getCompra();
			
			if(listaView == null)
			{
				LayoutInflater lif = getLayoutInflater();
				listaView = lif.inflate(R.layout.listacompras, null);
			}
			
			TextView orCompra = (TextView) listaView.findViewById(R.id.numeroPedido);
			TextView dtEfetuado = (TextView) listaView.findViewById(R.id.vDataPedido);
			TextView item = (TextView) listaView.findViewById(R.id.vItensPedido);
			TextView qtd = (TextView) listaView.findViewById(R.id.vQtdItenPedido);
			TextView vl = (TextView) listaView.findViewById(R.id.vValorCompra);
			TextView vlFrete = (TextView) listaView.findViewById(R.id.vValorFrete);
			TextView tpfrete = (TextView) listaView.findViewById(R.id.vTipoFrete);
			TextView mPag = (TextView) listaView.findViewById(R.id.vMeioPagamento);
			TextView qtdPar = (TextView) listaView.findViewById(R.id.vQtdParcelas);
			TextView pz = (TextView) listaView.findViewById(R.id.vPrazo);
			TextView etg = (TextView) listaView.findViewById(R.id.vDataEntrega);
			
			orCompra.setText(compra.getId());
			dtEfetuado.setText(compra.getDataPedido());
			item.setText(compra.getItens());
			qtd.setText(compra.getQuantidade());
			vl.setText(compra.getValorCompra());
			vlFrete.setText(compra.getValorFrete());
			tpfrete.setText(compra.getTipoFrete());
			mPag.setText(compra.getMeioPagamento());
			qtdPar.setText(compra.getQtdParcelas());
			pz.setText(compra.getPrazo());
			etg.setText(compra.getDataEntrega());

			
			return listaView;	
				
		}
	}
	
}
