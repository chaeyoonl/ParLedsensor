package ru.slybeaver.truecalendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;
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

    int check_day = 0;

    int h = 0, mi = 0;
    int h2 = 0, mi2 = 0;
    int h3 = 0, mi3 = 0;
    int h4 = 0, mi4 = 0;
    int h5 = 0, mi5 = 0;
    int h6 = 0, mi6 = 0;
    int h7 = 0, mi7 = 0;
    int h8 = 0, mi8 = 0;

    TextView tryText;
    TextView cadText;
    TextView usdText;
    TextView jpyText;
    TextView chfText;
    TextView ledText;
    TextView ledText3;
    TextView ledText4;

    TextView show_date_par_date_first;
    TextView show_date_par_date;
    TextView show_date_par;
    TextView show_date_par2;
    TextView show_date_par3;
    TextView show_date_par4;

    String strMonth = "01";

    Button btnYearMonthPicker;

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            Log.d("YearMonthPickerTest", "year = " + year + ", month = " + monthOfYear + ", day = " + dayOfMonth);
        }
    };

    String ss = "";
    String ss2 = "";
    String ss3 = "";
    String ss4 = "";
    String ss5 = "";
    String ss6 = "";
    String ss7 = "";
    String ss8 = "";

    String resultss = "";

    int ih = 0;
    TabHost tabHost, tabHost2, tabHost3;

    Button btnShowCalendar, btn_section, time_1, time_2, time_3, time_4, time_5, time_6, time_7, time_8, set_light, set_LED, btn_year, btn_month, btn_day;

    private WebView webView;
    private String url = "http://yakyong.dataponic.site/dataponic_ALC/login/check?userId=test&passwd=test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);











        //자동로그인 하기위해서 쿠키값 onResume, OnPeuse에도 있음
        CookieSyncManager.createInstance(this);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

        tabHost = (TabHost) findViewById(R.id.tabhost1);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("1").setContent(R.id.tab1).setIndicator("메인");

        TabHost.TabSpec tab2 = tabHost.newTabSpec("2").setContent(R.id.tab2).setIndicator("조회");

        TabHost.TabSpec tab3 = tabHost.newTabSpec("3").setContent(R.id.tab3).setIndicator("ALC");

        TabHost.TabSpec tab4 = tabHost.newTabSpec("4").setContent(R.id.tab4).setIndicator("제어");

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);

        /////////////////////////////////////
        tabHost2 = (TabHost) findViewById(R.id.tabhost2);
        tabHost2.setup();

        TabHost.TabSpec tab_sub1 = tabHost2.newTabSpec("1").setContent(R.id.tab_sub1).setIndicator("1구역");

        TabHost.TabSpec tab_sub2 = tabHost2.newTabSpec("2").setContent(R.id.tab_sub2).setIndicator("2구역");

        TabHost.TabSpec tab_sub3 = tabHost2.newTabSpec("3").setContent(R.id.tab_sub3).setIndicator("3구역");

        TabHost.TabSpec tab_sub4 = tabHost2.newTabSpec("4").setContent(R.id.tab_sub4).setIndicator("4구역");

        tabHost2.addTab(tab_sub1);
        tabHost2.addTab(tab_sub2);
        tabHost2.addTab(tab_sub3);
        tabHost2.addTab(tab_sub4);
