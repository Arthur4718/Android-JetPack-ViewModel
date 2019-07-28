# Android-JetPack-ViewModel
Using AndroidX and Jetpack to a simple use of View Model in Android. 


Here is another small sample using JetPack. Project was created using basic activity and AndroidX support. 



# Gradle build. 

```
def lifecycle_version = "2.0.0"
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    // Optional : Kotlin extension (https://d.android.com/kotlin/ktx)
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
```


Created a simple class to return a Random Int and apply it to a string variable, this will be extending Viewmodel from Jetpack.

```Java
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

```

Inside the Main Activity, on the On Create method, we fetch data from the model without worrying about interfaces. 

```Java
    TextView mTextView = findViewById(R.id.tv_number);
    //Providing data through the model without an interface
    MainActivityModel model = ViewModelProviders.of(this).get(MainActivityModel.class);
    String myRandomNumber = model.getNumber();
 
```


