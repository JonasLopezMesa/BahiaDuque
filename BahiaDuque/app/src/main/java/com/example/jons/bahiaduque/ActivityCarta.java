package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

import pl.polidea.view.ZoomView;


public class ActivityCarta extends ActionBarActivity implements View.OnClickListener {
    private TableLayout table_layout;
    private ZoomView zoomView;
    private ImageButton home;
    private ImageButton foto;
    private ImageButton carta;
    private ImageButton chef;
    private int request;
    private Button entrantes;
    private Button pescados_y_carnes;
    private Button especialidades;
    private Button postres;

    private ScrollView sv;
    private HorizontalScrollView svhorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_scrolling);

        home = (ImageButton) findViewById(R.id.boton_home);
        home.setOnClickListener(this);
        foto = (ImageButton) findViewById(R.id.boton_galeria);
        foto.setOnClickListener(this);
        carta = (ImageButton) findViewById(R.id.boton_carta);
        carta.setOnClickListener(this);
        chef = (ImageButton) findViewById(R.id.boto_chef);
        chef.setOnClickListener(this);

        entrantes = (Button) findViewById(R.id.entrantes);
        entrantes.setOnClickListener(this);
        pescados_y_carnes = (Button) findViewById(R.id.pescados_y_carnes);
        pescados_y_carnes.setOnClickListener(this);
        especialidades = (Button) findViewById(R.id.especialidades);
        especialidades.setOnClickListener(this);
        postres = (Button) findViewById(R.id.postres);
        postres.setOnClickListener(this);
        sv = (ScrollView) findViewById(R.id.scrollvertical);

        table_layout = new TableLayout(this);
        zoomView = new ZoomView(this);
        svhorizontal = new HorizontalScrollView(this);


        //Imagenes a Insertar
        Integer[] image = { R.drawable.carta1, R.drawable.carta2, R.drawable.carta3,R.drawable.carta4};

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
        svhorizontal.addView(table_layout);
        zoomView.addView(svhorizontal);
        sv.addView(zoomView);
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

    public boolean onGenericMotionEvent(MotionEvent event) {
        if (event.isFromSource(InputDevice.SOURCE_CLASS_POINTER)) {
            if((event.getAction() == MotionEvent.ACTION_UP) && (event.getAction() == MotionEvent.ACTION_UP)){
                //para hacer zoom?
            }
            if (event.getAction() == MotionEvent.ACTION_HOVER_MOVE) {
                if (sv.getScrollY() < 975) {
                    entrantes.setBackgroundResource(R.drawable.style_boton_pulsado);
                    pescados_y_carnes.setBackgroundResource(R.drawable.style_boton);
                    especialidades.setBackgroundResource(R.drawable.style_boton);
                    postres.setBackgroundResource(R.drawable.style_boton);
                }
                if ((sv.getScrollY() >= 975) && (sv.getScrollY() < 1823)) {
                    entrantes.setBackgroundResource(R.drawable.style_boton);
                    pescados_y_carnes.setBackgroundResource(R.drawable.style_boton_pulsado);
                    especialidades.setBackgroundResource(R.drawable.style_boton);
                    postres.setBackgroundResource(R.drawable.style_boton);
                }
                if ((sv.getScrollY() >= 1823) && (sv.getScrollY() < 2392)) {
                    entrantes.setBackgroundResource(R.drawable.style_boton);
                    pescados_y_carnes.setBackgroundResource(R.drawable.style_boton);
                    especialidades.setBackgroundResource(R.drawable.style_boton_pulsado);
                    postres.setBackgroundResource(R.drawable.style_boton);
                }
                if (sv.getScrollY() >= 2392) {
                    entrantes.setBackgroundResource(R.drawable.style_boton);
                    pescados_y_carnes.setBackgroundResource(R.drawable.style_boton);
                    especialidades.setBackgroundResource(R.drawable.style_boton);
                    postres.setBackgroundResource(R.drawable.style_boton_pulsado);
                }
                return true;
            }
        }
        return super.onGenericMotionEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_home:
                Intent intent1 = new Intent(ActivityCarta.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
            case R.id.boton_galeria:
                Intent intent2 = new Intent(ActivityCarta.this, ActivityGaleriaFotos.class);
                startActivityForResult(intent2, request);
                break;
            case R.id.boto_chef:
                Intent intent3 = new Intent(ActivityCarta.this, ActivityPresentation.class);
                startActivityForResult(intent3, request);
                break;

            case R.id.entrantes:
                sv.smoothScrollTo(0, 0);
                entrantes.setBackgroundResource(R.drawable.style_boton_pulsado);
                pescados_y_carnes.setBackgroundResource(R.drawable.style_boton);
                especialidades.setBackgroundResource(R.drawable.style_boton);
                postres.setBackgroundResource(R.drawable.style_boton);
                break;
            case R.id.pescados_y_carnes:
                sv.smoothScrollTo(0, 975);
                entrantes.setBackgroundResource(R.drawable.style_boton);
                pescados_y_carnes.setBackgroundResource(R.drawable.style_boton_pulsado);
                especialidades.setBackgroundResource(R.drawable.style_boton);
                postres.setBackgroundResource(R.drawable.style_boton);
                break;
            case R.id.especialidades:
                sv.smoothScrollTo(0, 1823);
                entrantes.setBackgroundResource(R.drawable.style_boton);
                pescados_y_carnes.setBackgroundResource(R.drawable.style_boton);
                especialidades.setBackgroundResource(R.drawable.style_boton_pulsado);
                postres.setBackgroundResource(R.drawable.style_boton);
                break;
            case R.id.postres:
                sv.smoothScrollTo(0, 2392);
                entrantes.setBackgroundResource(R.drawable.style_boton);
                pescados_y_carnes.setBackgroundResource(R.drawable.style_boton);
                especialidades.setBackgroundResource(R.drawable.style_boton);
                postres.setBackgroundResource(R.drawable.style_boton_pulsado);
                break;
        }
    }

}
