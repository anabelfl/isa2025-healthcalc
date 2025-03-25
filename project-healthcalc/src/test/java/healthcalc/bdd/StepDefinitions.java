package healthcalc.bdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private float result1;
	private boolean raiseException;
	private String exceptionMessage;

	private HealthCalc HealthCalculator;
	private int height1;
	private char gender1;
	
	@Given("a health calculator")
	public void a_health_calculator() {
		this.HealthCalculator = new HealthCalcImp();
 	}

	@Given("height is {int}")
	public void height_is(Integer h1) {
		this.height1 = h1;
	}

	@Given("gender is {string}")
	public void gender_is(String g) {
    	if (g.equalsIgnoreCase("female")) {
    	    this.gender1 = 'w';
    	} else if (g.equalsIgnoreCase("male")) {
    	    this.gender1 = 'm';
   		} else {
    	    this.gender1 = 'x'; // invalid gender to test exceptions
			raiseException = true; // Indicate it throws an exception
			exceptionMessage = "Invalid gender. Do use 'w' or 'm'";
		}
	}

	@Given("gender is male")
	public void gender_is_male() {
	    this.gender1 = 'm';
	}

	@Given("gender is female")
	public void gender_is_female() {
	    this.gender1 = 'w';
	}

	@When("I compute the ideal weight function")        
	public void i_compute_the_ideal_weight_function() { 
		try {
			// Storage the result of idealWeight given physical characteristics
			this.result1 = HealthCalculator.idealWeight(height1, gender1);
		} catch (Exception e) {
			raiseException = true; // Indicate it throws an exception
			exceptionMessage = e.getMessage(); // Storage the exception message
		}
	}

	@Then("the system returns a value between {double} and {double} kg.")
	public void the_system_returns_a_value_between_and_kg(Double double1_min, Double double1_max) {
        assertTrue(result1 >= double1_min && result1 <= double1_max, "Result is out of range.");
	}

	@Then("the system throws an exception with the message {string}.")
	public void the_system_throws_an_exception_with_the_message(String expected_message) {
		assertTrue(raiseException, "Expected an exception, but none was thrown.");
		assertTrue(exceptionMessage.equals(expected_message),
			"Expected message: \"" + expected_message + "\", but got: \"" + exceptionMessage + "\"");
	}



}
