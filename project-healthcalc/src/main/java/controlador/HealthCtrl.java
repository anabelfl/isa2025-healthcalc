package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.CardiovascularMetrics;
import healthcalc.Gender;
import healthcalc.HealthCalc;
import healthcalc.MetabolicMetrics;
import healthcalc.Person;
import healthcalc.PersonImp;
import vista.Vista;

public class HealthCtrl implements ActionListener {

	private HealthCalc modelo;
	private Vista vista;

	public HealthCtrl(HealthCalc modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("Compute")) {
            int selectedTabIndex = vista.getTabbedPane().getSelectedIndex();

        	/*
        	 * IDEAL WEIGHT
        	 */
            if (selectedTabIndex == 0) { // TAB IDEAL WEIGTH
                try {
                    int altura = vista.getAltura();
                    char generoChar = vista.getGeneroSeleccionado();

                    Gender genderEnum;
                    switch (generoChar) {
                        case 'w', 'W' -> genderEnum = Gender.FEMALE;
                        case 'm', 'M' -> genderEnum = Gender.MALE;
                        default -> throw new IllegalArgumentException("Gender cannot be null.");
                    }

                    Person person = new PersonImp(70, altura, 30, genderEnum); 
                    
                    CardiovascularMetrics cvMetrics = new CardiovascularMetrics();
                    float resultado = cvMetrics.getIdealBodyWeight(person);

                    vista.setResultado(resultado); 
                    vista.resetFieldsIW(); 

                } catch (IllegalArgumentException ex) {
                    vista.error("Error: " + ex.getMessage()); 
                } catch (Exception ex) {
                    vista.error("An unexpected error occurred: " + ex.getMessage());
                }
            } 
        	/*
        	 * BASAL METABOLIC RATE
        	 */
            else if (selectedTabIndex == 1) { // TAB BASAL METABOLIC RATE
                try {
                    float pesoBMR = vista.getPesoBMR();
                    int alturaBMR = vista.getAlturaBMR();
                    int edadBMR = vista.getEdadBMR();
                    char generoBMRChar = vista.getGeneroSeleccionadoBMR();

                    Gender genderEnumBMR;
                    switch (generoBMRChar) {
                        case 'w', 'W' -> genderEnumBMR = Gender.FEMALE;
                        case 'm', 'M' -> genderEnumBMR = Gender.MALE;
                        default -> throw new IllegalArgumentException("Gender cannot be null.");
                    }

                    Person personBMR = new PersonImp(pesoBMR, alturaBMR, edadBMR, genderEnumBMR);
                    
                    MetabolicMetrics mMetrics = new MetabolicMetrics();
                    float resultado = mMetrics.basalMetabolicRate(personBMR);

                    vista.setResultadoBMR(resultado);
                    vista.resetFieldsBMR();

                } catch (IllegalArgumentException ex) {
                    vista.errorBMR("Error: " + ex.getMessage());
                } catch (Exception ex) {
                    vista.errorBMR("An unexpected error occurred: " + ex.getMessage());
                }
            }
        }
    }
}
