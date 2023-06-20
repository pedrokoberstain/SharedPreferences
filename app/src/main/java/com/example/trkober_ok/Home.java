package com.example.trkober_ok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private Button bt_registrar;
    private Button bt_entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();
        IniciarComponentes();
        bt_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Register.class);
                startActivity(intent);
            }
        });

        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Menu.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes() {
        bt_registrar = findViewById(R.id.bt_registrar);
        bt_entrar = findViewById(R.id.bt_entrar);
    }
}
