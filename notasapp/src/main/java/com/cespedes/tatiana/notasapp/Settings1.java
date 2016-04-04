package com.cespedes.tatiana.notasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings1 extends AppCompatActivity {
    EditText eExpo, ePra, ePro;
    Button bSave, bLimpiar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings1);
        eExpo = (EditText) findViewById(R.id.ePExpo);
        ePra =(EditText) findViewById(R.id.ePPrac);
        ePro=(EditText)findViewById(R.id.ePProy);
        bSave=(Button)findViewById(R.id.bGuardar);
        bLimpiar2=(Button)findViewById(R.id.bLimpiar2);

        Bundle extras=getIntent().getExtras();


        eExpo.setText(String.valueOf(extras.getInt("pExposiciones")));
        ePra.setText(String.valueOf(extras.getInt("pPrac")));
        ePro.setText(String.valueOf(extras.getInt("pProyecto")));


        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp, prac, proy, total;

                exp = Double.parseDouble(eExpo.getText().toString());
                prac = Double.parseDouble(ePra.getText().toString());
                proy = Double.parseDouble(ePro.getText().toString());

                total = exp + prac + proy;
                Intent i = new Intent();

                if (total == 100) {
                    i.putExtra("prPro", ePro.getText().toString());
                    i.putExtra("prExpo", eExpo.getText().toString());
                    i.putExtra("prPra", ePra.getText().toString());
                    setResult(RESULT_OK, i);


                    finish();
                } else {
                    MostrarError();
                }
            }
        });

        bLimpiar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eExpo.setText("");
                ePra.setText("");
                ePro.setText("");
            }
        });


    }

    void MostrarError (){
        Toast.makeText(this, "El porcentaje no suma 100%", Toast.LENGTH_SHORT).show();
    }
}
