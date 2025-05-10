package cliente;

import adaptador.AmericanHealthAdapter;
import adaptador.EuropeanHealthAdapter;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import hospital.HospitalProxy;

public class MainStats {

    public static void main(String[] args) {

        HealthCalc calc = HealthCalcImp.getInstance();

        // Adaptadores
        EuropeanHealthAdapter calcEuropean = new EuropeanHealthAdapter(calc);
        AmericanHealthAdapter calcAmerican = new AmericanHealthAdapter(calc);

        // Proxies distintos
        HospitalProxy europeanProxy = new HospitalProxy(calcEuropean);
        HospitalProxy americanProxy = new HospitalProxy(calcAmerican);

        try {
            // Se añaden pacientes en sistema europeo (gramos, metros)
            System.out.println("------ Pacientes sistema europeo ------");
            europeanProxy.idealWeight(1.64f, 'm'); // altura en metros
            europeanProxy.basalMetabolicRate(63500f, 1.64f, 21, 'w'); // peso en gramos, altura en metros
            System.out.println();
            europeanProxy.basalMetabolicRate(80400f, 1.80f, 30, 'm'); // peso en gramos, altura en metros

            System.out.println();

            // Se añaden pacientes en sistema americano (libras, pies)
            System.out.println("------ Pacientes sistema americano ------");
            americanProxy.idealWeight(5.7f, 'm'); // pies
            americanProxy.basalMetabolicRate(140f, 5.7f, 21, 'w'); // libras, pies
            System.out.println();
            americanProxy.basalMetabolicRate(177f, 5.9f, 30, 'm'); // libras, pies

            System.out.println();
            
            System.out.println("------ Estadísticas Europeas ------");
            printStats(europeanProxy);

            System.out.println();

            System.out.println("------ Estadísticas Americanas ------");
            printStats(americanProxy);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printStats(HospitalProxy proxy) {
        System.out.println("Altura media: " + proxy.alturaMedia());
        System.out.println("Peso medio: " + proxy.pesoMedio());
        System.out.println("Edad media: " + proxy.edadMedia());
        System.out.println("BMR medio: " + proxy.bmrMedio());
        System.out.println("Nº de pacientes hombres: " + proxy.numSexoH());
        System.out.println("Nº de pacientes mujeres: " + proxy.numSexoM());
        System.out.println("Total pacientes: " + proxy.numTotalPacientes());
    }
}
