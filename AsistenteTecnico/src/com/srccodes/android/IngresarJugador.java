package com.srccodes.android;

import com.greenDao.esquema.DaoMaster;
import com.greenDao.esquema.DaoMaster.DevOpenHelper;
import com.greenDao.esquema.DaoSession;
import com.greenDao.esquema.Jugador;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.greenDao.esquema.JugadorDao;
public class IngresarJugador extends Activity {
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;
	private JugadorDao JugadorDao;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingresar_jugador);
		DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "Jugador", null);
		 db = openHelper.getWritableDatabase();
		 daoMaster = new DaoMaster(db);
		 daoSession = daoMaster.newSession();
		 JugadorDao = daoSession.getJugadorDao();
		 
		 
	}
	
	protected void guardar_jugador(){
		JugadorDao.insert(new Jugador(JugadorDao.count(),getString(R.id.txt_nombreJugador),getString(R.id.txt_apellidojugador),getString(R.id.txt_direccionjugador)));
		
	}
	
}
