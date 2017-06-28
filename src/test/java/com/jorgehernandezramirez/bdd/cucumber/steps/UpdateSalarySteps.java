package com.jorgehernandezramirez.bdd.cucumber.steps;

import com.jorgehernandezramirez.bdd.cucumber.configuration.UserConfiguration;
import com.jorgehernandezramirez.bdd.cucumber.dto.UserDto;
import com.jorgehernandezramirez.bdd.cucumber.service.IUserService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = UserConfiguration.class)
public class UpdateSalarySteps {

    @Autowired
    private IUserService userService;

    @Given("^dado los siguientes usuarios en el sistema$")
    public void inicializacionDeusuarios(final List<UserDto> userDtoList) {
        userDtoList.forEach(userDto -> {
            userService.save(userDto);
        });
    }

    @When("^se sube el salario del empleado '(\\d+)' un (\\d+)%$")
    public void incrementarElSalario(final Integer userId, final Integer porcentaje){
        final UserDto userDto = userService.getUser(String.valueOf(userId));
        userDto.setSalary(userDto.getSalary() + userDto.getSalary() * porcentaje / 100D);
        userService.update(userDto);
    }

    @Then("^el salario del empleado '(\\d+)' es (\\d+)")
    public void verifyAmountOfBooksFound(final Integer userId, final Double salario) {
        assertEquals(userService.getUser(String.valueOf(userId)).getSalary(),
                salario);
    }
}
