package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class ActivityMapa extends ActionBarActivity implements View.OnClickListener{

    private ImageButton home;
    private ImageButton galeria;
    private ImageButton barco;
    private ImageButton mapa;
    private ImageButton boton_snorkel;
    private int request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_mapa);
        hideVirtualButtons();

        home = (ImageButton) findViewById(R.id.homeBoton);
        home.setOnClickListener(this);

        galeria = (ImageButton) findViewById(R.id.galeriaBoton);
        galeria.setOnClickListener(this);

        barco = (ImageButton) findViewById(R.id.barcoBoton);
        barco.setOnClickListener(this);

        mapa = (ImageButton) findViewById(R.id.mapaBoton);
        mapa.setOnClickListener(this);

        boton_snorkel = (ImageButton) findViewById(R.id.boton_snorkel);
        boton_snorkel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeBoton:
                Intent intent1 = new Intent(ActivityMapa.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.galeriaBoton:
                Intent intent2 = new Intent(ActivityMapa.this, ActivityPampano.class);
                startActivityForResult(intent2, request);
                break;
            case R.id.barcoBoton:
                Intent intent4 = new Intent(ActivityMapa.this, ActivityYate.class);
                startActivityForResult(intent4, request);
                break;
            case R.id.mapaBoton:
                Intent intent5 = new Intent(ActivityMapa.this, ActivityTravesia.class);
                startActivityForResult(intent5, request);
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
