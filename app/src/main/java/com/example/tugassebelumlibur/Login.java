package com.example.tugassebelumlibur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tugassebelumlibur.helper.Pref;

public class Login extends AppCompatActivity {
    private int counter = 5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        final EditText username = findViewById(R.id.username);
        final EditText pass = findViewById(R.id.pass);
        Button btn = findViewById(R.id.btn);
        TextView tv_regis = findViewById(R.id.regis);

        final Bundle b = new Bundle();
        boolean statusInput = Pref.sharedIntance(getApplicationContext())
                .cekStatus();
        if (statusInput) {
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }

        tv_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Login.this, Register.class);
                startActivity(inten);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") || pass.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please insert your data", Toast.LENGTH_SHORT).show();
                } else if (username.getText().toString().equals("admin") || pass.getText().toString().equals("admin123")) {


                    Intent i = new Intent(Login.this, MainActivity.class);

                    Pref.sharedIntance(getApplicationContext()).setNama(
                            username.getText().toString());
                    Pref.sharedIntance(getApplicationContext())
                            .setStatusInput(true);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

