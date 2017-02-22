package com.example.simon.glirtproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simon.glirtproject.R;
import com.example.simon.glirtproject.object.ResultField;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Simon on 2/1/2017.
 */

public class resultFragment extends Fragment  {

    private static final String TAG = resultFragment.class.getSimpleName() ;
    private Button pushbtn;
    private EditText inputname;
    private TextView resultTv,surveyTv,txtuser;
    private String UserID;
    private FirebaseDatabase mfirebaseInstance;
    private DatabaseReference mFirebaseDatabase;
    String newdata = "";


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
        mFirebaseDatabase = mfirebaseInstance.getReference("users");

        //store app title to node users
        mfirebaseInstance.getReference("app_title").setValue("RealTime Record");

        //app title change listner to read the database
        mfirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //this method is callled once initial valuse is input and updated
                String appTitle = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onDataChange:App title updated " + appTitle);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //failed to read value
                Log.e(TAG, "onCancelled:Failed ot read app title value ",databaseError.toException());


            }
        });

        //save on button click
        pushbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputname.getText().toString();
                String result = resultTv.getText().toString();
                String survey = surveyTv.getText().toString();
                Toast.makeText(getActivity(), "checked push", Toast.LENGTH_SHORT).show();

                //check for already existed Gritscale
                if (TextUtils.isEmpty(UserID)){
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
        if (TextUtils.isEmpty(UserID)){
            pushbtn.setText("save");
        }else {
            pushbtn.setText("Update");
        }
    }

    private void createUser(String name, String result, String survey) {
        // TODO
        // In real apps this gritscale should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(UserID)) {
            UserID = mFirebaseDatabase.push().getKey();
        }

        ResultField resultfield = new ResultField(name,result,survey);

        mFirebaseDatabase.child(UserID).setValue(resultfield);

        addUserChangeListener();
    }

    /*user data change listitener*/
    private void addUserChangeListener() {
        mFirebaseDatabase.child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ResultField resultfield = dataSnapshot.getValue(ResultField.class);
                //check for null
                if (resultfield == null){
                    Log.e(TAG, "User data is null!");
                    return;
                }
                Log.e(TAG, "User data is changed!" + resultfield.name + ", " + resultfield.gritscore + ", " + resultfield.survey);

                // Display newly updated data
                txtuser.setText(resultfield.name + ", " + resultfield.gritscore + ", " + resultfield.survey);

//                //set result to textview from resultfield objects
//                resultTv.setText(resultfield.gritscore);

                // clear edit text
                /*inputname.setText("");
                resultTv.setText("");
                surveyTv.setText("");*/

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
            mFirebaseDatabase.child(UserID).child("name").setValue(name);

        if (!TextUtils.isEmpty(result))
            mFirebaseDatabase.child(UserID).child("result").setValue(result);

        if (!TextUtils.isEmpty(survey))
            mFirebaseDatabase.child(UserID).child("survey").setValue(survey);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            savedInstanceState.getString("key");
        }
    }

    /*this method is called after mainactivity mthod. carried data is displayed finallay*/
    public void updateData(String data){
        newdata = data;
        resultTv.setText(newdata);
        

        //seperating settext string into two values so i can make % value bold
        Double valuedouble = Double.valueOf(newdata);
        if (0 <= valuedouble && valuedouble <= 1.5) {
            surveyTv.setText("You Scored higher than about 10 % of Nepali Adult");

        }else if ( 1.5 < valuedouble && valuedouble <= 3.15) {
            surveyTv.setText("You Scored higher than about 35% of Nepali Adult");

        }else if ( 3.15 < valuedouble && valuedouble <= 4.0) {
            surveyTv.setText("You Scored higher than about 50% of Nepali Adult");

        }else if ( 4.0 < valuedouble && valuedouble <= 5.0) {
            surveyTv.setText("You Scored higher than about 65% of Nepali Adult");

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("key", newdata);
    }

}
