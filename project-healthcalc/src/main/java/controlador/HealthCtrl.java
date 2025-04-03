package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import healthcalc.HealthCalc;
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
                    char genero = vista.getGeneroSeleccionado(); 

                    float resultado = modelo.idealWeight(altura, genero); 
                    vista.setResultado(resultado); 
                    vista.resetFieldsIW(); 

                } catch (IllegalArgumentException ex) {
                    vista.error("Error: " + ex.getMessage()); 
                } catch (Exception ex) {
                    vista.error("Error: " + ex.getMessage());
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
                    char generoBMR = vista.getGeneroSeleccionadoBMR();

                    float resultado = modelo.basalMetabolicRate(pesoBMR, alturaBMR, edadBMR, generoBMR);
                    vista.setResultadoBMR(resultado);
                    vista.resetFieldsBMR();

                } catch (IllegalArgumentException ex) {
                    vista.errorBMR("Error: " + ex.getMessage());
                } catch (Exception ex) {
                    vista.errorBMR("Error: " + ex.getMessage());
                }
            }
        }
    }
}
