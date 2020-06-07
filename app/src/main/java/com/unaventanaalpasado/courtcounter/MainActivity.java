package com.unaventanaalpasado.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeam1=0;
    int scoreTeam2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuperarDatosActividadAnterior();


    }
    private void recuperarDatosActividadAnterior(){
        try{
            String varNombreTeam1 = getIntent().getStringExtra("NombreTeam1");
            String varNombreTeam2 = getIntent().getStringExtra("NombreTeam2");
            TextView view = findViewById(R.id.nombreTeam1);
            view.setText(varNombreTeam1);
            TextView view2 = findViewById(R.id.nombreTeam2);
            view2.setText(varNombreTeam2);
        }catch(Exception e){
            Toast.makeText(this,"Error al transmitir los datos a la nueva Actividad",Toast.LENGTH_SHORT);
        }

    }
    public void displayForTeam1(int score){
        TextView scoreView = findViewById(R.id.scoreTeam1);
        scoreView.setText(String.valueOf(score));
    }
    public void addOneForTeam1(View v) {
        scoreTeam1++;
        displayForTeam1(scoreTeam1);
    }
    public void addTwoForTeam1(View v) {
        scoreTeam1+=2;
        displayForTeam1(scoreTeam1);
    }
    public void addThreeForTeam1(View v) {
        scoreTeam1+=3;
        displayForTeam1(scoreTeam1);
    }
    public void addFourForTeam1(View v) {
        scoreTeam1+=4;
        displayForTeam1(scoreTeam1);
    }
    public void restOneForTeam1(View v) {
        scoreTeam1-=1;
        displayForTeam1(scoreTeam1);
    }

    public void displayForTeam2(int score){
        TextView scoreView = findViewById(R.id.scoreTeam2);
        scoreView.setText(String.valueOf(score));
    }
    public void addOneForTeam2(View v) {
        scoreTeam2++;
        displayForTeam2(scoreTeam2);
    }
    public void addTwoForTeam2(View v) {
        scoreTeam2+=2;
        displayForTeam2(scoreTeam2);
    }
    public void addThreeForTeam2(View v) {
        scoreTeam2+=3;
        displayForTeam2(scoreTeam2);
    }
    public void addFourForTeam2(View v) {
        scoreTeam2+=4;
        displayForTeam2(scoreTeam2);
    }
    public void restOneForTeam2(View v) {
        scoreTeam2-=1;
        displayForTeam2(scoreTeam2);
    }


    public void reset(View v){
        scoreTeam1=0;
        scoreTeam2=0;
        displayForTeam1(scoreTeam1);
        displayForTeam2(scoreTeam2);
    }

    public void home(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        TextView view = findViewById(R.id.nombreTeam1);
        intent.putExtra("NombreTeam1",view.getText()+"");
        TextView view2 = findViewById(R.id.nombreTeam2);
        intent.putExtra("NombreTeam2",view2.getText()+"");
        startActivity(intent);
    }


}
