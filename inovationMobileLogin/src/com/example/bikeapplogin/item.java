package com.example.bikeapplogin;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class item extends Activity {
	
	private List<String> item;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itens);
		
		item = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		
		ListView listaDeItens = (ListView) findViewById(R.id.listaItens);
	}	
	
	public void adicionaIten (){
	}
}
