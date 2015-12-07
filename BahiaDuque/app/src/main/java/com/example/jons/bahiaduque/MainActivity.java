package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private  ImageButton botonBrassrie;
    private  ImageButton botonTrattoria;
    private  ImageButton botonAguas;
    private  ImageButton botonAsia;
    private ImageButton idiomas;
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonBrassrie = (ImageButton)findViewById(R.id.imageButton);
        botonTrattoria = (ImageButton)findViewById(R.id.imageButton2);
        botonAguas = (ImageButton)findViewById(R.id.imageButton3);
        botonAsia = (ImageButton)findViewById(R.id.imageButton4);
        idiomas = (ImageButton)findViewById(R.id.imageButton5);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        //Evento Click de los Botones de imagenes
        botonBrassrie.setOnClickListener(this);
        botonTrattoria.setOnClickListener(this);
        botonAguas.setOnClickListener(this);
        botonAsia.setOnClickListener(this);
        idiomas.setOnClickListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);


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
    public void onResume() {
        super.onResume();
        hideVirtualButtons();
    }
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.imageButton:
                botonBrassrie.setImageResource(R.drawable.boton_brasserie_transparency);
                intent = new Intent(MainActivity.this, ActivityGaleriaFotos.class);
                startActivity(intent);
                break;
            case R.id.imageButton2:
                botonTrattoria.setImageResource(R.drawable.boton_trattoria_transparency);
                break;
            case R.id.imageButton3:
                botonAguas.setImageResource(R.drawable.boton_aguas_transparency);
                break;
            case R.id.imageButton4:
                botonAsia.setImageResource(R.drawable.boton_asia_transparency);
                break;
            case R.id.imageButton5:
                intent = new Intent(MainActivity.this, SplashScreen.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(MainActivity.this, ActivityMainPampano.class);
                startActivity(intent);
                break;
        }
    }
}
