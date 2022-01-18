package com.example.healthprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity {


    private Button button;
    private EditText Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        this.setTitle("FeedBack");

        Message = (EditText)findViewById(R.id.etFeedBack);
        button = (Button)findViewById(R.id.btnBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

        button = (Button)findViewById(R.id.btnSend);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message.setText("");
                Toast.makeText(getBaseContext(),"Thank You! We've recieved your feedback",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void home(){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
}