package com.example.bikeapplogin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ItemActivity extends Activity{

	//private  ItensExtra;
	private WebItem Item;
	private CapturaImagens cap;
	private int idUsuario;
	private ItemFavoritoService itfavservice;
	private String conteudo = null;
	private ConnectionNetwork conn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);

		Intent ItensExtra= getIntent();
		Item = (WebItem) ItensExtra.getSerializableExtra("Item");
		idUsuario = ItensExtra.getExtras().getInt("id_usuario");

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

		if(conn.checkConnect()){
			itfavservice = (ItemFavoritoService) new ItemFavoritoService(ItemActivity.this, idUsuario, Item.getId(), conteudo).execute();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			favorito(conteudo = itfavservice.getFavorito());
		}else{
			Toast.makeText(this, R.drawable.wifi, Toast.LENGTH_LONG).show();
		}
	}

	public void callImg (View v){
		Intent newActivity = new Intent(this, ImagensActivity.class);
		newActivity.putExtra("caminho1", Item.getCaminhoImg1());
		newActivity.putExtra("caminho2", Item.getCaminhoImg2());
		newActivity.putExtra("caminho3", Item.getCaminhoImg3());
		newActivity.putExtra("caminho4", Item.getCaminhoImg4());
		startActivity(newActivity);
	}

	@SuppressWarnings("unused")
	private void killBike (View v){
		Intent newActivity = new Intent(this, ItensActivity.class);
		startActivity(newActivity);
	}

	public void favorito (String fav){

		if("true".equals(fav)){
			ImageView estrela = (ImageView) findViewById(R.id.btPopBikeFavorito);
			Drawable dbImgItem = getResources().getDrawable(R.drawable.logoestrelainvertida);
			estrela.setImageDrawable(dbImgItem);

			Toast.makeText(this, "este item agora é favorito !", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Não foi possível tornar este item favorito !", Toast.LENGTH_LONG).show();
		}
	}
}
