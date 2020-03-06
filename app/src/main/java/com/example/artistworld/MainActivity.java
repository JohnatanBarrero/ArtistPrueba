package com.example.artistworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    TextView tvClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin= findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);


        tvClick = findViewById(R.id.editTextClick);
        tvClick.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btnLogin:
                goToApplication();
                break;
            case R.id.editTextClick:
                Toast.makeText(this, "El usuario y la clase son:", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    private void goToApplication() {
        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
        startActivity(i);
        finish();
    }
}
