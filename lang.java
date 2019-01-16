package com.app.kitsos.arduinoinstructions;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.app.kitsos.arduinoinstructions";


    String la;
    ListView listaki;
    String names[] = {"Blinking led","Traffic lights","Fading Led","RGB Led","Servo","Button & Led","Potentiometer & Led","Photoresistor","Temperature","Soil Sensor","Raindrop Sensor","Gas Detaction"}; //getResources().getStringArray(R.array.car_array); //{getString(R.string.prjct1),getString(R.string.prjct2),getString(R.string.prjct3),getString(R.string.prjct4),getString(R.string.prjct5),getString(R.string.prjct6),getString(R.string.prjct7),getString(R.string.prjct8)};
    String infopro[] = {"Blinking led","Traffic lights","Fading Led","RGB Led","Button & Led","Potentiometer & Led","Photoresistor","Temperature"};
    int images[] = {R.drawable.ledicon,R.drawable.tficon2,R.drawable.fadeicon,R.drawable.rgbicon, R.drawable.servoicon,R.drawable.btnicon,R.drawable.poticon,R.drawable.photoicon,R.drawable.tempicon,R.drawable.soilicon,R.drawable.dropicon,R.drawable.gasicon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        loadLocale();



//        String namestemp[] = getResources().getStringArray(R.array.car_array);
//        Toast.makeText(this, namestemp[2], Toast.LENGTH_SHORT).show();

       // setTitle("Arduino Projects");

        listaki = (ListView)findViewById(R.id.listakiprojects);

        MainActivity.CustomAdapter ca = new MainActivity.CustomAdapter();

        listaki.setAdapter(ca);
        listaki.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




                Intent intent = new Intent(MainActivity.this, Main3Activity.class);

                TextView tempokota = (TextView)view.findViewById(R.id.customtxt);
                String tttt = (String) tempokota.getText();


               // String message = "Blinking Led";
                intent.putExtra("projectname", tttt);
                intent.putExtra("projectid", i);
                startActivity(intent);
                //finish();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater min = getMenuInflater();
        min.inflate(R.menu.menu_main3,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_language:
                changelanguage();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void changelanguage()
    {
        
        String[] languageslist = {"English","Greek","Italic"};
        final AlertDialog.Builder mbuilder = new AlertDialog.Builder(this);
        mbuilder.setTitle("Choose Language");

        mbuilder.setSingleChoiceItems(languageslist, returnidlang(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)
                {
                    setLocal("en");
                    recreate();
                }
                else if(i==1)
                {
                    setLocal("el");
                    recreate();
                }
                else if(i==2)
                {
                    setLocal("it");
                    recreate();
                }
                dialogInterface.dismiss();
            }

        });

        AlertDialog mdialog2 = mbuilder.create();
        mdialog2.show();
    }

    private void setLocal(String s)
    {
        Locale locale = new Locale(s);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang",s);
        editor.apply();

    }

    public void loadLocale()
    {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_lang","");
        la = language;
        setLocal(language);

    }

    public int returnidlang()
    {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_lang","");
       //Toast.makeText(this, language, Toast.LENGTH_SHORT).show();
        if(language.equals("el"))
        {
            //Toast.makeText(this, "ellll", Toast.LENGTH_SHORT).show();
            return 1;
        }
        else if(language.equals("en"))
            return 0;
        else if(language.equals("it"))
            return 2;
        else{
            return -1;
        }
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list_projects,null);


            ImageView imgaki = (ImageView)view.findViewById(R.id.customimage);
            TextView textaki = (TextView)view.findViewById(R.id.customtxt);
           // TextView textaki2 = (TextView)view.findViewById(R.id.dtxt);


            imgaki.setImageResource(images[i]);
           // textaki2.setText(infopro[i]);
            textaki.setText(names[i]);

            return view;
        }
    }
}
