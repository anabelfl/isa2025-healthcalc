package hospital;

public interface HealthHospital {
    float idealWeight(float height, char gender);
    float basalMetabolicRate(float weight, float height, int age, char gender);
}
