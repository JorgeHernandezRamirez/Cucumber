package com.jorgehernandezramirez.bdd.cucumber;

import com.jorgehernandezramirez.bdd.cucumber.dto.UserDto;
import com.jorgehernandezramirez.bdd.cucumber.service.IUserService;
import com.jorgehernandezramirez.bdd.cucumber.service.InMemmoryUserService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class NumeroUsuariosConRolUserSteps {

    private IUserService userService = new InMemmoryUserService();

    private List<UserDto> usuariosConRolUser;

    @When("^se obtiene los usuarios con rol (.*)")
    public void debeObtenerTodosLosUsuariosConRol(final String rol){
        usuariosConRolUser = userService.obtenerUsuarios().stream().filter(userDto -> rol.equals(userDto.getRol())).collect(Collectors.toList());
    }

    @Then("^el número de usuarios obtenidos es (\\d+)")
    public void debeValidarElNumeroDeUsuariosObtenidos(final Integer numeroDeUsuarios) {
        assertEquals(Integer.valueOf(usuariosConRolUser.size()),
                Integer.valueOf(numeroDeUsuarios));
    }
}
