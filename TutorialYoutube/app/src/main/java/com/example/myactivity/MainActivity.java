package com.example.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID); //Aqui le conectamos la variable java con el valor del componente en el xml
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener((View view) -> {
            String idNumber = etID.getText().toString().trim();

            String dob = idNumber.substring(0,6);
            int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
            String sGender;
            if(gender < 5)
                sGender = "Female";
            else
                sGender = "Male";

            int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
            String sNationality;
            if(nationality == 0)
                sNationality = "SA citizen";
            else
                sNationality = "Permanent resident";

            String tvResultsText = "Date of birth: " + dob + "\n" +
                    "Gender: " + sGender + "\n" +
                    "Nationality " + sNationality;

            tvResults.setText(tvResultsText);
            tvResults.setVisibility(View.VISIBLE);
        });

    }


}
