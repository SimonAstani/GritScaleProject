package com.example.simon.glirtproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.simon.glirtproject.R;
import com.example.simon.glirtproject.object.ResultField;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

/**
 * Created by Simon on 2/1/2017.
 */

public class resultFragment extends Fragment  {

    private static final String TAG = resultFragment.class.getSimpleName() ;
    private Button pushbtn;
    private EditText inputname;
    private TextView resultTv,surveyTv,txtuser;
    private String gritscale;
    private FirebaseDatabase mfirebaseInstance;
    private DatabaseReference mFirebaseDatabase;

    public resultFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        //inflating the layout for tab fragment,,
        View rootview = inflater.inflate(R.layout.activity_result,container,false);
        //initializing the field
        pushbtn = (Button) rootview.findViewById(R.id.push);
        inputname = (EditText) rootview.findViewById(R.id.inputName);
        resultTv = (TextView) rootview.findViewById(R.id.resultTv);
        surveyTv = (TextView) rootview.findViewById(R.id.surveyTv);
        txtuser = (TextView) rootview.findViewById(R.id.txt_users);


        mfirebaseInstance = FirebaseDatabase.getInstance();
        //getting reference to node
        mFirebaseDatabase = mfirebaseInstance.getReference("gritscale");

        mfirebaseInstance.getReference("app_title").setValue("RealTime Record");

        //app title change listner
        mfirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                
                String appTitle = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onDataChange:App title updated " + appTitle);

                //
                
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled:Failed ot read app title value ",databaseError.toException());


            }
        });

        //save on button click
        pushbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputname.getText().toString().trim();
                String result = resultTv.getText().toString().trim();
                String survey = surveyTv.getText().toString().trim();

                //check for already existed Gritscale
                if (TextUtils.isEmpty(gritscale)){
                    createUser(name,result,survey);
                }else {
                    updateUser(name,result,survey);

                }
            }
        });
        toogleButton();

        return rootview;
    }

    private void toogleButton() {
        if (TextUtils.isEmpty(gritscale)){
            pushbtn.setText("save");
        }else {
            pushbtn.setText("Update");
        }
    }

    private void createUser(String name, String result, String survey) {
        // TODO
        // In real apps this gritscale should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(gritscale)) {
            gritscale = mFirebaseDatabase.push().getKey();
        }

        ResultField resultfield = new ResultField(name,result,survey);

        mFirebaseDatabase.child(gritscale).setValue(resultfield);

        addUserChangeListener();
    }

    private void addUserChangeListener() {
        mFirebaseDatabase.child(gritscale).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ResultField resultfield = dataSnapshot.getValue(ResultField.class);
                //check for null
                if (resultfield == null){
                    Log.e(TAG, "User data is null!");
                    return;
                }
                Log.e(TAG, "User data is changed!" + resultfield.name + ", " + resultfield.gritscore + ", " + resultfield.survey);

                // Display newly updated name and email
                txtuser.setText(resultfield.name + ", " + resultfield.gritscore + ", " + resultfield.survey);

                // clear edit text
                inputname.setText("");
                resultTv.setText("");
                surveyTv.setText("");

                toogleButton();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", databaseError.toException());

            }
        });
    }

    private void updateUser(String name, String result, String survey) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(name))
            mFirebaseDatabase.child(gritscale).child("name").setValue(name);

        if (!TextUtils.isEmpty(result))
            mFirebaseDatabase.child(gritscale).child("result").setValue(result);

        if (!TextUtils.isEmpty(survey))
            mFirebaseDatabase.child(gritscale).child("survey").setValue(survey);

    }
}
