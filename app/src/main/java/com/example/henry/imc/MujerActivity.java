package com.example.henry.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henry.imc.util.ImcCalculator;

public class MujerActivity extends AppCompatActivity {

    public  static final String LOG_TAG = "";

    private EditText etWeight;
    private EditText etHeight;
    private TextView tvImc;
    private TextView tvResult;
    private ImageView ivImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujer);
        Log.d(LOG_TAG,"muestra la activity");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        etWeight = findViewById(R.id.etWeight_1);
        etHeight = findViewById(R.id.etHeight_1);
        tvImc = findViewById(R.id.tvImc_1);
        tvResult = findViewById(R.id.tvResult_1);
        ivImage = findViewById(R.id.ivImage_1);

        Button btCalculate = findViewById(R.id.btCalculate_1);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG,"realiza el clic");
               float weight = Float.parseFloat(etWeight.getText().toString());
               float height = Float.parseFloat(etHeight.getText().toString());
               float result = ImcCalculator.calculateImc(weight, height);

               setFields(result);


            }
        });
    }

    private void setFields(float result) {

        tvImc.setText(String.format("I.M.C es: %s", result));


        if (result < 16) {
            tvResult.setText("Desnutrido");
            ivImage.setImageResource(R.drawable.destrunidamujer);

        } else if (result < 18.5) {
            tvResult.setText("Delgado");
            ivImage.setImageResource(R.drawable.delgadamujer);

        } else if (result < 24.9) {
            tvResult.setText("Ideal");
            ivImage.setImageResource(R.drawable.mujerideal);

        } else if (result < 31.9) {
            tvResult.setText("Sobrepeso");
            ivImage.setImageResource(R.drawable.sobrepesomujer);

        } else if (result < 60) {
            tvResult.setText("Obeso");
            ivImage.setImageResource(R.drawable.obesamujer);
        }

    }


}

