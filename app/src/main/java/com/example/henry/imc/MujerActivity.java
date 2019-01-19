package com.example.henry.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MujerActivity extends AppCompatActivity {

    public  static final String LOG_TAG = "";

    private EditText editText1;
    private EditText editText2;
    private Button button2;
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujer);
        Log.d(LOG_TAG,"muestra la activity");

        editText1 = (EditText) findViewById(R.id.edit_1_1);
        editText2 = (EditText) findViewById(R.id.edit_2_2);
        button2 = (Button) findViewById(R.id.bottom2_2);
        textView1 = (TextView) findViewById(R.id.text_2_2);
        textView2 = (TextView) findViewById(R.id.text_3_3);
        imageView = (ImageView) findViewById(R.id.imagen2);

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
                imageView.setImageResource(R.drawable.destrunidamujer);

            } else if (resul >= 16 && resul < 18.5) {
                textView2.setText("Delgado");
                imageView.setImageResource(R.drawable.delgadamujer);

            } else if (resul >= 18.5 && resul < 24.9) {
                textView2.setText("Ideal");
                imageView.setImageResource(R.drawable.mujerideal);

            } else if (resul >= 24.9 && resul < 31.9) {
                textView2.setText("Sobrepeso");
                imageView.setImageResource(R.drawable.sobrepesomujer);

            } else if (resul >= 31.9 && resul < 60) {
                textView2.setText("Obeso");
                imageView.setImageResource(R.drawable.obesamujer);
            }

        }catch (Exception e){

            Toast.makeText(MujerActivity.this,R.string.toast_num_incorret,Toast.LENGTH_SHORT).show();

        }

    }
    }

