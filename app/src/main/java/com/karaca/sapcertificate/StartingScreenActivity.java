package com.karaca.sapcertificate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class StartingScreenActivity extends AppCompatActivity {

    private  static  final  int REQUEST_CODE_QUIZ = 1;
    public  static  final  String EXTRA_DIFFICULTY = "extra_difficulty";

    public  static  final  String SHARED_PREFS = "sharedPrefs";
    public  static  final  String KEY_HIGHSCORE = "keyHighScore";

    private TextView textViewHighScore;
    private Spinner spinnerDifficulty;
    private Integer highscore;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_sap);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        textViewHighScore = findViewById(R.id.text_view_highscore);
        spinnerDifficulty = findViewById(R.id.spinner_difficulty);
        String[] difficultyLevels = Question.getAllDifficultyLevels();
        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter <String>(getApplication(),
                android.R.layout.simple_spinner_item,difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_list_item_1);
        //       spinnerDifficulty.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
        spinnerDifficulty.setPrompt("Select Exam");
        spinnerDifficulty.setAdapter(adapterDifficulty);

        loadHighScore();

        Button buttonStartQuiz = findViewById(R.id.button_start_quiz);

        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view) {
                if (internetErisimi()){
                    startQuiz();
                }else {

                    Toast.makeText(getApplicationContext(),R.string.notaccess,Toast.LENGTH_SHORT).show();
                }


            }

        });

    }
    private void startQuiz() {

        String  difficulty = spinnerDifficulty.getSelectedItem().toString();

        Intent intent = new Intent(getApplicationContext(),ExamActivity.class);
        intent.putExtra(EXTRA_DIFFICULTY,difficulty);
        //startActivity(intent);
        startActivityForResult(intent,REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_QUIZ){

            if (resultCode == RESULT_OK){

                int score = data.getIntExtra(ExamActivity.EXTRA_SCORE,0);
                if (score > highscore){
                    updateHighScore(score);
                }
            }

        }
    }

    private  void  loadHighScore(){
        SharedPreferences prefs  = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE,0);
        textViewHighScore.setText("High Score :" + highscore);
    }

    private void updateHighScore(int score) {

        highscore = score;
        textViewHighScore.setText("High Score :" + highscore);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE,highscore);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_cart)
        {
            updateHighScore(0);
            Toast.makeText(this, "Highscore reset", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean internetErisimi(){
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() &&
                conMgr.getActiveNetworkInfo().isConnected()){
            return true;

        }else{

            return false;
        }

    }
}
