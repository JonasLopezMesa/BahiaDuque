package com.example.jons.bahiaduque;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class SplashScreen extends ActionBarActivity implements View.OnClickListener {

    private ImageButton spanish;
    private ImageButton france;
    private ImageButton germany;
    private ImageButton italy;
    private int request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        spanish = (ImageButton) findViewById(R.id.imageButton14);
        spanish.setOnClickListener(this);


        Toast toast = Toast.makeText(getApplicationContext(), "Selecciona un idioma",
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 120);
        toast.show();
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
        View backgroundimage = findViewById(R.id.imageButton14);
        Drawable background = backgroundimage.getBackground();
        background.setAlpha(255);
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
            case R.id.imageButton14:
                spanish.setAlpha(80);
                View backgroundimage = findViewById(R.id.imageButton14);
                Drawable background = backgroundimage.getBackground();
                background.setAlpha(128);
                Intent intent1 = new Intent(SplashScreen.this, MainActivity.class);
                startActivityForResult(intent1, request);
                break;
        }
    }
}
