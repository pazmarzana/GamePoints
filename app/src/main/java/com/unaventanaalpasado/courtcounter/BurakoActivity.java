package com.unaventanaalpasado.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BurakoActivity extends AppCompatActivity {

    int scoreTeam1=0;
    int scoreTeam2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burako);

        // pongo a la escucha de cambio de texto al equipo1
        BurakoTextChangedListenerTeam1 miBurakoTextChangedListenerTeam1 = new BurakoTextChangedListenerTeam1(this);

        EditText viewCorteTeam1EditText = findViewById(R.id.corteTeam1);
        viewCorteTeam1EditText.addTextChangedListener(miBurakoTextChangedListenerTeam1);
        EditText viewMuertoTeam1EditText = findViewById(R.id.muertoTeam1);
        viewMuertoTeam1EditText.addTextChangedListener(miBurakoTextChangedListenerTeam1);
        EditText viewPurasTeam1EditText = findViewById(R.id.purasTeam1);
        viewPurasTeam1EditText.addTextChangedListener(miBurakoTextChangedListenerTeam1);
        EditText viewImPurasTeam1EditText = findViewById(R.id.imPurasTeam1);
        viewImPurasTeam1EditText.addTextChangedListener(miBurakoTextChangedListenerTeam1);
        EditText viewPuntosTeam1EditText = findViewById(R.id.puntosTeam1);
        viewPuntosTeam1EditText.addTextChangedListener(miBurakoTextChangedListenerTeam1);

        // pongo a la escucha de cambio de texto al equipo2
        BurakoTextChangedListenerTeam2 miBurakoTextChangedListenerTeam2 = new BurakoTextChangedListenerTeam2(this);
        EditText viewCorteTeam2EditText = findViewById(R.id.corteTeam2);
        viewCorteTeam2EditText.addTextChangedListener(miBurakoTextChangedListenerTeam2);
        EditText viewMuertoTeam2EditText = findViewById(R.id.muertoTeam2);
        viewMuertoTeam2EditText.addTextChangedListener(miBurakoTextChangedListenerTeam2);
        EditText viewPurasTeam2EditText = findViewById(R.id.purasTeam2);
        viewPurasTeam2EditText.addTextChangedListener(miBurakoTextChangedListenerTeam2);
        EditText viewCorteimPurasEditText = findViewById(R.id.imPurasTeam2);
        viewCorteimPurasEditText.addTextChangedListener(miBurakoTextChangedListenerTeam2);
        EditText viewPuntosTeam2EditText = findViewById(R.id.puntosTeam2);
        viewPuntosTeam2EditText.addTextChangedListener(miBurakoTextChangedListenerTeam2);


    }

    //        listener para los dos teams extiende clase propia TextChangedListener
    private class BurakoTextChangedListenerTeam1 extends TextChangedListener {

        private BurakoTextChangedListenerTeam1(Object target) {
            super(target);
        }

        @Override
        public void onTextChanged(Object target, Editable s) {
            displaySubtotalTeam1(calculoSubtotalTeam1());
        }
    }

    private class BurakoTextChangedListenerTeam2 extends TextChangedListener {

        private BurakoTextChangedListenerTeam2(Object target) {
            super(target);
        }

        @Override
        public void onTextChanged(Object target, Editable s) {
            displaySubtotalTeam2(calculoSubtotalTeam2());
        }
    }

    public void displayForTeam1(int score){
        TextView scoreView = findViewById(R.id.team_1_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySubtotalTeam1(int score){
        TextView view = findViewById(R.id.subTotalTeam1);
        view.setText(String.valueOf(score));
    }

    public int calculoSubtotalTeam1() {
        int subtotalTeam1 = 0;
        TextView view = findViewById(R.id.corteTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view2 = findViewById(R.id.muertoTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view2.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view3 = findViewById(R.id.purasTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view3.getText().toString())) * 200;
        }catch(NumberFormatException e){
        }
        TextView view4 = findViewById(R.id.imPurasTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view4.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view5 = findViewById(R.id.puntosTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view5.getText().toString()));
        }catch(NumberFormatException e){
        }
        return subtotalTeam1;

    }

    public void aceptarCalcularTotalTeam1(View v) {
        scoreTeam1 = scoreTeam1 + calculoSubtotalTeam1();
        displayForTeam1(scoreTeam1);
        resetValoresParcialesTeam1(v);
    }

/*    public void restOneForTeam1(View v) {
        scoreTeam1-=1;
        displayForTeam1(scoreTeam1);
    }*/


//                           TEAM 2

    public void displayForTeam2(int score){
        TextView scoreView = findViewById(R.id.team_2_score);
        scoreView.setText(String.valueOf(score));
    }
    public void displaySubtotalTeam2(int score){
        TextView view = findViewById(R.id.subTotalTeam2);
        view.setText(String.valueOf(score));
    }
    public int calculoSubtotalTeam2() {
        int subtotalTeam2 = 0;
        TextView view = findViewById(R.id.corteTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view2 = findViewById(R.id.muertoTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view2.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view3 = findViewById(R.id.purasTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view3.getText().toString())) * 200;
        }catch(NumberFormatException e){
        }
        TextView view4 = findViewById(R.id.imPurasTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view4.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view5 = findViewById(R.id.puntosTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view5.getText().toString()));
        }catch(NumberFormatException e){
        }
        return subtotalTeam2;


    }
/*    public void aceptarCalcularSubtotalTeam2(View v) {
        //displayForTeam2(scoreTeam2);
        //subtotalTeam2 = calculoSubtotalTeam2();
        displaySubtotalTeam2(calculoSubtotalTeam2());
    }*/

    public void aceptarCalcularTotalTeam2(View v) {

        scoreTeam2 = scoreTeam2 + calculoSubtotalTeam2();
        displayForTeam2(scoreTeam2);
        resetValoresParcialesTeam2(v);

    }
/*
    public void restOneForTeam2(View v) {
        scoreTeam2-=1;
        displayForTeam2(scoreTeam2);
    }
*/

//                               RESET


    public void reset(View v){
        scoreTeam1=0;
        scoreTeam2=0;
        displayForTeam1(scoreTeam1);
        displayForTeam2(scoreTeam2);
        resetValoresParcialesTeam1(v);
        resetValoresParcialesTeam2(v);
    }

    public void resetValoresParcialesTeam1(View v){
        TextView view = findViewById(R.id.corteTeam1);
        view.setText("");
        TextView view2 = findViewById(R.id.muertoTeam1);
        view2.setText("");
        TextView view3 = findViewById(R.id.purasTeam1);
        view3.setText("");
        TextView view4 = findViewById(R.id.imPurasTeam1);
        view4.setText("");
        TextView view5 = findViewById(R.id.puntosTeam1);
        view5.setText("");
        TextView view6 = findViewById(R.id.subTotalTeam1);
        view6.setText("");

    }

    public void resetValoresParcialesTeam2(View v){
        TextView view = findViewById(R.id.corteTeam2);
        view.setText("");
        TextView view2 = findViewById(R.id.muertoTeam2);
        view2.setText("");
        TextView view3 = findViewById(R.id.purasTeam2);
        view3.setText("");
        TextView view4 = findViewById(R.id.imPurasTeam2);
        view4.setText("");
        TextView view5 = findViewById(R.id.puntosTeam2);
        view5.setText("");
        TextView view6 = findViewById(R.id.subTotalTeam2);
        view6.setText("");

    }
    //             OTROS BOTONES
    public void home(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
