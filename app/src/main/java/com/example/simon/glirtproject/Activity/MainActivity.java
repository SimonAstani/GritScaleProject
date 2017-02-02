package com.example.simon.glirtproject.Activity;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RadioGroup;

import com.example.simon.glirtproject.Adapter.TabpagerAdapter;
import com.example.simon.glirtproject.R;
import com.example.simon.glirtproject.fragments.gritFragment;

public class MainActivity extends AppCompatActivity {
    private float value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, total;
    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7,
            radioGroup8, radioGroup9, radioGroup10, radioGroup11, radioGroup12;
    FloatingActionButton fab;
    private ViewPager mviewPager;
    private TabLayout mTabLayout;
    //tabpagerAdapter is a custom adapter class that provides fragment required for view pager
    private TabpagerAdapter tabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fab = (FloatingActionButton) findViewById(R.id.fab);

        radiobuttonlogic();
        floatingbuttonlogic();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mviewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mviewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mviewPager);


    }

    private void setupViewPager(ViewPager mviewPager) {
        tabPagerAdapter = new TabpagerAdapter(getSupportFragmentManager());
        tabPagerAdapter.addFragment(new gritFragment(), "GritScale");
        tabPagerAdapter.addFragment(new gritFragment(), "Result");
        tabPagerAdapter.addFragment(new gritFragment(), "AboutGrit");
        mviewPager.setAdapter(tabPagerAdapter);

    }


    /*This method contains logic of radio button and value assigned to it.*/
    public void radiobuttonlogic() {
        LayoutInflater layoutInflater= (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.single_row, null);

        radioGroup1 = (RadioGroup) popupView.findViewById(R.id.radiogroup1);
        radioGroup2 = (RadioGroup) popupView.findViewById(R.id.radiogroup2);
        radioGroup3 = (RadioGroup) popupView.findViewById(R.id.radiogroup3);
        radioGroup4 = (RadioGroup) popupView.findViewById(R.id.radiogroup4);
        radioGroup5 = (RadioGroup) popupView.findViewById(R.id.radiogroup5);
        radioGroup6 = (RadioGroup) popupView.findViewById(R.id.radiogroup6);
        radioGroup7 = (RadioGroup) popupView.findViewById(R.id.radiogroup7);
        radioGroup8 = (RadioGroup) popupView.findViewById(R.id.radiogroup8);
        radioGroup9 = (RadioGroup) popupView.findViewById(R.id.radiogroup9);
        radioGroup10 = (RadioGroup) popupView.findViewById(R.id.radiogroup10);
        radioGroup11 = (RadioGroup) popupView.findViewById(R.id.radiogroup11);
        radioGroup12 = (RadioGroup) popupView.findViewById(R.id.radiogroup12);


        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        value1 = 5;
                        break;
                    case R.id.radio2:
                        value1 = 4;
                        break;
                    case R.id.radio3:
                        value1 = 3;
                        break;
                    case R.id.radio4:
                        value1 = 2;
                        break;
                    case R.id.radio5:
                        value1 = 1;
                        break;
                }
            }
        });
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio14:
                        value4 = 5;
                        break;
                    case R.id.radio24:
                        value4 = 4;
                        break;
                    case R.id.radio34:
                        value4 = 3;
                        break;
                    case R.id.radio44:
                        value4 = 2;
                        break;
                    case R.id.radio54:
                        value4 = 1;
                        break;
                }
            }
        });
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio16:
                        value6 = 5;
                        break;
                    case R.id.radio26:
                        value6 = 4;
                        break;
                    case R.id.radio36:
                        value6 = 3;
                        break;
                    case R.id.radio46:
                        value6 = 2;
                        break;
                    case R.id.radio56:
                        value6 = 1;
                        break;
                }
            }
        });
        radioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio19:
                        value9 = 5;
                        break;
                    case R.id.radio29:
                        value9 = 4;
                        break;
                    case R.id.radio39:
                        value9 = 3;
                        break;
                    case R.id.radio49:
                        value9 = 2;
                        break;
                    case R.id.radio59:
                        value9 = 1;
                        break;
                }
            }
        });
        radioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio110:
                        value10 = 5;
                        break;
                    case R.id.radio210:
                        value10 = 4;
                        break;
                    case R.id.radio310:
                        value10 = 3;
                        break;
                    case R.id.radio410:
                        value10 = 2;
                        break;
                    case R.id.radio510:
                        value10 = 1;
                        break;
                }
            }
        });
        radioGroup12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio112:
                        value12 = 5;
                        break;
                    case R.id.radio212:
                        value12 = 4;
                        break;
                    case R.id.radio312:
                        value12 = 3;
                        break;
                    case R.id.radio412:
                        value12 = 2;
                        break;
                    case R.id.radio512:
                        value12 = 1;
                        break;
                }
            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio12:
                        value2 = 1;
                        break;
                    case R.id.radio22:
                        value2 = 2;
                        break;
                    case R.id.radio32:
                        value2 = 3;
                        break;
                    case R.id.radio42:
                        value2 = 4;
                        break;
                    case R.id.radio52:
                        value2 = 5;
                        break;
                }
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio13:
                        value3 = 1;
                        break;
                    case R.id.radio23:
                        value3 = 2;
                        break;
                    case R.id.radio33:
                        value3 = 3;
                        break;
                    case R.id.radio43:
                        value3 = 4;
                        break;
                    case R.id.radio53:
                        value3 = 5;
                        break;
                }
            }
        });
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio15:
                        value5 = 1;
                        break;
                    case R.id.radio25:
                        value5 = 2;
                        break;
                    case R.id.radio35:
                        value5 = 3;
                        break;
                    case R.id.radio45:
                        value5 = 4;
                        break;
                    case R.id.radio55:
                        value5 = 5;
                        break;
                }
            }
        });
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio17:
                        value7 = 1;
                        break;
                    case R.id.radio27:
                        value7 = 2;
                        break;
                    case R.id.radio37:
                        value7 = 3;
                        break;
                    case R.id.radio47:
                        value7 = 4;
                        break;
                    case R.id.radio57:
                        value7 = 5;
                        break;
                }
            }
        });
        radioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio18:
                        value8 = 1;
                        break;
                    case R.id.radio28:
                        value8 = 2;
                        break;
                    case R.id.radio38:
                        value8 = 3;
                        break;
                    case R.id.radio48:
                        value8 = 4;
                        break;
                    case R.id.radio58:
                        value8 = 5;
                        break;
                }
            }
        });
        radioGroup11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio111:
                        value11 = 1;
                        break;
                    case R.id.radio211:
                        value11 = 2;
                        break;
                    case R.id.radio311:
                        value11 = 3;
                        break;
                    case R.id.radio411:
                        value11 = 4;
                        break;
                    case R.id.radio511:
                        value11 = 5;
                        break;
                }
            }
        });
    }

    /*This method contains logic of floation action button where restult are displayed accoring to value obtained*/
    private void floatingbuttonlogic() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioGroup1.getCheckedRadioButtonId() == -1 || radioGroup2.getCheckedRadioButtonId() == -1 ||
                        radioGroup3.getCheckedRadioButtonId() == -1 || radioGroup4.getCheckedRadioButtonId() == -1 ||
                        radioGroup5.getCheckedRadioButtonId() == -1 || radioGroup6.getCheckedRadioButtonId() == -1 ||
                        radioGroup7.getCheckedRadioButtonId() == -1 || radioGroup8.getCheckedRadioButtonId() == -1 ||
                        radioGroup9.getCheckedRadioButtonId() == -1 || radioGroup10.getCheckedRadioButtonId() == -1 ||
                        radioGroup11.getCheckedRadioButtonId() == -1 || radioGroup12.getCheckedRadioButtonId() == -1) {

                    Snackbar.make(view, "Please check atleast one answer from each Before Submitting", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    total = (value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8 + value9 + value10 + value11 + value12) / 12;
                    DecimalFormat formater = new DecimalFormat("#.##");
                    String twoDigitNo = formater.format(total);

                    Intent intent = new Intent(getApplicationContext(), REsult.class);
                    intent.putExtra("Gritvalue", twoDigitNo);
                    startActivity(intent);


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

        return super.onOptionsItemSelected(item);
    }
}
