package com.example.simon.glirtproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.simon.glirtproject.R;
import com.example.simon.glirtproject.object.ResultField;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Simon on 2/1/2017.
 */

public class GlobalResultFragment extends Fragment {
    private RecyclerView mglobalrecycleResult;
    private LinearLayoutManager mlinearLayoutManager;
    //recycler adapter
    //@param <object,viewholder>
    private FirebaseRecyclerAdapter<ResultField,GlobalResultViewHolder> mfirebaseAdapter;
    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    public static final String USERS = "users";


    public GlobalResultFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //viewholder for recycle view
    public static class GlobalResultViewHolder extends RecyclerView.ViewHolder{
        public TextView gritname,gritscore,gritsurvey,gritupdateresult;

        public GlobalResultViewHolder(View itemView) {
            super(itemView);
            gritname = (TextView) itemView.findViewById(R.id.globeGritName);
            gritscore = (TextView) itemView.findViewById(R.id.globeGritScore);
            gritsurvey = (TextView) itemView.findViewById(R.id.globeGritSurvey);
            gritupdateresult = (TextView) itemView.findViewById(R.id.globeupdateScire);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflating the layout for tab fragment,,
        View rootview = inflater.inflate(R.layout.globalresult,container,false);
        //recycleview
        mglobalrecycleResult = (RecyclerView) rootview.findViewById(R.id.globeResult);
        mglobalrecycleResult.setHasFixedSize(true);
        //linear layout manager for recycle view
        mlinearLayoutManager = new LinearLayoutManager(getActivity());
        mlinearLayoutManager.setStackFromEnd(true);
        //send a query to database
        //Database Initialization get instance of firebase app that is link in json folder
        mdatabaseReference = FirebaseDatabase.getInstance().getReference();
        mfirebaseAdapter = new FirebaseRecyclerAdapter<ResultField,GlobalResultViewHolder>(
                ResultField.class,
                R.layout.globe_cardvw_result,
                GlobalResultViewHolder.class,
                mdatabaseReference.child(USERS)) {

            @Override
            protected void populateViewHolder(GlobalResultViewHolder viewHolder, ResultField result, int position) {
                viewHolder.gritname.setText(result.getName());
                viewHolder.gritscore.setText(result.getGritscore());
                viewHolder.gritsurvey.setText(result.getSurvey());
            }
        };

        mfirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount){
                super.onItemRangeInserted(positionStart, itemCount);
                int roomCount = mfirebaseAdapter.getItemCount();
                int lastVisiblePosition = mlinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (roomCount -1) && lastVisiblePosition == (positionStart -1))){
                    mglobalrecycleResult.scrollToPosition(positionStart);
                }
            }
        });
        mglobalrecycleResult.setLayoutManager(mlinearLayoutManager);
        mglobalrecycleResult.setAdapter(mfirebaseAdapter);

        return rootview;
    }

    @Override
    public void onStart() {
        super.onStart();

    }



}
