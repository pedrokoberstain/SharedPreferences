package com.example.trkober_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    //Declarar as variaveis
    EditText nome, email, renvemail, senha, cpf;
    Button send;

    TextView txtResultado;

    //Declarar arquivo de preferência
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nome=(EditText) findViewById(R.id.nome);
        email=(EditText) findViewById(R.id.email);
        renvemail=(EditText) findViewById(R.id.remail);
        senha=(EditText) findViewById(R.id.senha);
        cpf=(EditText) findViewById(R.id.cpf);
        send=(Button) findViewById(R.id.bt_salvar);

        getSupportActionBar().hide();

        //Classe Sharedpreferences
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, 0);
        //SharedPreferences sharedPreferences = getSharedPreferences("arquivo", 0);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DECLARAÇÃO DE VARIÁVEIS LOCAIS
                String usuarioLocal = nome.getText().toString();
                String emailLocal = email.getText().toString();
                String renvemailLocal = renvemail.getText().toString();
                String senhaLocal = senha.getText().toString();
                String cpfLocal = cpf.getText().toString();

                // DECLARAÇÃO DO EDITOR - SHAREDPREFERENCES NO MODO DE EDIÇÃO
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //FAZER A PERSISTÊNCIA DOS DADOS
                editor.putString("usuario", usuarioLocal);
                editor.putString("email", emailLocal);
                editor.putString("renvemail", renvemailLocal);
                editor.putString("senha", senhaLocal);
                editor.putString("cpf", cpfLocal);

                //CONFIRMAR PERSISTÊNCIA
                editor.commit();

                //NOTIFICAÇÃO NO APP
                Toast.makeText(Register.this, "Dados Cadastrados no arquivo XML", Toast.LENGTH_LONG).show();

                //LIMPAR FORMULÁRIO
                nome.getText().clear();
                email.getText().clear();
                renvemail.getText().clear();
                nome.requestFocus();
                senha.getText().clear();
                cpf.getText().clear();

                //RECUPERAR OS DADOS SALVOS
                SharedPreferences preferencia = getSharedPreferences(MyPREFERENCES,0);

                if (preferencia.contains("usuario")){
                    // RECUPERAR OS DADOS
                    String usuario = preferencia.getString("usuario", "Olá! Usuário não definido");
                    txtResultado.setText("Olá " + usuario);

                }else {
                    txtResultado.setText("Olá! Usuário não definido");
                }


            }
        });
    }
}