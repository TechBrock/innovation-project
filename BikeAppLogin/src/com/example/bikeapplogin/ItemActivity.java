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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);
		
		Intent ItensExtra= getIntent();
		Item = (WebItem) ItensExtra.getSerializableExtra("Item");
		
		//(ImageView) imgBike = (ImageView);// cap.getImage(this.getContext(), imgs.get(position));
		
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
	
	private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
	
	public void callImg (View v){
		goToActivity(ImagensActivity.class);
	}
}
