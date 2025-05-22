package healthcalc;

public class PersonImp implements Person {

    private float weight;
    private int height;
    private int age;
    private Gender gender;

    public PersonImp(float weight, int height, int age, Gender gender) {
        if (weight <= 0 || weight > 400) {
            throw new IllegalArgumentException("Weight out of range (1-400 kg).");
        }
        if (height <= 0 || height > 250) {
            throw new IllegalArgumentException("Height out of range (1-250 cm).");
        }
        if (age <= 0 || age > 110) {
            throw new IllegalArgumentException("Age out of range (1-110 years).");
        }
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null.");
        }

        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    // Getters de interfaz Person
    @Override
    public float weight() {
        return this.weight;
    }

    @Override
    public int height() {
        return this.height;
    }

    @Override
    public Gender gender() {
        return this.gender;
    }

    @Override
    public int age() {
        return this.age;
    }

    // public void setWeight(float weight) { this.weight = weight; }
    // public void setHeight(int height) { this.height = height; }
    // public void setAge(int age) { this.age = age; }
    // public void setGender(Gender gender) { this.gender = gender; }
}
