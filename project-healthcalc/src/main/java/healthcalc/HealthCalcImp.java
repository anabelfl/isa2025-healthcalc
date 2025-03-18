package healthcalc;

// Implementación de la intergaz HealthCalc

public class HealthCalcImp implements HealthCalc{

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        
        // Comprobación de parámetros
        if (height <= 0 || height > 250) { throw new IllegalArgumentException("Height out of range (1-250)"); }
        if (gender != 'm' && gender != 'w') { throw new IllegalArgumentException("Invalid gender. Do use 'w' or 'm'"); }

        // Cálculo del peso ideal usando la fórmula de Lorentz
        if (gender == 'm') {
            return height - 100 - (height - 150) / 4.0f;
        } else {
            return height - 100 - (height - 150) / 2.5f;
        }
    }    

    @Override
    public float basalMetabolicRate(float weight, int height, int age, char gender) throws Exception {
        
        //Comprobación de parámetros
        if (weight <= 0 || weight > 400) { throw new IllegalArgumentException("Weight out of range (1-400 kg)"); }
        if (height <= 0 || height > 250) { throw new IllegalArgumentException("Height out of range (1-250 cm)"); }
        if (age <= 0 || age > 110) { throw new IllegalArgumentException("Age out of range (1-110 years)"); }
        if (gender != 'm' && gender != 'w') { throw new IllegalArgumentException("Invalid gender. Do use 'w' or 'm'"); }

        // Cálculo de la Tasa Metabólica Basal usando la fórmula de Lorentz
        if (gender == 'm') {
            return 88.362f + (13.397f * weight) + (4.799f * height) - (5.677f * age);
        } else {
            return 447.593f + (9.247f * weight) + (3.098f * height) - (4.330f * age);
        }

    }

}