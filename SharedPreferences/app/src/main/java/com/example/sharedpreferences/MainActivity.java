package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_mail);
        button = findViewById(R.id.button);

        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);   //"datos" -> es el nombre general del archivo shared preferences
        et1.setText(pref.getString("mail", ""));    //primer parametro: nombre el valor que buscamos en nuestro shared preferences
                                                                // segundo parametro: valor en caso de que no haya ningun valor guardado
        button.setOnClickListener(this::guardar);

    }

    public void guardar(View view){
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();  //Con esto le digo que vamos a editar el archivo shared preferences por medio del editor
        editor.putString("mail", et1.getText().toString().trim());
        editor.commit();    //confirma que lo que guardamos arriba e efecto lo queremos guardar
        finish();
    }
}
