package com.jinyeob.carinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView numTextView;
    private TextView nameTextView;
    private String NUMBER = "";
    private String NAME = "";
    private String today="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numTextView=findViewById(R.id.textview_num);
        nameTextView=findViewById(R.id.textview_name);

        Intent loginIntent = getIntent();
        NUMBER = loginIntent.getStringExtra("num");
        NAME = loginIntent.getStringExtra("name");

        numTextView.setText(NUMBER);
        nameTextView.setText(NAME);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat weekdayFormat = new SimpleDateFormat("YYYY_MM_dd_HH:mm", Locale.getDefault());
        String today = weekdayFormat.format(currentTime);


    }
}