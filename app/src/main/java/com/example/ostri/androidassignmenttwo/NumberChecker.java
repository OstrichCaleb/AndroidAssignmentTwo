package com.example.ostri.androidassignmenttwo;

/**
 * Created by ostri on 10/13/2017.
 */

public class NumberChecker extends GuessingActivity {
    //Multiply random value (random() returns a number between 0 and 1, but will never be 1)
    // by 21 so that the range will be 0 to 21
    int targetNumber;
    String response;
    int numGuesses = 0;
    int range;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public NumberChecker(int range){
        numGuesses = 0;
        this.range = range;

        targetNumber = (int)(Math.random() * (this.range + 1));
    }

    public String checkGuess(int input){
        if (input > range){
            response = "Number should be less than " + range;
        } else if (input < 1){
            response = "Number should be more than 1";
        } else if (input > targetNumber){
            response = "Your guess was too high";
        } else if (input < targetNumber){
            response = "Your guess was too low";
        } else {
            response = "win";
        }

        numGuesses++;
        return response;
    }
}
