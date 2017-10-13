package com.example.ostri.androidassignmenttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView ansText;
    Button againBtn;
    String guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getIntentData();

        locateViews();

        bindData();
    }

    void locateViews() {
        this.ansText = (TextView) findViewById(R.id.ansText);
        this.againBtn = (Button) findViewById(R.id.againBtn);
    }

    void getIntentData(){
        if(getIntent().hasExtra(GuessingActivity.intentTag)){
            this.guesses = getIntent().getStringExtra(GuessingActivity.intentTag);
        }
    }

    void bindData(){
        ansText.setText(guesses);
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
            }
        });
    }
}
