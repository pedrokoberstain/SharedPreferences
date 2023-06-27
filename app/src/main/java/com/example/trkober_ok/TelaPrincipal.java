package com.example.trkober_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TelaPrincipal extends AppCompatActivity {

    private Button bt_cadastro;
    private Button bt_disponiveis;
    private Button bt_notafiscal;
    ImageView home;
    ImageView circulo;
    ImageView mais;
    ImageView mensagem;
    ImageView usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        getSupportActionBar().hide();

        home = findViewById(R.id.tabbar);
        circulo = findViewById(R.id.tabbar1);
        mais = findViewById(R.id.tabbar2);
        mensagem = findViewById(R.id.tabbar3);
        usuario = findViewById(R.id.tabbar4);
        bt_cadastro = findViewById(R.id.bt_transp);
        bt_disponiveis = findViewById(R.id.bt_cliente);
        bt_notafiscal = findViewById(R.id.notafiscal);

        bt_notafiscal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotaFiscal.class);
                startActivity(intent);
            }
        });
        bt_disponiveis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Disponiveis.class);
                startActivity(intent);
            }
        });

        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CadastroFretes.class);
                startActivity(intent);
            }
        });

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