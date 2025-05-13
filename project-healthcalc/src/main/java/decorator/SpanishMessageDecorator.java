package decorator;

import adapter.HealthHospital;

public class SpanishMessageDecorator implements HealthHospital {
    private final HealthHospital adaptee;

    public SpanishMessageDecorator(HealthHospital calc) {
        this.adaptee = calc;
    }

    @Override
    public float idealWeight(float height, char gender) {
        return adaptee.idealWeight(height, gender);
    }

    @Override
    public float basalMetabolicRate(float weightInKg, float heightInCm, int age, char gender) {
        float bmr = adaptee.basalMetabolicRate(weightInKg, heightInCm, age, gender);
        System.out.printf("La persona con altura %.2f metros y %.1f kg tiene un BMR de %.2f kcal/día.\n", heightInCm / 100f, weightInKg, bmr);
        return bmr;
    }
}
