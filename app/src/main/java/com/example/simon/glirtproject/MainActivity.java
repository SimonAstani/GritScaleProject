package com.example.simon.glirtproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float value1, value2, value3, value4, value5,value6,value7,value8,value9,value10,value11,value12, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup2);
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.radiogroup3);
        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radiogroup4);
        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.radiogroup5);
        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.radiogroup6);
        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.radiogroup7);
        RadioGroup radioGroup8 = (RadioGroup) findViewById(R.id.radiogroup8);
        RadioGroup radioGroup9 = (RadioGroup) findViewById(R.id.radiogroup9);
        RadioGroup radioGroup10 = (RadioGroup) findViewById(R.id.radiogroup10);
        RadioGroup radioGroup11 = (RadioGroup) findViewById(R.id.radiogroup11);
        RadioGroup radioGroup12 = (RadioGroup) findViewById(R.id.radiogroup12);
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
                        value4= 3;
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

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float total = (value1 + value2+value3+value4+value5+value6+value7+value8+value9+value10+value11+value12)/12;
                Toast.makeText(MainActivity.this, "your grit is" + total, Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "Replace with your own action" + total, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
