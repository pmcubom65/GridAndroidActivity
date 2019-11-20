package com.barajas.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button b;
    EditText et1;
    EditText et2;
    EditText et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b=(Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1=(EditText) findViewById(R.id.editText) ;
                et2=(EditText) findViewById(R.id.editText2) ;
                et3=(EditText) findViewById(R.id.editText3) ;
                Intent i=new Intent(Main2Activity.this, MainActivity.class);
                i.putExtra("user_login", et1.getText().toString());
                i.putExtra("user_email", et3.getText().toString());
                startActivity(i);
            }
        });
    }
}
