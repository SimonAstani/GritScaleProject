package com.sumanastani.np.glirtproject.Activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.sumanastani.np.glirtproject.Adapter.ExpandableListAdapter;
import com.sumanastani.np.glirtproject.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GritIntroActivity extends AppCompatActivity {
    private static ExpandableListView expandableListView;
    private static ExpandableListAdapter adapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grit_intro);

        expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);
        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);

        setItems();
        //setListener();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //enable action bar icon and toogle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //incase you need to change icon
        toolbar.setNavigationIcon(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_arrow_back_white_24dp));

    }

    private void setItems() {

        String[] Question_array = getResources().getStringArray(R.array.gritIntro_Question);
        String[] Answer_array = getResources().getStringArray(R.array.gritIntro_Answer);
        // Array list for header
        ArrayList<String> header = new ArrayList<String>();

        // Array list for child items
        List<String> child1 = new ArrayList<String>();
        List<String> child2 = new ArrayList<String>();
        List<String> child3 = new ArrayList<String>();
        List<String> child4 = new ArrayList<String>();
        List<String> child5 = new ArrayList<String>();
        List<String> child6 = new ArrayList<String>();
        List<String> child7 = new ArrayList<String>();
        List<String> child8 = new ArrayList<String>();
        List<String> child9 = new ArrayList<String>();
        List<String> child10 = new ArrayList<String>();
        List<String> child11 = new ArrayList<String>();
        List<String> child12 = new ArrayList<String>();
        List<String> child13 = new ArrayList<String>();
        List<String> child14 = new ArrayList<String>();
        List<String> child15 = new ArrayList<String>();
        child1.add(Answer_array[0]);
        child2.add(Answer_array[1]);
        child3.add(Answer_array[2]);
        child4.add(Answer_array[3]);
        child5.add(Answer_array[4]);
        child6.add(Answer_array[5]);
        child7.add(Answer_array[6]);
        child8.add(Answer_array[7]);
        child9.add(Answer_array[8]);
        child10.add(Answer_array[9]);
        child11.add(Answer_array[10]);
        child12.add(Answer_array[11]);
        child13.add(Answer_array[12]);
        child14.add(Answer_array[13]);
        child15.add(Answer_array[14]);

        // Hash map for both header and child
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

        // Adding headers to list
        for (int i = 0; i <= 14; i++) {
            header.add(Question_array[i]);
        }

        // Adding header and childs to hash map
        hashMap.put(header.get(0), child1);
        hashMap.put(header.get(1), child2);
        hashMap.put(header.get(2), child3);
        hashMap.put(header.get(3), child4);
        hashMap.put(header.get(4), child5);
        hashMap.put(header.get(5), child6);
        hashMap.put(header.get(6), child7);
        hashMap.put(header.get(7), child8);
        hashMap.put(header.get(8), child9);
        hashMap.put(header.get(9), child10);
        hashMap.put(header.get(10), child11);
        hashMap.put(header.get(11), child12);
        hashMap.put(header.get(12), child13);
        hashMap.put(header.get(13), child14);
        hashMap.put(header.get(14), child15);

        adapter = new ExpandableListAdapter(GritIntroActivity.this, header, hashMap);
        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
