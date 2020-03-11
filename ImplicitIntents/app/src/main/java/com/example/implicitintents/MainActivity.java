package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMap, btnWeb, btnCall, btnCallFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnCallFriend = findViewById(R.id.btnCallFriend);
        btnMap = findViewById(R.id.btnMap);
        btnWeb = findViewById(R.id.btnWeb);

        btnCall.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);  //This is shouting to the system if there is an app that can help me make call
        });

        btnCallFriend.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:3481052284"));    //This is opening the phone a dialing this number
                                                            //Uri: Uniform resource identifier
            startActivity(intent);
        });

        btnMap.setOnClickListener(view ->{

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=guadalajara jalisco"));
            startActivity(intent);

        });

        btnWeb.setOnClickListener(view ->{

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        });

    }
}
