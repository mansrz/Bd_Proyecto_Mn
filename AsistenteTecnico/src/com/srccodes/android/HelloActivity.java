package com.srccodes.android;

import com.greenDao.esquema.DaoMaster;
import com.greenDao.esquema.DaoSession;
import com.greenDao.esquema.JugadorDao;
import com.greenDao.esquema.DaoMaster.DevOpenHelper;

import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;


public class HelloActivity extends Activity {
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private JugadorDao JugadorDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        try {
        	 
        	 //String path, int openFlags, CursorFactory cursorFactory,DatabaseErrorHandler errorHandler)
        	 
        	 DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
             db = helper.getWritableDatabase();
             daoMaster = new DaoMaster(db);
             daoSession = daoMaster.newSession();
       //      noteDao = daoSession.getNoteDao();
        	 Log.i("Alerta", db.getPath());
        	 //openHelper.onCreate(db);
    		 //openHelper.onConfigure(db);
    		 //daoMaster = new DaoMaster(db);
    		 //daoSession = daoMaster.newSession();
        	 
		} catch (Exception e) {
			// TODO: handle exception
			Log.i("Alerta","Valio tro");
		}
    	    }
    public void Start(View view) {
        // Do something in response to button
    	setContentView(R.layout.menu);
    }
    public void equipo(View view) {
        // Do something in response to button
    	setContentView(R.layout.equipo);
    }
    public void crearj(View view) {
        // Do something in response to button
    	Intent act = new Intent(this, IngresarJugador.class);    	 
    	 startActivity(act);
    }
    public void entrenamiento(View view) {
        // Do something in response to button
    	setContentView(R.layout.entrenamientos);
    }
    public void formacion(View view) {
        // Do something in response to button
    	setContentView(R.layout.formacion);
    }
    public void configuracion(View view) {
        // Do something in response to button
    	setContentView(R.layout.configuracion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_hello, menu);
        return true;
    }    
    
    public boolean onResum(){
    	
    	setContentView(R.layout.menu);
		return false;
    	
    	
    }
    
    
}
