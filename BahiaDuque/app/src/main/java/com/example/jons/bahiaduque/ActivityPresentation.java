package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ImageButton;


public class ActivityPresentation extends ActionBarActivity implements View.OnClickListener {

    private ImageButton home;
    private ImageButton foto;
    private ImageButton carta;
    private int request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
        home = (ImageButton) findViewById(R.id.imageView2);
        home.setOnClickListener(this);
        foto = (ImageButton) findViewById(R.id.imageView3);
        foto.setOnClickListener(this);
        carta = (ImageButton) findViewById(R.id.imageView4);
        carta.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView2:
                Intent intent1 = new Intent(ActivityPresentation.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.imageView3:
                Intent intent2 = new Intent(ActivityPresentation.this, ActivityGaleriaFotos.class);
                startActivityForResult(intent2, request);
                break;
        }
    }
}
