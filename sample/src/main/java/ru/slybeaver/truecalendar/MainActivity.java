package ru.slybeaver.truecalendar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity implements SlyCalendarDialog.Callback {
    String S_reg_time;
    String S_led1_status;
    String S_led2_status;
    String S_led3_status;
    String S_led4_status;
    String S_led1_info;
    String S_led2_info;
    String S_led3_info;
    String S_led4_info;


    int check_day = 0;
    int txt_su = 0;

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

    TextView par_reg_time, led_reg_time;

    Button btn_bulb1, btn_bulb2, btn_bulb1_2, btn_bulb2_2, btn_bulb1_3, btn_bulb2_3, btn_bulb1_4, btn_bulb2_4;

    TextView txt_sudong, txt_sudong2, txt_sudong3, txt_sudong4;

    TextView LED_on_off, LED_on_off_2, LED_on_off_3, LED_on_off_4;

    TextView txt_1_time, txt_2_time, txt_3_time, txt_4_time;

    Button btn_sul1_1, btn_sul1_2, btn_sul2_1, btn_sul2_2, btn_sul3_1, btn_sul3_2, btn_sul4_1, btn_sul4_2;


    String strMonth = "01";

    String str_request = "0";

    String ssss, ssss2, ssss3;
    String tempss, tempss2;


    String S_timer_1_1, S_timer_1_2, S_timer_2_1, S_timer_2_2, S_timer_3_1, S_timer_3_2;


    Button btnYearMonthPicker;

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
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
    String ss9 = "";

    String resultss = "";

    int requests = 0;

    int ih = 0;
    TabHost tabHost, tabHost2, tabHost3, tabHost2_2, tabHost2_3, tabHost2_4;

    Button btnShowCalendar, btn_section, time_1, time_2, time_3, time_4, time_5, time_6, time_7, time_8, time_1_2, time_2_2, time_3_2, time_4_2, time_5_2, time_6_2, time_7_2, time_8_2, time_1_3, time_2_3, time_3_3, time_4_3, time_5_3, time_6_3, time_7_3, time_8_3, time_1_4, time_2_4, time_3_4, time_4_4, time_5_4, time_6_4, time_7_4, time_8_4, set_light, set_LED, btn_year, btn_month, btn_day, set_light_2, set_LED_2, set_light_3, set_LED_3, set_light_4, set_LED_4;

    private WebView webView;
    private String url = "http://yakyong.dataponic.site/dataponic_ALC/login/check?userId=test&passwd=test";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_1 = (Button) findViewById(R.id.time_1);
        time_2 = (Button) findViewById(R.id.time_2);
        time_3 = (Button) findViewById(R.id.time_3);
        time_5 = (Button) findViewById(R.id.time_5);
        time_6 = (Button) findViewById(R.id.time_6);
        time_7 = (Button) findViewById(R.id.time_7);

        time_1_2 = (Button) findViewById(R.id.time_1_2);
        time_2_2 = (Button) findViewById(R.id.time_2_2);
        time_3_2 = (Button) findViewById(R.id.time_3_2);
        time_5_2 = (Button) findViewById(R.id.time_5_2);
        time_6_2 = (Button) findViewById(R.id.time_6_2);
        time_7_2 = (Button) findViewById(R.id.time_7_2);

        time_1_3 = (Button) findViewById(R.id.time_1_3);
        time_2_3 = (Button) findViewById(R.id.time_2_3);
        time_3_3 = (Button) findViewById(R.id.time_3_3);
        time_5_3 = (Button) findViewById(R.id.time_5_3);
        time_6_3 = (Button) findViewById(R.id.time_6_3);
        time_7_3 = (Button) findViewById(R.id.time_7_3);

        time_1_4 = (Button) findViewById(R.id.time_1_4);
        time_2_4 = (Button) findViewById(R.id.time_2_4);
        time_3_4 = (Button) findViewById(R.id.time_3_4);
        time_5_4 = (Button) findViewById(R.id.time_5_4);
        time_6_4 = (Button) findViewById(R.id.time_6_4);
        time_7_4 = (Button) findViewById(R.id.time_7_4);

        /////////////////////
        Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
        // 년월일시분초 14자리 포멧
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
        S_reg_time = fourteen_format.format(date_now);
        int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
        S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
        Log.i("S_reg_time", S_reg_time);


        txt_sudong = (TextView) findViewById(R.id.txt_sudong);
        txt_sudong2 = (TextView) findViewById(R.id.txt_sudong2);
        txt_sudong3 = (TextView) findViewById(R.id.txt_sudong3);
        txt_sudong4 = (TextView) findViewById(R.id.txt_sudong4);


        //1구역 보광등 현재 상태
        LED_on_off = (TextView) findViewById(R.id.LED_on_off);
        LED_on_off_2 = (TextView) findViewById(R.id.LED_on_off_2);
        LED_on_off_3 = (TextView) findViewById(R.id.LED_on_off_3);
        LED_on_off_4 = (TextView) findViewById(R.id.LED_on_off_4);

        par_reg_time = (TextView) findViewById(R.id.par_reg_time);
        led_reg_time = (TextView) findViewById(R.id.led_reg_time);

        ///////////
        txt_1_time = (TextView) findViewById(R.id.txt_1_time);
        txt_2_time = (TextView) findViewById(R.id.txt_2_time);
        txt_3_time = (TextView) findViewById(R.id.txt_3_time);
        txt_4_time = (TextView) findViewById(R.id.txt_4_time);


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

        try {
            FileInputStream inFs = openFileInput("file.txt");
            byte[] txt = new byte[30];
            inFs.read(txt);
            str_request = new String(txt);
            inFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (str_request.contains("1_1")) {
            tabHost.setCurrentTabByTag("4");
            tabHost.setup();
        }

        if (str_request.contains("1_2")) {
            tabHost.setCurrentTabByTag("4");
            tabHost.setup();
/*            tabHost3.setCurrentTabByTag("2");
            tabHost3.setup();*/
        }

        if (str_request.contains("1_3")) {
            tabHost.setCurrentTabByTag("4");
            tabHost.setup();
/*            tabHost3.setCurrentTabByTag("3");
            tabHost3.setup();*/
        }

        if (str_request.contains("1_4")) {
            tabHost.setCurrentTabByTag("4");
            tabHost.setup();
/*            tabHost3.setCurrentTabByTag("4");
            tabHost3.setup();*/
        }


        try {
            FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
            str_request = "0";
            outFs.write(str_request.getBytes());
            outFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tabHost.setCurrentTabByTag("1");

        /////////////////////////////////////
        tabHost2 = (TabHost) findViewById(R.id.tabhost2);
        tabHost2.setup();

        final TabHost.TabSpec tab_sub1 = tabHost2.newTabSpec("t1").setContent(R.id.tab_sub1).setIndicator("수동");

        final TabHost.TabSpec tab_sub2 = tabHost2.newTabSpec("t2").setContent(R.id.tab_sub2).setIndicator("타이머");

        final TabHost.TabSpec tab_sub3 = tabHost2.newTabSpec("t3").setContent(R.id.tab_sub3).setIndicator("자동");


        tabHost2.addTab(tab_sub1);
        tabHost2.addTab(tab_sub2);
        tabHost2.addTab(tab_sub3);


        /////////////////////////////////////
        tabHost2_2 = (TabHost) findViewById(R.id.tabhost2_2);
        tabHost2_2.setup();

        TabHost.TabSpec tab_sub1_2 = tabHost2_2.newTabSpec("t1").setContent(R.id.tab_sub1_2).setIndicator("수동");

        TabHost.TabSpec tab_sub2_2 = tabHost2_2.newTabSpec("t2").setContent(R.id.tab_sub2_2).setIndicator("타이머");

        TabHost.TabSpec tab_sub3_2 = tabHost2_2.newTabSpec("t3").setContent(R.id.tab_sub3_2).setIndicator("자동");


        tabHost2_2.addTab(tab_sub1_2);
        tabHost2_2.addTab(tab_sub2_2);
        tabHost2_2.addTab(tab_sub3_2);

        /////////////////////////////////////
        tabHost2_3 = (TabHost) findViewById(R.id.tabhost2_3);
        tabHost2_3.setup();

        TabHost.TabSpec tab_sub1_3 = tabHost2_3.newTabSpec("t1").setContent(R.id.tab_sub1_3).setIndicator("수동");

        TabHost.TabSpec tab_sub2_3 = tabHost2_3.newTabSpec("t2").setContent(R.id.tab_sub2_3).setIndicator("타이머");

        TabHost.TabSpec tab_sub3_3 = tabHost2_3.newTabSpec("t3").setContent(R.id.tab_sub3_3).setIndicator("자동");


        tabHost2_3.addTab(tab_sub1_3);
        tabHost2_3.addTab(tab_sub2_3);
        tabHost2_3.addTab(tab_sub3_3);

        /////////////////////////////////////
        tabHost2_4 = (TabHost) findViewById(R.id.tabhost2_4);
        tabHost2_4.setup();

        TabHost.TabSpec tab_sub1_4 = tabHost2_4.newTabSpec("t1").setContent(R.id.tab_sub1_4).setIndicator("수동");

        TabHost.TabSpec tab_sub2_4 = tabHost2_4.newTabSpec("t2").setContent(R.id.tab_sub2_4).setIndicator("타이머");

        TabHost.TabSpec tab_sub3_4 = tabHost2_4.newTabSpec("t3").setContent(R.id.tab_sub3_4).setIndicator("자동");


        tabHost2_4.addTab(tab_sub1_4);
        tabHost2_4.addTab(tab_sub2_4);
        tabHost2_4.addTab(tab_sub3_4);


        /////////////////////////////////////
        tabHost3 = (TabHost) findViewById(R.id.tabhost3);
        tabHost3.setup();

        TabHost.TabSpec tab_sub1_ch = tabHost3.newTabSpec("1").setContent(R.id.tab_sub1_ch).setIndicator("1구역");

        TabHost.TabSpec tab_sub2_ch = tabHost3.newTabSpec("2").setContent(R.id.tab_sub2_ch).setIndicator("2구역");

        TabHost.TabSpec tab_sub3_ch = tabHost3.newTabSpec("3").setContent(R.id.tab_sub3_ch).setIndicator("3구역");

        TabHost.TabSpec tab_sub4_ch = tabHost3.newTabSpec("4").setContent(R.id.tab_sub4_ch).setIndicator("4구역");


        tabHost3.addTab(tab_sub1_ch);
        tabHost3.addTab(tab_sub2_ch);
        tabHost3.addTab(tab_sub3_ch);
        tabHost3.addTab(tab_sub4_ch);


        ///////////////////////////////
        /*
        설정버튼 제어부분
         */

        btn_sul1_1 = (Button) findViewById(R.id.btn_sul_1_1);
        btn_sul1_2 = (Button) findViewById(R.id.btn_sul_1_2);

        btn_sul2_1 = (Button) findViewById(R.id.btn_sul_2_1);
        btn_sul2_2 = (Button) findViewById(R.id.btn_sul_2_2);

        btn_sul3_1 = (Button) findViewById(R.id.btn_sul_3_1);
        btn_sul3_2 = (Button) findViewById(R.id.btn_sul_3_2);

        btn_sul4_1 = (Button) findViewById(R.id.btn_sul_4_1);
        btn_sul4_2 = (Button) findViewById(R.id.btn_sul_4_2);

        //1구역_수동_설정버튼 눌렀을 경우
        btn_sul1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led1_status = "1";

                HttpPost();

                onRestart_1();


            }
        });
        //1구역_타이머_설정버튼 눌렀을 경우
        btn_sul1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led1_status = "2";
                if (time_1.getText().toString().contains(":")) {
                    tempss = time_1.getText().toString();
                    tempss2 = time_5.getText().toString();
                    tempss = tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss = tempss + tempss2;

                    Log.i("S_timer", ssss);


                }
                if (time_2.getText().toString().contains(":")) {
                    tempss = time_2.getText().toString();
                    tempss2 = time_6.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss2 = tempss + tempss2;


                    ssss = ssss + ssss2;
                    Log.i("S_timer", ssss);

                }
                if (time_3.getText().toString().contains(":")) {
                    tempss = time_3.getText().toString();
                    tempss2 = time_7.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss3 = tempss + tempss2;


                    ssss = ssss + ssss3;

                }


                S_led1_info = ssss;
                HttpPost();

                onRestart_1();



            }
        });
        //2구역_수동_설정버튼 눌렀을 경우
        btn_sul2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led2_status = "1";

                HttpPost();

                onRestart_2();



            }
        });
        //2구역_타이머_설정버튼 눌렀을 경우
        btn_sul2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led2_status = "2";

                if (time_1_2.getText().toString().contains(":")) {
                    tempss = time_1_2.getText().toString();
                    tempss2 = time_5_2.getText().toString();
                    tempss = tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss = tempss + tempss2;

                    Log.i("S_timer", ssss);

                }
                if (time_2_2.getText().toString().contains(":")) {
                    tempss = time_2_2.getText().toString();
                    tempss2 = time_6_2.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss2 = tempss + tempss2;


                    ssss = ssss + ssss2;
                    Log.i("S_timer", ssss);

                }
                if (time_3_2.getText().toString().contains(":")) {
                    tempss = time_3_2.getText().toString();
                    tempss2 = time_7_2.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss3 = tempss + tempss2;


                    ssss = ssss + ssss3;

                }


                S_led2_info = ssss;

                HttpPost();

                onRestart_2();



            }
        });
        //3구역_수동_설정버튼 눌렀을 경우
        btn_sul3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led3_status = "1";

                HttpPost();

                onRestart_3();



            }
        });
        //3구역_타이머_설정버튼 눌렀을 경우
        btn_sul3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led3_status = "2";

                if (time_1_3.getText().toString().contains(":")) {
                    tempss = time_1_3.getText().toString();
                    tempss2 = time_5_3.getText().toString();
                    tempss = tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);


                    ssss = tempss + tempss2;

                    Log.i("S_timer", ssss);


                }
                if (time_2_3.getText().toString().contains(":")) {
                    tempss = time_2_3.getText().toString();
                    tempss2 = time_6_3.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss2 = tempss + tempss2;


                    ssss = ssss + ssss2;
                    Log.i("S_timer", ssss);

                }
                if (time_3_3.getText().toString().contains(":")) {
                    tempss = time_3_3.getText().toString();
                    tempss2 = time_7_3.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss3 = tempss + tempss2;


                    ssss = ssss + ssss3;

                }


                S_led3_info = ssss;
                HttpPost();

                onRestart_3();



            }
        });
        //4구역_수동_설정버튼 눌렀을 경우
        btn_sul4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led4_status = "1";

                HttpPost();

                onRestart_4();



            }
        });
        //4구역_타이머_설정버튼 눌렀을 경우
        btn_sul4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
                // 년월일시분초 14자리 포멧
                SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMddHHmmss");
                S_reg_time = fourteen_format.format(date_now);
                int temp = Integer.parseInt(S_reg_time.substring(8, 10)) + 9;
                S_reg_time = S_reg_time.substring(0, 8) + Integer.toString(temp) + S_reg_time.substring(10, 14);
                Log.i("S_reg_time", S_reg_time);

                S_led4_status = "2";

                if (time_1_4.getText().toString().contains(":")) {
                    tempss = time_1_4.getText().toString();
                    tempss2 = time_5_4.getText().toString();
                    tempss = tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);


                    ssss = tempss + tempss2;

                    Log.i("S_timer", ssss);


                }
                if (time_2_4.getText().toString().contains(":")) {
                    tempss = time_2_4.getText().toString();
                    tempss2 = time_6_4.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss2 = tempss + tempss2;


                    ssss = ssss + ssss2;
                    Log.i("S_timer", ssss);

                }
                if (time_3_4.getText().toString().contains(":")) {
                    tempss = time_3_4.getText().toString();
                    tempss2 = time_7_4.getText().toString();
                    tempss = ", " + tempss.substring(0, 2) + tempss.substring(3, 5) + "%26";
                    tempss2 = tempss2.substring(0, 2) + tempss2.substring(3, 5);

                    ssss3 = tempss + tempss2;


                    ssss = ssss + ssss3;

                }


                S_led4_info = ssss;
                Log.i("testtest", ssss);

                HttpPost();

                onRestart_4();



            }
        });





        ////////////////////////////////////

        time_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime();

            }

        });

        ///////////////////////////////////

        time_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime2();

            }

        });

        ///////////////////////////////////
        time_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime3();

            }

        });
        ///////////////////////////////////
        time_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime5();

            }

        });
        ///////////////////////////////////
        time_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime6();

            }

        });
        ///////////////////////////////////
        time_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime7();

            }

        });


        ////////////////////////////////////

        time_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime_2();

            }

        });

        ///////////////////////////////////
        time_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime2_2();

            }

        });

        ///////////////////////////////////
        time_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime3_2();

            }

        });
        ///////////////////////////////////
        time_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime5_2();

            }

        });
        ///////////////////////////////////
        time_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime6_2();

            }

        });
        ///////////////////////////////////
        time_7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime7_2();

            }

        });


        ////////////////////////////////////

        time_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime_3();

            }

        });

        ///////////////////////////////////
        time_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime2_3();

            }

        });

        ///////////////////////////////////
        time_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime3_3();

            }

        });
        ///////////////////////////////////
        time_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime5_3();

            }

        });
        ///////////////////////////////////
        time_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime6_3();

            }

        });
        ///////////////////////////////////
        time_7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime7_3();

            }

        });


        ////////////////////////////////////

        time_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime_4();

            }

        });

        ///////////////////////////////////
        time_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime2_4();

            }

        });

        ///////////////////////////////////
        time_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime3_4();

            }

        });
        ///////////////////////////////////
        time_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime5_4();

            }

        });
        ///////////////////////////////////
        time_6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime6_4();

            }

        });
        ///////////////////////////////////
        time_7_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTime7_4();

            }

        });


        btn_year = (Button) findViewById(R.id.btn_year);
        btn_year.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("년도 선택"); //제목
                final String[] versionArray = new String[]{"2021년"};

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //btn_year.setText(versionArray[which]);
                    }
                });
                //버튼 클릭시 동작
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //토스트 메시지
                        Toast.makeText(MainActivity.this, "확인을 눌르셨습니다.", Toast.LENGTH_SHORT).show();
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
                final String[] versionArray = new String[]{"1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"};

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, versionArray[which], Toast.LENGTH_SHORT).show();
                        strMonth = String.valueOf(versionArray[which]);
                        strMonth = "0" + strMonth.substring(0, 1);
                        Log.i("strMonth", strMonth);
                    }
                });
                //버튼 클릭시 동작
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //토스트 메시지
                        Toast.makeText(MainActivity.this, "확인을 눌르셨습니다.", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this,versionArray[0],Toast.LENGTH_SHORT).show();
                        check_day = 2;

                        DownloadData downloadData5 = new DownloadData();
                        try {
                            //시간에 따른 parsensor값
                            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListMon?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35&strDate=2021" + strMonth;
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
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRestart();
            }
        });

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


        btn_bulb1 = findViewById(R.id.btn_bulb1);
        btn_bulb2 = findViewById(R.id.btn_bulb2);
        btn_bulb2.performClick();

        btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
        btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

        btn_bulb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //1구역
                //LED_on_off.setText("OFF");
                S_led1_status = "1";
                S_led1_info = "off";
            }
        });


        btn_bulb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off.setText("ON");
                S_led1_status = "1";
                S_led1_info = "on";
            }
        });


        btn_bulb1_2 = findViewById(R.id.btn_bulb1_2);
        btn_bulb2_2 = findViewById(R.id.btn_bulb2_2);
        btn_bulb2_2.performClick();

        btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
        btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

        btn_bulb1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off_2.setText("OFF");
                S_led2_status = "1";
                S_led2_info = "off";
            }
        });


        btn_bulb2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off_2.setText("ON");
                S_led2_status = "1";
                S_led2_info = "on";
            }
        });


        btn_bulb1_3 = findViewById(R.id.btn_bulb1_3);
        btn_bulb2_3 = findViewById(R.id.btn_bulb2_3);
        btn_bulb2_3.performClick();

        btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
        btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

        btn_bulb1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off_3.setText("OFF");
                S_led3_status = "1";
                S_led3_info = "off";
            }
        });


        btn_bulb2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off_3.setText("ON");
                S_led3_status = "1";
                S_led3_info = "on";
            }
        });


        btn_bulb1_4 = findViewById(R.id.btn_bulb1_4);
        btn_bulb2_4 = findViewById(R.id.btn_bulb2_4);
        btn_bulb2_4.performClick();

        btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
        btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

        btn_bulb1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off_4.setText("OFF");
                S_led4_status = "1";
                S_led4_info = "off";
            }
        });


        btn_bulb2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape);
                btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);

                //LED_on_off_4.setText("ON");
                S_led4_status = "1";
                S_led4_info = "on";
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

        set_light_2 = (Button) findViewById(R.id.set_light_2);
        final Button main_label_2 = (Button) findViewById(R.id.set_light_2);
        set_light_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_label_2);
            }
        });


        set_LED_2 = (Button) findViewById(R.id.set_LED_2);
        final Button main_labe2_2 = (Button) findViewById(R.id.set_LED_2);
        set_LED_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_labe2_2);
            }
        });

        set_light_3 = (Button) findViewById(R.id.set_light_3);
        final Button main_label_3 = (Button) findViewById(R.id.set_light_3);
        set_light_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_label_3);
            }
        });


        set_LED_3 = (Button) findViewById(R.id.set_LED_3);
        final Button main_labe2_3 = (Button) findViewById(R.id.set_LED_3);
        set_LED_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_labe2_3);
            }
        });


        set_light_4 = (Button) findViewById(R.id.set_light_4);
        final Button main_label_4 = (Button) findViewById(R.id.set_light_4);
        set_light_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_label_4);
            }
        });


        set_LED_4 = (Button) findViewById(R.id.set_LED_4);
        final Button main_labe2_4 = (Button) findViewById(R.id.set_LED_4);
        set_LED_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog customDialog = new CustomDialog(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(main_labe2_4);
            }
        });


    }

    URL urls;

    {
        try {
            urls = new URL("http://cjpre.dataponic.co.kr:10080/preAPI/putLedSetData?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35");

            HttpURLConnection connection = (HttpURLConnection) urls.openConnection();
            connection.setRequestMethod("POST"); //전송방식
            connection.setDoOutput(true);       //데이터를 쓸 지 설정
            connection.setDoInput(true);        //데이터를 읽어올지 설정
            connection.setRequestProperty("reg_time", "20210201125010");
            connection.setRequestProperty("eq_num", "ABC001");
            connection.setRequestProperty("led1_status", "1");
            connection.setRequestProperty("led2_status", "1");
            connection.setRequestProperty("led3_status", "1");
            connection.setRequestProperty("led4_status", "1");
            connection.setRequestProperty("led1_info", "on");
            connection.setRequestProperty("led2_info", "on");
            connection.setRequestProperty("led3_info", "on");
            connection.setRequestProperty("led4_info", "on");
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        finish();

    }


    protected void onRestart_1() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        requests = 1;
        try {
            FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
            str_request = "1_1";
            outFs.write(str_request.getBytes());
            outFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();


    }

    protected void onRestart_2() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        requests = 1;
        try {
            FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
            str_request = "1_2";
            outFs.write(str_request.getBytes());
            outFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();


    }

    protected void onRestart_3() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        requests = 1;
        try {
            FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
            str_request = "1_3";
            outFs.write(str_request.getBytes());
            outFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();


    }

    protected void onRestart_4() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        requests = 1;
        try {
            FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE);
            str_request = "1_4";
            outFs.write(str_request.getBytes());
            outFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finish();


    }

