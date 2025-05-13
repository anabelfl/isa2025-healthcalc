package cliente;

import adapter.HealthAdapter;
import adapter.HealthHospital;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;

public class MainHospital {

    public static void main(String[] args) throws Exception {

		HealthCalc calcOriginal = HealthCalcImp.getInstance(); // usando singleton
		
        // Realizar las pruebas de la calculadora original
        float iw = calcOriginal.idealWeight(164, 'w');
        float bmr = calcOriginal.basalMetabolicRate(63, 164, 21, 'w');
        System.out.println(iw);
        System.out.println(bmr);
        
        HealthHospital calcAdaptado = new HealthAdapter(calcOriginal);

        // Realizar las pruebas de la calculadora adaptada
        float iw2 = calcAdaptado.idealWeight(1.64f, 'w');
        float bmr2 = calcAdaptado.basalMetabolicRate(63000f, 1.64f, 21, 'w');
        System.out.println("Peso ideal: " + iw2 + " g");
        System.out.println("BMR: " + bmr2 + " kcal/dia");
    }
}
