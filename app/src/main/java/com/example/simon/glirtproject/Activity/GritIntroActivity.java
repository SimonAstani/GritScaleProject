package com.example.simon.glirtproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.expandablelayout.library.ExpandableLayoutListView;
import com.example.simon.glirtproject.R;


public class GritIntroActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grit_intro);

        String[] array = getResources().getStringArray(R.array.gritIntro_Question);
         textView = (TextView) findViewById(R.id.header_text);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.view_row, R.id.header_text,array);
        final ExpandableLayoutListView expandableLayoutListView = (ExpandableLayoutListView) findViewById(R.id.listview);

        expandableLayoutListView.setAdapter(arrayAdapter);
        expandableLayoutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] answer = getResources().getStringArray(R.array.gritIntro_Answer);
                String value = (String) expandableLayoutListView.getItemAtPosition(position);
                Toast.makeText(GritIntroActivity.this, ""+ value, Toast.LENGTH_SHORT).show();
                textView.setText(value);
                if (position == 0){
                    textView.setText(answer[0]);
                }else if(position ==1){
                    textView.setText(answer[1]);
                }


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO: 3/6/17  need to work on toolbar in grit intro activity
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //do something
            return true;
        }
        if (id == R.id.about) {
            String myweb = "http://www.sumanastani.com.np";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(myweb));
            startActivity(i);
        }
        if (id == R.id.share) {
            Intent share = new Intent(Intent.ACTION_SEND);
            String message = getResources().getString(R.string.shareResult);
            share.putExtra(android.content.Intent.EXTRA_TEXT, message);
            share.setType("text/plain");
            startActivity(Intent.createChooser(share, "share in social media"));
        }
        if (id == R.id.about_grit){
            startActivity(new Intent(getApplicationContext(),GritIntroActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
