package cliente;

import adaptador.EuropeanHealthAdapter;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import hospital.HealthHospital;

public class MainHospital {

    public static void main(String[] args) {

		HealthCalc calcOriginal = HealthCalcImp.getInstance(); // usando singleton
		HealthHospital calcAdaptado = new EuropeanHealthAdapter(calcOriginal);

        // Realizar las pruebas
        float iw = calcAdaptado.idealWeight(1.64f, 'w');
        float bmr = calcAdaptado.basalMetabolicRate(63500f, 1.64f, 21, 'w');

        // Mostrar los resultados
        System.out.println("Peso ideal: " + iw + " kg");
        System.out.println("BMR: " + bmr + " kcal/dia");
    }
}
