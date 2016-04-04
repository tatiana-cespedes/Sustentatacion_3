package com.cespedes.tatiana.turismo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sitios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        Bundle extras=getIntent().getExtras();
    }
}
