package com.example.healthprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView info;
    private int counter=5;

    private static int SPLASH_SCREEN_TIME_OUT=2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        info = (TextView)findViewById(R.id.tvinfo);

        info.setText("No of attempts remaining is 5");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate(String username,String password){
        if((username.equals("admin")) && (password.equals("admin"))){
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else{
            counter--;
            info.setText("No of attempts remaining is "+ String.valueOf(counter));

            if(counter==0){
                Login.setEnabled(false);
            }

        }
    }

}