package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterResolutionException;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	private HealthCalc calc;

	// Arrange
	@BeforeEach
	void initialize() {
		calc = (HealthCalc) new HealthCalcImp();
	}

	@Test
	@DisplayName("Example test.")
	public void bmi() {
		assertEquals(true, true);
	}

	@Test
	@DisplayName("Test the validity of the height.")
	public void invalidHeight() {

        assertThrows(IllegalArgumentException.class, () -> 
            calc.idealWeight(0, 'm'));  // Se prueba con altura invalida = 0


			assertThrows(IllegalArgumentException.class, () -> 
            calc.idealWeight(-1, 'm'));  // Se prueba con altura invalida = 0
    }

	@Test
	@DisplayName("Test if the gender format is incorrect.")
	void invalidGenderFormatThrowsException() {
		// Arrange
		int h = 169;
		char gender = 'x';

		// Act
		assertThrows(ParameterResolutionException.class, () ->
			calc.idealWeight(h, gender));
	}

	@Test
	@DisplayName("Que me haga el cálculo bien de las mujeres")
	void correctNumericResultWomen() {
		int h = 164;

		// Act
		// For men: IW = height - 100 - (height - 150) / 4)


		HealthCalc calc = new HealthCalcImp();
		float iw_women = calc.idealWeight(h, 'w');

		// Assert
		assertEquals(58.4, iw_women);
	}

	@Test
	@DisplayName("Que me haga el cálculo bien de los hombres")
	void correctNumericResultMen() throws Exception {
		int h = 164;

		HealthCalc calc = new HealthCalcImp();
		double iw_men = calc.idealWeight(h, 'm');

		// Assert
		assertEquals(60.5, iw_men);
	}

	@Test
	@DisplayName("Altura menor a 3 metros. Límites")
	void limitHeight() {

	}


	@Test
	@DisplayName("Que no tenga decimales porque es en cm")
	void noDecimales() {

	}

	@Test
	@DisplayName("es en kg. Limite superior: 300")
	void limitKg() {

	}


}
