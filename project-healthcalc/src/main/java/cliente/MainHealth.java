package cliente;

import java.awt.EventQueue;

import controlador.HealthCtrl;
import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import vista.Vista;

public class MainHealth {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalc modelo = HealthCalcImp.getInstance();
					Vista vista = new Vista();
					HealthCtrl controlador = new HealthCtrl(modelo, vista);

					vista.registrarControlador(controlador);
					vista.registrarControladorBMR(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
