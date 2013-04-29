package com.example.bikeapplogin;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	
	public DBHelper(Context cont) {
		// TODO Auto-generated constructor stub
		super(cont,"bikeAppLogin",null,1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE TAREFAS (ID INTEGER PRIMARY KEY, DESCRICAO TEXT);");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
