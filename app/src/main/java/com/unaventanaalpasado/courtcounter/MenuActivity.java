package com.unaventanaalpasado.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
    public void burako(View v){
        Intent intent = new Intent(this, BurakoActivity.class);
        TextView view = findViewById(R.id.nombreTeam1);
        intent.putExtra("NombreTeam1",view.getText()+"");
        TextView view2 = findViewById(R.id.nombreTeam2);
        intent.putExtra("NombreTeam2",view2.getText()+"");
        startActivity(intent);
    }
    public void generico(View v){
        Intent intent = new Intent(this, GenericoActivity.class);
        TextView view = findViewById(R.id.nombreTeam1);
        intent.putExtra("NombreTeam1",view.getText()+"");
        TextView view2 = findViewById(R.id.nombreTeam2);
        intent.putExtra("NombreTeam2",view2.getText()+"");
        startActivity(intent);
    }
    public void truco(View v){
        Intent intent = new Intent(this, MainActivity.class);
        TextView view = findViewById(R.id.nombreTeam1);
        intent.putExtra("NombreTeam1",view.getText()+"");
        TextView view2 = findViewById(R.id.nombreTeam2);
        intent.putExtra("NombreTeam2",view2.getText()+"");
        startActivity(intent);
    }


}
