package com.example.explicitintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;
    final int ACTIVITY_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);
        Intent intentAct2 = new Intent(this, Activity2.class);
        Intent intentAct3 = new Intent(this, Activity3.class);

        btnAct2.setOnClickListener(view -> {

            if(etName.getText().toString().isEmpty()){
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            }
            else{
                String name = etName.getText().toString().trim();

                intentAct2.putExtra("name", name);  //Le estamos pasando una lista (Key, value) al intento. Estamos enviando info de una ventana a otra
                startActivity(intentAct2);  //Abre la siguiente actividad
            }

        });

        btnAct3.setOnClickListener(view -> {
            startActivityForResult(intentAct3, ACTIVITY_3);   // This is an intent and a request code at the same time. SO we can come back to this activity with new data
                                                              //ACTIVITY_3 is a unique identifier for the Activity3 class

        });
    }

    // Since we started a startActivityForResult() we will come back into the onActivityResult() method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode: Unique value to identify an Activity
        // resultCode: is RESULT_OK or RESULT_CANCELED (the state of the info we passed)
        // Intent data: an intent that contains the data we received from another activity

        if(requestCode == ACTIVITY_3){  // With the request code we can identify which activity is the one that came back (to this method)
            if(resultCode == RESULT_OK){
                tvResults.setText(data.getStringExtra("surname"));
            }
            else if(resultCode == RESULT_CANCELED){
                tvResults.setText("No data received");
            }

        }
    }
}
