package com.example.simon.glirtproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.simon.glirtproject.R;

public class REsult extends AppCompatActivity {
    TextView textView1,textView2;
    double valuedouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //getting value from another activiy using intent putExtra method
        textView1 = (TextView) findViewById(R.id.result);
        Intent intent = getIntent();
        String values = intent.getStringExtra("Gritvalue");
        textView1.setText(values);

        //creating textview from java and updating it using above grit values...
        textView2 = (TextView) findViewById(R.id.survey);

        //seperating settext string into two values so i can make % value bold


         valuedouble = Double.valueOf(values);
        if (0 <= valuedouble && valuedouble <= 1.5) {
            textView2.setText("You Scored higher than about 10 % of Nepali Adult");

        }else if ( 1.5 < valuedouble && valuedouble <= 3.15) {
            textView2.setText("You Scored higher than about 35% of Nepali Adult");

        }else if ( 3.15 < valuedouble && valuedouble <= 4.0) {
            textView2.setText("You Scored higher than about 50% of Nepali Adult");

        }else if ( 4.0 < valuedouble && valuedouble <= 5.0) {
            textView2.setText("You Scored higher than about 65% of Nepali Adult");

        }

    }
}
