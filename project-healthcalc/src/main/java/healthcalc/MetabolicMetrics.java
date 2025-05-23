package healthcalc;

public class MetabolicMetrics {

    public float basalMetabolicRate(Person person) throws Exception {
        float weight = person.weight();
        int height = person.height();
        int age = person.age();
        Gender gender = person.gender();

        return switch (gender) {
        case MALE -> 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
        case FEMALE -> 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        };
    }
}