package com.unaventanaalpasado.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BurakoActivity extends AppCompatActivity {

    int scoreTeam1=0;
    int scoreTeam2=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burako);
        recuperarDatosActividadAnterior();



        // pongo a la escucha de cambio de texto al equipo1
        BurakoTextChangedListenerTeam1 miBurakoTextChangedListenerTeam1 = new BurakoTextChangedListenerTeam1(this);

        EditText viewPuntosTeam1EditText = findViewById(R.id.fichasTeam1);
        viewPuntosTeam1EditText.addTextChangedListener(miBurakoTextChangedListenerTeam1);

        // pongo a la escucha de cambio de texto al equipo2
        BurakoTextChangedListenerTeam2 miBurakoTextChangedListenerTeam2 = new BurakoTextChangedListenerTeam2(this);

        EditText viewPuntosTeam2EditText = findViewById(R.id.fichasTeam2);
        viewPuntosTeam2EditText.addTextChangedListener(miBurakoTextChangedListenerTeam2);


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
        TextView scoreView = findViewById(R.id.scoreTeam1);
        scoreView.setText(String.valueOf(score));
    }

    public void displaySubtotalTeam1(int score){
        TextView view = findViewById(R.id.subTotalTeam1);
        view.setText(String.valueOf(score));
    }

    public int calculoSubtotalTeam1() {
        int subtotalTeam1 = 0;
        CheckBox view = findViewById(R.id.buttonCorteTeam1);
        if (view.isChecked()){
            subtotalTeam1 = subtotalTeam1 + 100;
        }
        CheckBox view2 = findViewById(R.id.buttonMuertoTeam1);
        if (view2.isChecked()){
            subtotalTeam1 = subtotalTeam1 + 100;
        }else{
            subtotalTeam1 = subtotalTeam1 - 100;
        }

        TextView view3 = findViewById(R.id.purasTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view3.getText().toString())) * 200;
        }catch(NumberFormatException e){
        }
        TextView view4 = findViewById(R.id.impurasTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view4.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view5 = findViewById(R.id.fichasTeam1);
        try {
            subtotalTeam1 = subtotalTeam1 + (Integer.parseInt(view5.getText().toString()));
        }catch(NumberFormatException e){
        }
        return subtotalTeam1;

    }




    public void aceptarCalcularTotal(View v) {

        CheckBox view1 = findViewById(R.id.buttonCorteTeam1);
        CheckBox view2 = findViewById(R.id.buttonCorteTeam2);
        TextView view3 = findViewById(R.id.purasTeam1);
        TextView view4 = findViewById(R.id.impurasTeam1);
        TextView view5 = findViewById(R.id.purasTeam2);
        TextView view6 = findViewById(R.id.impurasTeam2);



        int canastas1 = Integer.parseInt(view3.getText().toString())+Integer.parseInt(view4.getText().toString());
        int canastas2 = Integer.parseInt(view5.getText().toString())+Integer.parseInt(view6.getText().toString());
        if (view1.isChecked()&&view2.isChecked()){
            Toast.makeText(getApplicationContext(),"Solo uno de los jugadores puede cortar",Toast.LENGTH_SHORT).show();
        }else if (!view1.isChecked()&&!view2.isChecked()){
        Toast.makeText(getApplicationContext(),"Alguno de los jugadores debe cortar",Toast.LENGTH_SHORT).show();
        }else if (view1.isChecked()&&canastas1 < 1){
            Toast.makeText(getApplicationContext(),"El jugador para cortar debe realizar una canasta",Toast.LENGTH_SHORT).show();
        }else if (view2.isChecked()&&canastas2 < 1) {
            Toast.makeText(getApplicationContext(), "El jugador para cortar debe realizar una canasta", Toast.LENGTH_SHORT).show();
        }else{
            scoreTeam1 = scoreTeam1 + calculoSubtotalTeam1();
            displayForTeam1(scoreTeam1);
            resetValoresParcialesTeam1(v);
            scoreTeam2 = scoreTeam2 + calculoSubtotalTeam2();
            displayForTeam2(scoreTeam2);
            resetValoresParcialesTeam2(v);
        }
    }


    public void actualizarCorteTeam1(View v) {

        CheckBox view = findViewById(R.id.buttonCorteTeam1);
        if (view.isChecked()){
            //si corto tambien neceseariamente junto el muerto
            CheckBox view2 = findViewById(R.id.buttonMuertoTeam1);
            view2.setChecked(true);
             //si uno corta el otro no
            CheckBox view3 = findViewById(R.id.buttonCorteTeam2);
            if (view3.isChecked()){
                 view3.setChecked(false);
                displaySubtotalTeam2(calculoSubtotalTeam2());
            }
        }

        displaySubtotalTeam1(calculoSubtotalTeam1());
    }

    public void actualizarMuertoTeam1(View v) {
        CheckBox view = findViewById(R.id.buttonMuertoTeam1);
        if (!view.isChecked()){
            CheckBox view2 = findViewById(R.id.buttonCorteTeam1);
            view2.setChecked(false);
        }
        displaySubtotalTeam1(calculoSubtotalTeam1());
    }

    public void sumaPurasTeam1(View v) {
        TextView viewPurasTeam1 = findViewById(R.id.purasTeam1);
        int aux =Integer.parseInt(viewPurasTeam1.getText().toString());
        aux++;
        viewPurasTeam1.setText(Integer.toString(aux));
        displaySubtotalTeam1(calculoSubtotalTeam1());
    }

    public void restaPurasTeam1(View v) {
        TextView viewPurasTeam1 = findViewById(R.id.purasTeam1);
        int aux =Integer.parseInt(viewPurasTeam1.getText().toString());
        if(aux > 0) {
            aux--;
        }
        viewPurasTeam1.setText(Integer.toString(aux));
        displaySubtotalTeam1(calculoSubtotalTeam1());
    }

    public void sumaImpurasTeam1(View v) {
        TextView viewImpurasTeam1 = findViewById(R.id.impurasTeam1);
        int aux =Integer.parseInt(viewImpurasTeam1.getText().toString());
        aux++;
        viewImpurasTeam1.setText(Integer.toString(aux));
        displaySubtotalTeam1(calculoSubtotalTeam1());
    }

    public void restaImpurasTeam1(View v) {
        TextView viewImpurasTeam1 = findViewById(R.id.impurasTeam1);
        int aux =Integer.parseInt(viewImpurasTeam1.getText().toString());
        if(aux > 0) {
            aux--;
        }
        viewImpurasTeam1.setText(Integer.toString(aux));
        displaySubtotalTeam1(calculoSubtotalTeam1());
    }



