package app.cave.cgpacalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;

public class MainActivity extends AppCompatActivity {
int adds=0;
    LinearLayout cgpaL, resultL;
    TextView resulttCgpaTV, resulttPointTv, resultCreditTv, resulttCourseTv;
    Button againCalBtn;

    TextView addCourse, calculateTV, resetCourseTV;
    LinearLayout calculateLayout;
    ScrollView scroll;


    boolean finish = false;
    boolean permission3, permission4, permission5, permission6, permission7, permission8, permission9, permission10,
            permission11, permission12, permission13, permission14, permission15 = false;
    boolean stringEmpty = false;
    boolean gpaEmpty = false;

    LinearLayout s_Raw_3, s_Raw_4, s_Raw_5, s_Raw_6, s_Raw_7, s_Raw_8, s_Raw_9, s_Raw_10,
            s_Raw_11, s_Raw_12, s_Raw_13, s_Raw_14, s_Raw_15;

    EditText creditET1, creditET2, creditET3, creditET4, creditET5, creditET6, creditET7, creditET8, creditET9, creditET10,
            creditET11, creditET12, creditET13, creditET14, creditET15;

    Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10,
            spinner11, spinner12, spinner13, spinner14, spinner15;


    int addCourseBtnClickCount = 2;

    float gpa1, gpa2, gpa3, gpa4, gpa5, gpa6, gpa7, gpa8, gpa9, gpa10, gpa11, gpa12, gpa13, gpa14, gpa15;

    float credit1, credit2, credit3, credit4, credit5, credit6, credit7, credit8, credit9, credit10,
            credit11, credit12, credit13, credit14, credit15;

    float point1, point2, point3, point4, point5, point6, point7, point8, point9, point10,
            point11, point12, point13, point14, point15;

    int g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14, g15;

    View view;

    AdView adView;
    private InterstitialAd mInterstitialAd;
    private boolean doubleBackToExitPressedOnce=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        init();

