package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;


public class ActivityCarta extends ActionBarActivity implements View.OnClickListener {
    private TableLayout table_layout;

    private ImageButton home;
    private ImageButton foto;
    private ImageButton carta;
    private Button buttonCarta;
    private int request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        home = (ImageButton) findViewById(R.id.imageView2);
        home.setOnClickListener(this);
        foto = (ImageButton) findViewById(R.id.imageView3);
        foto.setOnClickListener(this);
        carta = (ImageButton) findViewById(R.id.imageView4);
        carta.setOnClickListener(this);

        //Imagenes a Insertar
        Integer[] image = { R.drawable.plato1_brasserie, R.drawable.plato2_brasserie, R.drawable.plato3_brasserie,R.drawable.plato4_brasserie,R.drawable.plato5_brasserie,
                R.drawable.plato6_brasserie,R.drawable.plato7_brasserie,R.drawable.plato8_brasserie, R.drawable.plato9__brasserie,R.drawable.plato10_brasserie,R.drawable.plato11_brasserie};

        table_layout = (TableLayout) findViewById(R.id.TablaCarta);
        for (int i = 0; i<image.length; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(1, 1, 1, 1);
            ImageView plato = new ImageView(this);
            plato.setImageResource(image[i]);
            plato.setLayoutParams(layoutParams);
            row.addView(plato);
            table_layout.addView(row);
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
        switch (v.getId()){
            case R.id.imageView2:
                Intent intent1 = new Intent(ActivityCarta.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.imageView3:
                Intent intent2 = new Intent(ActivityCarta.this, ActivityGaleriaFotos.class);
                startActivityForResult(intent2, request);
                break;
            case R.id.imageView4:
                Intent intent3 = new Intent(ActivityCarta.this, ActivityPresentation.class);
                startActivityForResult(intent3, request);
                break;
        }
    }

}
