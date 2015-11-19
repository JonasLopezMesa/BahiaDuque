package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class activity_galeriafotos extends ActionBarActivity implements View.OnClickListener {

    ImageButton tmp1;
    ImageButton tmp2;
    ImageButton tmp3;
    ImageButton tmp4;
    ImageButton tmp5;
    ImageButton tmp6;
    ImageButton tmp7;
    ImageButton tmp8;
    ImageButton tmp9;
    ImageButton tmp10;
    ImageButton tmp11;
    ImageButton tmp12;
    ImageView imagen;

    ImageButton home;
    ImageButton foto;
    ImageButton carta;

    int request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_galeriafotos);

        tmp1 = (ImageButton) findViewById(R.id.imageButton1);
        tmp1.setOnClickListener(this);
        tmp2 = (ImageButton) findViewById(R.id.imageButton2);
        tmp2.setOnClickListener(this);
        tmp3 = (ImageButton) findViewById(R.id.imageButton3);
        tmp3.setOnClickListener(this);
        tmp4 = (ImageButton) findViewById(R.id.imageButton4);
        tmp4.setOnClickListener(this);
        tmp5 = (ImageButton) findViewById(R.id.imageButton5);
        tmp5.setOnClickListener(this);
        tmp6 = (ImageButton) findViewById(R.id.imageButton6);
        tmp6.setOnClickListener(this);
        tmp7 = (ImageButton) findViewById(R.id.imageButton7);
        tmp7.setOnClickListener(this);
        tmp8 = (ImageButton) findViewById(R.id.imageButton8);
        tmp8.setOnClickListener(this);
        tmp9 = (ImageButton) findViewById(R.id.imageButton9);
        tmp9.setOnClickListener(this);
        tmp10 = (ImageButton) findViewById(R.id.imageButton10);
        tmp10.setOnClickListener(this);
        tmp11 = (ImageButton) findViewById(R.id.imageButton11);
        tmp11.setOnClickListener(this);
        tmp12 = (ImageButton) findViewById(R.id.imageButton12);
        tmp12.setOnClickListener(this);
        imagen = (ImageView) findViewById(R.id.imagen1);

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
            case R.id.imageButton1:
                imagen.setImageResource(R.drawable.foto1);
            break;
            case R.id.imageButton2:
                imagen.setImageResource(R.drawable.foto2);
            break;
            case R.id.imageButton3:
                imagen.setImageResource(R.drawable.foto3);
            break;
            case R.id.imageButton4:
                imagen.setImageResource(R.drawable.foto1);
            break;
            case R.id.imageButton5:
                imagen.setImageResource(R.drawable.foto2);
            break;
            case R.id.imageButton6:
                imagen.setImageResource(R.drawable.foto3);
            break;
            case R.id.imageButton7:
                imagen.setImageResource(R.drawable.foto1);
            break;
            case R.id.imageButton8:
                imagen.setImageResource(R.drawable.foto2);
            break;
            case R.id.imageButton9:
                imagen.setImageResource(R.drawable.foto3);
            break;
            case R.id.imageButton10:
                imagen.setImageResource(R.drawable.foto1);
            break;
            case R.id.imageButton11:
                imagen.setImageResource(R.drawable.foto2);
            break;
            case R.id.imageButton12:
                imagen.setImageResource(R.drawable.foto3);
            break;
            case R.id.imageView2:
                Intent intent1 = new Intent(activity_galeriafotos.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.imageView3:
                Intent intent2 = new Intent(activity_galeriafotos.this, activity_galeriafotos.class);
                startActivityForResult(intent2, request);
                break;
            case R.id.imageView4:
                Intent intent3 = new Intent(activity_galeriafotos.this, ActivityPresentation.class);
                startActivityForResult(intent3, request);
                break;
        }
    }
}
