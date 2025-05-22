package healthcalc;

public class CardiovascularMetrics {

    public float getIdealBodyWeight(Person person) throws Exception {
        int height = person.height();
        Gender gender = person.gender();

        // Basic validation (can be enhanced or moved to Person implementers)
        if (height <= 0 || height > 250) { 
            throw new IllegalArgumentException("Height out of range (1-250 cm) for ideal weight calculation."); 
        }

        // Calculation of ideal weight using the Lorentz formula
        if (gender == Gender.MALE) {
            return height - 100 - (height - 150) / 4.0f;
        } else if (gender == Gender.FEMALE) {
            return height - 100 - (height - 150) / 2.5f;
        } else {
            // This case should ideally not be reached if Person.gender() is correctly implemented
            throw new IllegalArgumentException("Invalid gender provided for ideal weight calculation.");
        }
    }
}