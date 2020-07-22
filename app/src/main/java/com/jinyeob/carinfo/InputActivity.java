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
    private EditText teamTextView;
    private EditText urlTextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        button = findViewById(R.id.button);
        numTextView = (EditText) findViewById(R.id.editTextNum);
        nameTextView = (EditText) findViewById(R.id.editTextName);
        teamTextView = (EditText) findViewById(R.id.editTextTeam);
        urlTextView = (EditText) findViewById(R.id.editTextURL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = numTextView.getText().toString();
                String name = nameTextView.getText().toString();
                String team = teamTextView.getText().toString();
                String url = urlTextView.getText().toString();

                SaveSharedPreference.setUser(
                        InputActivity.this,
                        numTextView.getText().toString(),
                        teamTextView.getText().toString(),
                        nameTextView.getText().toString(),
                        urlTextView.getText().toString()
                );


                if (num.length() > 0 && team.length() > 0 && name.length() > 0) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("num", num);
                    intent.putExtra("team", team);
                    intent.putExtra("name", name);
                    intent.putExtra("url", url);

                    startActivity(intent);
                    Toast.makeText(InputActivity.this, "정보가 저장되었습니다.", Toast.LENGTH_LONG).show();

                    finish();
                } else {
                    Toast.makeText(InputActivity.this, "정보를 입력해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}