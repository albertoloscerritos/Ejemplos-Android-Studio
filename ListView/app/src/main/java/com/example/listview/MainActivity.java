package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //datos
        String[] datos = {"estudiante 1", "estudiante 2", "estudiante 3"};

        //para conectar estos datos existe un adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,
                datos
        );

        ArrayList<Estudiante> estudiantitos = new ArrayList<>();
        estudiantitos.add(new Estudiante("Rafa", 25, 12));
        estudiantitos.add(new Estudiante("Juan Daniel", 14, 14));
        estudiantitos.add(new Estudiante("Gus", 24, 15));

        EstudianteAdapter adaptador = new EstudianteAdapter(estudiantitos, this);

        //vista
        listita = findViewById(R.id.listita);
        listita.setAdapter(adapter);
    }
}
