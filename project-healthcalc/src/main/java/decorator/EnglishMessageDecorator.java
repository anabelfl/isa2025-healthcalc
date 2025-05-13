package decorator;

import adapter.HealthHospital;

public class EnglishMessageDecorator implements HealthHospital {
    private final HealthHospital adaptee;

    public EnglishMessageDecorator(HealthHospital calc) {
        this.adaptee = calc;
    }

    @Override
    public float idealWeight(float heightInCm, char gender) {
        return adaptee.idealWeight(heightInCm, gender);
    }

    @Override
    public float basalMetabolicRate(float weightInKg, float heightInCm, int age, char gender) {
        float bmr = adaptee.basalMetabolicRate(weightInKg, heightInCm, age, gender);
        System.out.printf("The person with height %.2f meters and %.1f kg has a BMR of %.2f kcal/day.\n", heightInCm / 100f, weightInKg, bmr);
        return bmr;
    }
}
