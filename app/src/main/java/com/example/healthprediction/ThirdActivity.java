package com.example.healthprediction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        this.setTitle("Consultation");


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calls();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bills();
            }
        });



    }



    private void bills(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Your Bill is Rs 500");
        alert.setMessage("Click Yes to Pay");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ThirdActivity.this,"You have paid the bill",Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ThirdActivity.this,"You have not paid the bill",Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();

    }

    private void calls(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Call Doctor");
        alert.setMessage("Click Yes to Call");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ThirdActivity.this,"Calling doctor...",Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ThirdActivity.this,"Denied",Toast.LENGTH_SHORT).show();
            }
        });
        alert.create().show();

    }



}