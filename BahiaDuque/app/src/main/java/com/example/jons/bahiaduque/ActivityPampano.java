package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivityPampano extends ActionBarActivity implements View.OnClickListener {
    private ImageButton home;
    private ImageButton galeria;
    private ImageButton barco;
    private ImageButton mapa;
    private ImageButton tmp1;
    private ImageButton tmp2;
    private ImageButton tmp3;
    private ImageButton tmp4;
    private ImageButton tmp5;
    private ImageButton tmp6;
    private ImageButton tmp7;
    private ImageButton tmp8;
    private ImageButton tmp9;
    private ImageButton tmp10;
    private ImageButton tmp11;
    private ImageButton tmp12;
    private ImageButton tmp13;
    private ImageButton tmp14;
    private ImageButton tmp15;
    private ImageView imagen;
    private ImageButton desplazar;
    private int request;

    private HorizontalScrollView sv;
    private LinearLayout ly;

    private int des = 820; //Variable para controlar el desplazamiento


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_pampano);
        hideVirtualButtons();

        //Botones baner
        home = (ImageButton) findViewById(R.id.homeBoton);
        home.setOnClickListener(this);

        galeria = (ImageButton) findViewById(R.id.galeriaBoton);
        galeria.setOnClickListener(this);

        barco = (ImageButton) findViewById(R.id.barcoBoton);
        barco.setOnClickListener(this);

        mapa = (ImageButton) findViewById(R.id.mapaBoton);
        mapa.setOnClickListener(this);

        //Botones galería

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
        tmp13 = (ImageButton) findViewById(R.id.imageButton14);
        tmp13.setOnClickListener(this);
        tmp14 = (ImageButton) findViewById(R.id.imageButton15);
        tmp14.setOnClickListener(this);
        tmp15 = (ImageButton) findViewById(R.id.imageButton16);
        tmp15.setOnClickListener(this);

        imagen = (ImageView) findViewById(R.id.imagen1);

        desplazar = (ImageButton) findViewById(R.id.boton_derecha);
        desplazar.setOnClickListener(this);
        sv = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);

        ly = (LinearLayout) findViewById(R.id.layoutscroll);


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

    //Mal hecho
    public boolean onGenericMotionEvent(MotionEvent event) {
        if (event.isFromSource(InputDevice.SOURCE_CLASS_POINTER)) {
            if (event.getAction() == MotionEvent.ACTION_HOVER_MOVE) {
                Log.i("ACTIVIDAD", String.valueOf(ly.getChildCount()*205));
                Log.i("ACTIVIDAD", String.valueOf(sv.getScrollX()));
                if (sv.getScrollX() >= 2140 ) {
                    desplazar.setBackgroundResource(R.drawable.boton_izquierda2);
                }
                return true;
            }
        }
        return super.onGenericMotionEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //Botones baner

            case R.id.homeBoton:
                Intent intent1 = new Intent(ActivityPampano.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.galeriaBoton:
                Intent intent2 = new Intent(ActivityPampano.this, ActivityPampano.class);
                startActivityForResult(intent2, request);
                break;
            case R.id.barcoBoton:
                Intent intent4 = new Intent(ActivityPampano.this, ActivityYate.class);
                startActivityForResult(intent4, request);
                break;
            case R.id.mapaBoton:
                Intent intent5 = new Intent(ActivityPampano.this, ActivityTravesia.class);
                startActivityForResult(intent5, request);
                break;
            //Botones galería


            case R.id.imageButton1:
                imagen.setImageResource(R.drawable.galeria_pampano_3);
                break;
            case R.id.imageButton2:
                imagen.setImageResource(R.drawable.galeria_pampano_4);
                break;
            case R.id.imageButton3:
                imagen.setImageResource(R.drawable.galeria_pampano_5);
                break;
            case R.id.imageButton4:
                imagen.setImageResource(R.drawable.galeria_pampano_6);
                break;
            case R.id.imageButton5:
                imagen.setImageResource(R.drawable.galeria_pampano_7);
                break;
            case R.id.imageButton6:
                imagen.setImageResource(R.drawable.galeria_pampano_8);
                break;
            case R.id.imageButton7:
                imagen.setImageResource(R.drawable.galeria_pampano_9);
                break;
            case R.id.imageButton8:
                imagen.setImageResource(R.drawable.galeria_pampano_10);
                break;
            case R.id.imageButton9:
                imagen.setImageResource(R.drawable.galeria_pampano_11);
                break;
            case R.id.imageButton10:
                imagen.setImageResource(R.drawable.galeria_pampano_12);
                break;
            case R.id.imageButton11:
                imagen.setImageResource(R.drawable.galeria_pampano_13);
                break;
            case R.id.imageButton12:
                imagen.setImageResource(R.drawable.galeria_pampano_14);
                break;
            case R.id.imageButton14:
                imagen.setImageResource(R.drawable.galeria_pampano_15);
                break;
            case R.id.imageButton15:
                imagen.setImageResource(R.drawable.galeria_pampano_16);
                break;
            case R.id.imageButton16:
                imagen.setImageResource(R.drawable.galeria_pampano_17);
                break;
            case R.id.boton_derecha:
                Log.i("ACTIVIDAD", String.valueOf(sv.getScrollX()));
                if ((des >= ly.getChildCount()*205)){
                    des=0;
                    desplazar.setBackgroundResource(R.drawable.boton_derecha2);
                }
                sv.smoothScrollTo(des, 0);
                des=des+820;
                if (des >= ly.getChildCount()*205){
                    desplazar.setBackgroundResource(R.drawable.boton_izquierda2);
                }
                break;
        }
    }
}

