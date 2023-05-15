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
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1;

    //Declarar arquivo de preferência
    public static final String MyPREFERENCES = "arquivo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        ed1=(EditText)findViewById(R.id.nome);
        ed2=(EditText)findViewById(R.id.email);
        ed3=(EditText)findViewById(R.id.remail);
        ed4=(EditText)findViewById(R.id.senha);
        ed5=(EditText)findViewById(R.id.cpf);

        b1=(Button)findViewById(R.id.bt_salvar);

        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, 0);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome  = ed1.getText().toString();
                String email  = ed2.getText().toString();
                String renvemail  = ed3.getText().toString();
                String senha  = ed3.getText().toString();
                String cpf  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("Usuario", nome);
                editor.putString("Email", email);
                editor.putString("Confirmação do Email", renvemail);
                editor.putString("Senha", senha);
                editor.putString("CPF", cpf);
                editor.commit();
                Toast.makeText(Register.this,"Dados cadastrados no arquivo .xml com sucesso!!",Toast.LENGTH_LONG).show();

                //LIMPAR O EDITTEXT
                ed1.getText().clear();
                ed2.getText().clear();
                ed3.getText().clear();
                ed4.getText().clear();
                ed5.getText().clear();
                ed1.requestFocus();

            }
        });
    }
}