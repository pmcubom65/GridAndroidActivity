package com.barajas.gridlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.os.Build;
import android.widget.Toast;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;





public class MainActivity extends AppCompatActivity {
    androidx.gridlayout.widget.GridLayout migrid;
    Button b;
    LinkedHashMap<Integer, Button> mapa = new LinkedHashMap<Integer, Button>();
    Button cambiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anadirHijos();
    Intent recibo=getIntent();
    String login=recibo.getStringExtra("user_login");
   String mail= recibo.getStringExtra("user_email");
    Toast.makeText(MainActivity.this, login+mail, Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mimenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        Toast.makeText(MainActivity.this, "ejemplo", Toast.LENGTH_LONG).show();



        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void anadirHijos() {
        migrid = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.migrid);
        migrid.setPadding(30, 20, 20, 10);
        for (int i = 0; i < 18; i++) {
            RelativeLayout.LayoutParams rules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            b = new Button(this);
            if (i == 17) {
                b.setText("RESET");
            } else {
                b.setText("Botón " + i);
            }


            b.setTextColor(Color.WHITE);

            b.setBackgroundColor(Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));


            b.setId(i);
            b.setLayoutParams(rules);
            migrid.addView(b, i);

        }

        for (int i = 0; i < migrid.getChildCount(); i++) {
            View v = migrid.getChildAt(i);
            if (i != 17) {
                final int r=i;

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mapa.put(r, (Button) v);
                        v.setBackgroundColor(Color.WHITE);


                    }
                });
            } else {
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        recorrergrid();


                    }
                });
            }

        }

cambiar=(Button) findViewById(R.id.botonactividad);
        cambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }

    public void recorrergrid() {
       migrid.removeAllViews();
       anadirHijos();
    }
}