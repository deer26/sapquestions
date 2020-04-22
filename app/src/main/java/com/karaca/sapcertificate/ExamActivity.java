package com.karaca.sapcertificate;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class ExamActivity extends AppCompatActivity {
    private InterstitialAd interstitialAd;
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILIS = 30000;
    private int lastOrientation;

    private RelativeLayout rl;

    private static final String KEY_SCORE = "keyScore";
    private static final String KEY_QUESTION_COUNT = "keyQuestionCount";
    private static final String KEY_MILIS_LEFT = "keyMilisLeft";
    private static final String KEY_ANSWERED = "keyAnswered";
    private static final String KEY_QUESTION_LIST = "keyQuestionList";

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewDifficulty;
    private TextView textViewCountDown;


    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;

    private Button buttonConfirmNext;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftMilis;

    private ArrayList <Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;
    private long backPressedTime;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);


        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest2);

        MobileAds.initialize(this,"ca-app-pub-5927233659272665~2607000782");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5927233659272665/4731080176");
        AdRequest adRequest = new  AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
        rl = findViewById(R.id.rl);
        rl.setBackgroundResource(R.drawable.arkafon);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_sap);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewDifficulty = findViewById(R.id.text_view_difficulty);

        checkBox1 = findViewById(R.id.check_option1);
        checkBox2 = findViewById(R.id.check_option2);
        checkBox3 = findViewById(R.id.check_option3);
        checkBox4 = findViewById(R.id.check_option4);
        checkBox5 = findViewById(R.id.check_option5);
        checkBox6 = findViewById(R.id.check_option6);

        buttonConfirmNext = findViewById(R.id.button_confirm_next);


        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(StartingScreenActivity.EXTRA_DIFFICULTY);
        textViewDifficulty.setText("Exam: " + difficulty);

        if (savedInstanceState == null) {


            QuizDbHelper dbHelper = new QuizDbHelper(getApplicationContext());
            // questionList = dbHelper.getAllQuestions();
            // zorluk seçimleri için geldi

            if (difficulty.equals(Question.DIFFICULTY_KARMA)) {
                questionList = dbHelper.getAllQuestions();

            } else {

                questionList = dbHelper.getQuestions(difficulty);

            }


            questionCountTotal = questionList.size();
            Collections.shuffle(questionList);
            showNextQuestion();


        } else {

            questionList = savedInstanceState.getParcelableArrayList(KEY_QUESTION_LIST);

            if (questionList == null) {
                finish();
            } else {


                questionCountTotal = questionList.size();
                questionCounter = savedInstanceState.getInt(KEY_QUESTION_COUNT);
                currentQuestion = questionList.get(questionCounter - 1);
                score = savedInstanceState.getInt(KEY_SCORE);
                timeLeftMilis = savedInstanceState.getLong(KEY_MILIS_LEFT);
                answered = savedInstanceState.getBoolean(KEY_ANSWERED);

                if (!answered) {
                    //startCountDown();
                } else {
                    // updateCountDownText();
                    showSolution();
                }
            }

        }
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!answered) {

                    if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() ||
                            checkBox4.isChecked() || checkBox5.isChecked() || checkBox6.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();

                    }

                } else {

                    if (checkBox1.isChecked()) {
                        checkBox1.setChecked(false);
                    }
                    if (checkBox2.isChecked()) {
                        checkBox2.setChecked(false);
                    }
                    if (checkBox3.isChecked()) {
                        checkBox3.setChecked(false);
                    }
                    if (checkBox4.isChecked()) {
                        checkBox4.setChecked(false);
                    }
                    if (checkBox5.isChecked()) {
                        checkBox5.setChecked(false);
                    }
                    if (checkBox6.isChecked()) {
                        checkBox6.setChecked(false);
                    }
                    showNextQuestion();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        if (internetErisimi()) {


            super.onStart();
            checkOrientationChanged();
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void checkAnswer() {

        if (internetErisimi()) {


            answered = true;

            //countDownTimer.cancel();

            String answerNr1 = null, answerNr2 = null,
                    answerNr3 = null, answerNr4 = null,
                    answerNr5 = null, answerNr6 = null;

            if (checkBox1.isChecked()) {
                answerNr1 = "X";
            }
            if (checkBox2.isChecked()) {
                answerNr2 = "X";
            }
            if (checkBox3.isChecked()) {
                answerNr3 = "X";
            }
            if (checkBox4.isChecked()) {
                answerNr4 = "X";
            }
            if (checkBox5.isChecked()) {
                answerNr5 = "X";
            }
            if (checkBox6.isChecked()) {
                answerNr6 = "X";
            }


            if (Objects.equals(answerNr1, currentQuestion.getAnswerNr1()) && Objects.equals(answerNr2, currentQuestion.getAnswerNr2()) &&
                    Objects.equals(answerNr3, currentQuestion.getAnswerNr3()) && Objects.equals(answerNr4, currentQuestion.getAnswerNr4()) &&
                    Objects.equals(answerNr5, currentQuestion.getAnswerNr5()) && Objects.equals(answerNr6, currentQuestion.getAnswerNr6())) {

                score++;
                textViewScore.setText("Score :" + score);
            }
            showSolution();
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showSolution() {

        if (internetErisimi()) {


            checkBox1.setTextColor(Color.RED);
            checkBox2.setTextColor(Color.RED);
            checkBox3.setTextColor(Color.RED);
            checkBox4.setTextColor(Color.RED);
            checkBox5.setTextColor(Color.RED);
            checkBox6.setTextColor(Color.RED);

            if (Objects.equals(currentQuestion.getAnswerNr1(), "X")) {
                checkBox1.setTextColor(Color.GREEN);
            }
            if (Objects.equals(currentQuestion.getAnswerNr2(), "X")) {
                checkBox2.setTextColor(Color.GREEN);
            }
            if (Objects.equals(currentQuestion.getAnswerNr3(), "X")) {
                checkBox3.setTextColor(Color.GREEN);
            }
            if (Objects.equals(currentQuestion.getAnswerNr4(), "X")) {
                checkBox4.setTextColor(Color.GREEN);
            }
            if (Objects.equals(currentQuestion.getAnswerNr5(), "X")) {
                checkBox5.setTextColor(Color.GREEN);
            }
            if (Objects.equals(currentQuestion.getAnswerNr6(), "X")) {
                checkBox6.setTextColor(Color.GREEN);
            }

            if (questionCounter < questionCountTotal) {
                buttonConfirmNext.setText("Next");
                Drawable image = getApplication().getResources().getDrawable(R.drawable.ic_arrow_forward_black_24dp);
                buttonConfirmNext.setCompoundDrawablesWithIntrinsicBounds(image, null, null, null);
            } else {
                buttonConfirmNext.setText("Finish");
            }
        } else {

            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }


    }


    private void showNextQuestion() {
        if (interstitialAd.isLoaded())
        {
            interstitialAd.show();
        }

        if (internetErisimi()) {
            // Gizlemeyi geri al
            // gizleme olayları
            checkBox1.setVisibility(View.VISIBLE);
            checkBox2.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.VISIBLE);
            checkBox5.setVisibility(View.VISIBLE);
            checkBox6.setVisibility(View.VISIBLE);

            checkBox1.setTextColor(Color.BLACK);
            checkBox2.setTextColor(Color.BLACK);
            checkBox3.setTextColor(Color.BLACK);
            checkBox4.setTextColor(Color.BLACK);
            checkBox5.setTextColor(Color.BLACK);
            checkBox6.setTextColor(Color.BLACK);


            // rbGroup.clearCheck();
            if (questionCounter < questionCountTotal) {

                currentQuestion = questionList.get(questionCounter);
                textViewQuestion.setText(currentQuestion.getQuestion());
                checkBox1.setText(currentQuestion.getOption1());
                checkBox2.setText(currentQuestion.getOption2());
                checkBox3.setText(currentQuestion.getOption3());
                checkBox4.setText(currentQuestion.getOption4());
                checkBox5.setText(currentQuestion.getOption5());
                checkBox6.setText(currentQuestion.getOption6());

                // gizleme olayları

                if (currentQuestion.getOption1() == null) {
                    checkBox1.setVisibility(View.INVISIBLE);
                }
                if (currentQuestion.getOption2() == null) {
                    checkBox2.setVisibility(View.INVISIBLE);
                }
                if (currentQuestion.getOption3() == null) {
                    checkBox3.setVisibility(View.INVISIBLE);
                }
                if (currentQuestion.getOption4() == null) {
                    checkBox4.setVisibility(View.INVISIBLE);
                }
                if (currentQuestion.getOption5() == null) {
                    checkBox5.setVisibility(View.INVISIBLE);
                }
                if (currentQuestion.getOption6() == null) {
                    checkBox6.setVisibility(View.INVISIBLE);
                }
                questionCounter++;
                textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
                answered = false;
                Drawable image = getApplication().getResources().getDrawable(R.drawable.ic_check);
                buttonConfirmNext.setCompoundDrawablesWithIntrinsicBounds(image, null, null, null);
                buttonConfirmNext.setText("Confirm");

                timeLeftMilis = COUNTDOWN_IN_MILIS;

            } else {

                finishQuiz();
            }
        } else {

            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }

    }


    private void finishQuiz() {
        if (internetErisimi()) {


            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_SCORE, score);
            setResult(RESULT_OK, resultIntent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (internetErisimi()) {
        finishQuiz();
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        if (internetErisimi()) {
        // gizleme olayları

        if (currentQuestion.getOption1() == null) {
            checkBox1.setVisibility(View.INVISIBLE);
        }
        if (currentQuestion.getOption2() == null) {
            checkBox2.setVisibility(View.INVISIBLE);
        }
        if (currentQuestion.getOption3() == null) {
            checkBox3.setVisibility(View.INVISIBLE);
        }
        if (currentQuestion.getOption4() == null) {
            checkBox4.setVisibility(View.INVISIBLE);
        }
        if (currentQuestion.getOption5() == null) {
            checkBox5.setVisibility(View.INVISIBLE);
        }
        if (currentQuestion.getOption6() == null) {
            checkBox6.setVisibility(View.INVISIBLE);
        }

        super.onDestroy();

        } else {
            super.onDestroy();
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    //public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    public void onSaveInstanceState(Bundle outState) {

        if (internetErisimi()) {
        outState.putInt(KEY_SCORE, score);
        outState.putInt(KEY_QUESTION_COUNT, questionCounter);
        outState.putLong(KEY_MILIS_LEFT, timeLeftMilis);
        outState.putBoolean(KEY_ANSWERED, answered);
        outState.putParcelableArrayList(KEY_QUESTION_LIST, questionList);
        //super.onSaveInstanceState(outState, outPersistentState);
        super.onSaveInstanceState(outState);
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    private void checkOrientationChanged() {
        if (internetErisimi()) {
        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation != lastOrientation) {
            onScreenOrientationChanged(currentOrientation);
            lastOrientation = currentOrientation;
        }
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    public void onScreenOrientationChanged(int currentOrientation) {
        // Do something here when screen orientation changed
        if (internetErisimi()) {
        if (currentOrientation == 2 || currentOrientation == 1) {
            // gizleme olayları

            if (currentQuestion.getOption1() == null) {
                checkBox1.setVisibility(View.INVISIBLE);
            }
            if (currentQuestion.getOption2() == null) {
                checkBox2.setVisibility(View.INVISIBLE);
            }
            if (currentQuestion.getOption3() == null) {
                checkBox3.setVisibility(View.INVISIBLE);
            }
            if (currentQuestion.getOption4() == null) {
                checkBox4.setVisibility(View.INVISIBLE);
            }
            if (currentQuestion.getOption5() == null) {
                checkBox5.setVisibility(View.INVISIBLE);
            }
            if (currentQuestion.getOption6() == null) {
                checkBox6.setVisibility(View.INVISIBLE);
            }
        }
        } else {
            Toast.makeText(getApplicationContext(), R.string.notaccess, Toast.LENGTH_SHORT).show();
        }
    }

    public boolean internetErisimi() {
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() &&
                conMgr.getActiveNetworkInfo().isConnected()) {
            return true;

        } else {

            return false;
        }

    }
}

