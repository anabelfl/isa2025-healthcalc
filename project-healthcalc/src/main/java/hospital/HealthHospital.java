package hospital;

public interface HealthHospital {
    float idealWeight(float heightInMeters, char gender);
    float basalMetabolicRate(float weightInGrams, float heightInMeters, int age, char gender);

}
