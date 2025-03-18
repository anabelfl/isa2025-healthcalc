package healthcalc.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private Integer result ;
	private boolean raiseException;
	
	// copiar give when then en el codigo que me da el error de mvn test

	@Given("a health calculator")
	public void a_health_calculator() {
    // Write code here that turns the phrase above into concrete actions
	// crear calculadora
    throw new io.cucumber.java.PendingException();
	}

	@Given("height is {int}")
	public void height_is(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	// guardar valor de la altura
    throw new io.cucumber.java.PendingException();
	}

	@Given("gender is female")
	public void gender_is_female() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
	}

	@When("I compute the ideal weight function")
	public void i_compute_the_ideal_weight_function() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
	}

	@Then("The system returns {double}")
	public void the_system_returns(Double double1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
	}

}
