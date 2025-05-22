package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Health Calculator Tests.")
public class HealthCalcTest {

	private HealthCalc calc;

	// Arrange (uso general)
	@BeforeEach
	void initialize() {
		calc = HealthCalcImp.getInstance();
	}

/*
 * Tests del método idealWeight de la clase HealthCalcImp
 */

	@Test
	@DisplayName("Test the correct calculation of ideal weight for women")
	void correctResultWomenIW() throws Exception {
		// Arrange
		Person woman = new PersonImp(60, 164, 30, Gender.FEMALE);
		CardiovascularMetrics metrics = new CardiovascularMetrics();

		// Act
    	float result = metrics.getIdealBodyWeight(woman);
		float expected = 164 - 100 - (164 - 150) / 2.5f;

		// Assert
		assertEquals(expected, result, 0.1f);
	}

	@Test
	@DisplayName("Test the correct calculation of ideal weight for men")
	void correctResultMenIW() throws Exception {
   		// Arrange
   		Person man = new PersonImp(80, 191, 30, Gender.MALE);
    	CardiovascularMetrics metrics = new CardiovascularMetrics();

    	// Act
    	float result = metrics.getIdealBodyWeight(man);
    	float expected = 191 - 100 - (191 - 150) / 4.0f;

    	// Assert
    	assertEquals(expected, result, 0.1f);
	}

	@Test
	@DisplayName("Upper limit height is 250cm, otherwise throws exception.")
		void upperLimitHeightIW() {
    	// Arrange
    	CardiovascularMetrics metrics = new CardiovascularMetrics();

    	// Act + Assert
    	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
        	Person veryTallMan = new PersonImp(80, 251, 30, Gender.MALE);
        metrics.getIdealBodyWeight(veryTallMan);
    	});
	}	

	@Test
	@DisplayName("Lower limit height is 0cm, otherwise throws exception.")
		void lowerLimitHeightIW() {
		// Arrange
		CardiovascularMetrics metrics = new CardiovascularMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person veryShortMan = new PersonImp(80, 0, 30, Gender.MALE);
			metrics.getIdealBodyWeight(veryShortMan);
		});
	}

	/* Antes: throws exception when gender char is invalid
	 * Ahora: No se puede usar PersonImp para probar un género 
	 * uinválido porque no acepta un valor inválido.
	 * Tampoco existe un método que reciba un char
	 * directamente en CardiovascularMetrics.
	 */

/*
 * Tests del método basalMetabolicRate de la clase HealthCalcImp
 */

	@Test
	@DisplayName("Test the correct calculation of basal metabolic rate for women.")
	void correctResultWomenBMR() throws Exception {
		// Arrange
		Person woman = new PersonImp(65, 164, 21, Gender.FEMALE);
		MetabolicMetrics metrics = new MetabolicMetrics();

		// Act
		float bmr_women = metrics.basalMetabolicRate(woman);
		float result = 447.593f + (9.247f * 65) + (3.098f * 164) - (4.330f * 21);

		// Assert. Margen de error del 0.1
		assertEquals(result, bmr_women, 0.1f);
	}

	@Test
	@DisplayName("Test the correct calculation of basal metabolic rate for men.")
	void correctResultMenBMR() throws Exception {
		// Arrange
		Person man = new PersonImp(80, 177, 45, Gender.MALE);
		MetabolicMetrics metrics = new MetabolicMetrics();

		// Act
		float bmr_man = metrics.basalMetabolicRate(man);
		float result = 88.362f + (13.397f * 80) + (4.799f * 177) - (5.677f * 45);

		// Assert
		assertEquals(result, bmr_man, 0.1f);
	}

	@Test
	@DisplayName("The upper limit weight is 400kg; otherwise throw exception.")
	void upperLimitWeightBMR() {
		// Arrange
    	MetabolicMetrics metrics = new MetabolicMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person man = new PersonImp(500, 190, 30, Gender.MALE);
			metrics.basalMetabolicRate(man);
		});
	}

	@Test
	@DisplayName("Lower limit height is 0cm, otherwise throws exception.")
	void lowerLimitWeightBMR() {
		// Arrange
    	MetabolicMetrics metrics = new MetabolicMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person man = new PersonImp(80, 0, 30, Gender.MALE);
			metrics.basalMetabolicRate(man);
		});
	}

	@Test
	@DisplayName("The upper limit height is 250 cm; otherwise throw exception.")
	void upperLimitHeightBMR() {
		// Arrange
    	MetabolicMetrics metrics = new MetabolicMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person man = new PersonImp(60, 260, 65, Gender.MALE);
			metrics.basalMetabolicRate(man);
		});
	}

	@Test
	@DisplayName("The lower limit height is 0kg; otherwise, throw exception.")
	void lowerLimitHeightBMR() {
		// Arrange
    	MetabolicMetrics metrics = new MetabolicMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person fem = new PersonImp(60, -4, 65, Gender.FEMALE);
			metrics.basalMetabolicRate(fem);
		});
	}

	@Test
	@DisplayName("Test if age is in range; if not, throw an exception.")
	void invalidAgeThrowsException1BMR() {
		// Arrange
    	MetabolicMetrics metrics = new MetabolicMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person fem = new PersonImp(60, 100, -3, Gender.FEMALE);
			metrics.basalMetabolicRate(fem);
		});
	}

	@Test
	@DisplayName("Test if age is in range; if not, throw an exception.")
	void invalidAgeThrowsException2BMR() {
		// Arrange
    	MetabolicMetrics metrics = new MetabolicMetrics();

		// Act + Assert
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Person fem = new PersonImp(60, 100, 140, Gender.FEMALE);
			metrics.basalMetabolicRate(fem);
		});
	}

	/* Antes: throws exception when gender char is invalid
	 * Ahora: No se puede usar PersonImp para probar un género 
	 * uinválido porque no acepta un valor inválido.
	 * Tampoco existe un método que reciba un char
	 * directamente en Metabolicmetrics.
	 */

}
