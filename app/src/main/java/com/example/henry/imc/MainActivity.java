package com.example.henry.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public  static final String LOG_TAG = "MainActivity";

    private CheckBox cbMan;
    private CheckBox cbWoman;
    private Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Log.d(LOG_TAG,"Show the activity...");

        cbMan = (CheckBox) findViewById(R.id.cbMan);
        cbWoman = (CheckBox) findViewById(R.id.cbWoman);
        btNext = (Button) findViewById(R.id.btNext);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (cbMan.isChecked() && !cbWoman.isChecked()) {
                        intentMan();
                    }else if(!cbMan.isChecked() && cbWoman.isChecked()){
                        intentWoman();
                    }else {
                        Toast.makeText(MainActivity.this, R.string.toast_incorret, Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public void intentMan(){
        Log.d(LOG_TAG,"se ejecuta la siguiente activity");
        Intent next = new Intent(this,HombreActivity.class);
        startActivity(next);
    }

    public void intentWoman(){
        Log.d(LOG_TAG,"se ejecuta la siguiente activity");
        Intent next = new Intent(this,MujerActivity.class);
        startActivity(next);
    }
}
