package com.example.henry.imc.util;

import android.util.Log;

public class ImcCalculator {

    public static float calculateImc(float weight, float height) {
        return (weight / (height * 2));
    }

}