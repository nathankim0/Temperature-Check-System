package com.jinyeob.carinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private EditText numTextView;
    private EditText nameTextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        button = findViewById(R.id.button);
        numTextView = (EditText) findViewById(R.id.editTextNum);
        nameTextView = (EditText) findViewById(R.id.editTextName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = numTextView.getText().toString();
                String name = nameTextView.getText().toString();

                SaveSharedPreference.setUser(InputActivity.this, numTextView.getText().toString(), nameTextView.getText().toString());


                if (num.length() > 0 && name.length() > 0) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("num", num);
                    intent.putExtra("name", name);

                    startActivity(intent);
                    Toast.makeText(InputActivity.this, "정보가 저장되었습니다.", Toast.LENGTH_LONG).show();

                    finish();
                } else {
                    Toast.makeText(InputActivity.this, "사번과 이름을 입력해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}