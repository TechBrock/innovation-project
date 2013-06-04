package com.example.bikeapplogin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ItemActivity extends Activity{
	
	//private  ItensExtra;
	private WebItem Item;
	private capturaImagens cap;
	private int idUsuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);
		
		Intent ItensExtra= getIntent();
		Item = (WebItem) ItensExtra.getSerializableExtra("Item");
		Bundle extras = getIntent().getExtras();
		idUsuario = extras.getInt("id_usuario");
		
		ImageView img = (ImageView) findViewById(R.id.btPopBike);
		Bitmap bm = Bitmap.createBitmap(cap.getImage(ItemActivity.this, Item.getCaminhoImg1()).getDrawingCache());
		
		EditText nome = (EditText) findViewById(R.id.lblNomeBike);
		EditText classificacao = (EditText) findViewById(R.id.vClassificacao);
		EditText tipo = (EditText) findViewById(R.id.vTipo);
		EditText caracteristica = (EditText) findViewById(R.id.vCaracteristica);
		EditText tamanho = (EditText) findViewById(R.id.vTamanho);
		EditText dimenssao = (EditText) findViewById(R.id.vDimensao);
		EditText peso = (EditText) findViewById(R.id.vPeso);
		EditText aro = (EditText) findViewById(R.id.vAro);
		EditText adicionais = (EditText) findViewById(R.id.vAdicionais);
		EditText material = (EditText) findViewById(R.id.vMaterial);
		EditText garantia = (EditText) findViewById(R.id.vGarantia);
		
		
		img.setImageBitmap(bm);
		
		nome.setText(Item.getNome());
		classificacao.setText(Item.getClassificacao());
		tipo.setText(Item.getTipoItem());
		caracteristica.setText(Item.getCaracteristica());
		tamanho.setText(Item.getTamanho());
		dimenssao.setText(Item.getDimensao());
		peso.setText(Item.getPeso());
		aro.setText(Item.getAro());
		adicionais.setText(Item.getInformacoesAdicionais());
		material.setText(Item.getMaterial());
		garantia.setText(Item.getGarantia());
		
	}
	
	@SuppressWarnings("unused")
	private void tornaBikeFavorita(View v){
		Intent newActivity = new Intent(this, ItemFavoritoService.class);
        newActivity.putExtra("id_usuario", idUsuario);
        newActivity.putExtra("id_modelo", Item.getId());
        startActivity(newActivity);
	}
	
	public void callImg (View v){
		Intent newActivity = new Intent(this, ImagensActivity.class);
        newActivity.putExtra("caminho1", Item.getCaminhoImg1());
        newActivity.putExtra("caminho2", Item.getCaminhoImg2());
        newActivity.putExtra("caminho3", Item.getCaminhoImg3());
        newActivity.putExtra("caminho4", Item.getCaminhoImg4());
        startActivity(newActivity);
	}
}
