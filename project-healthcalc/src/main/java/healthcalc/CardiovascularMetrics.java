package healthcalc;

public class CardiovascularMetrics {

    public float getIdealBodyWeight(Person person) throws Exception {
        int height = person.height();
        Gender gender = person.gender();
        
        return switch (gender) {
        case MALE -> height - 100 - (height - 150) / 4.0f;
        case FEMALE -> height - 100 - (height - 150) / 2.5f;
        };

    }
}