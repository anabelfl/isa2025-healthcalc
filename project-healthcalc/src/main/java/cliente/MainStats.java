package cliente;

import adapter.HealthAdapter;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import proxy.HospitalProxy;

public class MainStats {

    public static void main(String[] args) {

        HealthCalc calc = HealthCalcImp.getInstance();
        
        // Adaptador
        HealthAdapter calcEuropea = new HealthAdapter(calc);
        System.out.println(calcEuropea.idealWeight(1.64f, 'w'));	
        System.out.println(calcEuropea.basalMetabolicRate(63000, 1.64f, 21, 'w'));

        HospitalProxy proxy = new HospitalProxy(calcEuropea);
        System.out.println(proxy.idealWeight(1.64f, 'w'));
        System.out.println(proxy.basalMetabolicRate(63000, 1.64f, 21, 'w'));
        printStats(proxy);
    }

    public static void printStats(HospitalProxy proxy) {
        System.out.println("------ Estadísticas ------");
        System.out.println("Altura media: " + proxy.alturaMedia());
        System.out.println("Peso medio: " + proxy.pesoMedio());
        System.out.println("Edad media: " + proxy.edadMedia());
        System.out.println("BMR medio: " + proxy.bmrMedio());
        System.out.println("Nº de pacientes hombres: " + proxy.numSexoH());
        System.out.println("Nº de pacientes mujeres: " + proxy.numSexoM());
        System.out.println("Total pacientes: " + proxy.numTotalPacientes());
    }
}
