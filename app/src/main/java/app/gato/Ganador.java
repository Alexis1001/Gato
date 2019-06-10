package app.gato;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ganador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);

        setContentView(R.layout.activity_ganador);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Importante");
        builder.setMessage("Ganador X");
        builder.setPositiveButton("OK",null);
        builder.create();
        builder.show();
        //Intent Ganadorx=new Intent(Ganador.this,GatoActivity2.class);
        //startActivity(Ganadorx);
    }
}
