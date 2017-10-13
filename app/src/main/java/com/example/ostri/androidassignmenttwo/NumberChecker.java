package com.example.ostri.androidassignmenttwo;

/**
 * Created by ostri on 10/13/2017.
 */

public class NumberChecker extends GuessingActivity {
    //Multiply random value (random() returns a number between 0 and 1, but will never be 1)
    // by 21 so that the range will be 0 to 21
    int targetNumber = (int)(Math.random() * 21);
    String response;
    int numGuesses = 0;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public NumberChecker(){
        numGuesses = 0;
    }

    public String checkGuess(int input){
        if (input > 20){
            response = "Number should be less than 20";
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
