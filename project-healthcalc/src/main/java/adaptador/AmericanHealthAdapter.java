package adaptador;

import healthcalc.HealthCalc;
import hospital.HealthHospital;

public class AmericanHealthAdapter implements HealthHospital {
    private final HealthCalc adaptee;

    public AmericanHealthAdapter(HealthCalc calc) {
        this.adaptee = calc;
    }

    @Override
    public float idealWeight(float heightInFeet, char gender) {
        // 1 pie = 30.48 cm
        int heightInCm = Math.round(heightInFeet * 30.48f);

        try {
            return adaptee.idealWeight(heightInCm, gender);
        } catch (Exception e) {
            throw new RuntimeException("Error en idealWeight: " + e.getMessage());
        }
    }

    @Override
    public float basalMetabolicRate(float weightInPounds, float heightInFeet, int age, char gender) {
        // 1 libra = 0.453592 kg
        // 1 pie = 30.48 cm
        // 1 cm = 0.01 m
        float weightInKg = weightInPounds * 0.453592f;
        int heightInCm = Math.round(heightInFeet * 30.48f);
        float heightInMeters = heightInCm / 100f;

        try {
            float bmr = adaptee.basalMetabolicRate(weightInKg, heightInCm, age, gender);

            System.out.printf("La persona con altura %.2f metros y %.1f kg tiene un BMR de %.2f kcal/dia.\n",
                                heightInMeters, weightInKg, bmr);
            System.out.printf("The person with height %.2f meters and %.1f kg has a BMR of %.2f kcal/day.\n",
                                heightInMeters, weightInKg, bmr);
            return bmr;

        } catch (Exception e) {
            throw new RuntimeException("Error en basalMetabolicRate: " + e.getMessage());
        }
    }
}
