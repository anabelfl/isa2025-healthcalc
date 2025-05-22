package healthcalc;

// Implementación de la interfaz HealthCalc

public class HealthCalcImp implements HealthCalc, Person{

    private static HealthCalcImp instance;

    private float weight;
    private int height;
    private int age;
    private Gender gender;
    
    private HealthCalcImp() {
        // Constructor privado para evitar instanciación externa
    }

    public static HealthCalcImp getInstance() {
        if (instance == null) {
            instance = new HealthCalcImp();
        }
        return instance;
    }

    // Setters
    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
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

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        throw new UnsupportedOperationException("idealWeight(int, char) is deprecated; use CardiovascularMetrics.getIdealBodyWeight(Person)");
    }    

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        throw new UnsupportedOperationException("basalMetabolicRate(float, int, int, char) is deprecated; use MetabolicMetrics.basalMetabolicRate(Person)");
    }
}
