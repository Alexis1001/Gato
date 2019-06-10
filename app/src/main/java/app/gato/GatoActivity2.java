package app.gato;
import android.os.Handler;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.app.AlertDialog;
public class GatoActivity2 extends AppCompatActivity {



    ImageButton boton1,boton2,boton3,boton4,boton5, boton6,boton7,boton8,boton9;
    Button boton10;
    ArrayList<ImageButton>botones=new ArrayList<ImageButton>();
    ArrayList<Integer>parametros=new ArrayList<Integer>();
    ArrayList<Integer>pociciones=new ArrayList<Integer>();
    ArrayList<ImageButton>auxiliar=new ArrayList<ImageButton>();
    int movimientos[][]=new int [4][4];
    int auxiliares[][]=new int[4][4];
    TextView dato1,dato2,dato3;
    int Jugador;
    int TotalJuegos=0;
    int ContadorGanador=0;

    int contadorGanadorO=0;
    int contadorGanadorX=0;

    int partidas=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato2);

         dato1=findViewById(R.id.textView);
         dato2=findViewById(R.id.textView2);
         dato3=findViewById(R.id.textView3);
         parametros=getIntent().getIntegerArrayListExtra("dato");
         TotalJuegos=parametros.get(0);
         Jugador=parametros.get(1);

         for(int i=0;i<movimientos.length;i++){
             for(int j=0;j<movimientos.length;j++){
                 movimientos[i][j]=0;
                 auxiliares[i][j]=0;
             }

         }
        boton1=findViewById(R.id.boton1);
        boton2=findViewById(R.id.boton2);
        boton3=findViewById(R.id.boton3);
        boton4=findViewById(R.id.boton4);
        boton5=findViewById(R.id.boton5);
        boton6=findViewById(R.id.boton6);
        boton7=findViewById(R.id.boton7);
        boton8=findViewById(R.id.boton8);
        boton9=findViewById(R.id.boton9);
        //boton10=findViewById(R.id.Reinicio);
        botones.add(boton1);
        botones.add(boton2);
        botones.add(boton3);
        botones.add(boton4);
        botones.add(boton5);
        botones.add(boton6);
        botones.add(boton7);
        botones.add(boton8);
        botones.add(boton9);
        auxiliar.add(boton1);
        auxiliar.add(boton2);
        auxiliar.add(boton3);
        auxiliar.add(boton4);
        auxiliar.add(boton5);
        auxiliar.add(boton6);
        auxiliar.add(boton7);
        auxiliar.add(boton8);
        auxiliar.add(boton9);



    }



    public void selecionar(View view){
         ContadorGanador++;


        if(Jugador==10){
                for(int j=0;j<auxiliar.size();j++){
                    if(view.getId()==auxiliar.get(j).getId()){
                        botones.get(j).setImageResource(R.drawable.imagen_dex);
                        botones.get(j).setEnabled(false);
                        getPocicionesX(j);
                        String ganable=getDeVuelbeGanador();
                        if(ganable.equals("X")){
                            partidas++;
                            dato3.setText("PARTIDA JUGADA N° "+partidas+" DE "+TotalJuegos);
                            if(partidas<TotalJuegos) {
                                Toast mensaje4 = Toast.makeText(getApplicationContext(), " GANO X  ", Toast.LENGTH_SHORT);
                                mensaje4.show();
                            }
                            ArrayList<Integer>Pintar=new ArrayList<>();
                            Pintar=getRegresaPocicionesPintar();
                            botones.get(Pintar.get(0)).setImageResource(R.drawable.superx);
                            botones.get(Pintar.get(1)).setImageResource(R.drawable.superx);
                            botones.get(Pintar.get(2)).setImageResource(R.drawable.superx);
                            ContadorGanador=0;
                            contadorGanadorX++;
                            dato2.setText("Punataje "+contadorGanadorX);
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(partidas<TotalJuegos){
                                       getReinciar(auxiliar);
                                       Jugador=20;
                                       Toast mensaje4 = Toast.makeText(getApplicationContext(), " TIRA O ", Toast.LENGTH_SHORT);
                                       mensaje4.show();
                                    }
                                }
                            },1000);
                        }
                        if(ganable.equals("")&&ContadorGanador==9){
                            partidas++;
                            dato3.setText("PARTIDA JUGADA N° "+partidas+" DE "+TotalJuegos);
                            Toast mensaje4 = Toast.makeText(getApplicationContext(), " EMPATE  ", Toast.LENGTH_SHORT);
                            mensaje4.show();
                            ContadorGanador=0;
                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(partidas<TotalJuegos) {
                                        Toast mensaje4 = Toast.makeText(getApplicationContext(), " TIRA O  ", Toast.LENGTH_SHORT);
                                        mensaje4.show();
                                        getReinciar(auxiliar);
                                    }
                                }
                            },700);

                        }

                    }


                }
            Jugador=20;
        }

        else {
             for (int j = 0; j < auxiliar.size(); j++) {
                  if (view.getId() == auxiliar.get(j).getId()) {
                      botones.get(j).setImageResource(R.drawable.imagen_dey);
                      botones.get(j).setEnabled(false);
                      getPociconesY(j);
                      String ganable=getDeVuelbeGanador();

                      if(ganable.equals("O")){
                          partidas++;
                          dato3.setText("PARTIDA JUGADA N° "+partidas+" DE "+TotalJuegos);
                          if(partidas<TotalJuegos) {
                              Toast mensaje4 = Toast.makeText(getApplicationContext(), " GANO  O ", Toast.LENGTH_SHORT);
                              mensaje4.show();
                           }
                          ArrayList<Integer>Pintar=new ArrayList<>();
                          Pintar=getRegresaPocicionesPintar();
                          botones.get(Pintar.get(0)).setImageResource(R.drawable.supero);
                          botones.get(Pintar.get(1)).setImageResource(R.drawable.supero);
                          botones.get(Pintar.get(2)).setImageResource(R.drawable.supero);
                          ContadorGanador=0;
                          contadorGanadorO++;
                          dato1.setText("Puntaje "+contadorGanadorO);
                          Handler handler=new Handler();
                          handler.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  if(partidas<TotalJuegos){
                                      getReinciar(auxiliar);
                                      Jugador=10;
                                      Toast mensaje4 = Toast.makeText(getApplicationContext(), " TIRA X ", Toast.LENGTH_SHORT);
                                      mensaje4.show();
                                  }

                              }
                          },1000);

                      }
                      if(ganable.equals("")&&ContadorGanador==9){
                          Toast mensaje4 = Toast.makeText(getApplicationContext(), "EMPATE ", Toast.LENGTH_SHORT);
                          mensaje4.show();
                          ContadorGanador=0;
                          partidas++;
                          dato3.setText("PARTIDA JUGADA N° "+partidas+" DE "+TotalJuegos);
                          Handler handler=new Handler();
                          handler.postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  if(partidas<TotalJuegos){
                                      Toast mensaje4 = Toast.makeText(getApplicationContext(), " TIRA X  ", Toast.LENGTH_SHORT);
                                      mensaje4.show();
                                      getReinciar(auxiliar);
                                  }
                              }
                          },700);
                      }

                    }
             }
            Jugador = 10;
        }

         if(partidas==TotalJuegos){
            Handler handler =new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(contadorGanadorO>contadorGanadorX){
                        // Toast mensaje4 = Toast.makeText(getApplicationContext(), " GANADOR ABSOLUTO O  ", Toast.LENGTH_SHORT);
                        // mensaje4.show();
                        setContentView(R.layout.activity_gato2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(GatoActivity2.this);
                        builder.setTitle(" GANADOR ");
                        builder.setMessage(" EL GANADOR ABSOLUTO  O");
                        //builder.setPositiveButton("OK",null);
                        builder.create();
                        builder.show();
                        //getReinciar(auxiliar);
                         Handler h=new Handler();
                         h.postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 Intent i=new Intent(GatoActivity2.this,MainActivity.class);
                                 startActivity(i);
                             }
                         },1500);

                    }
                    if(contadorGanadorX>contadorGanadorO){
                        //Toast mensaje4 = Toast.makeText(getApplicationContext(), " GANADOR ABSOLUTO  X  ", Toast.LENGTH_SHORT);
                        //mensaje4.show();
                        setContentView(R.layout.activity_gato2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(GatoActivity2.this);
                        builder.setTitle(" GANADOR ");
                        builder.setMessage(" EL GANADOR  ABSOLUTO X ");
                        //builder.setPositiveButton("OK",null);
                        builder.create();
                        builder.show();
                        //getReinciar(auxiliar);
                        Handler h=new Handler();
                        h.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i=new Intent(GatoActivity2.this,MainActivity.class);
                                startActivity(i);
                            }
                        },1500);
                    }
                    if(contadorGanadorO==contadorGanadorX){
                        //Toast mensaje4 = Toast.makeText(getApplicationContext(), "  EMPATE   ", Toast.LENGTH_SHORT);
                        //mensaje4.show();
                        setContentView(R.layout.activity_gato2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(GatoActivity2.this);
                        builder.setTitle(" GANADOR ");
                        builder.setMessage(" PARTIDAS IGUALES EMPATE ");
                        //builder.setPositiveButton("OK",null);
                        builder.create();
                        builder.show();
                        //getReinciar(auxiliar);
                        Handler h=new Handler();
                        h.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i=new Intent(GatoActivity2.this,MainActivity.class);
                                startActivity(i);
                            }
                        },2000);
                    }

                }
            },700);

         }

    }


    public void getReinciar(ArrayList<ImageButton> axiliar) {
        for (int k = 0; k < auxiliar.size(); k++) {
            if (botones.get(k).isEnabled() == false) {
                botones.get(k).setEnabled(true);
                botones.get(k).setImageResource(R.drawable.cuadrosuper);
            } else {
                botones.get(k).setImageResource(R.drawable.cuadrosuper);
            }
        }
        for (int n = 0; n < movimientos.length; n++) {
            for (int m = 0; m < movimientos.length; m++) {
                movimientos[n][m] = 0;
                auxiliares[n][m] = 0;
            }
        }

    }


    public ArrayList getRegresaPocicionesPintar(){

        ArrayList<Integer>PocicionesGnadoras=new ArrayList<Integer>();
        if(movimientos[0][0]==1&&movimientos[1][1]==1&&movimientos[2][2]==1){//1
            PocicionesGnadoras.add(0);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(8);
        }

        if(movimientos[0][2]==1&&movimientos[1][1]==1&&movimientos[2][0]==1){//2
            PocicionesGnadoras.add(2);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(6);
        }


        if(movimientos[0][0]==1&&movimientos[0][1]==1&&movimientos[0][2]==1){//3
            PocicionesGnadoras.add(0);
            PocicionesGnadoras.add(1);
            PocicionesGnadoras.add(2);
        }

        if(movimientos[1][0]==1&&movimientos[1][1]==1&&movimientos[1][2]==1){//4
            PocicionesGnadoras.add(3);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(5);
        }

        if(movimientos[2][0]==1&&movimientos[2][1]==1&&movimientos[2][2]==1){//5
            PocicionesGnadoras.add(6);
            PocicionesGnadoras.add(7);
            PocicionesGnadoras.add(8);
        }

        if(movimientos[0][0]==1&&movimientos[1][0]==1&&movimientos[2][0]==1){//6
            PocicionesGnadoras.add(0);
            PocicionesGnadoras.add(3);
            PocicionesGnadoras.add(6);
        }

        if(movimientos[0][1]==1&&movimientos[1][1]==1&&movimientos[2][1]==1){//7
            PocicionesGnadoras.add(1);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(7);
        }

        if(movimientos[0][2]==1&&movimientos[1][2]==1&&movimientos[2][2]==1){//8
            PocicionesGnadoras.add(2);
            PocicionesGnadoras.add(5);
            PocicionesGnadoras.add(8);
        }
        ///////////////////////////////////////////////////////////////////////////
        if(movimientos[0][0]==2&&movimientos[1][1]==2&&movimientos[2][2]==2){//1
            PocicionesGnadoras.add(0);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(8);
        }

        if(movimientos[0][2]==2&&movimientos[1][1]==2&&movimientos[2][0]==2){//2
            PocicionesGnadoras.add(2);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(6);
        }

        if(movimientos[0][0]==2&&movimientos[0][1]==2&&movimientos[0][2]==2){//3
            PocicionesGnadoras.add(0);
            PocicionesGnadoras.add(1);
            PocicionesGnadoras.add(2);
        }

        if(movimientos[1][0]==2&&movimientos[1][1]==2&&movimientos[1][2]==2){//4
            PocicionesGnadoras.add(3);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(5);
        }

        if(movimientos[2][0]==2&&movimientos[2][1]==2&&movimientos[2][2]==2){//5
            PocicionesGnadoras.add(6);
            PocicionesGnadoras.add(7);
            PocicionesGnadoras.add(8);
        }

        if(movimientos[0][0]==2&&movimientos[1][0]==2&&movimientos[2][0]==2){//6
            PocicionesGnadoras.add(0);
            PocicionesGnadoras.add(3);
            PocicionesGnadoras.add(6);
        }

        if(movimientos[0][1]==2&&movimientos[1][1]==2&&movimientos[2][1]==2){//
            PocicionesGnadoras.add(1);
            PocicionesGnadoras.add(4);
            PocicionesGnadoras.add(7);
        }

        if(movimientos[0][2]==2&&movimientos[1][2]==2&&movimientos[2][2]==2){
            PocicionesGnadoras.add(2);
            PocicionesGnadoras.add(5);
            PocicionesGnadoras.add(8);
        }

      return PocicionesGnadoras;
    }


    public int[][] getPocicionesX(int pox){

            if(pox<3){

                if(pox==0){
                 //  Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 0 + " perro j "+0+"", Toast.LENGTH_SHORT);
                 //  mensaje1.show();
                    movimientos[0][0]=1;

                }
                if(pox==1){
                    //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 0 + " perro j "+1+"", Toast.LENGTH_SHORT);
                    //mensaje1.show();
                    movimientos[0][1]=1;
                }
                if(pox==2){
                  // Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 0 + " perro j "+2+"", Toast.LENGTH_SHORT);
                   // mensaje1.show();
                    movimientos[0][2]=1;
                }



            }

            if(pox>2&&pox<6){
                if(pox==3){
                    //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 1 + " perro j "+0+"", Toast.LENGTH_SHORT);
                    //mensaje1.show();
                    movimientos[1][0]=1;

                }
                if(pox==4){
                    //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 1+ " perro j "+1+"", Toast.LENGTH_SHORT);
                    //mensaje1.show();
                    movimientos[1][1]=1;
                }
                if(pox==5){
                    // Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 1 + " perro j "+2+"", Toast.LENGTH_SHORT);
                    // mensaje1.show();
                    movimientos[1][2]=1;
                }

            }

            if(pox>5&&pox<9){
                if(pox==6){
                    //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 2 + " perro j "+0+"", Toast.LENGTH_SHORT);
                    //mensaje1.show();
                    movimientos[2][0]=1;
                }
                if(pox==7){
                    //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 2+ " perro j "+1+"", Toast.LENGTH_SHORT);
                    //mensaje1.show();
                    movimientos[2][1]=1;
                }
                if(pox==8){
                    // Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 2 + " perro j "+2+"", Toast.LENGTH_SHORT);
                    // mensaje1.show();
                    movimientos[2][2]=1;
                }

            }

     return  movimientos;

    }

    public int [][]getPociconesY(int pox){

        if(pox<3){
            if(pox==0){
              // Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 0 + " perro j "+0+"", Toast.LENGTH_SHORT);
              // mensaje1.show();
                movimientos[0][0]=2;

            }
            if(pox==1){
              // Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 0 + " perro j "+1+"", Toast.LENGTH_SHORT);
              // mensaje1.show();
                movimientos[0][1]=2;
            }
            if(pox==2){
              // Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 0 + " perro j "+2+"", Toast.LENGTH_SHORT);
               //mensaje1.show();
                movimientos[0][2]=2;
            }


        }

        if(pox>2&&pox<6){
            if(pox==3){
               //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 1 + " perro j "+0+"", Toast.LENGTH_SHORT);
               //mensaje1.show();
                movimientos[1][0]=2;

            }
            if(pox==4){
               //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 1+ " perro j "+1+"", Toast.LENGTH_SHORT);
               //mensaje1.show();
                movimientos[1][1]=2;
            }
            if(pox==5){
                //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 1 + " perro j "+2+"", Toast.LENGTH_SHORT);
                //mensaje1.show();
                movimientos[1][2]=2;
            }


        }

        if(pox>5&&pox<9){
            if(pox==6){
                //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 2 + " perro j "+0+"", Toast.LENGTH_SHORT);
                //mensaje1.show();
                movimientos[2][0]=2;

            }
            if(pox==7){
                //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 2+ " perro j "+1+"", Toast.LENGTH_SHORT);
                //mensaje1.show();
                movimientos[2][1]=2;
            }
            if(pox==8){
                //Toast mensaje1 = Toast.makeText(getApplicationContext(), "columna "+ 2 + " perro j "+2+"", Toast.LENGTH_SHORT);
                //mensaje1.show();
                movimientos[2][2]=2;
            }


        }
      return  movimientos;
    }

    public String getDeVuelbeGanador(){

        String Ganador="";

        if(movimientos[0][0]==1&&movimientos[1][1]==1&&movimientos[2][2]==1){//1
            Ganador="X";
        }

        if(movimientos[0][2]==1&&movimientos[1][1]==1&&movimientos[2][0]==1){//2
            Ganador="X";
        }

        if(movimientos[0][0]==1&&movimientos[0][1]==1&&movimientos[0][2]==1){//3
            Ganador="X";
        }

        if(movimientos[1][0]==1&&movimientos[1][1]==1&&movimientos[1][2]==1){//4
            Ganador="X";
        }

        if(movimientos[2][0]==1&&movimientos[2][1]==1&&movimientos[2][2]==1){//5
            Ganador="X";
        }

        if(movimientos[0][0]==1&&movimientos[1][0]==1&&movimientos[2][0]==1){//6
            Ganador="X";
        }

        if(movimientos[0][1]==1&&movimientos[1][1]==1&&movimientos[2][1]==1){//7
            Ganador="X";
        }

        if(movimientos[0][2]==1&&movimientos[1][2]==1&&movimientos[2][2]==1){//8
            Ganador="X";
        }
        ///////////////////////////////////////////////////////////////////////////
        if(movimientos[0][0]==2&&movimientos[1][1]==2&&movimientos[2][2]==2){//1
            Ganador="O";
        }

        if(movimientos[0][2]==2&&movimientos[1][1]==2&&movimientos[2][0]==2){//2
            Ganador="O";
        }

        if(movimientos[0][0]==2&&movimientos[0][1]==2&&movimientos[0][2]==2){//3
            Ganador="O";
        }

        if(movimientos[1][0]==2&&movimientos[1][1]==2&&movimientos[1][2]==2){//4
            Ganador="O";
        }

        if(movimientos[2][0]==2&&movimientos[2][1]==2&&movimientos[2][2]==2){//5
            Ganador="O";
        }

        if(movimientos[0][0]==2&&movimientos[1][0]==2&&movimientos[2][0]==2){//6
            Ganador="O";
        }

        if(movimientos[0][1]==2&&movimientos[1][1]==2&&movimientos[2][1]==2){//
            Ganador="O";
        }

        if(movimientos[0][2]==2&&movimientos[1][2]==2&&movimientos[2][2]==2){
            Ganador="O";
        }


        return Ganador;
    }






}
