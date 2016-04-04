package com.cespedes.tatiana.notasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eExpoci, ePracti, eProyec, eNotaFi;
    TextView tPorcExp, tPorcPracti, tPorcProyec;
    private Button bCalc, bLimpiar;
    double pproye=35, pexpo=40, pprac=25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eExpoci=(EditText) findViewById(R.id.eExpo);
        ePracti=(EditText) findViewById(R.id.ePrac);
        eProyec=(EditText) findViewById(R.id.eProy);
        eNotaFi=(EditText) findViewById(R.id.eNota);
        tPorcExp=(TextView) findViewById(R.id.tPorceExpo);
        tPorcPracti=(TextView) findViewById(R.id.tPorcePract);
        tPorcProyec=(TextView) findViewById(R.id.tPorceProyec);
        bCalc=(Button) findViewById(R.id.bCalc);
        bLimpiar=(Button) findViewById(R.id.bLimpiar);

        tPorcExp.setText(pexpo+"%");
        tPorcPracti.setText(pprac+"%");
        tPorcProyec.setText(pproye + "%");

        bCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp, prac, proy, nfinal;

                exp = Double.parseDouble(eExpoci.getText().toString());
                prac = Double.parseDouble(ePracti.getText().toString());
                proy = Double.parseDouble(eProyec.getText().toString());
                if (exp <= 5 & prac <= 5 & proy <= 5 & exp >= 0 & prac >= 0 & proy >= 0) {
                    nfinal = (((pexpo * exp) / 100) + ((pprac * prac) / 100) + ((pproye * proy) / 100)) * 10;
                    nfinal = (Math.round(nfinal));
                    nfinal = nfinal / 10;
                    eNotaFi.setText(String.valueOf(nfinal));

                } else {
                    MostrarError();
                }
            }
        });


        bLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eExpoci.setText("");
                ePracti.setText("");
                eProyec.setText("");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);//poner los puntitos del menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();//le lleva a id el id del item seleccionado
        if(id==R.id.menu_config){//si fue seleccionado en el menú la opción Config
            Toast.makeText(this, "Ha presionado opción configurar", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(this, Settings1.class);// permiten llamar aplicaciones externas
            i.putExtra("pProyecto", (int) pproye);
            i.putExtra("pExposiciones", (int) (pexpo));
            i.putExtra("pPrac", (int) pprac);
            startActivityForResult(i, 1234);//verificar quien respondió

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234 && resultCode==RESULT_OK){

            pproye=Double.parseDouble(data.getExtras().getString("prPro"));
            pexpo=Double.parseDouble(data.getExtras().getString("prExpo"));
            pprac=Double.parseDouble(data.getExtras().getString("prPra"));
            Toast.makeText(this, "Exposición: " + pexpo + "   Prácticas: " + pprac + "   Proyecto: " + pproye, Toast.LENGTH_SHORT).show();
            tPorcExp.setText(pexpo+"%");
            tPorcPracti.setText(pprac+"%");
            tPorcProyec.setText(pproye + "%");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    void MostrarError (){
        Toast.makeText(this, "Los parámetros no son correctos", Toast.LENGTH_SHORT).show();
    }

}
