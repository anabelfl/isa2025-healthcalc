package cliente;

import adaptador.HealthAdaptador;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import hospital.HospitalProxy;

public class MainStats {

    public static void main(String[] args) {

        // Adapter que convierte m/g → cm/kg y llama a la calculadora real
        HealthCalc calc = HealthCalcImp.getInstance();

        HealthAdaptador calcAdaptador = new HealthAdaptador(calc);

        // Proxy que envuelve al adapter, añade estadísticas
        HospitalProxy calcProxy = new HospitalProxy(calcAdaptador);

        
        try {
            calcProxy.idealWeight(1.64f, 'm');
            calcProxy.basalMetabolicRate(63500f, 1.64f, 21, 'w');
            calcProxy.basalMetabolicRate(80454, 1.8f, 30, 'm');


            // Obtener la media de las alturas, pesos, edades y BMR
            System.out.println("Altura media: " + calcProxy.alturaMedia());
            System.out.println("Peso medio: " + calcProxy.pesoMedio());
            System.out.println("Edad media: " + calcProxy.edadMedia());
            System.out.println("BMR medio: " + calcProxy.bmrMedio());

            // Obtener el número de pacientes por sexo
            System.out.println("Número de pacientes hombres: " + calcProxy.numSexoH());
            System.out.println("Número de pacientes mujeres: " + calcProxy.numSexoM());

            // Obtener el número total de pacientes
            System.out.println("Número total de pacientes: " + calcProxy.numTotalPacientes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
