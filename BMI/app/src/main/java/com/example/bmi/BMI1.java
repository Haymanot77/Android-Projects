package com.example.bmi;

public class BMI1 {
    public Double weight;
    public Double height;
    public Double calculateBMI(double wt,double ht) {
        return weight / (height* height);
    }
}

