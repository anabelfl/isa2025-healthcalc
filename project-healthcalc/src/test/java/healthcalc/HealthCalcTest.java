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
		int h = 164;
		char g = 'w';
		// Act
		float iw_women = calc.idealWeight(h, g);
		float result = h - 100 - (h - 150) / 2.5f;
		// Assert
		assertEquals(result, iw_women);
	}

	@Test
	@DisplayName("Test the correct calculation of ideal weight for men")
	void correctResultMenIW() throws Exception {
		int h = 164;
		char g = 'm';

		double iw_men = calc.idealWeight(h, g);
		float result = h - 100 - (h - 150) / 4.0f;

		assertEquals(result, iw_men);
	}

	@Test
	@DisplayName("Upper limit height is 250cm, otherwise throws exception.")
	void upperLimitHeightIW() {
		int h = 300;

		assertThrows(IllegalArgumentException.class, () -> 
		calc.idealWeight(h, 'm'));
	}

	@Test
	@DisplayName("Lower limit height is 0cm, otherwise throws exception.")
	void lowerLimitHeightIW() {
		int h = 0;

		assertThrows(IllegalArgumentException.class, () -> 
		calc.idealWeight(h, 'm'));
	}

	@Test
	@DisplayName("Throws exception when gender char is invalid.")
	void invalidGenderThrowsExceptionIW() {
		int h = 169;
		char gender = 'X';

		assertThrows(IllegalArgumentException.class, () ->
			calc.idealWeight(h, gender));
	}

/*
 * Tests del método basalMetabolicRate de la clase HealthCalcImp
 */

	@Test
	@DisplayName("Test the correct calculation of basal metabolic rate for women.")
	void correctResultWomenBMR() throws Exception {
		float w = 65;
		int h = 164;
		int age = 21;
		char g = 'w';

		float bmr_women = calc.basalMetabolicRate(w, h, age, g);
		float result = 447.593f + (9.247f * w) + (3.098f * h) - (4.330f * age);

		// assertEquals(1465.79, bmr_women, 0.01f); margen de error del 0.01
		assertEquals(result, bmr_women);
	}

	@Test
	@DisplayName("Test the correct calculation of basal metabolic rate for men.")
	void correctResultMenBMR() throws Exception {
		float w = 70;
		int h = 177;
		int age = 23;
		char g = 'm';

		float bmr_men = calc.basalMetabolicRate(w, h, age, g);
		float result = 88.362f + (13.397f * w) + (4.799f * h) - (5.677f * age);

		assertEquals(result, bmr_men);
	}

	@Test
	@DisplayName("The upper limit weight is 400kg; otherwise throw exception.")
	void upperLimitWeightBMR() {
		float w = 460;
		int h = 200;
		int age = 45;
		char g = 'm';

		assertThrows(IllegalArgumentException.class, () -> 
		calc.basalMetabolicRate(w, h, age, g));
	}

	@Test
	@DisplayName("The lower limit weight is 0kg; otherwise, throw exception.")
	void lowerLimitWeightBMR() {
		int w = 0;
		int h = 120;
		int age = 10;
		char g = 'w';
		
		assertThrows(IllegalArgumentException.class, () -> 
		calc.basalMetabolicRate(w, h, age, g));
	}

	@Test
	@DisplayName("The upper limit height is 250 cm; otherwise throw exception.")
	void upperLimitHeightBMR() {
		float w = 60;
		int h = 260;
		int age = 65;
		char g = 'm';

		assertThrows(IllegalArgumentException.class, () -> 
		calc.basalMetabolicRate(w, h, age, g));
	}

	@Test
	@DisplayName("The lower limit height is 0kg; otherwise, throw exception.")
	void lowerLimitHeightBMR() {
		int w = 60;
		int h = -4;
		int age = 10;
		char g = 'w';
		
		assertThrows(IllegalArgumentException.class, () -> 
		calc.basalMetabolicRate(w, h, age, g));
	}

	@Test
	@DisplayName("Test if age is in range; if not, throw an exception.")
	void invalidAgeThrowsException1BMR() {
		int w = 60;
		int h = 100;
		int age = -3;
		char g = 'm';
		
		assertThrows(IllegalArgumentException.class, () -> 
		calc.basalMetabolicRate(w, h, age, g));
	}

	@Test
	@DisplayName("Test if age is in range; if not, throw an exception.")
	void invalidAgeThrowsException2BMR() {
		int w = 60;
		int h = 100;
		int age = 130;
		char g = 'm';
		
		assertThrows(IllegalArgumentException.class, () -> 
		calc.basalMetabolicRate(w, h, age, g));
	}

	@Test
	@DisplayName("Throws exception when gender char is invalid.")
	void invalidGenderThrowsExceptionBMR() {
		int w = 60;
		int h = 150;
		int age = 23;
		char g = 'p';

		assertThrows(IllegalArgumentException.class, () ->
			calc.basalMetabolicRate(w, h, age, g));
	}

}
