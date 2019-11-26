package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.conexao.Conexao;
import com.example.myapplication.model.Compra;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class MainCompras extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView compras;
    Conexao con = null;
    List<Compra> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_compras);


        compras = (ListView)findViewById(R.id.listaCompras);

        compras.setOnItemClickListener(this);

        ImageButton fab = findViewById(R.id.btnNovaCompra);
        fab.setOnClickListener(this);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent it = new Intent(MainActivity.this, CadastroBovinos.class);
                startActivity(it);
            }
        });*/
    }

    public void cadastrar(View view){
        Intent it = new Intent(MainCompras.this, CadastrarCompra.class);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        con = new Conexao(this);
        lista = con.getCompras();

        ArrayAdapter<Compra> adp = new ArrayAdapter<Compra>(this,android.R.layout.simple_list_item_1,lista);
        compras.setAdapter(adp);

    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this,CadastrarCompra.class);
        startActivity(it);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int posicao = (int)compras.getItemIdAtPosition(position);
        int pegaid = lista.get(posicao).getId();
        Intent it = new Intent(this, AlterarCompra.class);
        it.putExtra("meuid",pegaid);
        startActivity(it);
    }
}
