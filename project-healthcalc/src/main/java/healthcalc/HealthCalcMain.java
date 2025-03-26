package healthcalc; 



public class HealthCalcMain {
    public static void main(String[] args) throws Exception  {
        HealthCalc c = new HealthCalcImp();
        float resultado_iw = c.idealWeight(180,'m');
        System.out.println(resultado_iw);

        float resultado_bmr = c.basalMetabolicRate(64, 164, 21, 'w');
        float resultado_bmr2 = c.basalMetabolicRate(80, 184, 25, 'm');

        System.out.println(resultado_bmr2);
    }
}
