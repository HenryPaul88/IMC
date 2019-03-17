package com.example.henry.imc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henry.imc.util.ImcCalculator;

public class HombreActivity extends AppCompatActivity {

    public static final String LOG_TAG = "HombreActivity";

    private EditText etWeight;
    private EditText etHeight;
    private TextView tvImc;
    private TextView tvResult;
    private ImageView ivImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombre);
        Log.d(LOG_TAG, "Show the activity...");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        tvImc = findViewById(R.id.tvImc);
        tvResult = findViewById(R.id.tvResult);
        ivImage = findViewById(R.id.ivImage);

        Button btCalculate = (Button) findViewById(R.id.btCalculate);
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "realiza el clic");
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
            ivImage.setImageResource(R.drawable.desnutridohombre);

        } else if (result < 18.5) {
            tvResult.setText("Delgado");
            ivImage.setImageResource(R.drawable.delgadohombre);

        } else if (result < 24.1) {
            tvResult.setText("Ideal");
            ivImage.setImageResource(R.drawable.idealhombre);

        } else if (result < 31.1) {
            tvResult.setText("Sobrepeso");
            ivImage.setImageResource(R.drawable.sobrepesohombre);

        } else if (result < 60) {
            tvResult.setText("Obeso");
            ivImage.setImageResource(R.drawable.obesohombre);
        }
    }

}