//                           TEAM 2

    public void displayForTeam2(int score){
        TextView scoreView = findViewById(R.id.scoreTeam2);
        scoreView.setText(String.valueOf(score));
    }
    public void displaySubtotalTeam2(int score){
        TextView view = findViewById(R.id.subTotalTeam2);
        view.setText(String.valueOf(score));
    }
    public int calculoSubtotalTeam2() {
        int subtotalTeam2 = 0;
        CheckBox view = findViewById(R.id.buttonCorteTeam2);
        if (view.isChecked()){
            subtotalTeam2 = subtotalTeam2 + 100;
        }
        CheckBox view2 = findViewById(R.id.buttonMuertoTeam2);
        if (view2.isChecked()){
            subtotalTeam2 = subtotalTeam2 + 100;
        }else{
            subtotalTeam2 = subtotalTeam2 - 100;
        }

        TextView view3 = findViewById(R.id.purasTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view3.getText().toString())) * 200;
        }catch(NumberFormatException e){
        }
        TextView view4 = findViewById(R.id.impurasTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view4.getText().toString())) * 100;
        }catch(NumberFormatException e){
        }
        TextView view5 = findViewById(R.id.fichasTeam2);
        try {
            subtotalTeam2 = subtotalTeam2 + (Integer.parseInt(view5.getText().toString()));
        }catch(NumberFormatException e){
        }
        return subtotalTeam2;

    }





    public void actualizarCorteTeam2(View v) {
        CheckBox view = findViewById(R.id.buttonCorteTeam2);
        if (view.isChecked()){
            //si corto tambien neceseariamente junto el muerto
            CheckBox view2 = findViewById(R.id.buttonMuertoTeam2);
            view2.setChecked(true);
            //si uno corta el otro no
            CheckBox view3 = findViewById(R.id.buttonCorteTeam1);
            if (view3.isChecked()){
                view3.setChecked(false);
                displaySubtotalTeam1(calculoSubtotalTeam1());
            }
        }

        displaySubtotalTeam2(calculoSubtotalTeam2());
    }

    public void actualizarMuertoTeam2(View v) {
        CheckBox view = findViewById(R.id.buttonMuertoTeam2);
        if (!view.isChecked()){
            CheckBox view2 = findViewById(R.id.buttonCorteTeam2);
            view2.setChecked(false);
        }
        displaySubtotalTeam2(calculoSubtotalTeam2());
    }

    public void sumaPurasTeam2(View v) {
        TextView viewPurasTeam2 = findViewById(R.id.purasTeam2);
        int aux =Integer.parseInt(viewPurasTeam2.getText().toString());
        aux++;
        viewPurasTeam2.setText(Integer.toString(aux));
        displaySubtotalTeam2(calculoSubtotalTeam2());
    }

    public void restaPurasTeam2(View v) {
        TextView viewPurasTeam2 = findViewById(R.id.purasTeam2);
        int aux =Integer.parseInt(viewPurasTeam2.getText().toString());
        if(aux > 0) {
            aux--;
        }
        viewPurasTeam2.setText(Integer.toString(aux));
        displaySubtotalTeam2(calculoSubtotalTeam2());
    }

    public void sumaImpurasTeam2(View v) {
        TextView viewImpurasTeam2 = findViewById(R.id.impurasTeam2);
        int aux =Integer.parseInt(viewImpurasTeam2.getText().toString());
        aux++;
        viewImpurasTeam2.setText(Integer.toString(aux));
        displaySubtotalTeam2(calculoSubtotalTeam2());
    }

    public void restaImpurasTeam2(View v) {
        TextView viewImpurasTeam2 = findViewById(R.id.impurasTeam2);
        int aux =Integer.parseInt(viewImpurasTeam2.getText().toString());
        if(aux > 0) {
            aux--;
        }
        viewImpurasTeam2.setText(Integer.toString(aux));
        displaySubtotalTeam2(calculoSubtotalTeam2());
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
        CheckBox view = findViewById(R.id.buttonCorteTeam1);
        view.setChecked(false);
        CheckBox view2 = findViewById(R.id.buttonMuertoTeam1);
        view2.setChecked(false);
        TextView view3 = findViewById(R.id.purasTeam1);
        view3.setText("0");
        TextView view4 = findViewById(R.id.impurasTeam1);
        view4.setText("0");
        TextView view5 = findViewById(R.id.fichasTeam1);
        view5.setText(""); //no poner 0
        TextView view6 = findViewById(R.id.subTotalTeam1);
        view6.setText("0");

    }

    public void resetValoresParcialesTeam2(View v) {
        CheckBox view = findViewById(R.id.buttonCorteTeam2);
        view.setChecked(false);
        CheckBox view2 = findViewById(R.id.buttonMuertoTeam2);
        view2.setChecked(false);
        TextView view3 = findViewById(R.id.purasTeam2);
        view3.setText("0");
        TextView view4 = findViewById(R.id.impurasTeam2);
        view4.setText("0");
        TextView view5 = findViewById(R.id.fichasTeam2);
        view5.setText(""); //no poner 0
        TextView view6 = findViewById(R.id.subTotalTeam2);
        view6.setText("0");
    }
    //             OTROS BOTONES

    public void home(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        TextView view = findViewById(R.id.nombreTeam1);
        intent.putExtra("NombreTeam1",view.getText()+"");
        TextView view2 = findViewById(R.id.nombreTeam2);
        intent.putExtra("NombreTeam2",view2.getText()+"");
        startActivity(intent);
    }


}
