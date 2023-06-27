package com.example.trkober_ok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Disponiveis extends AppCompatActivity {

    private TextView tvTransp;
    private TextView tvCliente;
    private TextView tvRastre;
    private TextView tvCadastrarFretes;
    private FirebaseFirestore db;

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
        tvTransp = findViewById(R.id.tv_transp);
        tvCliente = findViewById(R.id.tv_cliente);
        tvRastre = findViewById(R.id.tv_rastre);
        tvCadastrarFretes = findViewById(R.id.tv_cadastrar_fretes);

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


        db = FirebaseFirestore.getInstance();

        // A chave aleatória usada para recuperar os dados do Firestore
        String chaveAleatoria = "EzQjCoJFDzNpif4Qj9ro";

        db.collection("cargas").document(chaveAleatoria).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                // Extrair os dados do documento e defini-los nos TextViews
                                String carregamento = document.getString("carregamento");
                                String destino = document.getString("destino");
                                String tempoEstimado = document.getString("tempoEstimado");
                                  String tipoCarga = document.getString("tipoCarga");
                                String valor = document.getString("valor");

                                tvTransp.setText(carregamento);
                                tvCliente.setText(destino);
                                tvRastre.setText(tempoEstimado);
                                tvCadastrarFretes.setText(tipoCarga + " - " + valor);
                            }
                        }
                    }
                });

    }
}

