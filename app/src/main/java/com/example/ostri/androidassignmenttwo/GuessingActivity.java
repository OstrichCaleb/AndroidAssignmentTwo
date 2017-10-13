package com.example.ostri.androidassignmenttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuessingActivity extends AppCompatActivity {
    public static String intentTag = "inputData";

    Button checkBtn;
    EditText numEntry;
    NumberChecker number;
    String response;
    Integer numGuesses;
    String guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        number = new NumberChecker();
        locateViews();

        bindFunctionality();
    }

    void locateViews(){
        checkBtn = (Button) findViewById(R.id.checkBtn);
        numEntry = (EditText) findViewById(R.id.numEntry);
    }

    void bindFunctionality() {
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numEntry.getText() == null) {
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
}
