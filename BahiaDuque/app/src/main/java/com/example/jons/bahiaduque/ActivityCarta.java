package com.example.jons.bahiaduque;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;


public class ActivityCarta extends ActionBarActivity {
    private TableLayout table_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Integer[] image = { R.drawable.plato1, R.drawable.plato2, R.drawable.p2_1,R.drawable.p2_2,R.drawable.p2_3,R.drawable.p3_1,R.drawable.p3_2,R.drawable.p3_3,
                R.drawable.p4_1,R.drawable.p4_2,R.drawable.p4_3,};

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
}
