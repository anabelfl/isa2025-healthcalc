package hospital;

public class HospitalProxy implements HealthHospital, HealthStats {
    private final HealthHospital hospitalCalc; // Instancia de la clase HealthCalc

    private int totalPacientes = 0;
    private float sumaAlturas = 0;
    private float sumaPesos = 0;
    private int sumaEdades = 0;
    private float sumaBMR = 0;
    private int hombres = 0;
    private int mujeres = 0;

    public HospitalProxy(HealthHospital hospitalCalc) {
        this.hospitalCalc = hospitalCalc;
    }

    @Override
    public float idealWeight(float height, char gender) {
        float result = hospitalCalc.idealWeight(height, gender);

        sumaAlturas += height;
        if (gender == 'm') hombres++;
        else if (gender == 'w') mujeres++;
        totalPacientes++;

        return result;
    }

    @Override
    public float basalMetabolicRate(float weight, float height, int age, char gender) {
        float result = hospitalCalc.basalMetabolicRate(weight, height, age, gender);
        
        sumaPesos += weight;
        sumaAlturas += height;
        sumaEdades += age;
        sumaBMR += result;

        if (gender == 'm') hombres++;
        else if (gender == 'w') mujeres++;
        totalPacientes++;
        return result;
    }

    // Métodos para obtener estadísticas
    @Override
    public float alturaMedia() { return totalPacientes > 0 ? sumaAlturas / totalPacientes : 0; }
    
    @Override
    public float pesoMedio() { return totalPacientes > 0 ? sumaPesos / totalPacientes : 0; }
    
    @Override
    public float edadMedia() { return totalPacientes > 0 ? (float) sumaEdades / totalPacientes : 0; }
    
    @Override
    public float bmrMedio() { return totalPacientes > 0 ? sumaBMR / totalPacientes : 0; }
    
    @Override
    public int numSexoH() { return hombres; }
    
    @Override
    public int numSexoM() { return mujeres; }
    
    @Override
    public int numTotalPacientes() { return totalPacientes; }

}
