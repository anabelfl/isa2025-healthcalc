package healthcalc.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private String exceptionMessage;
	private Exception raiseException;

	private float result1;
	private HealthCalc HealthCalculator;
	private int height1;
	private char gender1;

	private float result2;
	private float weight2;
	private int height2;
	private int age2;
	private char gender2;
	
	@Given("a health calculator")
	public void a_health_calculator() {
		this.HealthCalculator = new HealthCalcImp();
 	}

	@Given("height is {int}")
	public void height_is(Integer h) {
		this.height1 = h;
		this.height2 = h;
	}

	@Given("gender is m")
	public void gender_is_m() {
	    this.gender1 = 'm';
		this.gender2 = 'm';
	}

	@Given("gender is w")
	public void gender_is_w() {
	    this.gender1 = 'w';
		this.gender2 = 'w';
	}

	@Given("gender is x")
	public void gender_is_x() {
    	    this.gender1 = 'x'; // invalid gender to test exceptions
			exceptionMessage = "Invalid gender. Do use 'w' or 'm'";
	}

	@Given("weight is {int}")
	public void weight_is(Integer weight) {  
		this.weight2 = weight;
	}

	@Given("age is {int}")
	public void age_is(Integer age) {     
		this.age2 = age;
	}

	@When("I compute the ideal weight function")        
	public void i_compute_the_ideal_weight_function() { 
		try {
			// Storage the result of idealWeight given physical characteristics
			this.result1 = HealthCalculator.idealWeight(height1, gender1);
			raiseException = null; // Si no hay error, limpiar la excepción
			System.out.println("Calculated Ideal Weight: " + this.result1); 
		} catch (Exception e) {
			raiseException = e; // Storage the exception message
		}
	}

	@When("I compute the basal metabolic rate function")    
	public void i_compute_the_basal_metabolic_rate_function() {
		try {
			// Storage the result of idealWeight given physical characteristics
			raiseException = null; // Si no hay error, limpiar la excepción
			this.result2 = HealthCalculator.basalMetabolicRate(weight2, height2, age2, gender2);
			System.out.println("Calculated BMR: " + this.result2); 
		} catch (Exception e) {
			raiseException = e; // Storage the exception 
		}
	}

	@Then("the system returns a value between {double} and {double} kg.")
	public void the_system_returns_a_value_between_and_kg(Double double1_min, Double double1_max) {
		System.out.println("Expected range: " + double1_min + " - " + double1_max);
		System.out.println("Actual result: " + result1);	
		assertTrue(result1 >= double1_min && result1 <= double1_max, "Result is out of range.");
	// assert: si condición es true (resultado está en el rango),
	// la prueba pasa. Si no, es false y la prueba falla y 
	// se muestra el mensaje
	}

	@Then("the system returns a value between {double} and {double}.")
	public void the_system_returns_a_value_between_and(Double double2_min, Double double2_max) {
		System.out.println("Expected range: " + double2_min + " - " + double2_max);
		System.out.println("Actual result: " + result2);	
		assertTrue(result2 >= double2_min && result2 <= double2_max, "Result is out of range.");
	}
	
	@Then("the system throws an exception with the message {string}.")
	public void the_system_throws_an_exception_with_the_message(String expected_message) {

		/*
		 * Si raiseException no es null, significa que hubo
		 * una excepción, entonces la prueba continúa.
		 * 
		 * Si raiseException es null, significa que
		 * no se lanzó ninguna excepción, pero se esperaba.
		 * Entonces la prueba fallará con el mensaje
		 */
    	assertNotNull(raiseException, "Expected an exception but none was thrown.");

		/*
		 * instanceof es un operador de Java que verifica
		 * si un objeto pertenece a una clase específica.
		 * 
		 * assertTrue verifica que la condición sea verdadera.
		 * Si condición es false, la prueba falla y muestra el mensaje
		 * 
		 * EN ESTE CASO CONCRETO:
		 * - Si raiseException es una instancia de
		 * IllegalArgumentException, la afirmación pasa
		 * - Si raiseException es de otro tipo
		 * la prueba fallará
		 */

    	assertTrue(raiseException instanceof IllegalArgumentException, 
    	    "Expected an IllegalArgumentException but got: " + raiseException.getClass().getSimpleName());

		/*
		 * assertEquals(valorEsperado, valorReal, mensajeDeErrorSiFalla)
		 * - Si son iguales, la prueba pasa.
		 * Si son diferentes, la prueba falla y muestra un mensaje.
		 */

    	assertEquals(expected_message, raiseException.getMessage(), 
     	   "Expected message: \"" + expected_message + "\", but got: \"" + raiseException.getMessage() + "\"");
	}



}
