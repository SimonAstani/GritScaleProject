package com.example.simon.glirtproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class REsult extends AppCompatActivity {
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView1 = (TextView) findViewById(R.id.result);
        Intent intent = getIntent();
        String values = intent.getStringExtra("Gritvalue");
        textView1.setText(values);


    }
}
