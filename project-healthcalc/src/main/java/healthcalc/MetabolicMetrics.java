package healthcalc;

public class MetabolicMetrics {

    public float basalMetabolicRate(Person person) throws Exception {
        float weight = person.weight();
        int height = person.height();
        int age = person.age();
        Gender gender = person.gender();

        if (weight <= 0 || weight > 400) { 
            throw new IllegalArgumentException("Weight out of range (1-400 kg) for BMR calculation."); 
        }
        if (height <= 0 || height > 250) { 
            throw new IllegalArgumentException("Height out of range (1-250 cm) for BMR calculation."); 
        }
        if (age <= 0 || age > 110) { 
            throw new IllegalArgumentException("Age out of range (1-110 years) for BMR calculation."); 
        }

        if (null == gender) {
            throw new IllegalArgumentException("Invalid gender provided for BMR calculation.");
        } else 
        switch (gender) {
            case MALE -> {
                return 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
            }
            case FEMALE -> {
                return 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
            }
            default ->
                throw new IllegalArgumentException("Invalid gender provided for BMR calculation.");
        }
    }
}