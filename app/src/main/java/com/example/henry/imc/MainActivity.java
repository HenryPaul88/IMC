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

    public  static final String LOG_TAG = "";

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"muestra la activity");

        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        button = (Button) findViewById(R.id.bottom);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,R.string.toast_incorret,Toast.LENGTH_SHORT).show();


                    if (checkBox1.isChecked() == true && checkBox2.isChecked() == false) {
                        intentHombre();
                    }else if(checkBox1.isChecked() == false && checkBox2.isChecked() == true){
                        intentMujer();
                    }else {
                        Toast.makeText(MainActivity.this, R.string.toast_incorret, Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public void intentHombre(){
        Log.d(LOG_TAG,"se ejecuta la siguiente activity");
        Intent next = new Intent(this,Main2Activity.class);
        startActivity(next);
    }

    public void intentMujer(){
        Log.d(LOG_TAG,"se ejecuta la siguiente activity");
        Intent next = new Intent(this,Main3Activity.class);
        startActivity(next);
    }
}