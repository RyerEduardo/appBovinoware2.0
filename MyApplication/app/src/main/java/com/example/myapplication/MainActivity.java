package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;



import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt, bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt = (Button) findViewById(R.id.btnCompras);
        bt1 = (Button) findViewById(R.id.btnVendas);
        bt.setOnClickListener(this);
        bt1.setOnClickListener(this);

    }

    //public void goVendas(View view){
      //  Intent it = new Intent(MainActivity.this, CadastrarVenda.class);
        //startActivity(it);
    //}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCompras:
                Intent it = new Intent(MainActivity.this, MainCompras.class);
                startActivity(it);
                break;
            case R.id.btnVendas:
                Intent it1 = new Intent(MainActivity.this, MainVendas.class);
                startActivity(it1);
                break;

        }
    }



}
