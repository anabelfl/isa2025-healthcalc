package cliente;

import adaptador.AmericanHealthAdapter;
import adaptador.EuropeanHealthAdapter;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import hospital.HealthHospital;

public class MainVersiones {

        public static void main(String[] args) {
                // Instancia de HealthCalcImp
                HealthCalc calcOriginal = HealthCalcImp.getInstance(); // usando singleton

                // Adaptador para la versión europae
                HealthHospital calcEuropea = new EuropeanHealthAdapter(calcOriginal);

                // Adaptador para la versión americana
                HealthHospital calcAmericana = new AmericanHealthAdapter(calcOriginal);
                
                // 6.1024 pies = 1.86 metros
                // 198.42 libras = 90 kg
                System.out.println("------ Version americana ------");
                float iw_am = calcAmericana.idealWeight(5.3806f, 'w');
                float bmr_am = calcAmericana.basalMetabolicRate(198.42f, 6.1024f, 37, 'm');
                
            
                System.out.println();
                System.out.println("------ Version europea ------");
                // 186 metros = 186 cm
                // 90 kg = 90000 g
                float iw_eu = calcEuropea.idealWeight(1.64f, 'w');
                float bmr_eu = calcEuropea.basalMetabolicRate(90000f, 1.86f, 37, 'm');
        }
    
}
