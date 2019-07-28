package devarthur4718.com.jetpackviewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityModel extends ViewModel {

    private String TAG =  this.getClass().getSimpleName();
    private String myRandomNumber ;

    public String getNumber(){


        Log.i(TAG, "Get Number");

        if(myRandomNumber == null){
            createNumber();
        }
        return myRandomNumber;

    }

    private void createNumber() {

        Random random = new Random();
        myRandomNumber = "Number: " + random.nextInt(1000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