/*    protected void onRestart_2() {

        // TODO Auto-generated method stub
        tabHost.setCurrentTabByTag("4");
        tabHost.setup();

    }*/




    String str_h = "";
    String str_mi = "";

    void showTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h = hourOfDay;
                mi = minute;
                str_h = String.valueOf(h);
                str_mi = String.valueOf(mi);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_1.setText(str_h + ":" + str_mi);
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
                str_h = String.valueOf(h2);
                str_mi = String.valueOf(mi2);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_2.setText(str_h + ":" + str_mi);
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
                str_h = String.valueOf(h3);
                str_mi = String.valueOf(mi3);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_3.setText(str_h + ":" + str_mi);
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
                str_h = String.valueOf(h5);
                str_mi = String.valueOf(mi5);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_5.setText(str_h + ":" + str_mi);
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
                str_h = String.valueOf(h6);
                str_mi = String.valueOf(mi6);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_6.setText(str_h + ":" + str_mi);
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
                str_h = String.valueOf(h7);
                str_mi = String.valueOf(mi7);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_7.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime_2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h = hourOfDay;
                mi = minute;
                str_h = String.valueOf(h);
                str_mi = String.valueOf(mi);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_1_2.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime2_2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h2 = hourOfDay;
                mi2 = minute;
                str_h = String.valueOf(h2);
                str_mi = String.valueOf(mi2);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_2_2.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime3_2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h3 = hourOfDay;
                mi3 = minute;
                str_h = String.valueOf(h3);
                str_mi = String.valueOf(mi3);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_3_2.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }


    void showTime5_2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h5 = hourOfDay;
                mi5 = minute;
                str_h = String.valueOf(h5);
                str_mi = String.valueOf(mi5);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_5_2.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime6_2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h6 = hourOfDay;
                mi6 = minute;
                str_h = String.valueOf(h6);
                str_mi = String.valueOf(mi6);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_6_2.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime7_2() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h7 = hourOfDay;
                mi7 = minute;
                str_h = String.valueOf(h7);
                str_mi = String.valueOf(mi7);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_7_2.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }


    void showTime_3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h = hourOfDay;
                mi = minute;
                str_h = String.valueOf(h);
                str_mi = String.valueOf(mi);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_1_3.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime2_3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h2 = hourOfDay;
                mi2 = minute;
                str_h = String.valueOf(h2);
                str_mi = String.valueOf(mi2);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_2_3.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime3_3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h3 = hourOfDay;
                mi3 = minute;
                str_h = String.valueOf(h3);
                str_mi = String.valueOf(mi3);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_3_3.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }


    void showTime5_3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h5 = hourOfDay;
                mi5 = minute;
                str_h = String.valueOf(h5);
                str_mi = String.valueOf(mi5);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_5_3.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime6_3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h6 = hourOfDay;
                mi6 = minute;
                str_h = String.valueOf(h6);
                str_mi = String.valueOf(mi6);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_6_3.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime7_3() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h7 = hourOfDay;
                mi7 = minute;
                str_h = String.valueOf(h7);
                str_mi = String.valueOf(mi7);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_7_3.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }


    void showTime_4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h = hourOfDay;
                mi = minute;
                str_h = String.valueOf(h);
                str_mi = String.valueOf(mi);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_1_4.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime2_4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h2 = hourOfDay;
                mi2 = minute;
                str_h = String.valueOf(h2);
                str_mi = String.valueOf(mi2);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_2_4.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime3_4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h3 = hourOfDay;
                mi3 = minute;
                str_h = String.valueOf(h3);
                str_mi = String.valueOf(mi3);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_3_4.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }


    void showTime5_4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h5 = hourOfDay;
                mi5 = minute;
                str_h = String.valueOf(h5);
                str_mi = String.valueOf(mi5);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_5_4.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime6_4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h6 = hourOfDay;
                mi6 = minute;
                str_h = String.valueOf(h6);
                str_mi = String.valueOf(mi6);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_6_4.setText(str_h + ":" + str_mi);
            }
        }, 21, 12, true);

        timePickerDialog.setMessage("메시지");
        timePickerDialog.show();


    }

    void showTime7_4() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                h7 = hourOfDay;
                mi7 = minute;
                str_h = String.valueOf(h7);
                str_mi = String.valueOf(mi7);
                if (str_h.length() == 1) {
                    str_h = "0" + str_h;
                }
                if (str_mi.length() == 1) {
                    str_mi = "0" + str_mi;
                }
                time_7_4.setText(str_h + ":" + str_mi);
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
        DownloadData downloadData6 = new DownloadData();


        try {
            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParData?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35";
            downloadData.execute(url);

        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }

        try {

            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getLedData?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35";
            downloadData2.execute(url);
        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }


        try {
            //시간에 따른 parsensor값
            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListData?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35";
            downloadData3.execute(url);
        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }

        try {
            //시간에 따른 parsensor값
            String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getLedSetData?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35";
            downloadData6.execute(url);
            Log.i("MyTag_URL", "URL");
        } catch (Exception e) {
            Log.i("MyTag", "Fail");
        }


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

            try {
                Log.i("Results_string", "let's see it");
                Log.i("Results_string", s);
                resultss += s;
                Log.i("Results", resultss);


                JSONArray jsonArray = null;
                JSONArray jsonArray2 = null;
                JSONArray jsonArray3 = null;
                JSONArray jsonArray4 = null;
                JSONArray jsonArray5 = null;
                JSONArray jsonArray7 = null;




                if (ih == 0) {
                    jsonArray = new JSONArray(s);
                }
                if (ih == 1) {
                    jsonArray2 = new JSONArray(s);
                }
                if (ih == 2) {
                    jsonArray3 = new JSONArray(s);
                }
                if (check_day == 1) {
                    jsonArray4 = new JSONArray(s);

                    for (int i = 0; i < jsonArray4.length(); i++) {


                        JSONObject jo = jsonArray4.getJSONObject(i);


                        String par1_avg = jo.getString("par1_avg");
                        String par2_avg = jo.getString("par2_avg");
                        String par3_avg = jo.getString("par3_avg");
                        String par4_avg = jo.getString("par4_avg");
                        String reg_time = jo.getString("reg_time");

                        if (i == 0) {
                            show_date_par_date_first.setText(reg_time.substring(0, 10));
                        }

                        ss = reg_time.substring(11, 13) + "시" + "\n";
                        ss2 = par1_avg + "\n";
                        ss3 = par2_avg + "\n";
                        ss4 = par3_avg + "\n";
                        ss5 = par4_avg + "\n";


                        show_date_par_date.setText(show_date_par_date.getText().toString() + ss); //시간
                        show_date_par.setText(show_date_par.getText().toString() + ss2);    //Par1
                        show_date_par2.setText(show_date_par2.getText().toString() + ss3);  //Par2
                        show_date_par3.setText(show_date_par3.getText().toString() + ss4);  //Par3
                        show_date_par4.setText(show_date_par4.getText().toString() + ss5);  //Par4


                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);

                    }


                    check_day = 0;

                }
                if (check_day == 2) {
                    jsonArray5 = new JSONArray(s);


                    for (int i = 0; i < jsonArray5.length(); i++) {
                        Log.i("check_day", String.valueOf(jsonArray5.length()));


                        JSONObject jo = jsonArray5.getJSONObject(i);


                        String par1_avg = jo.getString("par1_sum");
                        String par2_avg = jo.getString("par2_sum");
                        String par3_avg = jo.getString("par3_sum");
                        String par4_avg = jo.getString("par4_sum");
                        String reg_time = jo.getString("reg_time");

                        if (i == 0) {
                            show_date_par_date_first.setText(reg_time.substring(0, 10));
                        }

                        ss = reg_time.substring(0, 10) + "\n";
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
                if (txt_su == 1) {







                    Log.i("10tests", s);


                    ss = s.substring(64, 83);
                    txt_1_time.setText(ss);
                    txt_2_time.setText(ss);
                    txt_3_time.setText(ss);
                    txt_4_time.setText(ss);









                    //수동, 타이머, 자동 부분
                    ss = s.substring(100, 101);
                    if (ss.contains("1")) {
                        txt_sudong.setText("수동");
                        tabHost2.setCurrentTabByTag("t1");
                        S_led1_status = "1";
                    }
                    if (ss.contains("2")) {
                        txt_sudong.setText("타이머");
                        tabHost2.setCurrentTabByTag("t2");
                        S_led1_status = "2";
                    }
                    if (ss.contains("3")) {
                        txt_sudong.setText("자동");
                        tabHost2.setCurrentTabByTag("t3");
                        S_led1_status = "3";
                    }


                    ss = s.substring(118, 119);
                    if (ss.contains("1")) {
                        txt_sudong2.setText("수동");
                        tabHost2_2.setCurrentTabByTag("t1");
                        S_led2_status = "1";
                    }
                    if (ss.contains("2")) {
                        txt_sudong2.setText("타이머");
                        tabHost2_2.setCurrentTabByTag("t2");
                        S_led2_status = "2";
                    }
                    if (ss.contains("3")) {
                        txt_sudong2.setText("자동");
                        tabHost2_2.setCurrentTabByTag("t3");
                        S_led2_status = "3";
                    }


                    ss = s.substring(136, 137);
                    if (ss.contains("1")) {
                        txt_sudong3.setText("수동");
                        tabHost2_3.setCurrentTabByTag("t1");
                        S_led3_status = "1";
                    }
                    if (ss.contains("2")) {
                        txt_sudong3.setText("타이머");
                        tabHost2_3.setCurrentTabByTag("t2");
                        S_led3_status = "2";
                    }
                    if (ss.contains("3")) {
                        txt_sudong3.setText("자동");
                        tabHost2_3.setCurrentTabByTag("t3");
                        S_led3_status = "3";
                    }


                    ss = s.substring(154, 155);
                    if (ss.contains("1")) {
                        txt_sudong4.setText("수동");
                        tabHost2_4.setCurrentTabByTag("t1");
                        S_led4_status = "1";
                    }
                    if (ss.contains("2")) {
                        txt_sudong4.setText("타이머");
                        tabHost2_4.setCurrentTabByTag("t2");
                        S_led4_status = "2";
                    }
                    if (ss.contains("3")) {
                        txt_sudong4.setText("자동");
                        tabHost2_4.setCurrentTabByTag("t3");
                        S_led4_status = "3";
                    }


                    //jsonArray7 = new JSONArray(s);

                    //보광등 현재 상태 부분

                    int idx_1 = s.indexOf("led1_info\":\"");
                    idx_1 += 12;
                    int idx_1_end = s.indexOf("\",\"led2_info\"");
                    int idx_2 = s.indexOf("led2_info\":\"");
                    idx_2 += 12;
                    int idx_2_end = s.indexOf("\",\"led3_info\"");
                    int idx_3 = s.indexOf("led3_info\":\"");
                    idx_3 += 12;
                    int idx_3_end = s.indexOf("\",\"led4_info\"");
                    int idx_4 = s.indexOf("led4_info\":\"");
                    int idx_4_end = s.indexOf("\"}");
                    idx_4 += 12;


                    ////////////////////////////
                    /*
                    1구역

                     */
                    ss = s.substring(idx_1, idx_1_end);
                    if (ss.contains("off")) {
                        S_led1_info = "off";
                        btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                    }
                    if (ss.contains("on")) {
                        S_led1_info = "on";
                        btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                    }
                    if (ss.contains("&")) {

                        //첫번째 줄에 출력
                        int ss_4_1 = ss.indexOf("&");
                        if (ss_4_1 > 1) {   //5
                            String ss_4_1_1 = ss.substring(0, 2) + ":" + ss.substring(2, 4);   //0,4
                            String ss_4_1_2 = ss.substring(5, 7) + ":" + ss.substring(7, 9);   //5,9

                            time_1.setText(ss_4_1_1);
                            time_5.setText(ss_4_1_2);

                            S_led1_info = ss.substring(0, 4) + "%26" + ss.substring(5, 9);

                        }

                        //두번째 줄에 출력
                        int ss_4_2 = ss.indexOf("&", 5);
                        if (ss_4_2 > 1) {   //15
                            String ss_4_2_1 = ss.substring(11, 13) + ":" + ss.substring(13, 15); //11,15
                            String ss_4_2_2 = ss.substring(16, 18) + ":" + ss.substring(18, 20); //16,20

                            time_2.setText(ss_4_2_1);
                            time_6.setText(ss_4_2_2);

                            S_led1_info = S_led1_info + ", " + ss.substring(11, 15) + "%26" + ss.substring(16, 20);
                        }

                        //세번째 줄에 출력
                        int ss_4_3 = ss.indexOf("&", 20);
                        if (ss_4_3 > 1) {
                            String ss_4_3_1 = ss.substring(23, 25) + ":" + ss.substring(25, 27); //23,27
                            String ss_4_3_2 = ss.substring(28, 30) + ":" + ss.substring(30, 32); //28,32

                            time_3.setText(ss_4_3_1);
                            time_7.setText(ss_4_3_2);

                            S_led1_info = S_led1_info + ", " + ss.substring(23, 27) + "%26" + ss.substring(28, 32);
                        }


                    }


                    //////////////////////
                    /*
                    2구역

                     */
                    ss = s.substring(idx_2, idx_2_end);
                    if (ss.contains("off")) {
                        S_led2_info = "off";
                        btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                    }
                    if (ss.contains("on")) {
                        S_led2_info = "on";
                        btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                    }
                    if (ss.contains("&")) {

                        //첫번째 줄에 출력
                        int ss_4_1 = ss.indexOf("&");
                        if (ss_4_1 > 1) {   //5
                            String ss_4_1_1 = ss.substring(0, 2) + ":" + ss.substring(2, 4);   //0,4
                            String ss_4_1_2 = ss.substring(5, 7) + ":" + ss.substring(7, 9);   //5,9

                            time_1_2.setText(ss_4_1_1);
                            time_5_2.setText(ss_4_1_2);

                            S_led2_info = ss.substring(0, 4) + "%26" + ss.substring(5, 9);
                        }

                        //두번째 줄에 출력
                        int ss_4_2 = ss.indexOf("&", 5);
                        if (ss_4_2 > 1) {   //15
                            String ss_4_2_1 = ss.substring(11, 13) + ":" + ss.substring(13, 15); //11,15
                            String ss_4_2_2 = ss.substring(16, 18) + ":" + ss.substring(18, 20); //16,20

                            time_2_2.setText(ss_4_2_1);
                            time_6_2.setText(ss_4_2_2);

                            S_led2_info = S_led2_info + ", " + ss.substring(11, 15) + "%26" + ss.substring(16, 20);
                        }

                        //세번째 줄에 출력
                        int ss_4_3 = ss.indexOf("&", 20);
                        if (ss_4_3 > 1) {
                            String ss_4_3_1 = ss.substring(23, 25) + ":" + ss.substring(25, 27); //23,27
                            String ss_4_3_2 = ss.substring(28, 30) + ":" + ss.substring(30, 32); //28,32

                            time_3_2.setText(ss_4_3_1);
                            time_7_2.setText(ss_4_3_2);

                            S_led2_info = S_led2_info + ", " + ss.substring(23, 27) + "%26" + ss.substring(28, 32);
                        }
                    }


                    //////////////////////////
                    /*
                    3구역

                     */
                    ss = s.substring(idx_3, idx_3_end);
                    if (ss.contains("off")) {
                        S_led3_info = "off";
                        btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);


                    }
                    if (ss.contains("on")) {
                        S_led3_info = "on";
                        btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);


                    }
                    if (ss.contains("&")) {

                        //첫번째 줄에 출력
                        int ss_4_1 = ss.indexOf("&");
                        if (ss_4_1 > 1) {   //5
                            String ss_4_1_1 = ss.substring(0, 2) + ":" + ss.substring(2, 4);   //0,4
                            String ss_4_1_2 = ss.substring(5, 7) + ":" + ss.substring(7, 9);   //5,9

                            time_1_3.setText(ss_4_1_1);
                            time_5_3.setText(ss_4_1_2);

                            S_led3_info = ss.substring(0, 4) + "%26" + ss.substring(5, 9);
                        }

                        //두번째 줄에 출력
                        int ss_4_2 = ss.indexOf("&", 5);
                        if (ss_4_2 > 1) {   //15
                            String ss_4_2_1 = ss.substring(11, 13) + ":" + ss.substring(13, 15); //11,15
                            String ss_4_2_2 = ss.substring(16, 18) + ":" + ss.substring(18, 20); //16,20

                            time_2_3.setText(ss_4_2_1);
                            time_6_3.setText(ss_4_2_2);

                            S_led3_info = S_led3_info + ", " + ss.substring(11, 15) + "%26" + ss.substring(16, 20);
                        }

                        //세번째 줄에 출력
                        int ss_4_3 = ss.indexOf("&", 20);
                        if (ss_4_3 > 1) {
                            String ss_4_3_1 = ss.substring(23, 25) + ":" + ss.substring(25, 27); //23,27
                            String ss_4_3_2 = ss.substring(28, 30) + ":" + ss.substring(30, 32); //28,32

                            time_3_3.setText(ss_4_3_1);
                            time_7_3.setText(ss_4_3_2);

                            S_led3_info = S_led3_info + ", " + ss.substring(23, 27) + "%26" + ss.substring(28, 32);
                        }
                    }

                    //////////////////////////////
                    /*
                    4구역

                     */
                    ss = s.substring(idx_4, idx_4_end);
                    if (ss.contains("off")) {
                        S_led4_info = "off";
                        btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                    }
                    if (ss.contains("on")) {
                        S_led4_info = "on";
                        btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape);
                        btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                    }
                    if (ss.contains("&")) {

                        //첫번째 줄에 출력
                        int ss_4_1 = ss.indexOf("&");
                        if (ss_4_1 > 1) {   //5
                            String ss_4_1_1 = ss.substring(0, 2) + ":" + ss.substring(2, 4);   //0,4
                            String ss_4_1_2 = ss.substring(5, 7) + ":" + ss.substring(7, 9);   //5,9

                            time_1_4.setText(ss_4_1_1);
                            time_5_4.setText(ss_4_1_2);

                            S_led4_info = ss.substring(0, 4) + "%26" + ss.substring(5, 9);
                        }

                        //두번째 줄에 출력
                        int ss_4_2 = ss.indexOf("&", 5);
                        if (ss_4_2 > 1) {   //15
                            String ss_4_2_1 = ss.substring(11, 13) + ":" + ss.substring(13, 15); //11,15
                            String ss_4_2_2 = ss.substring(16, 18) + ":" + ss.substring(18, 20); //16,20

                            time_2_4.setText(ss_4_2_1);
                            time_6_4.setText(ss_4_2_2);

                            S_led4_info = S_led3_info + ", " + ss.substring(11, 15) + "%26" + ss.substring(16, 20);
                        }

                        //세번째 줄에 출력
                        int ss_4_3 = ss.indexOf("&", 20);
                        if (ss_4_3 > 1) {
                            String ss_4_3_1 = ss.substring(23, 25) + ":" + ss.substring(25, 27); //23,27
                            String ss_4_3_2 = ss.substring(28, 30) + ":" + ss.substring(30, 32); //28,32

                            time_3_4.setText(ss_4_3_1);
                            time_7_4.setText(ss_4_3_2);

                            S_led4_info = S_led3_info + ", " + ss.substring(23, 27) + "%26" + ss.substring(28, 32);
                        }
                    }


                }



