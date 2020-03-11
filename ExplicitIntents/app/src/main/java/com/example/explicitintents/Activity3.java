package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText etSurname;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = findViewById(R.id.etSurname);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            if(etSurname.getText().toString().isEmpty()){
                Toast.makeText(this, "Enter all the fields", Toast.LENGTH_SHORT).show();
            }
            else{
                String surname = etSurname.getText().toString().trim();
                Intent intent = new Intent();   // We dont want this intent to start a new activity, instead we need it to pass through the data
                intent.putExtra("surname", surname);
                setResult(RESULT_OK, intent);
                Activity3.this.finish();    // This will kill the actual activity and send us back to the activity that call it on the first place
            }
        });
    }
}
