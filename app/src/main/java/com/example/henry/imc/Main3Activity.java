package com.example.henry.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    public  static final String LOG_TAG = "";

    private EditText editText1;
    private EditText editText2;
    private Button button2;
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d(LOG_TAG,"muestra la activity");

        editText1 = (EditText) findViewById(R.id.edit_1_1);
        editText2 = (EditText) findViewById(R.id.edit_2_2);
        button2 = (Button) findViewById(R.id.bottom2_2);
        textView1 = (TextView) findViewById(R.id.text_2_2);
        textView2 = (TextView) findViewById(R.id.text_3_3);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"realiza el clic");
                calculo();

            }
        });
    }

    public void calculo(){
        try {
            Log.d(LOG_TAG, "se ejecuta el metodo calcular");
            String valor1 = editText1.getText().toString();
            String valor2 = editText2.getText().toString();

            float num1 = Float.parseFloat(valor1);
            float num2 = Float.parseFloat(valor2);

            float resul = (num1 / (num2*2));

            String calcular = String.valueOf(resul);
            textView1.setText("I.M.C es: " + calcular);

            if (resul < 16) {
                textView2.setText("Desnutrido");
            } else if (resul >= 16 && resul < 18) {
                textView2.setText("Delgado");
            } else if (resul >= 18 && resul < 28) {
                textView2.setText("Ideal");
            } else if (resul >= 28 && resul < 31) {
                textView2.setText("Sobrepeso");
            } else if (resul >= 31 && resul < 36) {
                textView2.setText("Obeso");
            }

        }catch (Exception e){

            Toast.makeText(Main3Activity.this,R.string.toast_num_incorret,Toast.LENGTH_SHORT).show();

        }

    }
    }