/*
                if (txt_su == 0) {
                    for (int i = 0; i < jsonArray6.length(); i++) {
                        JSONObject jo = jsonArray6.getJSONObject(i);

                        String led1_status = jo.getString("led1_status");
                        String led2_status = jo.getString("led2_status");
                        String led3_status = jo.getString("led3_status");
                        String led4_status = jo.getString("led4_status");




                        ss = led1_status;
                        ss2 = led2_status;
                        ss3 = led3_status;
                        ss4 = led4_status;





                        txt_sudong.setText(ss);
                        txt_sudong2.setText(ss2);
                        txt_sudong3.setText(ss3);
                        txt_sudong4.setText(ss4);



                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);
                    }
                }
*/

                if (ih == 0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jo = jsonArray.getJSONObject(i);

                        String par1 = jo.getString("par1");
                        String par2 = jo.getString("par2");
                        String par3 = jo.getString("par3");
                        String par4 = jo.getString("par4");
                        String par_time = jo.getString("reg_time");


                        ss = par1;
                        ss2 = par2;
                        ss3 = par3;
                        ss4 = par4;
                        ss5 = par_time;


                        chfText.setText(ss);
                        usdText.setText(ss2);
                        jpyText.setText(ss3);
                        tryText.setText(ss4);

                        ss5 = ss5.substring(0, 4) + "년" + ss5.substring(4, 6) + "월" + ss5.substring(6, 8) + "일" + ss5.substring(8, 17);


                        par_reg_time.setText(ss5);


                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);
                    }
                }
                if (ih == 1) {
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        JSONObject jo = jsonArray2.getJSONObject(i);


                        String led1 = jo.getString("led1");
                        String led2 = jo.getString("led2");
                        String led3 = jo.getString("led3");
                        String led4 = jo.getString("led4");
                        String led_times = jo.getString("reg_time");


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


                        cadText.setText(ss5);
                        ledText.setText(ss6);
                        ledText3.setText(ss7);
                        ledText4.setText(ss8);

                        LED_on_off.setText(ss5);
                        LED_on_off_2.setText(ss6);
                        LED_on_off_3.setText(ss7);
                        LED_on_off_4.setText(ss8);

                        ss9 = led_times;
                        ss9 = ss9.substring(0, 4) + "년" + ss9.substring(4, 6) + "월" + ss9.substring(6, 8) + "일" + ss9.substring(8, 17);
                        led_reg_time.setText(ss9);

/*                        LED_on_off.setText(ss5);

                        if (ss5.contains("OFF")) {
                            btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        } if (ss5.contains("ON")) {
                            btn_bulb2.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb1.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        }

                        LED_on_off_2.setText(ss6);
                        if (ss6.contains("OFF")) {
                            btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        } if (ss6.contains("ON")) {
                            btn_bulb2_2.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb1_2.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        }


                        LED_on_off_3.setText(ss7);
                        if (ss7.contains("OFF")) {
                            btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        } if (ss7.contains("ON")) {
                            btn_bulb2_3.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb1_3.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        }

                        LED_on_off_4.setText(ss8);
                        if (ss8.contains("OFF")) {
                            btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        } if (ss8.contains("ON")) {
                            btn_bulb2_4.setBackgroundResource(R.drawable.btn_bulb_shape);
                            btn_bulb1_4.setBackgroundResource(R.drawable.btn_bulb_shape_dark);
                        }*/

                    }
                }
                if (ih == 2) {
                    for (int i = 0; i < jsonArray3.length(); i++) {


                        JSONObject jo = jsonArray3.getJSONObject(i);


                        String par1_avg = jo.getString("par1_avg");
                        String par2_avg = jo.getString("par2_avg");
                        String par3_avg = jo.getString("par3_avg");
                        String par4_avg = jo.getString("par4_avg");
                        String reg_time = jo.getString("reg_time");

                        if (i == 0) {
                            show_date_par_date_first.setText(reg_time.substring(0, 10));
                        }


                        ss = reg_time.substring(11, 13) + "\n";
                        ss2 = par1_avg + "\n";
                        ss3 = par2_avg + "\n";
                        ss4 = par3_avg + "\n";
                        ss5 = par4_avg + "\n";


                        show_date_par_date.setText(show_date_par_date.getText().toString() + ss); //시간
                        show_date_par.setText(show_date_par.getText().toString() + ss2);    //Par1
                        show_date_par2.setText(show_date_par2.getText().toString() + ss3);  //Par2
                        show_date_par3.setText(show_date_par3.getText().toString() + ss4);  //Par3
                        show_date_par4.setText(show_date_par4.getText().toString() + ss5);  //Par4


                        Log.i("MyTag", "parser start");
                        Log.i("My Tag", ss);

                    }


                    txt_su = 1;


                }
                if (check_day == 1) {
                    Log.i("check_day", "check_day clicked");

                }
                if (check_day == 2) {
                    Log.i("check_day", "check_day clicked");


                }

                ih++;



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
                strDate = tempDate.substring(0, 4);    //년도 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(6, 8);    //월 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(10, 12);    //일 잘라내기

                Log.i("strDate", strDate);

                check_day = 1;
                DownloadData downloadData4 = new DownloadData();
                try {
                    //시간에 따른 parsensor값
                    String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListDay?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35&strDate=" + strDate + "&endDate=" + strDate;
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
                strDate = tempDate.substring(0, 4);    //년도 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(6, 8);    //월 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(firstDate.getTime());
                strDate = strDate + tempDate.substring(10, 12);    //일 잘라내기

                Log.i("strDate", strDate);


                //끝나는 날짜
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime());
                Log.i("tempDate", tempDate);
                endDate = tempDate.substring(0, 4);    //년도 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime());
                endDate = endDate + tempDate.substring(6, 8);    //월 잘라내기
                tempDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(secondDate.getTime());
                endDate = endDate + tempDate.substring(10, 12);    //일 잘라내기

                Log.i("endDate", endDate);


                check_day = 1;
                DownloadData downloadData4 = new DownloadData();
                try {
                    //시간에 따른 parsensor값
                    String url = "http://cjpre.dataponic.co.kr:10080/preAPI/getParListDay?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35&strDate=" + strDate + "&endDate=" + endDate;
                    downloadData4.execute(url);
                    Log.i("MyTag_check_day", "success");
                } catch (Exception e) {
                    Log.i("MyTag_check_day", "Fail");
                }
            }
        }
    }

    private void HttpPost() {

        new AsyncTask<Void, Void, JSONObject>() {

            @Override
            protected JSONObject doInBackground(Void... voids) {

                JSONObject result = null;
                try {
                    URL url = new URL("http://cjpre.dataponic.co.kr:10080/preAPI/putLedSetData?servicekey=3765575006d27474d35b1023b67297de0025467bb4d5566f509a5d0634c2dd35");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setUseCaches(false);
                    connection.setConnectTimeout(15000);

                    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());

                    HashMap<String, String> map = new HashMap<>();
                    map.put("reg_time", S_reg_time);
                    map.put("eq_num", "ABC001");
                    map.put("led1_status", S_led1_status);
                    map.put("led2_status", S_led2_status);
                    map.put("led3_status", S_led3_status);
                    map.put("led4_status", S_led4_status);
                    map.put("led1_info", S_led1_info);
                    map.put("led2_info", S_led2_info);
                    map.put("led3_info", S_led3_info);
                    map.put("led4_info", S_led4_info);

                    StringBuffer sbParams = new StringBuffer();

                    Log.i("world", "hihi");

                    boolean isAnd = false;

                    for (String key : map.keySet()) {

                        if (isAnd)

                            sbParams.append("&");


                        sbParams.append(key).append("=").append(map.get(key));

                        if (!isAnd)

                            if (map.size() >= 2)

                                isAnd = true;

                    }


                    wr.write(sbParams.toString());

                    wr.flush();

                    wr.close();

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();

                    } else {
                        Log.e("world", "ConnectException");
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        result = new JSONObject(response.toString());
                    }

                } catch (ConnectException e) {
                    //Log.e(TAG, "ConnectException");
                    e.printStackTrace();
                    Log.e("world", "ConnectException");


                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("world", "ConnectException");
                }

                return result;
            }

            @Override
            protected void onPostExecute(JSONObject jsonObject) {
                super.onPostExecute(jsonObject);
            }

        }.execute();
    }
}
