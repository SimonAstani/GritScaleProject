package com.example.simon.glirtproject.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.simon.glirtproject.Adapter.TabpagerAdapter;
import com.example.simon.glirtproject.Interface.ResultPass;
import com.example.simon.glirtproject.R;
import com.example.simon.glirtproject.fragments.GlobalResultFragment;
import com.example.simon.glirtproject.fragments.GritFragment;
import com.example.simon.glirtproject.fragments.ResultFragment;

/*new feature brach*/

public class MainActivity extends AppCompatActivity implements ResultPass {
    private ViewPager mviewPager;
    private TabLayout mTabLayout;
    //tabpagerAdapter is a custom adapter class that provides fragment required for view pager
    private TabpagerAdapter tabPagerAdapter;
    private TextView gritInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //changing grit info dynamicially in time
        gritInfo = (TextView) findViewById(R.id.gritIntro);
        changeGritText();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //viewpager defines swipe behaviour of fragment
        mviewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mviewPager);

        //tablayout changes the page based on tab clicked
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mviewPager);
    }

    //change the collapsing toolbar text dynamically

    private void changeGritText() {
        final String[] gritArray = getResources().getStringArray(R.array.gritInformation);
        final Handler gritInfoHanlder = new Handler();
        gritInfoHanlder.post(new Runnable() {

                int tipPosition = 0;
            @Override
            public void run() {
                //set number of tip(randon/another way)
                gritInfo.setText(gritArray[tipPosition]);
                tipPosition++;
                if (tipPosition == gritArray.length) {
                    gritInfoHanlder.removeCallbacks(this);
                } else {
                    gritInfoHanlder.postDelayed(this, 1000 * 3);
                }
            }
        });
    }

    //this method implement methods from tabpagerAdpater that is used to add fragment and title
    private void setupViewPager(ViewPager mviewPager) {
        tabPagerAdapter = new TabpagerAdapter(getSupportFragmentManager());
        tabPagerAdapter.addFragment(new GritFragment(), "GritScale");
        tabPagerAdapter.addFragment(new ResultFragment(), "Your Result");
        tabPagerAdapter.addFragment(new GlobalResultFragment(), "Global Result");
        mviewPager.setAdapter(tabPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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


    /*onFaBClicked must be implemtented when we are traying to communicate bewtween fragments inside tab7
    * steps: 1. implements interface and use method777
    * 2. create new obect of fragment that we are trying to ssend data finaaly
    * 3.. tabpaggeAdapter.getItem(@param positon of the tab here 1 for second tab)
    * 4. update the data in the final*/
    @Override
    public void onFabClicked(String data) {
        ResultFragment RF = (ResultFragment) tabPagerAdapter.getItem(1);
        RF.updateData(data);
    }
}
