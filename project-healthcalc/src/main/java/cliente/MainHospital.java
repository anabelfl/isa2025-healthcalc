package cliente;

import healthcalc.CardiovascularMetrics;
import healthcalc.Gender;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import healthcalc.MetabolicMetrics;
import healthcalc.Person;
import healthcalc.PersonImp;

public class MainHospital {

    public static void main(String[] args) throws Exception {

		HealthCalc calcOriginal = HealthCalcImp.getInstance(); // usando singleton

        Person person1 = new PersonImp(63, 164, 21, Gender.FEMALE);
        Person person2 = new PersonImp(70, 180, 35, Gender.MALE); // Ejemplo adicional
		
        CardiovascularMetrics cvMetrics = new CardiovascularMetrics();
        MetabolicMetrics mMetrics = new MetabolicMetrics();

        float iw1 = cvMetrics.getIdealBodyWeight(person1);
        float iw2 = cvMetrics.getIdealBodyWeight(person2);

        float bmr1 = mMetrics.basalMetabolicRate(person1);
        float bmr2 = mMetrics.basalMetabolicRate(person2);

        System.out.println(iw1);
        System.out.println(iw2);
        System.out.println(bmr1);
        System.out.println(bmr2);
        
    }
}
