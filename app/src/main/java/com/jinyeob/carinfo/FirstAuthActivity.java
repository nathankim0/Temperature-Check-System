package com.jinyeob.carinfo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FirstAuthActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_auth);

        if(SaveSharedPreference.getUserName(FirstAuthActivity.this).length() == 0 || SaveSharedPreference.getUserNum(FirstAuthActivity.this).length() == 0) {
            // call Login Activity
            intent = new Intent(FirstAuthActivity.this, InputActivity.class);

            startActivity(intent);
            this.finish();
        } else {
            // Call Next Activity
            intent = new Intent(FirstAuthActivity.this, MainActivity.class);
            intent.putExtra("num", SaveSharedPreference.getUserNum(this).toString());
            intent.putExtra("name", SaveSharedPreference.getUserName(this).toString());

            startActivity(intent);
            this.finish();
        }
    }
}