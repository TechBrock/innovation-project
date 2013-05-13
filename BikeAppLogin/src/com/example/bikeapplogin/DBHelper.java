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
		db.execSQL("CREATE TABLE LOGIN (ID INTEGER PRIMARY KEY, USUARIO TEXT, SENHA TEXT, IDUSUARIO INTEGER);");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