/*
        /////////////////////////////////////
        tabHost3 = (TabHost) findViewById(R.id.tabhost3);
        tabHost3.setup();

        TabHost.TabSpec tab_sub1_ch = tabHost2.newTabSpec("1").setContent(R.id.tab_sub1_ch).setIndicator("1구역");

        TabHost.TabSpec tab_sub2_ch = tabHost2.newTabSpec("2").setContent(R.id.tab_sub2_ch).setIndicator("2구역");

        TabHost.TabSpec tab_sub3_ch = tabHost2.newTabSpec("3").setContent(R.id.tab_sub3_ch).setIndicator("3구역");


        tabHost2.addTab(tab_sub1_ch);
        tabHost2.addTab(tab_sub2_ch);
        tabHost2.addTab(tab_sub3_ch);*/

        //////////////////////////////////////

        final int[] selectedItem = {0};
        final String[] items = new String[]{"1구역", "2구역", "3구역", "4구역"};

        btn_section = (Button) findViewById(R.id.btn_section);
        btn_section.setText(items[selectedItem[0]]);
        btn_section.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("구역을 선택하시오.")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedItem[0] = which;

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this
                                        , items[selectedItem[0]]
                                        , Toast.LENGTH_SHORT).show();

                                btn_section.setText(items[selectedItem[0]]);
                            }
                        })
                        .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this
                                        , " 취소 버튼을 눌렀습니다."
                                        , Toast.LENGTH_SHORT).show();
                            }
                        });
                dialog.create();
                dialog.show();


            }
        });

        ////////////////////////////////////
        time_1 = (Button) findViewById(R.id.time_1);
        time_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime();

            }

        });

        ///////////////////////////////////
        time_2 = (Button) findViewById(R.id.time_2);
        time_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime2();

            }

        });

        ///////////////////////////////////
        time_3 = (Button) findViewById(R.id.time_3);
        time_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime3();

            }

        });
        ///////////////////////////////////
        time_4 = (Button) findViewById(R.id.time_4);
        time_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime4();

            }

        });
        ///////////////////////////////////
        time_5 = (Button) findViewById(R.id.time_5);
        time_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime5();

            }

        });
        ///////////////////////////////////
        time_6 = (Button) findViewById(R.id.time_6);
        time_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime6();

            }

        });
        ///////////////////////////////////
        time_7 = (Button) findViewById(R.id.time_7);
        time_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime7();

            }

        });
        ///////////////////////////////////
        time_8 = (Button) findViewById(R.id.time_8);
        time_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime8();

            }

        });






        btn_year = (Button) findViewById(R.id.btn_year);
        btn_year.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("년도 선택"); //제목
                final String[] versionArray = new String[] {"2021년"};

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //btn_year.setText(versionArray[which]);
                    }
                });
                //버튼 클릭시 동작
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        //토스트 메시지
                        Toast.makeText(MainActivity.this,"확인을 눌르셨습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

            }
        });




        btn_month = (Button) findViewById(R.id.btn_month);
        btn_month.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("2021년 월 선택"); //제목
                final String[] versionArray = new String[] {"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,versionArray[which],Toast.LENGTH_SHORT).show();
                        strMonth = String.valueOf(versionArray[which]);
                        strMonth = "0" + strMonth.substring(0,1);
                        Log.i("strMonth", strMonth);
                    }
                });
                //버튼 클릭시 동작
                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        //토스트 메시지
                        Toast.makeText(MainActivity.this,"확인을 눌르셨습니다.",Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this,versionArray[0],Toast.LENGTH_SHORT).show();
                        check_day = 2;

                        DownloadData downloadData5 = new DownloadData();
                        try {
                            //시간에 따른 parsensor값
                            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListMon?strDate=2021" + strMonth;
                            downloadData5.execute(url);
                            Log.i("MyTag_check_day", url);
                        } catch (Exception e) {
                            Log.i("MyTag_check_day", "Fail");
                        }



                    }
                });
                dlg.show();


            }
        });


        btn_day = (Button) findViewById(R.id.btn_day);
        btn_day.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new SlyCalendarDialog()
                        .setSingle(false)
                        .setFirstMonday(false)
                        .setCallback(MainActivity.this)
                        .show(getSupportFragmentManager(), "TAG_SLYCALENDAR");
            }
        });













        tryText = findViewById(R.id.tryText);
        cadText = findViewById(R.id.cadText);
        usdText = findViewById(R.id.usdText);
        jpyText = findViewById(R.id.jpyText);
        chfText = findViewById(R.id.chfText);
        ledText = findViewById(R.id.ledText2);
        ledText3 = findViewById(R.id.ledText3);
        ledText4 = findViewById(R.id.ledText4);

        show_date_par_date_first = findViewById(R.id.show_date_par_date_first);
        show_date_par_date = findViewById(R.id.show_date_par_date);
        show_date_par = findViewById(R.id.show_date_par);
        show_date_par2 = findViewById(R.id.show_date_par2);
        show_date_par3 = findViewById(R.id.show_date_par3);
        show_date_par4 = findViewById(R.id.show_date_par4);

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

        final Button btn_bulb1, btn_bulb2;
        btn_bulb1 = findViewById(R.id.btn_bulb1);
        btn_bulb2 = findViewById(R.id.btn_bulb2);

        btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
        btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

        btn_bulb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
            }
        });


        btn_bulb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
            }
        });

        ////////////////////////////
        set_light = (Button) findViewById(R.id.set_light);
        final Button main_label = (Button) findViewById(R.id.set_light);
        set_light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_label);
            }
        });


        set_LED = (Button) findViewById(R.id.set_LED);
        final Button main_labe2 = (Button) findViewById(R.id.set_LED);
        set_LED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_labe2);
            }
        });



    }














    void showTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h = hourOfDay;
                mi = minute;
                time_1.setText(h + ":" + mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h2 = hourOfDay;
                mi2 = minute;
                time_2.setText(h2 + ":" + mi2);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h3 = hourOfDay;
                mi3 = minute;
                time_3.setText(h3 + ":" + mi3);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h4 = hourOfDay;
                mi4 = minute;
                time_4.setText(h4 + ":" + mi4);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime5() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h5 = hourOfDay;
                mi5 = minute;
                time_5.setText(h5 + ":" + mi5);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime6() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h6 = hourOfDay;
                mi6 = minute;
                time_6.setText(h6 + ":" + mi6);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime7() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h7 = hourOfDay;
                mi7 = minute;
                time_7.setText(h7 + ":" + mi7);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime8() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h8 = hourOfDay;
                mi8 = minute;
                time_8.setText(h8 + ":" + mi8);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }


    @Override
    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();

    }

    @Override
    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void getRates(View view) {
        DownloadData downloadData = new DownloadData();
        DownloadData downloadData2 = new DownloadData();
        DownloadData downloadData3 = new DownloadData();


        try {
            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParData";
            downloadData.execute(url);

        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }

        try {

            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getLedData";
            downloadData2.execute(url);
        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }


        try {
            //시간에 따른 parsensor값
            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListData";
            downloadData3.execute(url);
        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }

/*        if (check_day == 1) {
            try {
                //시간에 따른 parsensor값
                String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListDay?strDate=20210110&endDate=20210111";
                downloadData3.execute(url);
                Log.i("MyTag_check_day", "http://cjpre.dataponic.co.kr:10080/preAPI/getParListDay?strDate=20210110&endDate=20210111");
            } catch (Exception e) {
                Log.i("MyTag", "Fail");
            }



            check_day = 0;
        }*/



    }

    private class DownloadData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;
            Log.i("MyTag", "http");

            try {
                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);


                int data = inputStreamReader.read();

                while (data > 0) {
                    char character = (char) data;
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

            show_date_par_date.setText("");
            show_date_par.setText("");
            show_date_par2.setText("");
            show_date_par3.setText("");
            show_date_par4.setText("");
            Log.i("MyTag", String.valueOf(check_day));
            Log.i("MyTag", s);
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
                JSONArray jsonArray3 = null;
                JSONArray jsonArray4 = null;
                JSONArray jsonArray5 = null;

                if (ih == 0) {
                    jsonArray = new JSONArray(s);
                } if (ih == 1) {
                    jsonArray2 = new JSONArray(s);
                } if (ih == 2) {
                    jsonArray3 = new JSONArray(s);
                } if (check_day == 1) {
                    jsonArray4 = new JSONArray(s);
                } if (check_day == 2) {
                    jsonArray5 = new JSONArray(s);
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
                } if (ih == 1) {
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        JSONObject jo = jsonArray2.getJSONObject(i);


                        String led1 = jo.getString("led1");
                        String led2 = jo.getString("led2");
                        String led3 = jo.getString("led3");
                        String led4 = jo.getString("led4");

                        Log.i("My Tags", led1);
                        Log.i("My Tags", led2);
                        Log.i("My Tags", led3);
                        Log.i("My Tags", led4);

                        if (led1.contains("0")) {
                            ss5 = "OFF";
                        } else if (led1.contains("1")) {
                            ss5 = "ON";
                        } else {
                            ss5 = "ERR";
                        }

                        if (led2.contains("0")) {
                            ss6 = "OFF";
                        } else if (led2.contains("1")) {
                            ss6 = "ON";
                        } else {
                            ss6 = "ERR";
                        }

                        if (led3.contains("0")) {
                            ss7 = "OFF";
                        } else if (led3.contains("1")) {
                            ss7 = "ON";
                        } else {
                            ss7 = "ERR";
                        }

                        if (led4.contains("0")) {
                            ss8 = "OFF";
                        } else if (led4.contains("1")) {
                            ss8 = "ON";
                        } else {
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
                } if (ih == 2) {
                    for (int i = 0; i < jsonArray3.length(); i++) {




                        JSONObject jo = jsonArray3.getJSONObject(i);


                        String par1_avg = jo.getString("par1_avg");
                        String par2_avg = jo.getString("par2_avg");
                        String par3_avg = jo.getString("par3_avg");
                        String par4_avg = jo.getString("par4_avg");
                        String reg_time = jo.getString("reg_time");

                        if (i == 0) {
                            show_date_par_date_first.setText(reg_time.substring(0,10));
                        }

                        ss = reg_time.substring(11,13) + "\n";
                        ss2 = par1_avg + "\n";
                        ss3 = par2_avg + "\n";
                        ss4 = par3_avg + "\n";
                        ss5 = par4_avg + "\n";

                        //ss5 = led1;
                        //System.out.println("base:" + ss);


                        show_date_par_date.setText(show_date_par_date.getText().toString() + ss); //시간
                        show_date_par.setText(show_date_par.getText().toString() + ss2);    //Par1
                        show_date_par2.setText(show_date_par2.getText().toString() + ss3);  //Par2
                        show_date_par3.setText(show_date_par3.getText().toString() + ss4);  //Par3
                        show_date_par4.setText(show_date_par4.getText().toString() + ss5);  //Par4

                        //cadText.setText(ss5);
                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);

                    }





                } if (check_day == 1) {
                    for (int i = 0; i < jsonArray4.length(); i++) {




                        JSONObject jo = jsonArray4.getJSONObject(i);


                        String par1_avg = jo.getString("par1_avg");
                        String par2_avg = jo.getString("par2_avg");
                        String par3_avg = jo.getString("par3_avg");
                        String par4_avg = jo.getString("par4_avg");
                        String reg_time = jo.getString("reg_time");

                        if (i == 0) {
                            show_date_par_date_first.setText(reg_time.substring(0,10));
                        }

                        ss = reg_time.substring(11,13) + "\n";
                        ss2 = par1_avg + "\n";
                        ss3 = par2_avg + "\n";
                        ss4 = par3_avg + "\n";
                        ss5 = par4_avg + "\n";

                        //ss5 = led1;
                        //System.out.println("base:" + ss);


                        show_date_par_date.setText(show_date_par_date.getText().toString() + ss); //시간
                        show_date_par.setText(show_date_par.getText().toString() + ss2);    //Par1
                        show_date_par2.setText(show_date_par2.getText().toString() + ss3);  //Par2
                        show_date_par3.setText(show_date_par3.getText().toString() + ss4);  //Par3
                        show_date_par4.setText(show_date_par4.getText().toString() + ss5);  //Par4

                        //cadText.setText(ss5);
                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);

                    }







                    check_day = 0;
                } if (check_day == 2) {
                    Log.i("check_day", "check_day clicked");
                    for (int i = 0; i < jsonArray5.length(); i++) {
                        Log.i("check_day", String.valueOf(jsonArray5.length()));



                        JSONObject jo = jsonArray5.getJSONObject(i);


                        String par1_avg = jo.getString("par1_sum");
                        String par2_avg = jo.getString("par2_sum");
                        String par3_avg = jo.getString("par3_sum");
                        String par4_avg = jo.getString("par4_sum");
                        String reg_time = jo.getString("reg_time");

/*                        if (i == 0) {
                            show_date_par_date_first.setText(reg_time.substring(0,10));
                        }*/

                        ss = reg_time.substring(5,10) + "\n";
                        ss2 = par1_avg + "\n";
                        ss3 = par2_avg + "\n";
                        ss4 = par3_avg + "\n";
                        ss5 = par4_avg + "\n";

                        //ss5 = led1;
                        //System.out.println("base:" + ss);

                        Log.i("MyTagss", show_date_par.getText().toString() + ss2);
                        show_date_par_date.setText(show_date_par_date.getText().toString() + ss); //시간
                        show_date_par.setText(show_date_par.getText().toString() + ss2);    //Par1
                        show_date_par2.setText(show_date_par2.getText().toString() + ss3);  //Par2
                        show_date_par3.setText(show_date_par3.getText().toString() + ss4);  //Par3
                        show_date_par4.setText(show_date_par4.getText().toString() + ss5);  //Par4

                        //cadText.setText(ss5);
                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);

                    }



                    check_day = 0;
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

    String strDate = "", endDate = "", tempDate = "";
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

                //하나의 날짜만 선택된 경우
                btnShowCalendar.setText(new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime()));

                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                Log.i("tempDate", tempDate);
                strDate = tempDate.substring(0,4);    //년도 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(6,8);    //월 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(10,12);    //일 잘라내기

                Log.i("strDate", strDate);

                check_day = 1;
                DownloadData downloadData4 = new DownloadData();
                try {
                    //시간에 따른 parsensor값
                    String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListDay?strDate=" + strDate + "&endDate=" + strDate;
                    downloadData4.execute(url);
                    Log.i("MyTag_check_day", "success");
                } catch (Exception e) {
                    Log.i("MyTag_check_day", "Fail");
                }
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


                //범위가 있는 날짜가 선택된 경우
                btnShowCalendar.setText(getString(
                        R.string.period,
                        new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime()),
                        new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime())
                ));

                //시작 날짜
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                Log.i("tempDate", tempDate);
                strDate = tempDate.substring(0,4);    //년도 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(6,8);    //월 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(10,12);    //일 잘라내기

                Log.i("strDate", strDate);


                //끝나는 날짜
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime());
                Log.i("tempDate", tempDate);
                endDate = tempDate.substring(0,4);    //년도 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime());
                endDate = endDate + tempDate.substring(6,8);    //월 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime());
                endDate = endDate + tempDate.substring(10,12);    //일 잘라내기

                Log.i("endDate", endDate);


                check_day = 1;
                DownloadData downloadData4 = new DownloadData();
                try {
                    //시간에 따른 parsensor값
                    String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListDay?strDate=" + strDate + "&endDate=" + endDate;
                    downloadData4.execute(url);
                    Log.i("MyTag_check_day", "success");
                } catch (Exception e) {
                    Log.i("MyTag_check_day", "Fail");
                }
            }
        }
    }
}
