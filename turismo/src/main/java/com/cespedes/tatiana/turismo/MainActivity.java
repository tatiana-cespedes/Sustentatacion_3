package com.cespedes.tatiana.turismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);//poner los puntitos del menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();//le lleva a id el id del item seleccionado
        if(id==R.id.menu_hoteles) {//si fue seleccionado en el menú la opción Config
            Toast.makeText(this, "Ha presionado Hoteles", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Hoteles.class);// permiten llamar aplicaciones externas
            startActivity(i);
            return true;
        }

        if(id==R.id.menu_bares) {//si fue seleccionado en el menú la opción Config
            Toast.makeText(this, "Ha presionado Bares", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Bares.class);// permiten llamar aplicaciones externas
            startActivity(i);
            return true;
        }
        if(id==R.id.menu_sitios) {//si fue seleccionado en el menú la opción Config
            Toast.makeText(this, "Ha presionado Sitios turísticos", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Sitios.class);// permiten llamar aplicaciones externas
            startActivity(i);
            return true;
        }
        if(id==R.id.menu_informacion) {//si fue seleccionado en el menú la opción Config
            Toast.makeText(this, "Ha presionado Información Demográfica", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Informacion.class);// permiten llamar aplicaciones externas
            startActivity(i);
            return true;
        }
        if(id==R.id.menu_acercade) {//si fue seleccionado en el menú la opción Config
            Toast.makeText(this, "Ha presionado Acerca de...", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, AcercaDe.class);// permiten llamar aplicaciones externas
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
