package com.example.trkober_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Disponiveis extends AppCompatActivity {

    ImageView home;
    ImageView circulo;
    ImageView mais;
    ImageView mensagem;
    ImageView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponiveis);
        getSupportActionBar().hide();

        home = findViewById(R.id.tabbar);
        circulo = findViewById(R.id.tabbar1);
        mais = findViewById(R.id.tabbar2);
        mensagem = findViewById(R.id.tabbar3);
        usuario = findViewById(R.id.tabbar4);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);
                startActivity(intent);
            }
        });

        circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Disponiveis.class);
                startActivity(intent);
            }
        });
        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastroFretes.class);
                startActivity(intent);
            }
        });
        mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mensagens.class);
                startActivity(intent);
            }
        });
        usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Usuario.class);
                startActivity(intent);
            }
        });
    }
}