        MobileAds.initialize(this, getString(R.string.appID));

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void init() {

        addCourse = (TextView) findViewById(R.id.add_course_TV);
        calculateTV = (TextView) findViewById(R.id.calculate_TV);
        //  resetCourseTV = (TextView) findViewById(R.id.reset_course_TV);
        calculateLayout = (LinearLayout) findViewById(R.id.calculate_layout);
        scroll = (ScrollView) findViewById(R.id.scroll_view);

        s_Raw_3 = (LinearLayout) findViewById(R.id.s_raw_3);
        s_Raw_4 = (LinearLayout) findViewById(R.id.s_row_4);
        s_Raw_5 = (LinearLayout) findViewById(R.id.s_row_5);
        s_Raw_6 = (LinearLayout) findViewById(R.id.s_row_6);
        s_Raw_7 = (LinearLayout) findViewById(R.id.s_row_7);
        s_Raw_8 = (LinearLayout) findViewById(R.id.s_row_8);
        s_Raw_9 = (LinearLayout) findViewById(R.id.s_row_9);
        s_Raw_10 = (LinearLayout) findViewById(R.id.s_row_10);
        s_Raw_11 = (LinearLayout) findViewById(R.id.s_row_11);
        s_Raw_12 = (LinearLayout) findViewById(R.id.s_row_12);
        s_Raw_13 = (LinearLayout) findViewById(R.id.s_row_13);
        s_Raw_14 = (LinearLayout) findViewById(R.id.s_row_14);
        s_Raw_15 = (LinearLayout) findViewById(R.id.s_row_15);

        creditET1 = (EditText) findViewById(R.id.s_credit_ET1);
        creditET2 = (EditText) findViewById(R.id.s_credit_ET2);
        creditET3 = (EditText) findViewById(R.id.s_credit_ET3);
        creditET4 = (EditText) findViewById(R.id.s_credit_ET4);
        creditET5 = (EditText) findViewById(R.id.s_credit_ET5);
        creditET6 = (EditText) findViewById(R.id.s_credit_ET6);
        creditET7 = (EditText) findViewById(R.id.s_credit_ET7);
        creditET8 = (EditText) findViewById(R.id.s_credit_ET8);
        creditET9 = (EditText) findViewById(R.id.s_credit_ET9);
        creditET10 = (EditText) findViewById(R.id.s_credit_ET10);
        creditET11 = (EditText) findViewById(R.id.s_credit_ET11);
        creditET12 = (EditText) findViewById(R.id.s_credit_ET12);
        creditET13 = (EditText) findViewById(R.id.s_credit_ET13);
        creditET14 = (EditText) findViewById(R.id.s_credit_ET14);
        creditET15 = (EditText) findViewById(R.id.s_credit_ET15);

        spinner1 = (Spinner) findViewById(R.id.s_spinner1);
        spinner2 = (Spinner) findViewById(R.id.s_spinner2);
        spinner3 = (Spinner) findViewById(R.id.s_spinner3);
        spinner4 = (Spinner) findViewById(R.id.s_spinner4);
        spinner5 = (Spinner) findViewById(R.id.s_spinner5);
        spinner6 = (Spinner) findViewById(R.id.s_spinner6);
        spinner7 = (Spinner) findViewById(R.id.s_spinner7);
        spinner8 = (Spinner) findViewById(R.id.s_spinner8);
        spinner9 = (Spinner) findViewById(R.id.s_spinner9);
        spinner10 = (Spinner) findViewById(R.id.s_spinner10);
        spinner11 = (Spinner) findViewById(R.id.s_spinner11);
        spinner12 = (Spinner) findViewById(R.id.s_spinner12);
        spinner13 = (Spinner) findViewById(R.id.s_spinner13);
        spinner14 = (Spinner) findViewById(R.id.s_spinner14);
        spinner15 = (Spinner) findViewById(R.id.s_spinner15);

//
        cgpaL = findViewById(R.id.cgpaCalculationLayout);
        resultL = findViewById(R.id.resultLayout);

        resulttCgpaTV = findViewById(R.id.total_cgpa_TV);
        resulttCourseTv = findViewById(R.id.total_course_TV);
        resultCreditTv = findViewById(R.id.total_credit_TV);
        resulttPointTv = findViewById(R.id.total_grade_TV);

        againCalBtn = findViewById(R.id.againCalID);

        //
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addNewCourse();

            }


        });


        againCalBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                cgpaL.setVisibility(View.VISIBLE);
                resultL.setVisibility(View.GONE);

                adds++;
                if(adds%2==0)
                {
                    mInterstitialAd = new InterstitialAd(MainActivity.this);
                    mInterstitialAd.setAdUnitId(getString(R.string.instarial_full_screen));
                    AdRequest adRequest = new AdRequest.Builder().build();//.addTestDevice("93448558CC721EBAD8FAAE5DA52596D3").build(); //add test device
                    mInterstitialAd.loadAd(adRequest);
                    mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            }
                        }
                    });
                }
            }
        });
        calculateTV.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                adds++;
                if(adds%2==0)
                {
                    mInterstitialAd = new InterstitialAd(MainActivity.this);
                    mInterstitialAd.setAdUnitId(getString(R.string.instarial_full_screen));
                    AdRequest adRequest = new AdRequest.Builder().build();//.addTestDevice("93448558CC721EBAD8FAAE5DA52596D3").build(); //add test device
                    mInterstitialAd.loadAd(adRequest);
                    mInterstitialAd.setAdListener(new AdListener() {
                        public void onAdLoaded() {
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            }
                        }
                    });
                }


                calculateSGPA();


            }
        });


        calculateLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {


                calculateSGPA();


            }
        });


       /* resetCourseTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetAll();
            }
        });*/


    }


    private void addNewCourse() {

        switch (++addCourseBtnClickCount) {

            case 3: {
                s_Raw_3.setVisibility(LinearLayout.VISIBLE);
                s_Raw_3.requestFocus();
                finish = false;
                break;
            }
            case 4: {
                s_Raw_4.setVisibility(LinearLayout.VISIBLE);
                s_Raw_4.requestFocus();
                finish = false;
                break;
            }
            case 5: {
                s_Raw_5.setVisibility(LinearLayout.VISIBLE);
                s_Raw_5.requestFocus();
                finish = false;
                break;
            }
            case 6: {
                s_Raw_6.setVisibility(LinearLayout.VISIBLE);
                s_Raw_6.requestFocus();
                finish = false;
                break;
            }
            case 7: {
                s_Raw_7.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                finish = false;
                break;
            }
            case 8: {
                s_Raw_8.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                finish = false;
                break;
            }
            case 9: {
                s_Raw_9.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }
            case 10: {
                s_Raw_10.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }
            case 11: {
                s_Raw_11.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }
            case 12: {
                s_Raw_12.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }
            case 13: {
                s_Raw_13.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }
            case 14: {
                s_Raw_14.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }
            case 15: {
                s_Raw_15.setVisibility(LinearLayout.VISIBLE);
                addCourse.requestFocus();
                scroll.fullScroll(View.FOCUS_DOWN);
                finish = false;
                break;
            }

            default: {

                Toast.makeText(MainActivity.this, "Maximum number of Course has been added", Toast.LENGTH_SHORT).show();
            }


        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)

    private void calculateSGPA() {

        getGradeGPA();

        if (creditET1.getText().toString().equals("")) {

            creditET1.setError("FillUp");
            stringEmpty = true;

        } else {

            credit1 = Float.parseFloat(creditET1.getText().toString());
            stringEmpty = false;


        }


        if (creditET2.getText().toString().equals("")) {

            creditET2.setError("FillUp");
            stringEmpty = true;

        } else {

            credit2 = Float.parseFloat(creditET2.getText().toString());
            stringEmpty = false;

        }


        if (s_Raw_3.getVisibility() == View.VISIBLE) {

            if (creditET3.getText().toString().equals("")) {

                creditET3.setError("FillUp");
                stringEmpty = true;

            } else {

                credit3 = Float.parseFloat(creditET3.getText().toString());
                stringEmpty = false;

            }

        } else {


            if (!stringEmpty && !gpaEmpty) {


                finish = true;
                float totalCredit = credit1 + credit2;

                point1 = gpa1 * credit1;
                point2 = gpa2 * credit2;

                float totalPoint = point1 + point2;
                float sGPA = totalPoint / totalCredit;


                String totalSGPA = String.format("%.2f", sGPA);
                String finalTotalPoint = String.format("%.2f", totalPoint);
                String finalTotalCredit = String.format("%.2f", totalCredit);


                cgpaL.setVisibility(View.GONE);
                resultL.setVisibility(View.VISIBLE);
                resulttPointTv.setText(finalTotalPoint);
                resultCreditTv.setText(finalTotalCredit);
                resulttCourseTv.setText("2");
                resulttCgpaTV.setText(totalSGPA);
            }
        }


        if (!finish || permission3) {

            if (s_Raw_4.getVisibility() == View.VISIBLE) {

                if (creditET4.getText().toString().equals("")) {

                    creditET4.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit4 = Float.parseFloat(creditET4.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission3 = true;
                    float totalCredit = credit1 + credit2 + credit3;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;

                    float totalPoint = point1 + point2 + point3;
                    float sGPA = totalPoint / totalCredit;


                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("3");
                    resulttCgpaTV.setText(totalSGPA);
                }


            }
        }


        if (!finish || permission4) {

            if (s_Raw_5.getVisibility() == View.VISIBLE) {

                if (creditET5.getText().toString().equals("")) {

                    creditET5.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit5 = Float.parseFloat(creditET5.getText().toString());
                    stringEmpty = false;
                }

            } else {

                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission4 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;

                    float totalPoint = point1 + point2 + point3 + point4;
                    float sGPA = totalPoint / totalCredit;


                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("4");
                    resulttCgpaTV.setText(totalSGPA);
                }


            }

        }


        if (!finish || permission5) {

            if (s_Raw_6.getVisibility() == View.VISIBLE) {

                if (creditET6.getText().toString().equals("")) {

                    creditET6.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit6 = Float.parseFloat(creditET6.getText().toString());
                    stringEmpty = false;
                }

            } else {

                if (!stringEmpty && !gpaEmpty) {

                    permission5 = true;
                    finish = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;

                    float totalPoint = point1 + point2 + point3 + point4 + point5;
                    float sGPA = totalPoint / totalCredit;


                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);

                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("5");
                    resulttCgpaTV.setText(totalSGPA);

                }


            }

        }


        if (!finish || permission6) {


            if (s_Raw_7.getVisibility() == View.VISIBLE) {

                if (creditET7.getText().toString().equals("")) {

                    creditET7.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit7 = Float.parseFloat(creditET7.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission6 = true;

                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6;
                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("6");
                    resulttCgpaTV.setText(totalSGPA);
                }

            }
        }


        if (!finish || permission7) {

            if (s_Raw_8.getVisibility() == View.VISIBLE) {

                if (creditET8.getText().toString().equals("")) {

                    creditET8.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit8 = Float.parseFloat(creditET8.getText().toString());
                    stringEmpty = false;
                }

            } else {

                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission7 = true;

                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7;
                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("7");
                    resulttCgpaTV.setText(totalSGPA);
                }
            }
        }


        if (!finish || permission8) {


            if (s_Raw_9.getVisibility() == View.VISIBLE) {

                if (creditET9.getText().toString().equals("")) {

                    creditET9.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit9 = Float.parseFloat(creditET9.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission8 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8;
                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("8");
                    resulttCgpaTV.setText(totalSGPA);
                }

            }

        }


        if (!finish || permission9) {


            if (s_Raw_10.getVisibility() == View.VISIBLE) {

                if (creditET10.getText().toString().equals("")) {

                    creditET10.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit10 = Float.parseFloat(creditET10.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission9 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;
                    point9 = gpa9 * credit9;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9;
                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);

                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("9");
                    resulttCgpaTV.setText(totalSGPA);
                }

            }
        }


        if (!finish || permission10) {


            if (s_Raw_11.getVisibility() == View.VISIBLE) {

                if (creditET11.getText().toString().equals("")) {

                    creditET11.setError("FillUp");
                    stringEmpty = true;
                } else {

                    credit11 = Float.parseFloat(creditET11.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission10 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9 + credit10;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;
                    point9 = gpa9 * credit9;
                    point10 = gpa10 * credit10;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10;
                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("10");
                    resulttCgpaTV.setText(totalSGPA);

                }


            }

        }


        if (!finish || permission11) {


            if (s_Raw_12.getVisibility() == View.VISIBLE) {

                if (creditET12.getText().toString().equals("")) {

                    creditET12.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit12 = Float.parseFloat(creditET12.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission11 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9 + credit10 +
                            credit11;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;
                    point9 = gpa9 * credit9;
                    point10 = gpa10 * credit10;
                    point11 = gpa11 * credit11;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10 +
                            point11;
                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("11");
                    resulttCgpaTV.setText(totalSGPA);


                }

            }

        }


        if (!finish || permission12) {


            if (s_Raw_13.getVisibility() == View.VISIBLE) {

                if (creditET13.getText().toString().equals("")) {

                    creditET13.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit13 = Float.parseFloat(creditET13.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {


                    finish = true;
                    permission12 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9 + credit10 +
                            credit11 + credit12;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;
                    point9 = gpa9 * credit9;
                    point10 = gpa10 * credit10;
                    point11 = gpa11 * credit11;
                    point12 = gpa12 * credit12;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10 +
                            point11 + point12;

                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("12");
                    resulttCgpaTV.setText(totalSGPA);

                }

            }


        }


        if (!finish || permission13) {


            if (s_Raw_14.getVisibility() == View.VISIBLE) {

                if (creditET14.getText().toString().equals("")) {

                    creditET14.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit14 = Float.parseFloat(creditET14.getText().toString());
                    stringEmpty = false;
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission13 = true;

                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9 + credit10 +
                            credit11 + credit12 + credit13;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;
                    point9 = gpa9 * credit9;
                    point10 = gpa10 * credit10;
                    point11 = gpa11 * credit11;
                    point12 = gpa12 * credit12;
                    point13 = gpa13 * credit13;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10 +
                            point11 + point12 + point13;

                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("13");
                    resulttCgpaTV.setText(totalSGPA);
                }

            }


        }


        if (!finish || permission14) {


            if (s_Raw_15.getVisibility() == View.VISIBLE) {

                if (creditET15.getText().toString().equals("")) {

                    creditET15.setError("FillUp");
                    stringEmpty = true;

                } else {

                    credit15 = Float.parseFloat(creditET15.getText().toString());
                    stringEmpty = false;
                    doLast();
                }

            } else {


                if (!stringEmpty && !gpaEmpty) {

                    finish = true;
                    permission14 = true;
                    float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9 + credit10 +
                            credit11 + credit12 + credit13 + credit14;

                    point1 = gpa1 * credit1;
                    point2 = gpa2 * credit2;
                    point3 = gpa3 * credit3;
                    point4 = gpa4 * credit4;
                    point5 = gpa5 * credit5;
                    point6 = gpa6 * credit6;
                    point7 = gpa7 * credit7;
                    point8 = gpa8 * credit8;
                    point9 = gpa9 * credit9;
                    point10 = gpa10 * credit10;
                    point11 = gpa11 * credit11;
                    point12 = gpa12 * credit12;
                    point13 = gpa13 * credit13;
                    point14 = gpa13 * credit14;

                    float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10 +
                            point11 + point12 + point13 + point14;

                    float sGPA = totalPoint / totalCredit;

                    String totalSGPA = String.format("%.2f", sGPA);
                    String finalTotalPoint = String.format("%.2f", totalPoint);
                    String finalTotalCredit = String.format("%.2f", totalCredit);


                    cgpaL.setVisibility(View.GONE);
                    resultL.setVisibility(View.VISIBLE);
                    resulttPointTv.setText(finalTotalPoint);
                    resultCreditTv.setText(finalTotalCredit);
                    resulttCourseTv.setText("14");
                    resulttCgpaTV.setText(totalSGPA);

                }

            }
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void doLast() {


        float totalCredit = credit1 + credit2 + credit3 + credit4 + credit5 + credit6 + credit7 + credit8 + credit9 + credit10 +
                credit11 + credit12 + credit13 + credit14 + credit15;

        point1 = gpa1 * credit1;
        point2 = gpa2 * credit2;
        point3 = gpa3 * credit3;
        point4 = gpa4 * credit4;
        point5 = gpa5 * credit5;
        point6 = gpa6 * credit6;
        point7 = gpa7 * credit7;
        point8 = gpa8 * credit8;
        point9 = gpa9 * credit9;
        point10 = gpa10 * credit10;
        point11 = gpa11 * credit11;
        point12 = gpa12 * credit12;
        point13 = gpa13 * credit13;
        point14 = gpa13 * credit14;
        point15 = gpa15 * credit15;

        float totalPoint = point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10 +
                point11 + point12 + point13 + point14 + point15;

        float sGPA = totalPoint / totalCredit;

        String totalSGPA = String.format("%.2f", sGPA);
        String finalTotalPoint = String.format("%.2f", totalPoint);
        String finalTotalCredit = String.format("%.2f", totalCredit);

        cgpaL.setVisibility(View.GONE);
        resultL.setVisibility(View.VISIBLE);
        resulttPointTv.setText(finalTotalPoint);
        resultCreditTv.setText(finalTotalCredit);
        resulttCourseTv.setText("15");
        resulttCgpaTV.setText(totalSGPA);

    }


    private void getGradeGPA() {


        g1 = spinner1.getSelectedItemPosition();
        g2 = spinner2.getSelectedItemPosition();
        g3 = spinner3.getSelectedItemPosition();
        g4 = spinner4.getSelectedItemPosition();
        g5 = spinner5.getSelectedItemPosition();
        g6 = spinner6.getSelectedItemPosition();
        g7 = spinner7.getSelectedItemPosition();
        g8 = spinner8.getSelectedItemPosition();
        g9 = spinner9.getSelectedItemPosition();
        g10 = spinner10.getSelectedItemPosition();
        g11 = spinner11.getSelectedItemPosition();
        g12 = spinner12.getSelectedItemPosition();
        g13 = spinner13.getSelectedItemPosition();
        g14 = spinner14.getSelectedItemPosition();
        g15 = spinner15.getSelectedItemPosition();

        if (g1 == 0) {

            Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 1", Toast.LENGTH_SHORT).show();
            gpaEmpty = true;

        } else if (g1 == 1) {

            gpa1 = (float) 4.00;
            gpaEmpty = false;

        } else if (g1 == 2) {

            gpa1 = (float) 3.75;
            gpaEmpty = false;

        } else if (g1 == 3) {

            gpa1 = (float) 3.50;
            gpaEmpty = false;


        } else if (g1 == 4) {

            gpa1 = (float) 3.25;
            gpaEmpty = false;

        } else if (g1 == 5) {

            gpa1 = (float) 3.00;
            gpaEmpty = false;

        } else if (g1 == 6) {

            gpa1 = (float) 2.75;
            gpaEmpty = false;

        } else if (g1 == 7) {

            gpa1 = (float) 2.50;
            gpaEmpty = false;

        } else if (g1 == 8) {

            gpa1 = (float) 2.25;
            gpaEmpty = false;

        } else if (g1 == 9) {

            gpa1 = (float) 2.00;
            gpaEmpty = false;

        } else if (g1 == 10) {

            gpa1 = (float) 0.00;
            gpaEmpty = false;
        }


        if (g2 == 0) {

            gpaEmpty = true;
            Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 2", Toast.LENGTH_SHORT).show();

        } else if (g2 == 1) {

            gpa2 = (float) 4.00;
            gpaEmpty = false;

        } else if (g2 == 2) {

            gpa2 = (float) 3.75;
            gpaEmpty = false;

        } else if (g2 == 3) {

            gpa2 = (float) 3.50;
            gpaEmpty = false;


        } else if (g2 == 4) {

            gpa2 = (float) 3.25;
            gpaEmpty = false;

        } else if (g2 == 5) {

            gpa2 = (float) 3.00;
            gpaEmpty = false;

        } else if (g2 == 6) {

            gpa2 = (float) 2.75;
            gpaEmpty = false;

        } else if (g2 == 7) {

            gpa2 = (float) 2.50;
            gpaEmpty = false;

        } else if (g2 == 8) {

            gpa2 = (float) 2.25;
            gpaEmpty = false;

        } else if (g2 == 9) {

            gpa2 = (float) 2.00;
            gpaEmpty = false;

        } else if (g2 == 10) {

            gpa2 = (float) 0.00;
            gpaEmpty = false;
        }


        if (s_Raw_3.getVisibility() == View.VISIBLE) {


            if (g3 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 3", Toast.LENGTH_SHORT).show();

            } else if (g3 == 1) {

                gpa3 = (float) 4.00;
                gpaEmpty = false;

            } else if (g3 == 2) {

                gpa3 = (float) 3.75;
                gpaEmpty = false;

            } else if (g3 == 3) {

                gpa3 = (float) 3.50;
                gpaEmpty = false;


            } else if (g3 == 4) {

                gpa3 = (float) 3.25;
                gpaEmpty = false;

            } else if (g3 == 5) {

                gpa3 = (float) 3.00;
                gpaEmpty = false;

            } else if (g3 == 6) {

                gpa3 = (float) 2.75;
                gpaEmpty = false;

            } else if (g3 == 7) {

                gpa3 = (float) 2.50;
                gpaEmpty = false;

            } else if (g3 == 8) {

                gpa3 = (float) 2.25;
                gpaEmpty = false;

            } else if (g3 == 9) {

                gpa3 = (float) 2.00;
                gpaEmpty = false;

            } else if (g3 == 10) {

                gpa3 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_4.getVisibility() == View.VISIBLE) {


            if (g4 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 4", Toast.LENGTH_SHORT).show();

            } else if (g4 == 1) {

                gpa4 = (float) 4.00;
                gpaEmpty = false;

            } else if (g4 == 2) {

                gpa4 = (float) 3.75;
                gpaEmpty = false;

            } else if (g4 == 3) {

                gpa4 = (float) 3.50;
                gpaEmpty = false;

            } else if (g4 == 4) {

                gpa4 = (float) 3.25;
                gpaEmpty = false;

            } else if (g4 == 5) {

                gpa4 = (float) 3.00;
                gpaEmpty = false;

            } else if (g4 == 6) {

                gpa4 = (float) 2.75;
                gpaEmpty = false;

            } else if (g4 == 7) {

                gpa4 = (float) 2.50;
                gpaEmpty = false;

            } else if (g4 == 8) {

                gpa4 = (float) 2.25;
                gpaEmpty = false;

            } else if (g4 == 9) {

                gpa4 = (float) 2.00;
                gpaEmpty = false;

            } else if (g4 == 10) {

                gpa4 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_5.getVisibility() == View.VISIBLE) {

            if (g5 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 5", Toast.LENGTH_SHORT).show();

            } else if (g5 == 1) {

                gpa5 = (float) 4.00;
                gpaEmpty = false;

            } else if (g5 == 2) {

                gpa5 = (float) 3.75;
                gpaEmpty = false;

            } else if (g5 == 3) {

                gpa5 = (float) 3.50;
                gpaEmpty = false;

            } else if (g5 == 4) {

                gpa5 = (float) 3.25;
                gpaEmpty = false;

            } else if (g5 == 5) {

                gpa5 = (float) 3.00;
                gpaEmpty = false;

            } else if (g5 == 6) {

                gpa5 = (float) 2.75;
                gpaEmpty = false;

            } else if (g5 == 7) {

                gpa5 = (float) 2.50;
                gpaEmpty = false;

            } else if (g5 == 8) {

                gpa5 = (float) 2.25;
                gpaEmpty = false;

            } else if (g5 == 9) {

                gpa5 = (float) 2.00;
                gpaEmpty = false;

            } else if (g5 == 10) {

                gpa5 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_6.getVisibility() == View.VISIBLE) {

            if (g6 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 6", Toast.LENGTH_SHORT).show();

            } else if (g6 == 1) {

                gpa6 = (float) 4.00;
                gpaEmpty = false;

            } else if (g6 == 2) {

                gpa6 = (float) 3.75;
                gpaEmpty = false;

            } else if (g6 == 3) {

                gpa6 = (float) 3.50;
                gpaEmpty = false;

            } else if (g6 == 4) {

                gpa6 = (float) 3.25;
                gpaEmpty = false;

            } else if (g6 == 5) {

                gpa6 = (float) 3.00;
                gpaEmpty = false;

            } else if (g6 == 6) {

                gpa6 = (float) 2.75;
                gpaEmpty = false;

            } else if (g6 == 7) {

                gpa6 = (float) 2.50;
                gpaEmpty = false;

            } else if (g6 == 8) {

                gpa6 = (float) 2.25;
                gpaEmpty = false;

            } else if (g6 == 9) {

                gpa6 = (float) 2.00;
                gpaEmpty = false;

            } else if (g6 == 10) {

                gpa6 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_7.getVisibility() == View.VISIBLE) {

            if (g7 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 7", Toast.LENGTH_SHORT).show();

            } else if (g7 == 1) {

                gpa7 = (float) 4.00;
                gpaEmpty = false;

            } else if (g7 == 2) {

                gpa7 = (float) 3.75;
                gpaEmpty = false;

            } else if (g7 == 3) {

                gpa7 = (float) 3.50;
                gpaEmpty = false;

            } else if (g7 == 4) {

                gpa7 = (float) 3.25;
                gpaEmpty = false;

            } else if (g7 == 5) {

                gpa7 = (float) 3.00;
                gpaEmpty = false;

            } else if (g7 == 6) {

                gpa7 = (float) 2.75;
                gpaEmpty = false;

            } else if (g7 == 7) {

                gpa7 = (float) 2.50;
                gpaEmpty = false;

            } else if (g7 == 8) {

                gpa7 = (float) 2.25;
                gpaEmpty = false;

            } else if (g7 == 9) {

                gpa7 = (float) 2.00;
                gpaEmpty = false;

            } else if (g7 == 10) {

                gpa7 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_8.getVisibility() == View.VISIBLE) {

            if (g8 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 8", Toast.LENGTH_SHORT).show();

            } else if (g8 == 1) {

                gpa8 = (float) 4.00;
                gpaEmpty = false;

            } else if (g8 == 2) {

                gpa8 = (float) 3.75;
                gpaEmpty = false;

            } else if (g8 == 3) {

                gpa8 = (float) 3.50;
                gpaEmpty = false;

            } else if (g8 == 4) {

                gpa8 = (float) 3.25;
                gpaEmpty = false;

            } else if (g8 == 5) {

                gpa8 = (float) 3.00;
                gpaEmpty = false;

            } else if (g8 == 6) {

                gpa8 = (float) 2.75;
                gpaEmpty = false;

            } else if (g8 == 7) {

                gpa8 = (float) 2.50;
                gpaEmpty = false;

            } else if (g8 == 8) {

                gpa8 = (float) 2.25;
                gpaEmpty = false;

            } else if (g8 == 9) {

                gpa8 = (float) 2.00;
                gpaEmpty = false;

            } else if (g8 == 10) {

                gpa8 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_9.getVisibility() == View.VISIBLE) {

            if (g9 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 9", Toast.LENGTH_SHORT).show();

            } else if (g9 == 1) {

                gpa9 = (float) 4.00;
                gpaEmpty = false;

            } else if (g9 == 2) {

                gpa9 = (float) 3.75;
                gpaEmpty = false;

            } else if (g9 == 3) {

                gpa9 = (float) 3.50;
                gpaEmpty = false;

            } else if (g9 == 4) {

                gpa9 = (float) 3.25;
                gpaEmpty = false;

            } else if (g9 == 5) {

                gpa9 = (float) 3.00;
                gpaEmpty = false;

            } else if (g9 == 6) {

                gpa9 = (float) 2.75;
                gpaEmpty = false;

            } else if (g9 == 7) {

                gpa9 = (float) 2.50;
                gpaEmpty = false;

            } else if (g9 == 8) {

                gpa9 = (float) 2.25;
                gpaEmpty = false;

            } else if (g9 == 9) {

                gpa9 = (float) 2.00;
                gpaEmpty = false;

            } else if (g9 == 10) {

                gpa9 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_10.getVisibility() == View.VISIBLE) {

            if (g10 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 10", Toast.LENGTH_SHORT).show();

            } else if (g10 == 1) {

                gpa10 = (float) 4.00;
                gpaEmpty = false;

            } else if (g10 == 2) {

                gpa10 = (float) 3.75;
                gpaEmpty = false;

            } else if (g10 == 3) {

                gpa10 = (float) 3.50;
                gpaEmpty = false;

            } else if (g10 == 4) {

                gpa10 = (float) 3.25;
                gpaEmpty = false;

            } else if (g10 == 5) {

                gpa10 = (float) 3.00;
                gpaEmpty = false;

            } else if (g10 == 6) {

                gpa10 = (float) 2.75;
                gpaEmpty = false;

            } else if (g10 == 7) {

                gpa10 = (float) 2.50;
                gpaEmpty = false;

            } else if (g10 == 8) {

                gpa10 = (float) 2.25;
                gpaEmpty = false;

            } else if (g10 == 9) {

                gpa10 = (float) 2.00;
                gpaEmpty = false;

            } else if (g10 == 10) {

                gpa10 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_11.getVisibility() == View.VISIBLE) {

            if (g11 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 11", Toast.LENGTH_SHORT).show();

            } else if (g11 == 1) {

                gpa11 = (float) 4.00;
                gpaEmpty = false;

            } else if (g11 == 2) {

                gpa11 = (float) 3.75;
                gpaEmpty = false;

            } else if (g11 == 3) {

                gpa11 = (float) 3.50;
                gpaEmpty = false;

            } else if (g11 == 4) {

                gpa11 = (float) 3.25;
                gpaEmpty = false;

            } else if (g11 == 5) {

                gpa11 = (float) 3.00;
                gpaEmpty = false;

            } else if (g11 == 6) {

                gpa11 = (float) 2.75;
                gpaEmpty = false;

            } else if (g11 == 7) {

                gpa11 = (float) 2.50;
                gpaEmpty = false;

            } else if (g11 == 8) {

                gpa11 = (float) 2.25;
                gpaEmpty = false;

            } else if (g11 == 9) {

                gpa11 = (float) 2.00;
                gpaEmpty = false;

            } else if (g11 == 10) {

                gpa11 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_12.getVisibility() == View.VISIBLE) {

            if (g12 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 12", Toast.LENGTH_SHORT).show();

            } else if (g12 == 1) {

                gpa12 = (float) 4.00;
                gpaEmpty = false;

            } else if (g12 == 2) {

                gpa12 = (float) 3.75;
                gpaEmpty = false;

            } else if (g12 == 3) {

                gpa12 = (float) 3.50;
                gpaEmpty = false;

            } else if (g12 == 4) {

                gpa12 = (float) 3.25;
                gpaEmpty = false;

            } else if (g12 == 5) {

                gpa12 = (float) 3.00;
                gpaEmpty = false;

            } else if (g12 == 6) {

                gpa12 = (float) 2.75;
                gpaEmpty = false;

            } else if (g12 == 7) {

                gpa12 = (float) 2.50;
                gpaEmpty = false;

            } else if (g12 == 8) {

                gpa12 = (float) 2.25;
                gpaEmpty = false;

            } else if (g12 == 9) {

                gpa12 = (float) 2.00;
                gpaEmpty = false;

            } else if (g12 == 10) {

                gpa12 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_13.getVisibility() == View.VISIBLE) {

            if (g13 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 13", Toast.LENGTH_SHORT).show();

            } else if (g13 == 1) {

                gpa13 = (float) 4.00;
                gpaEmpty = false;

            } else if (g13 == 2) {

                gpa13 = (float) 3.75;
                gpaEmpty = false;

            } else if (g13 == 3) {

                gpa13 = (float) 3.50;
                gpaEmpty = false;

            } else if (g13 == 4) {

                gpa13 = (float) 3.25;
                gpaEmpty = false;

            } else if (g13 == 5) {

                gpa13 = (float) 3.00;
                gpaEmpty = false;

            } else if (g13 == 6) {

                gpa13 = (float) 2.75;
                gpaEmpty = false;

            } else if (g13 == 7) {

                gpa13 = (float) 2.50;
                gpaEmpty = false;

            } else if (g13 == 8) {

                gpa13 = (float) 2.25;
                gpaEmpty = false;

            } else if (g13 == 9) {

                gpa13 = (float) 2.00;
                gpaEmpty = false;

            } else if (g13 == 10) {

                gpa13 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_14.getVisibility() == View.VISIBLE) {

            if (g14 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 14", Toast.LENGTH_SHORT).show();

            } else if (g14 == 1) {

                gpa14 = (float) 4.00;
                gpaEmpty = false;

            } else if (g14 == 2) {

                gpa14 = (float) 3.75;
                gpaEmpty = false;

            } else if (g14 == 3) {

                gpa14 = (float) 3.50;
                gpaEmpty = false;

            } else if (g14 == 4) {

                gpa14 = (float) 3.25;
                gpaEmpty = false;

            } else if (g14 == 5) {

                gpa14 = (float) 3.00;
                gpaEmpty = false;

            } else if (g14 == 6) {

                gpa14 = (float) 2.75;
                gpaEmpty = false;

            } else if (g14 == 7) {

                gpa14 = (float) 2.50;
                gpaEmpty = false;

            } else if (g14 == 8) {

                gpa14 = (float) 2.25;
                gpaEmpty = false;

            } else if (g14 == 9) {

                gpa14 = (float) 2.00;
                gpaEmpty = false;

            } else if (g14 == 10) {

                gpa14 = (float) 0.00;
                gpaEmpty = false;
            }


        }


        if (s_Raw_15.getVisibility() == View.VISIBLE) {

            if (g15 == 0) {
                gpaEmpty = true;
                Toast.makeText(MainActivity.this, "Please enter a valid GPA in Course 15", Toast.LENGTH_SHORT).show();

            } else if (g15 == 1) {

                gpa15 = (float) 4.00;
                gpaEmpty = false;

            } else if (g15 == 2) {

                gpa15 = (float) 3.75;
                gpaEmpty = false;

            } else if (g15 == 3) {

                gpa15 = (float) 3.50;
                gpaEmpty = false;

            } else if (g15 == 4) {

                gpa15 = (float) 3.25;
                gpaEmpty = false;

            } else if (g15 == 5) {

                gpa15 = (float) 3.00;
                gpaEmpty = false;

            } else if (g15 == 6) {

                gpa15 = (float) 2.75;
                gpaEmpty = false;

            } else if (g15 == 7) {

                gpa15 = (float) 2.50;
                gpaEmpty = false;

            } else if (g15 == 8) {

                gpa15 = (float) 2.25;
                gpaEmpty = false;

            } else if (g15 == 9) {

                gpa15 = (float) 2.00;
                gpaEmpty = false;

            } else if (g15 == 10) {

                gpa15 = (float) 0.00;
                gpaEmpty = false;
            }


        }


    }

    public void resetallText(View view) {

        s_Raw_3.setVisibility(LinearLayout.GONE);
        s_Raw_4.setVisibility(LinearLayout.GONE);
        s_Raw_5.setVisibility(LinearLayout.GONE);
        s_Raw_6.setVisibility(LinearLayout.GONE);
        s_Raw_7.setVisibility(LinearLayout.GONE);
        s_Raw_8.setVisibility(LinearLayout.GONE);
        s_Raw_9.setVisibility(LinearLayout.GONE);
        s_Raw_10.setVisibility(LinearLayout.GONE);
        s_Raw_11.setVisibility(LinearLayout.GONE);
        s_Raw_12.setVisibility(LinearLayout.GONE);
        s_Raw_13.setVisibility(LinearLayout.GONE);
        s_Raw_14.setVisibility(LinearLayout.GONE);
        s_Raw_15.setVisibility(LinearLayout.GONE);


        finish = false;

        permission3 = false;
        permission4 = false;
        permission5 = false;
        permission6 = false;
        permission7 = false;
        permission8 = false;
        permission9 = false;
        permission10 = false;
        permission11 = false;
        permission12 = false;
        permission13 = false;
        permission14 = false;
        permission15 = false;

        creditET1.setText("");
        creditET2.setText("");
        creditET3.setText("");
        creditET4.setText("");
        creditET5.setText("");
        creditET6.setText("");
        creditET7.setText("");
        creditET8.setText("");
        creditET9.setText("");
        creditET10.setText("");
        creditET10.setText("");
        creditET12.setText("");
        creditET13.setText("");
        creditET14.setText("");
        creditET15.setText("");

        spinner1.setSelection(0);
        spinner2.setSelection(0);
        spinner3.setSelection(0);
        spinner4.setSelection(0);
        spinner5.setSelection(0);
        spinner6.setSelection(0);
        spinner7.setSelection(0);
        spinner8.setSelection(0);
        spinner9.setSelection(0);
        spinner10.setSelection(0);
        spinner11.setSelection(0);
        spinner12.setSelection(0);
        spinner13.setSelection(0);
        spinner14.setSelection(0);
        spinner15.setSelection(0);

        addCourseBtnClickCount = 2;


        cgpaL.setVisibility(View.VISIBLE);
        resultL.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucgpa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog);
                } else {
                    builder = new AlertDialog.Builder(this);
                }
                builder.setTitle("Thanks for using my app")
                        .setMessage("Do you want to exit from here?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(0);
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();
                break;
            case R.id.share:
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Install now");
                String app_url = "https://play.google.com/store/apps/details?id=app.cave.cgpacalculator";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                break;

            case R.id.reset:
                resetallText(view);
                break;
            case R.id.rate:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=app.cave.cgpacalculator"));
                startActivity(intent);
                break;
            case R.id.review:
                Intent inter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=app.cave.cgpacalculator"));
                startActivity(inter);
                break;
            case R.id.moreapp:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=7556100466882241730"));
                startActivity(i);
                break;
            case R.id.exit:
                System.exit(0);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}




