package com.sumanastani.np.glirtproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sumanastani.np.glirtproject.R;
import com.sumanastani.np.glirtproject.object.ResultField;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Simon on 2/1/2017.
 */

public class ResultFragment extends Fragment {
    private static final String TAG = ResultFragment.class.getSimpleName();
    //    private Button fabpush;
    private FloatingActionButton fabpush;
    private EditText inputname;
    ProgressBar progressBarResult;
    private TextView resultTv, surveyTv, txtuser;
    private String UserID;
    private FirebaseDatabase mfirebaseInstance;
    private DatabaseReference mFirebaseDatabase;
    String newdata;

    public ResultFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        //inflating the layout for tab fragment,,
        View rootview = inflater.inflate(R.layout.activity_result, container, false);

        //initializing the field
        fabpush = (FloatingActionButton) rootview.findViewById(R.id.fabpush);

        //fabpush = (Button) rootview.findViewById(R.id.push);
        inputname = (EditText) rootview.findViewById(R.id.inputName);
        resultTv = (TextView) rootview.findViewById(R.id.resultTv);
        surveyTv = (TextView) rootview.findViewById(R.id.surveyTv);
//        txtuser = (TextView) rootview.findViewById(R.id.txt_users);
        progressBarResult = (ProgressBar) rootview.findViewById(R.id.progressBarResult);

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
                Log.e(TAG, "onCancelled:Failed ot read app title value ", databaseError.toException());
            }
        });

        //save on button click
        fabpush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputname.getText().toString();
                String result = resultTv.getText().toString();
                String survey = surveyTv.getText().toString();


                /*making sure to input name before pushing to cloud*/
                if (TextUtils.isEmpty(survey)){
                    Toast.makeText(getActivity(), "Please ! Answer 12 set Of Question to find your grit score", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(name)) {
                    inputname.setError("make sure you input your name");
                }
                //check for already existed Gritscale
                else if (TextUtils.isEmpty(UserID)) {
                    Toast.makeText(getActivity(), "Information Pushed. View Others result in Global Result tab", Toast.LENGTH_LONG).show();
                    createUser(name, result, survey);
                } else {
                    Toast.makeText(getActivity(), "Information updated to Cloud", Toast.LENGTH_LONG).show();
                    updateUser(name, result, survey);
                }
            }
        });
        toogleButton();

        return rootview;
    }

    private void toogleButton() {
        if (TextUtils.isEmpty(UserID)) {
            fabpush.setImageResource(R.drawable.ic_cloud_check_white_24dp);
            //            fabpush.setText("save");
        } else {
            fabpush.setImageResource(R.drawable.ic_cloud_upload_white_24dp);
            //            fabpush.setText("Update");
        }
    }

    private void createUser(String name, String result, String survey) {
        // In real apps this gritscale should be fetched
        // by implementing firebase auth
        if (TextUtils.isEmpty(UserID)) {
            UserID = mFirebaseDatabase.push().getKey();
        }

        ResultField resultfield = new ResultField(name, result, survey);

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
                if (resultfield == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }
                Log.e(TAG, "User data is changed!" + resultfield.name + ", " + resultfield.gritscore + ", " + resultfield.survey);

                // Display newly updated data
//                txtuser.setText(resultfield.name + ", " + resultfield.gritscore + ", " + resultfield.survey);

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
    public void updateData(String data) {
        newdata = data;
        resultTv.setText(newdata);

        /*little trick to display string newdata to progressbar. We converted to Dobule multiply it to convert
        * to integer as progress bas only accept the int datatypes.
        * then finally setprogress in value after conversion to int :)*/

        Double value = Double.parseDouble(newdata);
        value = value * 10000;
        int valueprogress = value.intValue();
        progressBarResult.setMax(5 * 10000);
        progressBarResult.setProgress(valueprogress);

        //seperating settext string into two values so i can make % value bold
        Double valuedouble = Double.valueOf(newdata);
        if (0 <= valuedouble && valuedouble <= 1.5) {
            surveyTv.setText("Scored higher than about 10 % of Nepali Adult");
        } else if (1.5 < valuedouble && valuedouble <= 3.15) {
            surveyTv.setText("Scored higher than about 35% of Nepali Adult");
        } else if (3.15 < valuedouble && valuedouble <= 4.0) {
            surveyTv.setText("Scored higher than about 50% of Nepali Adult");
        } else if (4.0 < valuedouble && valuedouble <= 5.0) {
            surveyTv.setText("Scored higher than about 75% of Nepali Adult");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key", newdata);
    }
}
