package com.unaventanaalpasado.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GeneralActivity extends AppCompatActivity {

    int scoreTeam1=0;
    int scoreTeam2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        // pongo a la escucha de cambio de texto al equipo1
        GeneralTextChangedListenerTeam1 miGeneralTextChangedListenerTeam1 = new GeneralTextChangedListenerTeam1(this);


        EditText viewPuntosTeam1EditText = findViewById(R.id.puntosTeam1);
        viewPuntosTeam1EditText.addTextChangedListener(miGeneralTextChangedListenerTeam1);
        EditText viewPuntosExtraTeam1EditText = findViewById(R.id.puntosExtraTeam1);
        viewPuntosExtraTeam1EditText.addTextChangedListener(miGeneralTextChangedListenerTeam1);

        // pongo a la escucha de cambio de texto al equipo2
        GeneralTextChangedListenerTeam2 miGeneralTextChangedListenerTeam2 = new GeneralTextChangedListenerTeam2(this);

        EditText viewPuntosTeam2EditText = findViewById(R.id.puntosTeam2);
        viewPuntosTeam2EditText.addTextChangedListener(miGeneralTextChangedListenerTeam2);
        EditText viewPuntosExtraTeam2EditText = findViewById(R.id.puntosExtraTeam2);
        viewPuntosExtraTeam2EditText.addTextChangedListener(miGeneralTextChangedListenerTeam2);


    }

    //        listener para los dos teams extiende clase propia TextChangedListener
    private class GeneralTextChangedListenerTeam1 extends TextChangedListener {

        private GeneralTextChangedListenerTeam1(Object target) {
            super(target);
        }

        @Override
        public void onTextChanged(Object target, Editable s) {
            displaySubtotalTeam1(calculoSubtotalTeam1());
        }
    };

    private class GeneralTextChangedListenerTeam2 extends TextChangedListener {

        private GeneralTextChangedListenerTeam2(Object target) {
            super(target);
        }

        @Override
        public void onTextChanged(Object target, Editable s) {
            displaySubtotalTeam2(calculoSubtotalTeam2());
        }
    };

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
        TextView view = findViewById(R.id.puntosTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + Integer.parseInt(view.getText().toString());
        }catch(NumberFormatException e){
        }
        TextView view2 = findViewById(R.id.puntosExtraTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + Integer.parseInt(view2.getText().toString());
        }catch(NumberFormatException e){
        }

        return subtotalTeam1;

    }

    public void aceptarCalcularTotalTeam1(View v) {
        scoreTeam1 = scoreTeam1 + calculoSubtotalTeam1();
        displayForTeam1(scoreTeam1);
        resetValoresParcialesTeam1(v);
    }




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
        TextView view = findViewById(R.id.puntosTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + Integer.parseInt(view.getText().toString());
        }catch(NumberFormatException e){
        }
        TextView view2 = findViewById(R.id.puntosExtraTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + Integer.parseInt(view2.getText().toString());
        }catch(NumberFormatException e){
        }

        return subtotalTeam2;


    }


    public void aceptarCalcularTotalTeam2(View v) {

        scoreTeam2 = scoreTeam2 + calculoSubtotalTeam2();
        displayForTeam2(scoreTeam2);
        resetValoresParcialesTeam2(v);

    }


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
        TextView view = findViewById(R.id.puntosTeam1);
        view.setText("");
        TextView view2 = findViewById(R.id.puntosExtraTeam1);
        view2.setText("");

    }

    public void resetValoresParcialesTeam2(View v){
        TextView view = findViewById(R.id.puntosTeam2);
        view.setText("");
        TextView view2 = findViewById(R.id.puntosExtraTeam2);
        view2.setText("");

    }
    //             OTROS BOTONES
    public void home(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
