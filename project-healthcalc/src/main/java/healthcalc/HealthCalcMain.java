package healthcalc; 



public class HealthCalcMain {
    public static void main(String[] args) throws Exception  {
        HealthCalc c = new HealthCalcImp();
        float resultado_iw = c.idealWeight(180,'m');
        System.out.println(resultado_iw);

        float resultado_bmr = c.basalMetabolicRate(64, 164, 21, 'w');
        System.out.println(resultado_bmr);
    }
}
