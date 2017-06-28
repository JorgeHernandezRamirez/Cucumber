package com.jorgehernandezramirez.bdd.cucumber;

import com.jorgehernandezramirez.bdd.cucumber.dto.UserDto;
import com.jorgehernandezramirez.bdd.cucumber.service.IUserService;
import com.jorgehernandezramirez.bdd.cucumber.service.InMemmoryUserService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ActualizacionSalarioSteps {

    private IUserService userService = new InMemmoryUserService();

    @Given("^dado los siguientes usuarios en el sistema$")
    public void inicializacionDeusuarios(final List<UserDto> userDtoList) {
        userDtoList.forEach(userDto -> {
            userService.guardarUsuario(userDto);
        });
    }

    @When("^se sube el salario del empleado '(\\d+)' un (\\d+)%$")
    public void incrementarElSalario(final Integer userId, final Integer porcentaje){
        final UserDto userDto = userService.obtenerUsuario(String.valueOf(userId));
        userDto.setSalario(userDto.getSalario() + userDto.getSalario() * porcentaje / 100D);
        userService.actualizarUsuario(userDto);
    }

    @Then("^el salario del empleado '(\\d+)' es (\\d+)")
    public void verifyAmountOfBooksFound(final Integer userId, final Double salario) {
        assertEquals(userService.obtenerUsuario(String.valueOf(userId)).getSalario(),
                salario);
    }
}
