package adaptador;

import healthcalc.HealthCalc;
import hospital.HealthHospital;

public class HealthAdaptador implements HealthHospital {
    private final HealthCalc calc;

    public HealthAdaptador(HealthCalc calc) {
        this.calc = calc;
    }

    @Override
    public float idealWeight(float heightInMeters, char gender) {
        int heightInCm = Math.round(heightInMeters * 100);
        try {
            return calc.idealWeight(heightInCm, gender);
        } catch (Exception e) {
            throw new RuntimeException("Error de conversión en peso ideal: " + e.getMessage());
        }
    }

    @Override
    public float basalMetabolicRate(float weightInGrams, float heightInMeters, int age, char gender) {
        float weightInKg = weightInGrams / 1000f;
        int heightInCm = Math.round(heightInMeters * 100);
        try {
            return calc.basalMetabolicRate(weightInKg, heightInCm, age, gender);
        } catch (Exception e) {
            throw new RuntimeException("Error de conversión en BMR: " + e.getMessage());
        }
    }

}