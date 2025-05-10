package adaptador;

import healthcalc.HealthCalc;
import hospital.HealthHospital;

public class EuropeanHealthAdapter implements HealthHospital {
    private final HealthCalc adaptee;

    public EuropeanHealthAdapter(HealthCalc calc) {
        this.adaptee = calc;
    }

    @Override
    public float idealWeight(float heightInMeters, char gender) {
        int heightInCm = Math.round(heightInMeters * 100);
        try {
            return adaptee.idealWeight(heightInCm, gender);
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
            System.out.printf("La persona con altura %.2f metros y %.1f kg tiene un BMR de %.2f kcal/dia.\n", heightInMeters, weightInKg, bmr);
            System.out.printf("The person with height %.2f meters and %.1f kg has a BMR of %.2f kcal/day.\n", heightInMeters, weightInKg, bmr);
            return bmr;

        } catch (Exception e) {
            throw new RuntimeException("Error de conversión en BMR: " + e.getMessage());
        }
    }

}