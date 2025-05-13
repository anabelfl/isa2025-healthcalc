package cliente;

import adapter.HealthAdapter;
import decorator.AmericanDecorator;
import decorator.EnglishMessageDecorator;
import decorator.SpanishMessageDecorator;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;

public class MainVersiones {

        public static void main(String[] args) throws Exception {
                // Instancia de HealthCalcImp
                HealthCalc calcOriginal = HealthCalcImp.getInstance(); // usando singleton
                
                HealthAdapter calcEuropea = new HealthAdapter(calcOriginal);
                AmericanDecorator calcAmericana = new AmericanDecorator(calcEuropea);

                // Misma prueba con diferentes unidades
                System.out.println(calcEuropea.idealWeight(1.64f, 'w'));
                float pruebaAmericana = calcAmericana.idealWeight(5.3806f, 'w');
                System.out.println(pruebaAmericana);

                // Prueba de BMR con diferentes unidades
                float pruebaBMR = calcEuropea.basalMetabolicRate(63000, 1.64f, 21, 'w');
                System.out.println(pruebaBMR);
                float pruebaAmericana2 = calcAmericana.basalMetabolicRate(138.89f, 5.3806f, 21, 'w');
                System.out.println(pruebaAmericana2);

                // Prueba mensajes
                EnglishMessageDecorator calcIngles = new EnglishMessageDecorator(calcEuropea);
                System.out.println(calcIngles.basalMetabolicRate(63000, 1.64f, 21, 'w'));

                SpanishMessageDecorator calcEspañol = new SpanishMessageDecorator(calcEuropea);
                System.out.println(calcEspañol.basalMetabolicRate(63000, 1.64f, 21, 'w'));
        }
    
}
