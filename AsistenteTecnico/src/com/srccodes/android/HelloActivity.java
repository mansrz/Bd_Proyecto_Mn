package com.srccodes.android;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class HelloActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
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
    	setContentView(R.layout.jugador);
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
