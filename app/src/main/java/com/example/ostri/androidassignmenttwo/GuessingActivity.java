package com.example.ostri.androidassignmenttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GuessingActivity extends AppCompatActivity {
    public static String intentTag = "inputData";

    Button checkBtn;
    EditText numEntry;
    NumberChecker number;
    String response;
    Integer numGuesses;
    String guesses;
    Integer range;
    String strRange;
    TextView promptText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        getIntentData();

        number = new NumberChecker((int)range);

        locateViews();

        bindFunctionality();
    }

    void locateViews(){
        checkBtn = (Button) findViewById(R.id.checkBtn);
        numEntry = (EditText) findViewById(R.id.numEntry);
        promptText = (TextView) findViewById(R.id.promptText);
    }

    void bindFunctionality() {
        promptText.setText("Guess a number between 1 and " + strRange);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numEntry.getText().toString().isEmpty()) {
                    displayToast("Please enter a number");
                } else {
                    response = number.checkGuess(Integer.parseInt(numEntry.getText().toString()));
                    if (response == "win"){
                        displayToast("Your guess was correct!");
                        numGuesses = (Integer) number.numGuesses;
                        guesses = numGuesses.toString();

                        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                        intent.putExtra(intentTag, guesses);
                        startActivity(intent);
                    } else {
                        displayToast(response);
                    }
                }
            }
        });
    }

    private void displayToast(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    void getIntentData(){
        if(getIntent().hasExtra(LandingActivity.intentTag)){
            this.strRange = getIntent().getStringExtra(LandingActivity.intentTag);
            this.range = Integer.parseInt(strRange);
            if (this.range < 2){
                displayToast("Sorry, but you can't have it that easy!");
                this.range = 20;
                this.strRange = "20";
            }
        }
    }
}
