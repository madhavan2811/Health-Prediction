package com.example.healthprediction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private EditText Name;
    private TextView info;
    private Button con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Name = (EditText)findViewById(R.id.et);


        this.setTitle("Disease");

        info = (TextView)findViewById(R.id.textView2);

        Button button2 = (Button) findViewById(R.id.btn2);
        Button button = (Button) findViewById(R.id.btn);
        info.setText(" ");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = Name.getText().toString();
                s = s.replace(" ", "");
                if(s.equalsIgnoreCase("jointpain") || s.equalsIgnoreCase("fever") || s.equalsIgnoreCase("cold") || s.equalsIgnoreCase("cough")){
                    info.setText("Predicted Disease is Dengue");
                }
                else if(s.equalsIgnoreCase("pain") || s.equalsIgnoreCase("headache")){
                    info.setText("Predicted Disease is Malaria");
                }
                else if(s.equalsIgnoreCase("stomachpain") || s.equalsIgnoreCase("lossofappetite") || s.equalsIgnoreCase("vomiting")){
                    info.setText("Predicted Disease is Typhoid");
                }

                else if(s.equalsIgnoreCase("fatigue") || s.equalsIgnoreCase("shortnessofbreath")){
                    info.setText("Predicted Disease is Anemia");
                }


                else if(s.equalsIgnoreCase("swelling") || s.equalsIgnoreCase("skinrash")){
                    info.setText("Predicted Disease is Chikungunya");
                }

                else if(s.equalsIgnoreCase("weightloss") || s.equalsIgnoreCase("nightsweats")){
                    info.setText("Predicted Disease is Tuberculosis");
                }
                else if(s.equalsIgnoreCase("yellowskin")){
                    info.setText("Predicted Disease is Hepatitis");
                }
                else if(s.equalsIgnoreCase("vomiting")){
                    info.setText("Predicted Disease is Diarrhea");
                }
                else if(s.equalsIgnoreCase("")){
                    info.setText("Please enter the symptoms");
                }
                else{
                    info.setText("Couldn't match with disease");
                }

            }
        });


    }


    public void home(){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itNotifications:
                Intent intent = new Intent(this,NotifyActivity.class);
                startActivity(intent);
                return true;
            case R.id.itAccounts:
                Toast.makeText(this, "Page not yet ready.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itHistory:
                Toast.makeText(this, "Page not yet ready.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itSettings:
                Toast.makeText(this, "Page not yet ready.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itFeedback:
                intent = new Intent(this,FeedBackActivity.class);
                startActivity(intent);
                return true;
            case R.id.itAbout:
                intent = new Intent(this,AboutUsActivity.class);
                startActivity(intent);
                return true;
            case R.id.itExit:
                exit();
                return  true;
            case R.id.itLogout:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void exit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



}