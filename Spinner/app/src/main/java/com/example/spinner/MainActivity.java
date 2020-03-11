package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText et1, et2;
    private TextView tv1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.txt_valor1);
        et2 = findViewById(R.id.txt_valor2);
        tv1 = findViewById(R.id.tv_resultado);
        spinner = findViewById(R.id.spinner);

        String[] options = {"sum", "rest", "multiply", "divide"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
        spinner.setAdapter(adapter);

        button.setOnClickListener(this::calc);

    }

    public void calc(View view){
        String val1 = et1.getText().toString();
        String val2 = et2.getText().toString();

        int num1 = Integer.parseInt(val1);
        int num2 = Integer.parseInt(val2);

        String selection = spinner.getSelectedItem().toString();

        if(selection.equals("sum")){
            int suma  = num1 + num2;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);

        }
    }
}
