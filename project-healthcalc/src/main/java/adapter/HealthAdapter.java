package adapter;

import healthcalc.HealthCalc;

public class HealthAdapter implements HealthHospital {
    private final HealthCalc adaptee;

    public HealthAdapter(HealthCalc calc) {
        this.adaptee = calc;
    }

    @Override
    public float idealWeight(float heightInMeters, char gender) {
        int heightInCm = Math.round(heightInMeters * 100);
        try {
            float resultadoEnGramos = adaptee.idealWeight(heightInCm, gender) * 1000f;
            return resultadoEnGramos;
        } catch (Exception e) {
            throw new RuntimeException("Error de conversión en peso ideal: " + e.getMessage());
        }
    }

    @Override
    public float basalMetabolicRate(float weightInGrams, float heightInMeters, int age, char gender) {
        float weightInKg = weightInGrams / 1000f;
        int heightInCm = Math.round(heightInMeters * 100);

        try {
            float bmr = adaptee.basalMetabolicRate(weightInKg, heightInCm, age, gender);
            return bmr;

        } catch (Exception e) {
            throw new RuntimeException("Error de conversión en BMR: " + e.getMessage());
        }
    }

}