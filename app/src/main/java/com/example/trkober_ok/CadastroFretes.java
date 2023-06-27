package com.example.trkober_ok;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class CadastroFretes extends AppCompatActivity {

    private EditText etCarregamento, etDestino, etValor, etTipoCarga, etTempoEstimado;
    private Button btnSalvar;
    private FirebaseFirestore db;
    private CollectionReference cargasCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_fretes);
        getSupportActionBar().hide();

        // Inicializar o Firebase Firestore
        db = FirebaseFirestore.getInstance();
        cargasCollection = db.collection("cargas");

        // Obter referências para os campos de entrada
        etCarregamento = findViewById(R.id.carregamento);
        etDestino = findViewById(R.id.destino);
        etValor = findViewById(R.id.valor);
        etTipoCarga = findViewById(R.id.tipo);
        etTempoEstimado = findViewById(R.id.tempo);

        // Obter referência para o botão de salvar
        btnSalvar = findViewById(R.id.bt_ok);

        // Configurar o ouvinte de clique do botão de salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarInformacoes();
            }
        });
    }

    private void salvarInformacoes() {
        // Obter os valores dos campos de entrada
        String carregamento = etCarregamento.getText().toString().trim();
        String destino = etDestino.getText().toString().trim();
        String valor = etValor.getText().toString().trim();
        String tipoCarga = etTipoCarga.getText().toString().trim();
        String tempoEstimado = etTempoEstimado.getText().toString().trim();

        // Verificar se os campos estão preenchidos
        if (carregamento.isEmpty() || destino.isEmpty() || valor.isEmpty() || tipoCarga.isEmpty() || tempoEstimado.isEmpty()) {
            // Exibir uma mensagem de erro se algum campo estiver vazio
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Criar um mapa com os dados da carga
        Map<String, Object> carga = new HashMap<>();
        carga.put("carregamento", carregamento);
        carga.put("destino", destino);
        carga.put("valor", valor);
        carga.put("tipoCarga", tipoCarga);
        carga.put("tempoEstimado", tempoEstimado);

        // Salvar a carga no Firestore
        cargasCollection.document().set(carga, SetOptions.merge())
                .addOnSuccessListener(aVoid -> {
                    // Exibir uma mensagem de sucesso
                    Toast.makeText(CadastroFretes.this, "Carga salva com sucesso", Toast.LENGTH_SHORT).show();

                    // Limpar os campos de entrada
                    etCarregamento.setText("");
                    etDestino.setText("");
                    etValor.setText("");
                    etTipoCarga.setText("");
                    etTempoEstimado.setText("");
                })
                .addOnFailureListener(e -> {
                    // Exibir uma mensagem de erro em caso de falha
                    Toast.makeText(CadastroFretes.this, "Erro ao salvar a carga", Toast.LENGTH_SHORT).show();
                });
    }
}
