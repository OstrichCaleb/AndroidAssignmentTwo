package com.example.ostri.androidassignmenttwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {
    public static String intentTag = "inputData";
    Button submit;
    EditText rangeEntry;
    String range;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        locateViews();

        bindFunctionality();
    }

    void locateViews(){
        submit = (Button) findViewById(R.id.startBtn);
        rangeEntry = (EditText) findViewById(R.id.rangeEntry);
    }

    void bindFunctionality() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rangeEntry.getText().toString().isEmpty()) {
                    range = "20";
                } else {
                    range = (rangeEntry.getText().toString());
                }
                Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
                intent.putExtra(intentTag, range);
                startActivity(intent);
            }
        });
    }
}