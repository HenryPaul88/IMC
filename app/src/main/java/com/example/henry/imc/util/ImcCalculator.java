package com.example.henry.imc.util;


public class ImcCalculator {

    public static float calculateImc(float weight, float height)

    {
        return (weight / (height * 2));
    }

}