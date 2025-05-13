package decorator;

import adapter.HealthHospital;

public class AmericanDecorator implements HealthHospital {
    private final HealthHospital adaptee;

    public AmericanDecorator(HealthHospital calc) {
        this.adaptee = calc;
    }

    @Override
    public float idealWeight(float heightInFeet, char gender) {
        // 1 pie = 30.48 cm
        float heightEnMetros = heightInFeet * 0.3048f;

        try {
            return adaptee.idealWeight(heightEnMetros, gender);
        } catch (Exception e) {
            throw new RuntimeException("Error idealWeight: " + e.getMessage());
        }
    }

    @Override
    public float basalMetabolicRate(float weightInPounds, float heightInFeet, int age, char gender) {
        // 1 libra = 0.453592 kg
        // 1 pie = 30.48 cm
        float weightEnG = weightInPounds * 0.453592f * 1000f;
        float heightEnMetros = heightInFeet * 0.3048f;

        try {
            float bmr = adaptee.basalMetabolicRate(weightEnG, heightEnMetros, age, gender);
            return bmr;

        } catch (Exception e) {
            throw new RuntimeException("Error basalMetabolicRate: " + e.getMessage());
        }
    }
}