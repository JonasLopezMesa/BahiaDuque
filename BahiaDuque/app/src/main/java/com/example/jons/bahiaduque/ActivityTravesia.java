package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class ActivityTravesia extends ActionBarActivity implements View.OnClickListener{

    private ImageButton home;
    private ImageButton galeria;
    private ImageButton barco;
    private ImageButton mapa;
    private ImageButton trav1;
    private ImageButton trav2;
    private ImageButton trav3;
    private ImageButton trav4;
    private ImageButton trav5;
    private int request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_travesia);

        home = (ImageButton) findViewById(R.id.homeBoton);
        home.setOnClickListener(this);

        galeria = (ImageButton) findViewById(R.id.galeriaBoton);
        galeria.setOnClickListener(this);

        barco = (ImageButton) findViewById(R.id.barcoBoton);
        barco.setOnClickListener(this);

        mapa = (ImageButton) findViewById(R.id.mapaBoton);
        mapa.setOnClickListener(this);

        trav1 =(ImageButton) findViewById(R.id.botonTravesia1);
        trav1.setOnClickListener(this);

        trav2 =(ImageButton) findViewById(R.id.botonTravesia2);
        trav2.setOnClickListener(this);

        trav3 =(ImageButton) findViewById(R.id.botonTravesia3);
        trav3.setOnClickListener(this);

        trav4 =(ImageButton) findViewById(R.id.botonTravesia4);
        trav4.setOnClickListener(this);

        trav5 =(ImageButton) findViewById(R.id.botonTravesia5);
        trav5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homeBoton:
                Intent intent1 = new Intent(ActivityTravesia.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.galeriaBoton:
                Intent intent2 = new Intent(ActivityTravesia.this, ActivityPampano.class);
                startActivityForResult(intent2, request);
                break;
            case R.id.barcoBoton:
                Intent intent4 = new Intent(ActivityTravesia.this, ActivityYate.class);
                startActivityForResult(intent4, request);
                break;
            case R.id.mapaBoton:
                Intent intent5 = new Intent(ActivityTravesia.this, ActivityTravesia.class);
                startActivityForResult(intent5, request);
                break;
            case R.id.botonTravesia1:
                Intent intent6 = new Intent(ActivityTravesia.this, ActivityMapa.class);
                startActivityForResult(intent6, request);
                break;
            case R.id.botonTravesia2:
                Intent intent7 = new Intent(ActivityTravesia.this, ActivityMapa.class);
                startActivityForResult(intent7, request);
                break;
            case R.id.botonTravesia3:
                Intent intent8 = new Intent(ActivityTravesia.this, ActivityMapa.class);
                startActivityForResult(intent8, request);
                break;
            case R.id.botonTravesia4:
                Intent intent9 = new Intent(ActivityTravesia.this, ActivityMapa.class);
                startActivityForResult(intent9, request);
                break;
            case R.id.botonTravesia5:
                Intent intent10 = new Intent(ActivityTravesia.this, ActivityMapa.class);
                startActivityForResult(intent10, request);
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // In KITKAT (4.4) and next releases, hide the virtual buttons
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                hideVirtualButtons();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        hideVirtualButtons();
    }

    @TargetApi(19)
    public void hideVirtualButtons() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
