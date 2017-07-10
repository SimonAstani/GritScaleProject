package com.sumanastani.np.glirtproject.fragments;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sumanastani.np.glirtproject.R;
import com.sumanastani.np.glirtproject.object.ResultField;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Simon on 2/1/2017.
 */

public class GlobalResultFragment extends Fragment {
    private RecyclerView mglobalrecycleResult;
    private LinearLayoutManager mlinearLayoutManager;
    //recycler adapter
    //@param <object,viewholder>
    private FirebaseRecyclerAdapter<ResultField, GlobalResultViewHolder> mfirebaseAdapter;
    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    public static final String USERS = "users";
    private SwipeRefreshLayout swipeContainer;


    public GlobalResultFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //viewholder for recycle view

    public static class GlobalResultViewHolder extends RecyclerView.ViewHolder {
        public TextView gritname, gritscore, gritsurvey, gritupdateresult;

        public GlobalResultViewHolder(View itemView) {
            super(itemView);
            gritname = (TextView) itemView.findViewById(R.id.globeGritName);
            gritscore = (TextView) itemView.findViewById(R.id.globeGritScore);
            gritsurvey = (TextView) itemView.findViewById(R.id.globeGritSurvey);
            gritupdateresult = (TextView) itemView.findViewById(R.id.globeupdateScire);

            //dynamically change back ground color if textview from own custom cplor

            Random r = new Random();
            int red=r.nextInt(255 - 0 + 1)+0;
            int green=r.nextInt(255 - 0 + 1)+0;
            int blue=r.nextInt(255 - 0 + 1)+0;

            GradientDrawable draw = new GradientDrawable();
            draw.setShape(GradientDrawable.OVAL);
            draw.setColor(Color.rgb(red,green,blue));
            draw.setSize(120, 120);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                gritscore.setBackground(draw);
            }

            /*List<String> colors;

            colors=new ArrayList<String>();
            colors.add( "4a148c" + "6a1b9a "+ "7b1fa2"+ "880e4f"+ "ad1457"+ "c2185b"+ "d81b60"+ "b71c1c"+ "d32f2f"+
                    "1a237e"+ "283593"+ "303f9f"+ "303f9f"+ "1565c0"+ "1976d2"+ "37474f"+ "263238"+ "546e7a"+ "e65100"+ "ef6c00"+ "ffa000"+
                    "00c853"+ "00e676"+ "69f0ae"+ "b9f6ca"+ "01579b"+ "0277bd"+ "0288d1"+ "039be5"+ "b71c1c"+ "c62828");

        *//*    String[] mColors = {
                    "4a148c", "6a1b9a ", "7b1fa2", "880e4f", "ad1457", "c2185b", "d81b60", "b71c1c", "d32f2f",
                    "1a237e", "283593", "303f9f", "303f9f", "1565c0", "1976d2", "37474f", "263238", "546e7a", "e65100", "ef6c00", "ffa000",
                    "00c853", "00e676", "69f0ae", "b9f6ca", "01579b", "0277bd", "0288d1", "039be5", "b71c1c", "c62828"};
*//*
            Random r = new Random();
            int i1 = r.nextInt(30-0)+0;

            //genrating shape with colors
            GradientDrawable draw = new GradientDrawable();
            draw.setShape(GradientDrawable.OVAL);
            draw.setSize(100, 100);
            draw.setColor(Color.parseColor("#" + colors.get(i1)));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                gritscore.setBackground(draw);
            }*/
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflating the layout for tab fragment,,
        View rootview = inflater.inflate(R.layout.globalresult, container, false);

        //recycleview
        mglobalrecycleResult = (RecyclerView) rootview.findViewById(R.id.globeResult);
        mglobalrecycleResult.setHasFixedSize(true);

        //linear layout manager for recycle view
        mlinearLayoutManager = new LinearLayoutManager(getActivity());
        mlinearLayoutManager.setStackFromEnd(true);

        //refresh layout in recycleview
        swipeContainer = (SwipeRefreshLayout) rootview.findViewById(R.id.swipeContainer);
        swipeContainer.setColorSchemeResources(R.color.colorAccent);
        loadItem();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadItem();
                swipeContainer.setRefreshing(false);

            }
        });

        return rootview;
    }

    public void loadItem() {
        //send a query to database
        //Database Initialization get instance of firebase app that is link in json folder
        mdatabaseReference = FirebaseDatabase.getInstance().getReference();
        mfirebaseAdapter = new FirebaseRecyclerAdapter<ResultField, GlobalResultViewHolder>(
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

        mfirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
               /* int roomCount = mfirebaseAdapter.getItemCount();
                int lastVisiblePosition = mlinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (roomCount - 1) && lastVisiblePosition == (positionStart - 1))) {
                    mglobalrecycleResult.scrollToPosition(positionStart);
                }*/
               mglobalrecycleResult.scrollToPosition(positionStart);
            }
        });
        mglobalrecycleResult.setLayoutManager(mlinearLayoutManager);
        mglobalrecycleResult.setAdapter(mfirebaseAdapter);

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
