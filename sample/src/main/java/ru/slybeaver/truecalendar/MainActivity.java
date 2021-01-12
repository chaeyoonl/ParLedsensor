package ru.slybeaver.truecalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import ru.slybeaver.slycalendarview.SlyCalendarDialog;



import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements SlyCalendarDialog.Callback {
    TextView tryText;
    TextView cadText;
    TextView usdText;
    TextView jpyText;
    TextView chfText;
    TextView ledText;
    TextView ledText3;
    TextView ledText4;

    String ss="";
    String ss2="";
    String ss3="";
    String ss4="";
    String ss5="";
    String ss6="";
    String ss7="";
    String ss8="";

    String resultss="";

    int ih = 0;
    TabHost tabHost;

    Button btnShowCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (TabHost) findViewById(R.id.tabhost1);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("1").setContent(R.id.tab1).setIndicator("메인");

        TabHost.TabSpec tab2 = tabHost.newTabSpec("2").setContent(R.id.tab2).setIndicator("조회");

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);


        tryText = findViewById(R.id.tryText);
        cadText = findViewById(R.id.cadText);
        usdText = findViewById(R.id.usdText);
        jpyText = findViewById(R.id.jpyText);
        chfText = findViewById(R.id.chfText);
        ledText = findViewById(R.id.ledText2);
        ledText3 = findViewById(R.id.ledText3);
        ledText4 = findViewById(R.id.ledText4);

        Date currentTime = Calendar.getInstance().getTime();
        String date_text = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault()).format(currentTime);
        btnShowCalendar = (Button) findViewById(R.id.btnShowCalendar);
        btnShowCalendar.setText(new SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault()).format(currentTime));

        Button button;
        button = findViewById(R.id.buttons);
        button.performClick();

        findViewById(R.id.btnShowCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SlyCalendarDialog()
                        .setSingle(false)
                        .setFirstMonday(false)
                        .setCallback(MainActivity.this)
                        .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");
            }
        });
    }

    public void getRates(View view) {
        DownloadData downloadData = new DownloadData();
        DownloadData downloadData2 = new DownloadData();

        try {
            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParData";
            downloadData.execute(url);

        } catch (Exception e) {
            Log.i("MyTag","Fail");
        }

        try {

            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getLedData";
            downloadData2.execute(url);
        } catch (Exception e) {
            Log.i("MyTag","Fail");
        }


    }

    private class DownloadData extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;
            Log.i("MyTag","http");

            try {
                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);



                int data = inputStreamReader.read();

                while (data > 0) {
                    char character =(char) data;
                    result += character;

                    data = inputStreamReader.read();
                }
                return result;

            } catch (Exception e) {
                return null;
            }


        }

        @Override
        protected void onPostExecute(String s) {
            //Log.i("Results_string",s);
            super.onPostExecute(s);

            Log.i("MyTag",s);
            //jpyText.setText(s);

            //System.out.println("Alınan data:" + s);

            try {
                Log.i("Results_string", "let's see it");
                Log.i("Results_string", s);
                resultss += s;
                Log.i("Results", resultss);
                //jpyText.setText(s);


                JSONArray jsonArray = null;
                JSONArray jsonArray2 = null;
                if (ih == 0) {
                    jsonArray = new JSONArray(s);
                } else {
                    jsonArray2 = new JSONArray(s);
                }


/*                String par1 = resultss.substring(resultss.lastIndexOf("par1"));
                ss = par1;
                usdText.setText(ss);*/

                if (ih == 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);

                        String par1 = jo.getString("par1");
                        String par2 = jo.getString("par2");
                        String par3 = jo.getString("par3");
                        String par4 = jo.getString("par4");

/*                    String par1= jo.getString("led1");
                    String par2= jo.getString("led2");
                    String par3= jo.getString("led3");
                    String par4= jo.getString("led4");*/
                        //String led1= jo.getString("led1");


                        ss = par1;
                        ss2 = par2;
                        ss3 = par3;
                        ss4 = par4;


                        //ss5 = led1;
                        //System.out.println("base:" + ss);


                        chfText.setText(ss);
                        usdText.setText(ss2);
                        jpyText.setText(ss3);
                        tryText.setText(ss4);


                        //cadText.setText(ss5);
                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);
                    }
                }else {
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        JSONObject jo = jsonArray2.getJSONObject(i);


                        String led1 = jo.getString("led1");
                        String led2= jo.getString("led2");
                        String led3 = jo.getString("led3");
                        String led4= jo.getString("led4");

                        Log.i("My Tags", led1);
                        Log.i("My Tags", led2);
                        Log.i("My Tags", led3);
                        Log.i("My Tags", led4);

                        if (led1.contains("0")) {
                            ss5 = "OFF";
                        }else if (led1.contains("1")) {
                            ss5 = "ON";
                        }else{
                            ss5 = "ERR";
                        }

                        if (led2.contains("0")) {
                            ss6 = "OFF";
                        }else if (led2.contains("1")) {
                            ss6 = "ON";
                        }else{
                            ss6 = "ERR";
                        }

                        if (led3.contains("0")) {
                            ss7 = "OFF";
                        }else if (led3.contains("1")) {
                            ss7 = "ON";
                        }else{
                            ss7 = "ERR";
                        }

                        if (led4.contains("0")) {
                            ss8 = "OFF";
                        }else if (led4.contains("1")) {
                            ss8 = "ON";
                        }else{
                            ss8 = "ERR";
                        }


/*                        ss5 = led1;
                        ss6 = led2;
                        ss7 = led3;
                        ss8 = led4;*/

                        cadText.setText(ss5);
                        ledText.setText(ss6);
                        ledText3.setText(ss7);
                        ledText4.setText(ss8);



                    }
                }






                ih++;







/*

                JSONObject jsonObject = new JSONObject(s);
                String base = jsonObject.getString("base");
                //System.out.println("base:" + base);

                String rates = jsonObject.getString("rates");
                //System.out.print("rates:" + rates);

                JSONObject jsonObject1 = new JSONObject(rates);
                String turkishLira = jsonObject1.getString("TRY");
                tryText.setText("TRY: " + turkishLira);
                String usd = jsonObject1.getString("USD");
                usdText.setText("USD: " + usd);
                String cad = jsonObject1.getString("CAD");
                cadText.setText("CAD: " + cad);
                String chf = jsonObject1.getString("CHF");
                chfText.setText("CHF: " + chf);
                String jpy = jsonObject1.getString("JPY");
                jpyText.setText("JPY: " + jpy);

*/

            } catch (Exception e) {

            }


        }
    }


    @Override
    public void onCancelled() {
        //Nothing
    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {
        if (firstDate != null) {
            if (secondDate == null) {   //범위 없이 하루만 설정될 경우..
                firstDate.set(Calendar.HOUR_OF_DAY, hours);
                firstDate.set(Calendar.MINUTE, minutes);
                Toast.makeText(
                        this,
                        new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime()),
                        Toast.LENGTH_LONG

                ).show();

                btnShowCalendar.setText(new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime()));

            } else {    //범위 설정이 된 상태에서 저장이 된다면..
                Toast.makeText(
                        this,
                        getString(
                                R.string.period,
                                new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime()),
                                new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime())
                        ),
                        Toast.LENGTH_LONG

                ).show();


                btnShowCalendar.setText(getString(
                        R.string.period,
                        new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime()),
                        new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime())
                ));
            }
        }
    }
}
