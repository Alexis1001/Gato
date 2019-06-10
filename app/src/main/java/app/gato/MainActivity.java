package app.gato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageView equis,ceros;
    CheckBox ChekEquis,ChekCero;
    EditText texto;
    Button okay;
    int jugador=0;

    ArrayList<Integer>parametros=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equis=findViewById(R.id.equis);
        ceros=findViewById(R.id.cero);
        ChekEquis=findViewById(R.id.checkBoxequis);
        ChekCero=findViewById(R.id.checkBoxcero);
        texto=findViewById(R.id.vidas);
        okay=findViewById(R.id.jugar);







        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ChekCero.isChecked()==true&&ChekEquis.isChecked()==true){
                    Toast mensaje = Toast.makeText(getApplicationContext(), " DECIDACE POR UNA ", Toast.LENGTH_SHORT);
                    mensaje.show();
                }

                if(ChekEquis.isChecked()==true&&ChekCero.isChecked()==false){

                    if(!texto.getText().toString().isEmpty()&&Integer.parseInt(texto.getText().toString())>0){
                        Toast mensaje = Toast.makeText(getApplicationContext(), " USTED TIRA LA X ", Toast.LENGTH_SHORT);
                        mensaje.show();
                        jugador=10;
                        Intent vista2=new Intent(MainActivity.this,GatoActivity2.class);
                        String nJuego=texto.getText().toString();
                        int Njuegos=Integer.parseInt(nJuego);
                        parametros.add(Njuegos);
                        parametros.add(jugador);
                        vista2.putExtra("dato",parametros);
                        startActivity(vista2);
                        parametros.clear();
                        texto.setText("");
                    }
                    else{
                        Toast mensaje = Toast.makeText(getApplicationContext(), " INGRESA VECES AJUGAR", Toast.LENGTH_SHORT);
                        mensaje.show();
                    }

                }

                if(ChekCero.isChecked()==true&&ChekEquis.isChecked()==false){

                    if(!texto.getText().toString().isEmpty()&&Integer.parseInt(texto.getText().toString())>0){
                        Toast mensaje = Toast.makeText(getApplicationContext(), " USTED TIRA LA O ", Toast.LENGTH_SHORT);
                        mensaje.show();
                        jugador=20;
                        Intent vista2=new Intent(MainActivity.this,GatoActivity2.class);
                        String nJuego=texto.getText().toString();
                        int Njuegos=Integer.parseInt(nJuego);
                        parametros.add(Njuegos);
                        parametros.add(jugador);
                        vista2.putExtra("dato",parametros);
                        startActivity(vista2);
                        parametros.clear();
                        texto.setText("");

                    }
                    else{
                        Toast mensaje = Toast.makeText(getApplicationContext(), " INGRESA VECES AJUGAR", Toast.LENGTH_SHORT);
                        mensaje.show();
                    }


                }

                if(ChekEquis.isChecked()==false&&ChekCero.isChecked()==false){
                    Toast mensaje = Toast.makeText(getApplicationContext(), " ELIJA UNA ", Toast.LENGTH_SHORT);
                    mensaje.show();
                }

            }
        });




    }







}
