package com.logcat.anilreddy.display_random_numbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    EditText FT,ST,RT;
    Button Calculate;
    Random random;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Calculate = (Button) findViewById(R.id.Cal_btn);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                random = new Random();

                FT = (EditText) findViewById(R.id.FirstNo);
                String value = FT.getText().toString();
                int  val= Integer.parseInt(value);

                ST = (EditText) findViewById(R.id.SecondNo);
                String value1 = ST.getText().toString();
                int  val1= Integer.parseInt(value1);

                int result = val+val1;

                RT = (EditText) findViewById(R.id.Result);

                if((result%2) == 0)
                {
                    RT.setText(String.valueOf(result));
                    Toast.makeText(SecondActivity.this,"Answers is Correct ",Toast.LENGTH_SHORT).show();

                    intent = new Intent(SecondActivity.this,ThirdActivity.class);
                    startActivity(intent);

                }

             else
                 {
                    int randomNumber = random.nextInt(result);
                    RT.setText(String.valueOf(randomNumber));
                    Toast.makeText(SecondActivity.this,"Answers is Not Correct ",Toast.LENGTH_SHORT).show();

                     intent = new Intent(SecondActivity.this,ThirdActivity.class);
                     startActivity(intent);
                }
            }
        });
    }
}
